package emf;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Utilitary class for EMF models.
 * This class gathers usefull functions to load, save and modify easily
 * EMF models and metamodels.
 * @author M. Kerboeuf
 */
public class UtilEMF {

	// PRIVATE **********************************************************************************

	/**
	 * Private class dedicated to the utilitary function changeMetamodel.
	 * This class maps two sets of instances. The first one corresponds to the instances
	 * of a source model. The second one correponds to the instances of a copy of
	 * the source model conforming to another metamodel.
	 * @author M. Kerboeuf
	 */
	private static class EObjectMap {
		private Map<EObject, EObject> map;
		private EObject  modelRootObject;
		private EPackage oldMetamodelRootPackage;
		private EPackage newMetamodelRootPackage;

		/**
		 * Provides the package matching with a package path corresponding to a given package list.
		 * @param path The package path.
		 * @param ePackage The parent package from which the search starts.
		 * @return The package at the end of the path if it exists or null.
		 */
		private static EPackage getEndOfEPackagePath(List<EPackage> path, EPackage ePackage) {
			for (int i=1; i<path.size(); i++) {
				ePackage = getSubEPackage(ePackage, path.get(i).getName());
				if (ePackage==null) return null;
			}
			return ePackage;
		}

		/**
		 * Creates the list of the nested packages containing a given package.
		 * If this list contains a given first package, then this
		 * package is the first of the resulting list.
		 * @param p A package to scan.
		 * @param startPackage The start package from which the list is supposed to begin.
		 * @return The list of nested packages including p.
		 */
		private static List<EPackage> getEPackagePath(EPackage p, EPackage startPackage) {
			List<EPackage> path = new ArrayList<EPackage>();
			while (p!=null) {
				path.add(0, p);
				if (p.equals(startPackage)) break;
				p = p.getESuperPackage();
			}
			return path;
		}

		/**
		 * Provides a subpackage identified by a given name.
		 * @param p The parent package.
		 * @param ePackageName The name of the subpackage.
		 * @return The subpackage of p with the given name if it exists or null.
		 */
		private static EPackage getSubEPackage(EPackage p, String ePackageName) {
			for(EPackage subPackage : p.getESubpackages())
				if (subPackage.getName().equals(ePackageName)) return subPackage;
			return null;
		}

		/**
		 * Creates a map between the provided source instances and copies of
		 * this instances in the new metamodel.
		 * @param modelRootObject root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 */
		public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage) {
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)) this.map.put(eo, this.createObjectCopy(eo));
		}

		public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String,Map<String,String>>> renamingMap) {		
			//public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, String> renamingMap) {	
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)) {
				this.map.put(eo, this.createObjectCopy(eo, renamingMap));
			}
		}

		/**
		 * Creates in the copy the feature values of the source model.
		 */
		@SuppressWarnings("unchecked")
		public void copyFeatures() {
			for (EObject sourceInstance : this.map.keySet()) {
				EObject targetInstance = this.map.get(sourceInstance);
				// Recreation of changeable features (excluding derived features):
				for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures())
					if (sourceInstance.eIsSet(sourceFeature)) {
						EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
						if (targetFeature==null) throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel.");
						if (targetFeature.isChangeable() // there is someting to set in the target...
								&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())) // ...which is not a container
							if (sourceFeature.isMany()) // update of many valued feature
								for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature))
									((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							else { // update of single valued reference
								Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
								if (sourceFeatureValue!=null) 
									targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							}
					}
			}
		}

		@SuppressWarnings("unchecked")
		public void copyFeatures(Map<String,Map<String,Map<String,String>>> mymap) {
			for (EObject sourceInstance : this.map.keySet()) {

				/*for (Entry<String, Map<String, Map<String, String>>> e: mymap.entrySet()) {
					System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
				}*/

				Map<String, Map<String, String>> newName = mymap.get(sourceInstance.eClass().getName());
				Map<String,String> featuresName = new HashMap<String, String>();

				String newClassName = null;
				for (Entry<String, Map<String, String>> e: newName.entrySet()) {
					newClassName = e.getKey();
					featuresName = e.getValue();
				}

				EObject targetInstance = this.map.get(sourceInstance);
				// Recreation of changeable features (excluding derived features):
				for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
					if (sourceInstance.eIsSet(sourceFeature)) {
						EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(featuresName.get(sourceFeature.getName()));

						if (targetFeature==null) throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel.");
						if (targetFeature.isChangeable() // there is someting to set in the target...
								&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())) // ...which is not a container
							if (sourceFeature.isMany()) // update of many valued feature
								for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature))
									((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							else { // update of single valued reference
								Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
								if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							}
					}
				}
			}
		}

		/**
		 * Creates a copy in the new metamodel of a feature value related to a class
		 * of the source metamodel.
		 * @param sourceFeature Source feature.
		 * @param sourceFeatureValue Source feature value to copy.
		 * @return copy of the source feature value.
		 */
		private Object createFeatureValueCopy(EStructuralFeature sourceFeature, Object sourceFeatureValue) {
			EClassifier sourceAttributeType = sourceFeature.getEType();
			List<EPackage> sourceAttributeTypePackagePath = getEPackagePath(sourceAttributeType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceAttributeTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the feature is not defined within the new package, so we try to keep the current value:
				return sourceFeatureValue;
			EPackage targetPackage = getEndOfEPackagePath(sourceAttributeTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceAttributeType.getEPackage()+" is not found.");
			if (sourceAttributeType instanceof EDataType) { // the feature is an attribute: data type (including enum)
				EClassifier targetAttributeType = targetPackage.getEClassifier(sourceAttributeType.getName());
				if (targetAttributeType==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required data type "+sourceAttributeType.getName());
				if (!(targetAttributeType instanceof EDataType)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceAttributeType.getName()+" which is not a data type (and which sould be)");
				return targetPackage.getEFactoryInstance().createFromString(((EDataType)targetAttributeType), sourceFeatureValue.toString());
			}
			// the feature is a local reference:
			return this.map.get(sourceFeatureValue);
		}

		/**
		 * Creates a copy in the new metamodel of an instance conforming to the class
		 * of the source metamodel.
		 * @param source Object to copy.
		 * @return copy of the source object.
		 */
		private EObject createObjectCopy(EObject source) {
			EClass sourceClassType = source.eClass();
			List<EPackage> sourceClassTypePackagePath = getEPackagePath(sourceClassType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceClassTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the object is not defined within the new package, so we try to create a new instance from this object's class:
				return EcoreUtil.create(sourceClassType);
			EPackage targetPackage = getEndOfEPackagePath(sourceClassTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceClassType.getEPackage()+" is not found.");
			EClassifier copyClass = targetPackage.getEClassifier(sourceClassType.getName());
			if (copyClass==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required class "+sourceClassType.getName());
			if (!(copyClass instanceof EClass)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceClassType.getName()+" which is not an EClass (and which sould be)");
			return EcoreUtil.create((EClass)copyClass);
		}

		private EObject createObjectCopy(EObject source, Map<String, Map<String,Map<String,String>>> renameMap) {
			//private EObject createObjectCopy(EObject source, Map<String, String> renameMap) {	

			/*for (Entry<String, Map<String, Map<String, String>>> e: renameMap.entrySet()) {
				System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
			}*/

			EClass sourceClassType = source.eClass();
			Map<String, Map<String,String>> value = renameMap.get(sourceClassType.getName());
			String key = null ;
			Map<String,String> val = new HashMap<String, String>();

			for (Entry<String, Map<String,String>> e: value.entrySet()) {
				key = e.getKey();
				val = e.getValue();
			}

			List<EPackage> sourceClassTypePackagePath = getEPackagePath(sourceClassType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceClassTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the object is not defined within the new package, so we try to create a new instance from this object's class:
				return EcoreUtil.create(sourceClassType);
			EPackage targetPackage = getEndOfEPackagePath(sourceClassTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceClassType.getEPackage()+" is not found.");

			EClassifier searched = null;

			for(EClassifier tp : targetPackage.getEClassifiers()){

				if(tp.getName().equals(key)){
					searched = tp;
					break;
				}	
			}

			//EClassifier copyClass = targetPackage.getEClassifier(sourceClassType.getName());
			EClassifier copyClass = searched;
			if (copyClass==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required class "+sourceClassType.getName());
			if (!(copyClass instanceof EClass)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceClassType.getName()+" which is not an EClass (and which sould be)");
			return EcoreUtil.create((EClass)copyClass);
		}


		/**
		 * Provides the source model copy.
		 * @return the copy of the root instance of the source model.
		 */
		public EObject getRootCopy() {
			return this.map.get(this.modelRootObject);
		}

	}

	// PUBLIC ***********************************************************************************

	/**
	 * Addition of UUID attributes.
	 * @param metamodelRootPackage Root package of the metamodel to be extended with UUID attibutes.
	 * @return Updated root package.
	 */
	/*public static EPackage addUUIDAttribute(EPackage metamodelRootPackage) {
		for (TreeIterator<EObject> it = metamodelRootPackage.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof EClass) { // update of the classes...
				EClass c = (EClass) next;
				boolean toUpdate = true; //...that are not already updated by inheritance
				for (EClass supClass : c.getESuperTypes()) // scan of inherited classes
					if (metamodelRootPackage.equals(supClass.getEPackage())) {
						// an inherited class is already in the same package
						toUpdate = false;
						break;
					}
				if (toUpdate) {
					EAttribute uuid = EcoreFactory.eINSTANCE.createEAttribute();
					uuid.setName("UUID");
					uuid.setEType(EcorePackage.eINSTANCE.getEString());
					uuid.setLowerBound(0);
					uuid.setUpperBound(1);
					uuid.setUnique(true);
					c.getEStructuralFeatures().add(uuid);
				}
			}
		}
		return metamodelRootPackage;
	}*/

	/**
	 * Addition of UUID attributes.
	 * @param metamodelFilePath File path of the metamodel to be extended with UUID attibutes.
	 * @return Loaded and updated root package.
	 */
	/*public static EPackage addUUIDAttribute(String metamodelFilePath) {
		// Metamodel loading:		
		EPackage metamodelRootPackage = loadMetamodel(metamodelFilePath);
		// Update:
		return addUUIDAttribute(metamodelRootPackage);
	}*/

	/**
	 * Addition of UUID attributes.
	 * @param metamodelURI URI of the metamodel to be extended with UUID attibutes.
	 * @return Loaded and updated root package.
	 */
	/*public static EPackage addUUIDAttribute(URI metamodelURI) {
		// Metamodel loading:		
		EPackage metamodelRootPackage = loadMetamodel(metamodelURI);
		// Update:
		return addUUIDAttribute(metamodelRootPackage);
	}*/
	
	/**
	 * 
	 * @param metamodelRootPackage
	 * @return metamodel without duplicate UUID
	 */
	/*public static EPackage removeDuplicateUUIDAttribute(EPackage metamodelRootPackage) {
		List<EStructuralFeature> uuidToRemove = new ArrayList<EStructuralFeature>();
		for (TreeIterator<EObject> it = metamodelRootPackage.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			EStructuralFeature uuid_c = null;
			EStructuralFeature uuid_sc = null;
			if (next instanceof EClass) { // update of the classes...
				EClass c = (EClass) next;	
				for(EStructuralFeature feature :c.getEStructuralFeatures() ){
					if(feature.getName().equals("UUID")){ 
						uuid_c = feature; 
						}
				}
				for (EClass supClass : c.getESuperTypes()) {// scan of inherited classes
					for(EStructuralFeature feature :supClass.getEStructuralFeatures() ){
						if(feature.getName().equals("UUID")){
							uuid_sc = feature;
							if(uuid_c != null && uuid_sc != null){ uuidToRemove.add(uuid_c); }
						}
					}
				}
			}
		}
		for (EStructuralFeature ef : uuidToRemove) EcoreUtil.remove(ef);
		return metamodelRootPackage;
	}*/
	

	/**
	 * Creation of UUID values.
	 * @param modelRoot Root object of the model to be modified.
	 * @return Updated root object.
	 */

	/*public static EObject addUUIDValues(EObject modelRoot) {
		// UUID feature of root object:
		EStructuralFeature uuid = null;
		EList<EAttribute> a = modelRoot.eClass().getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) 
			if (a.get(i).getName().equals("UUID")) uuid = a.get(i);
		// Update of root object :
		if (uuid!=null) 
			modelRoot.eSet(uuid, EcoreUtil.generateUUID());
		// Update of children object :
		for(EObject modelRootChild : modelRoot.eContents()) 
			addUUIDValues(modelRootChild);
		return modelRoot;
	}*/
	/*public static EObject addUUIDValues(EObject modelRoot) {
		// UUID feature of root object:
		EStructuralFeature uuid = null;
		EList<EAttribute> a = modelRoot.eClass().getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) 
			if (a.get(i).getName().equals("UUID")) 
				uuid = a.get(i);
		// Update of root object :
		if (uuid!=null){ 
			for(EAttribute attribute : modelRoot.eClass().getEAllAttributes()){
				if(attribute.getName().equals("name")){
					modelRoot.eSet(uuid, modelRoot.eClass().getName()+":"+modelRoot.eGet(modelRoot.eClass().getEStructuralFeature(attribute.getName())).toString());
					break;
				}else if(attribute.getName().equals("Identification")){
					modelRoot.eSet(uuid, modelRoot.eClass().getName()+":"+modelRoot.eGet(modelRoot.eClass().getEStructuralFeature(attribute.getName())).toString());
					break;
				}else if(attribute.getName().equals("UUID")){
					modelRoot.eSet(uuid, modelRoot.eClass().getName()+":"+EcoreUtil.generateUUID());
					break;
				}

				//	modelRoot.eSet(uuid,modelRoot.eGet(modelRoot.eClass().getEStructuralFeature(nameForIdentification)).toString());
				/*modelRoot.eSet(uuid, uuidVal);
				uuidValue= uuidValue+1;
				uuidVal= ""+uuidValue;	*/
			/*}
			//modelRoot.eSet(uuid, EcoreUtil.generateUUID());
		}
		// Update of children object :
		for(EObject modelRootChild : modelRoot.eContents()) addUUIDValues(modelRootChild);
		return modelRoot;
	}*/
	
	/**
	 * Deletion of UUID attributes
	 * @param metamodelFilePath File path of the metamodel from wich UUID attributes have to me removed.
	 * @return Updated root package
	 */
	/*public static EPackage removeUUIDAttribute(String metamodelFilePath){
		// Metamodel loading
		EPackage metamodelRootPackage = loadMetamodel(metamodelFilePath);
		// Update
		return removeUUIDAttribute(metamodelRootPackage);
	}*/
	
	/**
	 * 
	 * @param metamodelRootPackage
	 * @return metamodel without UUID
	 */
	/*public static EPackage removeUUIDAttribute(EPackage metamodelRootPackage){
		List<EStructuralFeature> uuidToRemove = new ArrayList<EStructuralFeature>();
		for(TreeIterator<EObject> it = metamodelRootPackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			EStructuralFeature uuid = null;
			if(next instanceof EClass){
				EClass c = (EClass) next;
				for(EStructuralFeature feature : c.getEStructuralFeatures()){
					if(feature.getName().equals("UUID")){
						uuid = feature;
						uuidToRemove.add(uuid);
					}
				}
			}
		}
		for(EStructuralFeature ef : uuidToRemove) EcoreUtil.remove(ef);
		return metamodelRootPackage;
	}*/
	
	/**
	 * Creating an ecore composed of subpackages. Each subpackage correspond to an external ecore
	 * @param rootPackage
	 * @param externalEcoreMap
	 */
	public static EPackage createExtendedEcore(Map<EPackage, ArrayList<EPackage>> relatedPackages, String originalEcoreFilePath, EPackage rootPackage){
		String name =  rootPackage.getName()+"Extended";
		EPackage newRootPackage;

		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		newRootPackage = theCoreFactory.createEPackage();
		newRootPackage.setName(name);
		newRootPackage.setNsPrefix(name);
		newRootPackage.setNsURI("http://"+name+".ecore");

		for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
			EPackage ep = e.getKey();
			EPackage pack = theCoreFactory.createEPackage();
			if(!isContainedInEcore(newRootPackage, ep)){
				if(!ep.getName().equals("ecore")){
					pack = EcoreUtil.copy(ep);
					pack.setName(pack.getName());
					pack.setNsPrefix(pack.getNsPrefix());
					pack.setNsURI(pack.getNsURI());

					for(EClassifier ec : pack.getEClassifiers()){
						ArrayList<EClass> toAdd = new ArrayList<EClass>();
						ArrayList<EClass> toRemove = new ArrayList<EClass>();
						if(ec instanceof EClass){
							for(EClass sc : ((EClass) ec).getESuperTypes()){ 
								toRemove.add(sc); 
							}
							if(!toRemove.isEmpty()){ 
								((EClass) ec).getESuperTypes().removeAll(toRemove); }
							//fake references
							for(EReference er : ((EClass) ec).getEAllReferences()){ 
								er.setEType(ec); 
							}
						}

					}
					newRootPackage.getESubpackages().add(pack);
				}
			}
		}
		// reestablish super classes
		newRootPackage = reestablishSuperClass(newRootPackage, relatedPackages);
		// reestablish references
		newRootPackage = reestablishReference(newRootPackage, relatedPackages);
		// remove annotations
		newRootPackage = removeAnnotation(newRootPackage, relatedPackages);
		return newRootPackage;
	}
	
	public static EPackage reestablishSuperClasses(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap){
		// recuperer chaque subpackage
		Map <String, ArrayList<EClass>> mapToAdd = new HashMap<String, ArrayList<EClass>>();
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, EPackage> e: packageKeyPackageMap.entrySet()) {
				EPackage epackagek = e.getValue();
				if(subp.getNsURI().equals(epackagek.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackagek.getEClassifiers()){
						// class du rootPackage a modifier
						ArrayList<EClass> toAdd = new ArrayList<EClass>();
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){

							if(eclass instanceof EClass){
								//if(eclass.getName().equals("TransactionpartType")){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a des superclasses
									if(!((EClass) eclassk).getESuperTypes().isEmpty()){

										// recupperer les superclasses
										for(EClassifier esuperclassk : ((EClass) eclassk).getESuperTypes()){
											// recuperer le package qui contient la superclass
											EPackage containerPackage = null;
											for(EPackage subpp : rootPackage.getESubpackages()){
												for(EClassifier eclasskk : subpp.getEClassifiers()){
													if(eclasskk.getName().equals(esuperclassk.getName())){
														containerPackage = subpp;
														break;
													}
												}
											}
											// recuperer le package (du ecore extended) dans lequel se trouve la classe
											EClassifier newClass = getClass(containerPackage, (EClass) esuperclassk);
											if(newClass != null){
												toAdd.add((EClass) newClass); 
												mapToAdd.put(eclass.getName(), toAdd);
											}
										}
									}
								}
							}
						}
						/*
						if(!toAdd.isEmpty()){
							((EClass) c).getESuperTypes().addAll(toAdd); 
						}

						/*
						for( EClass s : c.getEAllSuperTypes()){
						}*/

						rootPackage = addSuperTypes(rootPackage, packageKeyPackageMap, mapToAdd);
					}
				}
			}
		}
		return rootPackage;
	}
	
	
	public static EPackage reestablishReferences(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap){
		// recuperer chaque subpackage
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, EPackage> e: packageKeyPackageMap.entrySet()) {
				//EPackage epackage = (EPackage) e.getValue();
				EPackage epackagek = e.getValue();
				if(subp.getNsURI().equals(epackagek.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackagek.getEClassifiers()){
						// class du rootPackage a modifier
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){
							if(eclass instanceof EClass){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a de references vers d'autres packages
									for(EReference er : ((EClass) eclassk).getEAllReferences()){
										// recupperer er du ecore extended
										for(EReference err :  c.getEAllReferences()){
											if(er.getName().equals(err.getName())){
												EClass type = (EClass) er.getEType();
												// recuperer le package qui contient la superclass
												EPackage containerPackage = null;
												for(EPackage subpp : rootPackage.getESubpackages()){
													for(EClassifier eclasskk : subpp.getEClassifiers()){
														if(eclasskk.getName().equals(type.getName())){
															containerPackage = subpp;
															if(containerPackage.getNsURI().equals(((EPackage)type.eContainer()).getNsURI())){
																EClass relatedClass = UtilEMF.getClass(containerPackage, (EClass)er.getEType());
																err.setEType(relatedClass);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return rootPackage;
	}
	
	
	/**
	 * 
	 */
	public static EPackage reestablishReference(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages){
		// recuperer chaque subpackage
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
				EPackage epackage = e.getKey();
				if(subp.getNsURI().equals(epackage.getNsURI())){
					// parcours des classes
					for(EClassifier eclass : epackage.getEClassifiers()){
						// class du rootPackage a modifier
						EClass csub = null;
						for(EClassifier eclasssub : subp.getEClassifiers()){
							if(eclasssub instanceof EClass){
								csub = (EClass) eclasssub;
								if(eclasssub.getName().equals(eclass.getName())){
									// verifier si la class a de references vers d'autres packages
									for(EReference er : ((EClass) eclass).getEAllReferences()){
										// recupperer er du ecore extended
										for(EReference ersub :  csub.getEAllReferences()){
											if(er.getName().equals(ersub.getName())){
												EClass type = (EClass) er.getEType();
												// recuperer le package qui contient la superclass
												EPackage containerPackagesub = null;
												for(EPackage subpp : rootPackage.getESubpackages()){
													for(EClassifier subcc : subpp.getEClassifiers()){
														if(subcc.getName().equals(type.getName())){
															containerPackagesub = subpp;
															if(containerPackagesub.getNsURI().equals(((EPackage)type.eContainer()).getNsURI())){
																EClass relatedClass = UtilEMF.getClass(containerPackagesub, (EClass)er.getEType());
																ersub.setEType(relatedClass);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return rootPackage;
	}

	
	/**
	 * 
	 * @param rootPackage
	 * @return
	 */
	public static EPackage reestablishSuperClass(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages) {
		// recuperer chaque subpackage
		Map <String, ArrayList<EClass>> mapToAdd = new HashMap<String, ArrayList<EClass>>();
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
				EPackage epackage = e.getKey();
				if(subp.getNsURI().equals(epackage.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackage.getEClassifiers()){
						// class du rootPackage a modifier
						ArrayList<EClass> toAdd = new ArrayList<EClass>();
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){

							if(eclass instanceof EClass){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a des superclasses
									if(!((EClass) eclassk).getESuperTypes().isEmpty()){

										// recupperer les superclasses
										for(EClassifier esuperclassk : ((EClass) eclassk).getESuperTypes()){
											// recuperer le package qui contient la superclass
											EPackage containerPackage = null;
											for(EPackage subpp : rootPackage.getESubpackages()){
												for(EClassifier eclasskk : subpp.getEClassifiers()){
													if(eclasskk.getName().equals(esuperclassk.getName())){
														containerPackage = subpp;
														break;
													}
												}
											}
											// recuperer le package (du ecore extended) dans lequel se trouve la classe
											EClassifier newClass = getClass(containerPackage, (EClass) esuperclassk);
											if(newClass != null){
												toAdd.add((EClass) newClass); 
												mapToAdd.put(eclass.getName(), toAdd);
											}
										}
									}
								}
							}
						}
						rootPackage = addSuperClasses(rootPackage, relatedPackages, mapToAdd);
					}
				}
			}
		}
		return rootPackage;
	}
	
	/**
	 * Metamodel processor: removes annotations. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without annotations).
	 */
	public static EPackage removeAnnotation(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages){
		for(EPackage subp : rootPackage.getESubpackages()){
			removeAnnotations(subp);
		}
		return rootPackage;
	}

	
	public static boolean isContainedInEcore(EPackage pack, EPackage subPack){
		boolean result = false;
		for(EPackage p : pack.getESubpackages()){
			if(p.getName().equals(subPack.getName())){
				result= true;
				break;
			}
		}
		return result;
	}
	
	public static EClass getClass(EPackage ePackage, EClass eClass){
		EClass ec = null;
		for(TreeIterator<EObject> it = ePackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			if(next instanceof EClass){
				EClass c = (EClass) next;
				if(c.getName().equals(eClass.getName())){
					ec = c;
					break;
				}
			}
		}
		return ec;
	}

	public static EPackage addSuperTypes(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap, Map<String, ArrayList<EClass>> toAddMap){
		for(EPackage subp : rootPackage.getESubpackages()){
			for(EClassifier eclass : subp.getEClassifiers()){
				ArrayList<EClass> val = toAddMap.get(eclass.getName());
				if(val != null){
					((EClass) eclass).getESuperTypes().addAll(val); 
				}
			}
		}
		return rootPackage;
	}
	
	/**
	 * 
	 * @param rootPackage
	 * @param packageKeyPackageMap
	 * @param toAddMap
	 * @return
	 */
	public static EPackage addSuperClasses(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackagesMap, Map<String, ArrayList<EClass>> toAddMap){
		for(EPackage subp : rootPackage.getESubpackages()){
			for(EClassifier eclass : subp.getEClassifiers()){
				ArrayList<EClass> val = toAddMap.get(eclass.getName());
				if(val != null){
					((EClass) eclass).getESuperTypes().addAll(val); 
				}
			}
		}
		return rootPackage;
	}
	
	/**
	 * Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, EPackage newMetamodelRootPackage) {
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage);
		eObjectMap.copyFeatures();
		return eObjectMap.getRootCopy();
	}

	public static EObject changeMetamodel(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String, Map<String, String>>> renameMap) {
		//public static EObject changeMetamodel(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, String> renameMap) {
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage, renameMap);
		eObjectMap.copyFeatures(renameMap);
		return eObjectMap.getRootCopy();
	}


	/**
	 * Modification of metamodel.
	 * @param modelRootObject Root object whose metaclass belongs
	 * to the EPackage which is intended to be modified.
	 * @param newMetamodelFilePath File path of the new metamodel. 
	 * @return Updated root object.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, String newMetamodelFilePath) {
		// Metamodel loading:
		EPackage newMetamodelRootPackage = loadMetamodel(newMetamodelFilePath);
		// Model update
		return changeMetamodel(modelRootObject, newMetamodelRootPackage);
	}

	/**
	 * Modification of metamodel.
	 * @param modelRootObject Root object whose metaclass belongs
	 * to the EPackage which is intended to be modified.
	 * @param newMetamodelURI URI of the new metamodel. 
	 * @return Updated root object.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, URI newMetamodelURI) {
		// Metamodel loading:
		EPackage newMetamodelRootPackage = loadMetamodel(newMetamodelURI);
		// Model update
		return changeMetamodel(modelRootObject, newMetamodelRootPackage);
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelRootPackage Root package of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass if it exists or null.
	 */
	public static EObject createInstance(String className, EPackage metamodelRootPackage) {
		EClassifier classToInstanciate = metamodelRootPackage.getEClassifier(className);
		if (classToInstanciate==null || !(classToInstanciate instanceof EClass)) return null;
		return EcoreUtil.create((EClass)classToInstanciate);
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelFilePath File path of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass.
	 */
	public static EObject createInstance(String className, String metamodelFilePath) {
		return createInstance(className, loadMetamodel(metamodelFilePath));
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelURI URI of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass.
	 */
	public static EObject createInstance(String className, URI metamodelURI) {
		return createInstance(className, loadMetamodel(metamodelURI));
	}

	/**
	 * Creation of a default resource set associated to an EPackage NS_URI
	 * and an instance of this EPackage.
	 * @param nsuri NS_URI of the EPackage.
	 * @param metamodelRootPackage Instance of the EPackage.
	 * @return New resource set which package registry maps nsuri to metamodelRootPackage.
	 */
	public static ResourceSet createResourceSet (String nsuri, Object metamodelRootPackage) {
		ResourceSet resourceSet = new ResourceSetImpl();
		// Default XMI extension:
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		// Register:
		resourceSet.getPackageRegistry().put(nsuri, metamodelRootPackage);
		return resourceSet;
	}

	/**
	 * Initialisation of a map relating UUIDs to the corresponding EObjects.
	 * @param root The root instance of the model to scan.
	 * @return The map relating UUIDs to instances of root (root included).
	 */
	public static Map<String, EObject> createUUIDMap(EObject root) {
		Map<String, EObject> map = new HashMap<String, EObject>();
		List<EObject> fifo = new ArrayList<EObject>();
		for(fifo.add(root); !fifo.isEmpty(); ) {
			EObject next = fifo.remove(0);
			String nextUUID = UtilEMF.getUUID(next);
			if (nextUUID!=null) map.put(nextUUID, next);
			fifo.addAll(next.eContents());
		}
		return map;
	}

	/**
	 * Provides the set of external packages definig feature types.
	 * @param root The root package to scan.
	 * @return The set of packages that are not defined within or equal to root, and that
	 * define classifiers used as type of features.
	 */
	public static Set<EPackage> getAllExternalPackages(EPackage root) {
		Set<EPackage> allExternal = new HashSet<EPackage>(); // result: new empty set recursively extended by the subpackages:
		for (EPackage subPackage : root.getESubpackages()) allExternal.addAll(getAllExternalPackages(subPackage));
		// We scan now the direct content of the package:
		for (EClassifier ec : root.getEClassifiers())
			if (ec instanceof EClass)
				for (EStructuralFeature er : ((EClass)ec).getEAllStructuralFeatures()) {
					EPackage refPackage = er.getEType().getEPackage(); // package to check
					boolean inside = false;
					while  (!inside && refPackage!=null) {
						if (refPackage.equals(root)) inside=true;
						refPackage = refPackage.getESuperPackage();
					}
					if (!inside) allExternal.add(er.getEType().getEPackage());
				}		
		return allExternal;
	}

	/**
	 * Creation of a set of instances contained into a root instance, including this root instance.
	 * @param root Root instance.
	 * @return A new set containing all the content of root, including root.
	 */
	public static Set<EObject> getAllInstances(EObject root) {
		Set<EObject> allContent = new HashSet<EObject>();
		allContent.add(root);
		for(TreeIterator<EObject> it = root.eAllContents(); it.hasNext();) allContent.add(it.next());
		return allContent;
	}

	/**
	 * Get the String value of UUID if it exists.
	 * @param o Object to scan.
	 * @return The UUID of o if it exists or null.
	 */
	public static String getUUID (Object o) {
		EObject instance = ( (o==null||!(o instanceof EObject)) ? null : (EObject)o );
		EStructuralFeature esfUUID = (instance==null ? null : instance.eClass().getEStructuralFeature("UUID"));
		Object value = (esfUUID==null ? null : instance.eGet(esfUUID));
		return ( (value==null||!(value instanceof String)) ? null : (String)value );
	}

	/**
	 * Metamodel (Ecore model) loading.
	 * @param metamodelFilePath File path of the metamodel to load.
	 * @return Root package of the loaded metamodel.
	 */
	public static EPackage loadMetamodel (String metamodelFilePath) {		
		// Metamodel loading:				
		return loadMetamodel(URI.createFileURI(new File(metamodelFilePath).getAbsolutePath()));
	}

	/**
	 * Metamodel (Ecore model) loading.
	 * @param metamodelURI URI of the metamodel to load.
	 * @return Root package of the loaded metamodel.
	 */
	public static EPackage loadMetamodel (URI metamodelURI) {
		// Model loading:		
		return (EPackage)loadModel(metamodelURI, EcorePackage.eINSTANCE);
	}
	
	/**
	 * Model loading.
	 * @param inputFilePath File name of the model to load.
	 * @param metamodelRootPackage EPackage expected to be
	 * the container of the metaclass of the model root object.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String inputFilePath, EPackage metamodelRootPackage) {
		return loadModel(URI.createFileURI(new File(inputFilePath).getAbsolutePath()), metamodelRootPackage);
	}

	/**
	 * Model loading.
	 * @param modelInputFilePath File name of the model to load.
	 * @param metamodelInputFilePath File name of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String modelInputFilePath, String metamodelInputFilePath) {
		return loadModel(URI.createFileURI(new File(modelInputFilePath).getAbsolutePath()), metamodelInputFilePath);
	}

	/**
	 * Model loading.
	 * @param inputFilePath File name of the model to load.
	 * @param metamodelURI URI of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String inputFilePath, URI metamodelURI) {
		return loadModel(URI.createFileURI(new File(inputFilePath).getAbsolutePath()), metamodelURI);
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelRootPackage EPackage expected to be
	 * the container of the metaclass of the model root object.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, EPackage metamodelRootPackage) {
		// Creation of a ResourceSet mapping the package ns uri to the package:
		ResourceSet resourceSet = createResourceSet(metamodelRootPackage.getNsURI(), metamodelRootPackage);
		// Creation of a resource linked to the model uri:
		Resource resource = resourceSet.getResource(modeluri, true);
		// First element of the model (root object):
		return resource.getContents().get(0);
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelFilePath File name of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, String metamodelFilePath) {
		// Model loading:		
		return loadModel(modeluri, URI.createFileURI(new File(metamodelFilePath).getAbsolutePath()));
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelURI URI of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, URI metamodelURI) {
		// Metamodel loading:
		EPackage metamodelRootPackage = loadMetamodel(metamodelURI);
		// Model loading:				
		return loadModel(modeluri, metamodelRootPackage);
	}

	/**
	 * Metamodel processor: removes annotations. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without annotations).
	 */
	public static EPackage removeAnnotations(EPackage metaModelRootObject) {
		List<EAnnotation> annotToRemove = new ArrayList<EAnnotation>(); // will contain all annotations
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if (nextEClassName.equals("EAnnotation")) annotToRemove.add((EAnnotation)next);
		}
		// Removing references of deleted operation witin annotations:
		for (EAnnotation ea : annotToRemove) EcoreUtil.remove(ea);
		return metaModelRootObject;
	}

	/**
	 * Metamodel processor: removes operations. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without operations).
	 */
	public static EPackage removeOperations(EPackage metaModelRootObject) {
		List<EOperation>  opToRemove     = new ArrayList<EOperation>();  // will contain removed operations
		List<EAnnotation> annotToProcess = new ArrayList<EAnnotation>(); // will contain all annotations
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if      (nextEClassName.equals("EClass"))      opToRemove.addAll(((EClass)next).getEOperations());
			else if (nextEClassName.equals("EAnnotation")) annotToProcess.add((EAnnotation)next);
		}
		// Removing references of deleted operation witin annotations:
		for (EAnnotation ea : annotToProcess) ea.getReferences().removeAll(opToRemove);
		// Removing operations:
		for (EOperation eo : opToRemove) eo.getEContainingClass().getEOperations().remove(eo);
		return metaModelRootObject;
	}

	/**
	 * Metamodel processor: removes opposite feature from all references. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without opposite references).
	 */
	public static EPackage removeOppositeFeature(EPackage metaModelRootObject) {
		List<EReference> refToUpdate = new ArrayList<EReference>();  // will contain updated references
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if (nextEClassName.equals("EClass")) refToUpdate.addAll(((EClass)next).getEReferences());
		}
		// Updating operations:
		for (EReference er : refToUpdate) er.setEOpposite(null);
		return metaModelRootObject;
	}

	/**
	 * Deletion of UUID values.
	 * @param modelRoot Root object of the model to be modified.
	 * @return Updated root object.
	 */
	public static EObject removeUUIDValues(EObject modelRoot) {
		// UUID feature of root object:
		EStructuralFeature uuid = null;
		EList<EAttribute> a = modelRoot.eClass().getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) if (a.get(i).getName().equals("UUID")) uuid = a.get(i);
		// Update of root object :
		if (uuid!=null) modelRoot.eUnset(uuid);
		// Update of children object :
		for(EObject modelRootChild : modelRoot.eContents()) removeUUIDValues(modelRootChild);
		return modelRoot;
	}
	
	static Map<EPackage, String> packageLocationMap = new HashMap<EPackage, String>();

	Map<EPackage, String> getPackageLocationMap(){
		return packageLocationMap;
	}

	
	/**
	 * 
	 * @param rootPackage
	 * @return
	 */
	public static Map<EPackage, ArrayList<EPackage>> getRelatedPackages(EPackage rootPackage, Map<EPackage, String> thePackageLocationMap, ArrayList<EPackage> evaluated){
		ArrayList<EPackage> alreadyEvaluated;
		if(evaluated == null || evaluated.isEmpty()){
			alreadyEvaluated = new ArrayList<EPackage>();
		}else{
			alreadyEvaluated = evaluated;
		}
		packageLocationMap = thePackageLocationMap;
		Map<EPackage, ArrayList<EPackage>> relatedPackagesMap = new HashMap<EPackage, ArrayList<EPackage>>();
		ArrayList<EPackage> packagesList = new ArrayList<EPackage>();
		for(TreeIterator<EObject> it = rootPackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			if(next instanceof EClass){
				EClass c = (EClass) next;
				// look for references to classes contained in external ecore
				for(EReference er : c.getEAllReferences()){
					EPackage containerPackage = (EPackage)(er.getEType().eContainer());
					if(containerPackage != null){
						if(!containerPackage.getNsURI().equals(rootPackage.getNsURI())){
							if(!packagesList.contains(containerPackage)){
								packagesList.add(containerPackage);
								String location = lookForLocation(containerPackage, rootPackage, packageLocationMap);
								packageLocationMap.put(containerPackage, location);
							}
						}
					}
				}
				// look for supertypes in external ecore
				for(EClass supertype : c.getEAllSuperTypes()){
					EPackage containerPackage = (EPackage)(supertype.eContainer());
					if(!containerPackage.getNsURI().equals(rootPackage.getNsURI())){
						if(!packagesList.contains(containerPackage)){
							packagesList.add(containerPackage);
							String location = lookForLocation(containerPackage, rootPackage, packageLocationMap);
							packageLocationMap.put(containerPackage, location);
						}
					}
				}
				relatedPackagesMap.put(rootPackage, packagesList);
			}
		}
		if(!packagesList.isEmpty()){
			for(EPackage p : packagesList){
				if(!alreadyEvaluated.contains(p)){
					alreadyEvaluated.add(p);
					Map<EPackage, ArrayList<EPackage>> temporalMap = new HashMap<EPackage, ArrayList<EPackage>>();
					temporalMap = getRelatedPackages(p, packageLocationMap, alreadyEvaluated);
					relatedPackagesMap.putAll(temporalMap);
				}
			}
		}
		return relatedPackagesMap;
	}

	/**
	 * 
	 * @param ePackage
	 * @param rootPackage
	 * @return
	 */
	public static  String lookForLocation(EPackage ePackage, EPackage rootPackage, Map<EPackage, String> packageLocationMap){
		String rootLocation = packageLocationMap.get(rootPackage);
		return rootLocation.replace(rootPackage.getName()+".ecore", ePackage.getName()+".ecore");		
	}

	/**
	 * Metamodel saving.
	 * The ressource and NsURI of the package are updated.
	 * The packages corresponding to external dependencies 
	 * are serialised locally together with the metamodel itself.
	 * @param metaModelRootObject Root object of the metamodel to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root package.
	 */
	public static EPackage saveMetamodel(EPackage metaModelRootObject, String outputFilePath) throws IOException {
		return saveMetamodel(metaModelRootObject, outputFilePath, true);
	}

	/**
	 * Metamodel saving.
	 * The ressource and NsURI of the package are updated.
	 * The packages corresponding to external dependencies 
	 * can be serialised locally together with the metamodel itself.
	 * @param metaModelRootObject Root object of the metamodel to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @param withExternalPackageDependencies States if the external dependencies must but serialized or not.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root package.
	 */
	public static EPackage saveMetamodel(EPackage metaModelRootObject, String outputFilePath, boolean withExternalPackageDependencies) throws IOException {
		File metamodelFile = new File(outputFilePath);
		String metamodelFilename  = metamodelFile.getAbsolutePath();
		// New NsURI matching with the new file path:
		metaModelRootObject.setNsURI(URI.createFileURI(metamodelFilename).toString());
		// Request for the serialization of external dependencies:
		if (withExternalPackageDependencies) {
			Map<EPackage, Resource> resourcesBackup = new HashMap<EPackage, Resource>();
			for (EPackage ep : getAllExternalPackages(metaModelRootObject)) {
				String pname = ep.getName()+".ecore";
				pname =  Character.toUpperCase(pname.charAt(0)) + pname.substring(1);
				// backup of current resource before saving (and so update):
				Resource currentResource = ep.eResource();
				if (currentResource!=null) resourcesBackup.put(ep, currentResource);
				saveModel(ep, metamodelFile.getParentFile().getAbsolutePath()+"/"+pname);
			}
			// Metamodel serialization:
			saveModel(metaModelRootObject, metamodelFilename);
			// Restoring the initial resources:
			for (EPackage ep : resourcesBackup.keySet()) resourcesBackup.get(ep).getContents().add(ep);
		}
		else saveModel(metaModelRootObject, metamodelFilename);
		return metaModelRootObject;
	}

	/**
	 * Model saving.
	 * @param modelRootObject Root object to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root object.
	 */
	public static EObject saveModel(EObject modelRootObject, String outputFilePath) throws IOException {	
		// Creating the resource set from the metadata of modelRootObject:
		ResourceSet resourceSet = createResourceSet(modelRootObject.eClass().getEPackage().getNsURI(), modelRootObject.eClass().getEPackage());
		// Creating a new resource in this resource set:
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(outputFilePath).getAbsolutePath()));
		// Adding the object in the new resource and saving:
		resource.getContents().add(modelRootObject);	
		resource.save(Collections.EMPTY_MAP);
		return modelRootObject;
	}

}

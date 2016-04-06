/**
 * 
 * facade for ecoreModif classes (Modif ATL fabrics, EcoreModif IO Fabric, 
 * Refactoring, XML creation and code generation
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  @author Paola Vallejo
 *  22/11/2013
 */

package uiModif;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;

import dependency.DependencyPackage;
import dependency.Graph;
import migration.DerivedReference;
import migration.Instance;
import migration.Migration;
import migration.MigrationPackage;
import migration.ReferencePath;
import migration.tools.MigrationRoundtrip;
import migration.tools.UtilEMF;
import migrationspecgen.MigrationSpecificationGenerator;
import modif.*;
import modif.util.*;
import refactor.Refactoring;
import ecoremodif.EattributeModif;
import ecoremodif.EclassModif;
import ecoremodif.EreferenceModif;
import ecoremodif.RootEcoreModif;
import ecoremodifutils.ModifIO;

public class modifService {

	protected RootEcoreModif theRootEcoreModif;
	protected RootEcoreModif theRootEcoreModifCopy;
	protected ModifIO modifIO ;

	protected Map<String, ArrayList<String>> superTypesMap;
	protected Map<String, ArrayList<String>> attributesMap;

	protected String initialEcoreFile;
	protected String inputEcoreFile;
	protected String originalEcoreFile;
	protected String keyEcoreFile;
	protected String toolEcoreFile;
	protected String refactoredEcoreFile;
	protected EPackage keyEcoreFilePackage;
	protected String modifFile;
	protected String originalModelFile;
	protected String migratedModelFile;
	protected String migrationFile;
	protected String toolOutputModelFile;
	protected String reversedModelFile;
	protected String recontextualizedKeysModelFile;
	protected String graphFile;
	protected String recontextualizedGraphModelFile;
	protected String recontextualizedFinalModelFile;
	protected String projectFile;

	protected ArrayList<String> hideClassList;
	protected ArrayList<String> flattenClassList;

	protected String refactoredWithoutKFileName;
	MigrationSpecificationGenerator migrationSpecificationGenerator;

	protected boolean isUML;

	EPackage sourceMetamodelUUID;

	protected Migration migration;
	protected MigrationRoundtrip migrt;
	EObject migratedModel;

	protected Map<String, Map<String, Map<String, String>>> renamemap;
	protected Map<String, Map<String, ArrayList<ArrayList<String>>>> hidemap;
	protected Map<String, String> newReferenceName;
	protected Map<String, Map<String, ArrayList<String>>> referencesToClassMap;

	public modifService() {
		theRootEcoreModif = null;
		modifIO = new ModifIO();
	}

	/**
	 * 
	 * @param originalEF input Ecore
	 * @param keyEF input Ecore with keys
	 * @param modifF Modif specification
	 * @param inputMF input model
	 * @param migrationF migration specification
	 * @param toolOutputMF model processed by tool
	 * @param graphF dependency graph
	 * @param projectF project source folder
	 * @param isUML indicates that the input Ecore is UML
	 */
	public void setFiles(String projectF, String originalEF, String modifF, String processedMF, String graphF){
		this.projectFile = projectF;
		this.originalEcoreFile = originalEF;
		this.modifFile = modifF;
		this.toolOutputModelFile = processedMF;
		this.graphFile = graphF;
	}

	/**
	 * @param originalEF input Ecore
	 */
	public void setFiles(String originalEF){
		this.originalEcoreFile = originalEF;
	}

	/**
	 * 
	 * @param projectF
	 * @param originalEF
	 * @param modifF
	 * @param toolEF
	 * @param inputMF
	 * @param migrationF
	 * @param processedMF
	 * @param graphF
	 * @param isUML
	 */
	public void setFiles(String projectF, String originalEF, String modifF, String toolEF, String inputMF, String migrationF, String processedMF, String graphF, boolean isUML){
		this.projectFile = projectF;
		this.originalEcoreFile = originalEF;
		this.modifFile = modifF;
		this.toolEcoreFile = toolEF;
		this.originalModelFile = inputMF;
		this.migrationFile = migrationF;
		this.toolOutputModelFile = processedMF;
		this.graphFile = graphF;
		this.isUML = isUML;
	}

	/**
	 * Creation of a new metamodel from a given input metamodel 
	 * extended with UUID attributes.
	 * @return Copy of the originalEcore with UUID
	 * 
	 */
	public EPackage addUUIDAttributes(){
		EPackage rootKeyPackage = null;
		EPackage temporalPackage = null;
		try{
			if(isUML){
				// Copy of  UMLPackage.eINSTANCE without operations
				//rootKeyPackage = UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(UtilEMF.removeOperations(UtilEMF.addUUIDAttribute(EcoreUtil.copy(UMLPackage.eINSTANCE)))));				
				this.keyEcoreFile = this.projectFile+"/metamodel/UMLK.ecore";
				UtilEMF.saveMetamodel(rootKeyPackage, keyEcoreFile);
				rootKeyPackage = UtilEMF.loadMetamodel(keyEcoreFile);
			}else{
				// Add UUID attribute
				temporalPackage = UtilEMF.addUUIDAttribute(originalEcoreFile);
				// Remove duplicate UUID attribute
				rootKeyPackage = UtilEMF.removeDuplicateUUIDAttribute(temporalPackage);
				//rootKeyPackage = UtilEMF.removeOppositeFeature(rootKeyPackage);

				String[] strArray = originalEcoreFile.split("\\.");
				String modelName = strArray[strArray.length-2];

				this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"K"));
				UtilEMF.saveMetamodel(rootKeyPackage, keyEcoreFile, false);
			}
			System.out.println("[saving] file "+keyEcoreFile +": ok");	

		} catch (IOException e) {
			e.printStackTrace();
		}
		return rootKeyPackage;
	}

	/**
	 * Creation of UUID values
	 * @param UMLPackage with UUID
	 */
	public String addUUIDValues(EPackage rootPackage){
		String keyModelFile = null;
		try {
			File f = new File(originalModelFile);
			String[] strArray = originalModelFile.split("\\.");
			String modelName = strArray[0];
			if(isUML){
				// Loading UML, changing the metamodel, adding UUIDs, and saving :			
				//EObject modelRoot = UtilEMF.addUUIDValues(UtilEMF.changeMetamodel(null, UtilEMF.loadModel(originalModelFile, UMLPackage.eINSTANCE), rootPackage), rootPackage);
				//keyModelFile = originalModelFile.replace(modelName, modelName+"_k").replace(rootPackage.getName(), rootPackage.getName()+"k.xmi");
				//UtilEMF.saveModel(modelRoot, keyModelFile);
			}
			else{
				// Loading model, changing the metamodel, adding UUIDs, and saving :
				EObject modelRoot = UtilEMF.addUUIDValues(UtilEMF.changeMetamodel(null, UtilEMF.loadModel(originalModelFile, originalEcoreFile), rootPackage), rootPackage);
				keyModelFile = originalModelFile.replace(rootPackage.getName(), rootPackage.getName()+"k");
				UtilEMF.saveModel(modelRoot, keyModelFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyModelFile;
	}

	/**
	 * 
	 * @param rootKeyPackage
	 * @param rootPackage
	 * @return
	 */
	public String addUUIDValues(EPackage rootKeyPackage, EPackage rootPackage){
		String keyModelFile = null;
		try {
			File f = new File(originalModelFile);
			String[] strArray = originalModelFile.split("\\.");
			String modelName = strArray[0];
			if(isUML){
				// Loading UML, changing the metamodel, adding UUIDs, and saving :			
				//EObject modelRoot = UtilEMF.addUUIDValues(UtilEMF.changeMetamodel(null, UtilEMF.loadModel(originalModelFile, UMLPackage.eINSTANCE), rootPackage), rootPackage);
				//keyModelFile = originalModelFile.replace(modelName, modelName+"_k").replace(rootPackage.getName(), rootPackage.getName()+"k.xmi");
				//UtilEMF.saveModel(modelRoot, keyModelFile);
			}
			else{
				// Loading model, changing the metamodel, adding UUIDs, and saving :
				EObject tempModel = UtilEMF.loadModel(originalModelFile, originalEcoreFile);

				EObject tempModel2 = UtilEMF.changeMetamodel(tempModel, rootKeyPackage);

				UtilEMF.saveModel(tempModel2, "C:/ModifProject/Test_MultiEcore/model/myModel.key.xmi");

				/*EObject modelRoot = UtilEMF.addUUIDValues(UtilEMF.changeMetamodel(null, tempModel, rootKeyPackage), rootKeyPackage, rootPackage);				
				String name = rootPackage.getName();
				int n = name.length(); 
				char c = name.charAt(n-1); 

				keyModelFile = originalModelFile.replace(name.substring(0, n-1),name);				
				UtilEMF.saveModel(modelRoot, keyModelFile);*/
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyModelFile;
	}

	/**
	 * 
	 * @param rootPackage
	 * @return
	 */
	public Map<String, ArrayList<String>> buildMapReferencesToInstance(EPackage rootPackage){
		Map<String, ArrayList<String>> referencesToInstanceMap = UtilEMF.buildMapReferencesToInstance(UtilEMF.loadModel(originalModelFile, originalEcoreFile), rootPackage);
		return referencesToInstanceMap;
	}

	/**
	 * Deletion of UUID attributes
	 * @param metamodelRootPackage
	 */
	public void removeUUIDAttribute(EPackage metamodelRootPackage){
		EPackage metamodel = UtilEMF.removeUUIDAttribute(metamodelRootPackage);

	}

	/**
	 * Deletion of UUID values
	 * @throws IOException 
	 */
	public void removeUUIDSimpleMigration(String modelFileName, String refactoredMetamodelWithoutK, String refactoredMetamodelWithoutKName) throws IOException{
		EPackage rootPackage;
		String finalModelFile = null;
		File f = new File(originalModelFile);
		finalModelFile = modelFileName.replace("migrated", "final").replace(refactoredMetamodelWithoutKName+"k",refactoredMetamodelWithoutKName);
		// Loading model, deleting UUIDs and saving model
		rootPackage = UtilEMF.loadMetamodel(keyEcoreFile);
		EPackage originalPackage = UtilEMF.loadMetamodel(originalEcoreFile);
		String URI = originalPackage.getNsURI();
		EObject modelRoot = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(UtilEMF.loadModel(modelFileName, rootPackage)), refactoredMetamodelWithoutK);
		try { UtilEMF.saveModel(modelRoot, finalModelFile); } 
		catch (IOException e) { e.printStackTrace(); }

		//String output = finalModelFile.replace("tempfinal", "final");		
		// add schema location to the migrated file
		//addSchemaLocation(finalModelFile, output, URI, metamodelName);
	}

	/**
	 *  Add schema location to a xmi file
	 * @param inputfile
	 * @param finalModelFile
	 * @param URI
	 * @throws IOException
	 */
	public void addSchemaLocation(String inputfile, String finalModelFile, String URI, String metamodelName) throws IOException {
		//xsi:schemaLocation="http://mde.vallejo.statechart ../metamodel/Statechart.ecore" 
		FileReader fr=new FileReader(inputfile);
		BufferedReader br=new BufferedReader(fr);

		File fout = new File(finalModelFile);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		String line=br.readLine();

		while (line!=null) {
			String xmi = "xmlns:xmi=\"http://www.omg.org/XMI\"";
			//String nom = "Statechart.ecore";
			if(line.contains(xmi)){
				String newLine = line.replace(xmi, "xsi:schemaLocation=\""+ URI + " ../metamodel/"+ metamodelName +"\""+ " "+xmi);
				bw.write(newLine);
			}else{
				bw.write(line);
			}
			bw.newLine();  
			line=br.readLine();
		} 
		br.close();
		fr.close();  
		bw.close();
	}

	/**
	 * Deletion of UUID values
	 */
	public void removeUUIDValue(){
		try {
			EPackage rootPackage; 
			String finalModelFile = null;
			/*if(isUML){
				File f = new File(originalModelFile);
				String[] strArray = originalModelFile.split("\\.");
				String modelName = strArray[0];
				finalModelFile = (originalModelFile.replace(modelName, modelName+"_final").replace("file:",""));

				// Loading model, deleting UUIDs and saving model
				rootPackage = UtilEMF.loadMetamodel(keyEcoreFile);
				//EObject modelRoot = UtilEMF.changeMetamodel(null, UtilEMF.removeUUIDValues(UtilEMF.loadModel(recontextualizedGraphModelFile, rootPackage)), UMLPackage.eINSTANCE);
				//UtilEMF.saveModel(modelRoot, finalModelFile);
			}else{*/
			File f = new File(originalModelFile);
			String[] strArray = originalModelFile.split("\\.");
			String modelName = strArray[0];
			String modelMetamodel = strArray[1];
			//finalModelFile = (originalModelFile.replace(modelName, modelName+"_final").replace("file:",""));
			String[] strArrayTool = recontextualizedGraphModelFile.split("\\.");
			String toolMetamodel = strArrayTool[1];
			finalModelFile = recontextualizedGraphModelFile.replace("_recontextgraph", "").replace(toolMetamodel, modelMetamodel);
			// Loading model, deleting UUIDs and saving model
			rootPackage = UtilEMF.loadMetamodel(keyEcoreFile);
			EObject modelRoot = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(UtilEMF.loadModel(recontextualizedGraphModelFile, rootPackage)), originalEcoreFile);
			UtilEMF.saveModel(modelRoot, finalModelFile);
			//}
			System.out.println("[saving] file "+finalModelFile +": ok");
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * Generates the modif file able to refactor the domain metamodel
	 * 
	 * @param domainMetamodel metamodel to be refactored
	 * @param atlModif type of modif (NoModif or EraseAll)
	 * @param modifFile modif file name
	 * @throws IOException
	 */
	public void generateModifFile(String domainMetamodel, int atlModif, String modifFile, boolean key) throws IOException{
		ModifIO aModifIO = new ModifIO();
		utilModifFactory anUtilModifFactory = new utilModifFactory();
		EPackage theRootEcore        = aModifIO.LoadEcore(domainMetamodel);
		Modifications theRootModif;
		if (atlModif==2) { theRootModif = anUtilModifFactory.generateEraseAll(theRootEcore, key); }
		else { theRootModif = anUtilModifFactory.generateNoModif(theRootEcore, key); }
		OutputStream f = new FileOutputStream(modifFile) ;
		ModifIO.SaveModif(theRootModif, modifFile);
	}

	/**
	 * Simplifies the modif file
	 * 
	 * @param modifF modif file
	 */
	public void Minimize(String modifF) {
		Minimize tool = new Minimize();
		Modifications modif = modifIO.LoadModif(modifF);
		tool.go(modif);
		try { ModifIO.SaveModif(modif, modifF);
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * Create the modif file
	 */
	public void CreateModif() {
		// fabric call from files
		if(keyEcoreFile == null){
			String[] strArray = originalEcoreFile.split("\\.");

			String modelName = strArray[strArray.length-2];
			this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"K"));
		}
		modifIO.setModifIO(keyEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		theRootEcoreModifCopy = theRootEcoreModif;
		buildSuperTypesMap(theRootEcoreModif);
	}

	/**
	 * Create the modif file
	 */
	public RootEcoreModif CreateModif(boolean simpleRefactoring,  String metamodel) {
		EPackage rootkeyPackage;
		// fabric call from files
		if(simpleRefactoring){			
			modifIO.setModifIO(originalEcoreFile, modifFile);
			theRootEcoreModif = modifIO.getEcoreModif();
			theRootEcoreModifCopy = theRootEcoreModif;
			buildSuperTypesMap(theRootEcoreModif);
			//simple migration
		}else{
			EPackage domainMM = UtilEMF.loadMetamodel(metamodel);
			boolean addKeys = true;
			// verifying if keys were already added
			for(TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();){
				EObject next = it.next();
				if(next instanceof EClass){
					EClass c = (EClass) next;
					for(EAttribute ea : c.getEAllAttributes()){
						if(ea.getName().equals("UUID")){
							addKeys = false;
							break;
						}
					}
				}
			}

			// adding keys
			if(addKeys){ rootkeyPackage = addUUIDAttributes();
			}
			else{ rootkeyPackage = domainMM; }

			if(keyEcoreFile == null){
				String[] strArray = originalEcoreFile.split("\\.");
				String modelName = strArray[strArray.length-2];
				this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"K"));
			}
			modifIO.setModifIO(keyEcoreFile, modifFile);
			theRootEcoreModif = modifIO.getEcoreModif();
			theRootEcoreModifCopy = theRootEcoreModif;
			buildSuperTypesMap(theRootEcoreModif);
			buildHideList(theRootEcoreModif);
			buildFlattenList(theRootEcoreModif);
		}

		return theRootEcoreModif;
	}

	/**
	 * Create the modif file
	 */
	public RootEcoreModif CreateModif(String metamodel) {
		EPackage rootkeyPackage;
		// fabric call from files
		EPackage domainMM = UtilEMF.loadMetamodel(metamodel);
		rootkeyPackage = domainMM;
		if(keyEcoreFile == null){
			String[] strArray = originalEcoreFile.split("\\.");
			String modelName = strArray[strArray.length-2];
			this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"extendedK"));
		}

		modifIO.setModifIO(keyEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();

		//theRootEcoreModifCopy = theRootEcoreModif;
		//buildSuperTypesMap(theRootEcoreModif);
		//buildHideList(theRootEcoreModif);
		//buildFlattenList(theRootEcoreModif);
		return theRootEcoreModif;
	}

	/**
	 * Modif specification creation
	 * @param type
	 * @param extendedPackage
	 * @param extendedName
	 * @return
	 */
	public RootEcoreModif createModifSpecification(int type, EPackage extendedPackage, String extendedName) {
		String modifNoModif;
		String modifEraseAll;
		File noModif;
		File eraseAll;
		EObject modifSpecification = null;

		File f = new File(this.originalEcoreFile);
		int idx = f.getName().lastIndexOf('.');

		File modifFolder = new File(f.getParent().replace("metamodel", "modif"));

		// modif folder does not exist
		if(!modifFolder.exists()){
			//modif folder creation
			File dir = new File(f.getParent()+"/../modif");
			dir.mkdir();
			System.out.println("The modif folder has been created");
		}

		switch (type) {
		case 1:
			modifNoModif = f.getParent().replace("metamodel", "modif")+"/NoModif"+extendedPackage.getName()+".modif";
			noModif = new File(modifNoModif);
			modifFile = modifNoModif;
			// There is a NoModif specification
			if(noModif.exists()){
				System.out.println("[rewriting] The "+ noModif.getName() +" specification will be rewrited");
			}
			modifSpecification = createModif(noModif, modifNoModif, type, extendedName);
			break;

		case 2:
			modifEraseAll = f.getParent().replace("metamodel", "modif")+"/eraseAll"+extendedPackage.getName()+".modif";
			eraseAll = new File(modifEraseAll);
			modifFile = modifEraseAll;
			// There is a eraseAll specification
			if(eraseAll.exists()){
				System.out.println("[rewriting] The "+ eraseAll.getName() +" specification will be rewrited");
			}
			modifSpecification = createModif(eraseAll, modifEraseAll, type, extendedName);
			break;
		}

		modifIO.setModifIO(extendedName, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		return theRootEcoreModif;
	}	

	/**
	 * 
	 * @param modifFile
	 * @param modifFileName
	 * @param type
	 * @return
	 */
	public EObject createModif(File modifFile, String modifFileName, int type, String extendedPackage) {
		ModifIO aModifIO = new ModifIO();
		utilModifFactory anUtilModifFactory = new utilModifFactory();
		EPackage theRootEcore = aModifIO.LoadEcore(extendedPackage);
		Modifications theRootModif;
		if (type==2) {
			theRootModif = anUtilModifFactory.generateEraseAll(theRootEcore);
		} else {
			theRootModif = anUtilModifFactory.generateNoModif(theRootEcore);
		}
		try {
			OutputStream ff = new FileOutputStream(modifFile) ;
			// Saving the modif specification
			ModifIO.SaveModif(theRootModif, modifFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (EObject)theRootModif;
	}

	/**
	 * Create for a specific metamodel
	 */
	public EObject createModif(File modifFile, String modifFileName, int type) {
		ModifIO aModifIO = new ModifIO();
		utilModifFactory anUtilModifFactory = new utilModifFactory();
		EPackage theRootEcore = aModifIO.LoadEcore(this.originalEcoreFile);
		Modifications theRootModif;
		if (type==2) {
			theRootModif = anUtilModifFactory.generateEraseAll(theRootEcore);
		} else {
			theRootModif = anUtilModifFactory.generateNoModif(theRootEcore);
		}
		try {
			OutputStream ff = new FileOutputStream(modifFile) ;
			ModifIO.SaveModif(theRootModif, modifFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (EObject)theRootModif;
	}

	/**
	 * Create the modif file
	 */
	public void CreateModifUML() {
		// fabric call from files
		modifIO.setModifIO(this.originalEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
	}

	/**
	 * Select a modif specification
	 * @param packageName
	 * @param modifFile
	 * @return
	 */
	public RootEcoreModif loadModifSpecification(String packageName, String modifFile) {
		modifIO.setModifIO(packageName, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		return theRootEcoreModif;
	}

	/**
	 * Refactoring of metamodels
	 */
	public ArrayList<EPackage> Refactoring(RootEcoreModif theRootEcoreModif) {
		ArrayList<EPackage> refactoredPackages = new ArrayList<EPackage>();
		System.out.println("Refactoring");				
		if (theRootEcoreModif != null) {
			if (Refactoring.isOk(theRootEcoreModif)) {
				// launch refactoring operators
				Refactoring.operate(theRootEcoreModif);
			}
		}

		refactoredPackages.add(theRootEcoreModif.getRoot().getEcore());

		if(!theRootEcoreModif.getRoot().getEcore().getESubpackages().isEmpty()) {
			for(EPackage subp : theRootEcoreModif.getRoot().getEcore().getESubpackages()) {
				refactoredPackages.add(subp);
			}
		}

		return refactoredPackages;
	}

	/**
	 * 
	 * @param projectSourceFolder
	 * @param modifSpecificationType
	 * @param isUML
	 */
	public void Refactoring(String projectSourceFolder, int modifSpecificationType, boolean isUML, boolean GUI, String existingMetamodel) {
		if(isUML) {
			try {
				String refactoredMetamodelPath = RefactoringUML(projectSourceFolder, modifSpecificationType, false, GUI);
				// Compares the refactored metamodel with an existing metamodel
				if(existingMetamodel != "") {
					boolean check = Compare(refactoredMetamodelPath, existingMetamodel);
					if(check == true){
						System.out.println("Refactored Metamodel and target metamodel matches");
					}else{
						System.out.println("Refactored Metamodel and target metamodel does not match");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// TODO Refactoring
		}
	}

	/**
	 * 
	 * @param projectSourceFolder
	 * @param modifSpecificationType
	 * @throws IOException
	 */
	public String RefactoringUML(String projectSourceFolder, int modifSpecificationType, boolean coevolution, boolean GUI) throws IOException {
		String refactoredMetamodelPath = null;

		// Copie d'UML avec Ecore local
		EPackage sourceMetamodel = EcoreUtil.copy(UMLPackage.eINSTANCE);

		// Copie d'UML avec Ecore local sans operations, sans annotations et sans ref opposites. 
		EPackage sourceMetamodelSimple = UtilEMF.removeOperations(UtilEMF.removeAnnotations(UtilEMF.removeOppositeFeature(sourceMetamodel)));
		UtilEMF.saveMetamodel(sourceMetamodelSimple, projectSourceFolder+"/metamodel/UML.ecore", true);

		if(coevolution) {
			// Copie d'UML avec Ecore local sans operations, sans annotations et sans ref opposites. 
			// Avec UUID
			sourceMetamodelUUID = UtilEMF.addUUIDAttribute(sourceMetamodelSimple);
			// Deletion of duplicate UUID attribute
			EPackage sourceMetamodelUUIDunique = UtilEMF.removeDuplicateUUIDAttribute(sourceMetamodelUUID);
			UtilEMF.saveMetamodel(sourceMetamodelUUIDunique, projectSourceFolder+"/metamodel/UMLUUID.ecore", true);
		}

		// Create a by default modif specification
		String modifFileName = null;
		if(modifSpecificationType == 1) {
			if(coevolution) {
				modifFileName = projectSourceFolder+"/modif/NoModifUMLUUID.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
			}else {
				modifFileName = projectSourceFolder+"/modif/NoModifUML.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
			}
		}else if(modifSpecificationType == 2){
			if(coevolution) {
				modifFileName = projectSourceFolder+"/modif/EraseAllUMLUUID.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
			}else {
				modifFileName = projectSourceFolder+"/modif/EraseAllUML.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
			}
		}

		// Refactoring

		if(coevolution) {
			setFiles(projectSourceFolder, projectSourceFolder+"/metamodel/UMLUUID.ecore", modifFileName, null, null);

		}else {
			setFiles(projectSourceFolder, projectSourceFolder+"/metamodel/UML.ecore", modifFileName, null, null);
		}

		if(!GUI) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Modify your modif file in order to indicate de operators to be applied");
			System.out.println("Did you finish? y/n");
			String finish = keyboard.nextLine();

			if(finish.equals("y")) {
				CreateModifUML();
				// Siplifying the modif specification
				Minimize(modifFileName);
				refactoredMetamodelPath = Refactor();
			}else {
				// TODO finish != y
			}
			keyboard.close();

			if(coevolution) {
				// Delete UUIDs from the refactored metamodel
				EPackage refactoredMetamodel = UtilEMF.removeUUIDAttribute(refactoredMetamodelPath);
				UtilEMF.saveMetamodel(refactoredMetamodel, refactoredMetamodelPath.replace("UUID",""));
			}
		}else {
			CreateModifUML();
		}
		return refactoredMetamodelPath;
	}

	/**
	 * Transforms the input ecore according to the operators of the modif file
	 */
	public String Refactor() {
		if (theRootEcoreModif != null) {
			if (Refactoring.isOk(theRootEcoreModif)) {
				// launch refactoring operators
				Refactoring.operate(theRootEcoreModif);
				// save the resulting ecore model		
				try {
					// Save refactored metamodel with UUID
					modifIO.save(projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore");		
					refactoredEcoreFile = projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore";
				} catch (IOException e) { e.printStackTrace(); }				
			}else System.out.println("\nChange the Modif model");	
		}
		return refactoredEcoreFile;
	}

	/**
	 * 
	 * @return
	 */
	public EPackage RefactorSimpleMigration() {
		EPackage refactoredWithoutK = null;
		//String refactoredWithoutKFileName = null;
		if (theRootEcoreModif != null) {
			if (Refactoring.isOk(theRootEcoreModif)) {
				// launch refactoring operators
				Refactoring.operate(theRootEcoreModif);
				// save the resulting ecore model		
				try {
					// Save refactored metamodel with UUID
					modifIO.save(projectFile+"\\"+theRootEcoreModif.getRoot().getNewName()+".ecore");	
					refactoredEcoreFile = projectFile+"\\"+theRootEcoreModif.getRoot().getNewName()+".ecore";
					// Save refactored metamodel without UUID
					refactoredWithoutK = UtilEMF.removeUUIDAttribute(UtilEMF.loadMetamodel(refactoredEcoreFile));

					File f = new File(refactoredWithoutK.getNsURI());
					int idx = f.getName().lastIndexOf('K');
					int idx2 = refactoredWithoutK.getName().lastIndexOf('K');
					int idx3 = refactoredWithoutK.getNsPrefix().lastIndexOf('K');
					refactoredWithoutKFileName = (f.getParent()+"/"+f.getName().substring(0, idx)+".ecore").replace("file:\\", "");

					refactoredWithoutK.setName(refactoredWithoutK.getName().substring(0, idx2));
					refactoredWithoutK.setNsPrefix(refactoredWithoutK.getNsPrefix().substring(0, idx3));
					UtilEMF.saveMetamodel(refactoredWithoutK, refactoredWithoutKFileName);
				} catch (IOException e) { e.printStackTrace(); }				
			}else System.out.println("\nChange the Modif model");	
		}
		return refactoredWithoutK;
	}

	/**
	 * 
	 * @param theRootEcoreModif
	 * @return
	 */
	public EPackage RefactorSimpleMigration(RootEcoreModif theRootEcoreModif) {
		EPackage refactoredWithoutK = null;
		if (theRootEcoreModif != null) {
			if (Refactoring.isOk(theRootEcoreModif)) {
				// launch refactoring operators
				Refactoring.operate(theRootEcoreModif);

				// save the resulting ecore model		
				try {
					// Save refactored metamodel with UUID
					modifIO.save(projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore");	
					refactoredEcoreFile = projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore";

					//EPackage refactoredMetamodel = UtilEMF.loadMetamodel(refactoredEcoreFile);

					// Save refactored metamodel without UUID
					//refactoredWithoutK = UtilEMF.removeUUIDAttribute(UtilEMF.loadMetamodel(refactoredEcoreFile));

					/*File f = new File(refactoredWithoutK.getNsURI());
					int idx = f.getName().lastIndexOf('K');
					int idx2 = refactoredWithoutK.getName().lastIndexOf('K');
					int idx3 = refactoredWithoutK.getNsPrefix().lastIndexOf('K');
					refactoredWithoutKFileName = (f.getParent()+"/"+f.getName().substring(0, idx)+".ecore").replace("file:\\", "");
					refactoredWithoutK.setName(refactoredWithoutK.getName().substring(0, idx2));
					refactoredWithoutK.setNsPrefix(refactoredWithoutK.getNsPrefix().substring(0, idx3));*/

					//**//
					//UtilEMF.saveMetamodel(refactoredWithoutK, refactoredWithoutKFileName);
					//boolean withExternalPackagesDependencies = false;
					//UtilEMF.saveMetamodel(refactoredWithoutK, refactoredWithoutKFileName, withExternalPackagesDependencies);
					//refactoredWithoutKFileName = "C:/ModifProject/Test_MultiEcore/metamodel/p1extendedrefactoredK.ecore";
					//UtilEMF.saveMetamodel2(refactoredMetamodel, refactoredWithoutKFileName, withExternalPackagesDependencies);
				} catch (IOException e) { e.printStackTrace(); }			
			}else System.out.println("\nChange the Modif model");	
		}
		return refactoredWithoutK;
	}

	public String getRefactoredWithoutKFileName(){
		return refactoredWithoutKFileName;
	}

	/**
	 * 
	 * @return EPackage of the refactored metamodel
	 */
	public EPackage getRefactoredMetamodel(){
		//EPackage refactoredMetamodel = UtilEMF.loadMetamodel(refactoredEcoreFile);
		return UtilEMF.loadMetamodel(refactoredEcoreFile);
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public void Coevolution(String projectSourceFolder, int modifSpecificationType, boolean isUML,
			String sourceModelPath, boolean withMigrationCodeGeneration, boolean GUI, String existingMetamodel) throws IOException {
		if(isUML) {
			// Refactoring
			String refactoredMetamodelPath = RefactoringUML(projectSourceFolder, modifSpecificationType, true, GUI);

			// Deletion of UUIDs from the refactored metamodel
			EPackage refactoredMetamodelNoUUID = UtilEMF.removeUUIDAttribute(refactoredMetamodelPath);
			String refactoredMetamodelNoUUIDPath = refactoredMetamodelPath.replace("UUID", "");
			UtilEMF.saveMetamodel(refactoredMetamodelNoUUID, refactoredMetamodelNoUUIDPath);

			// Comparison between refactored metamodel and target metamodel
			if(existingMetamodel != "") {
				boolean check = Compare(refactoredMetamodelNoUUIDPath, existingMetamodel);
				if(check == true){
					System.out.println("Refactored Metamodel and target metamodel matches");
					Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, withMigrationCodeGeneration);
				}else{
					System.out.println("Refactored Metamodel and target metamodel does not match");
				}
			}else {
				Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, withMigrationCodeGeneration);
			}
		} else {
			// TODO Refactoring if not UML
		}
	}



	/**
	/**
	 * Checks if the domain metamodel and the tool metamodel fully matches
	 * @return
	 */
	public boolean Compare(){
		boolean check;
		URI uri1 = URI.createFileURI(refactoredEcoreFile);
		URI uri2 = URI.createFileURI(toolEcoreFile);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource = resourceSet1.getResource(uri1, true); 
		Resource resource2 = resourceSet2.getResource(uri2, true);
		IComparisonScope scope = new DefaultComparisonScope(resource, resource2, null);
		org.eclipse.emf.compare.Comparison comparison = EMFCompare.builder().build().compare(scope);
		List<org.eclipse.emf.compare.Diff> differences = ((org.eclipse.emf.compare.Comparison) comparison).getDifferences();
		if(differences.size() == 0){ check = true; }
		else{ check = false; }
		return check;
	}

	/**
	 *  Checks if a metamodel fully matches with an existing metamodel
	 */
	public boolean Compare(String metamodelPath, String existingMetamodelPath) {
		boolean check;
		URI uri1 = URI.createFileURI(metamodelPath);
		URI uri2 = URI.createFileURI(existingMetamodelPath);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource = resourceSet1.getResource(uri1, true); 
		Resource resource2 = resourceSet2.getResource(uri2, true);
		IComparisonScope scope = new DefaultComparisonScope(resource, resource2, null);
		org.eclipse.emf.compare.Comparison comparison = EMFCompare.builder().build().compare(scope);
		List<org.eclipse.emf.compare.Diff> differences = ((org.eclipse.emf.compare.Comparison) comparison).getDifferences();
		if(differences.size() == 0){ check = true; }
		else{ check = false; }
		return check;
	}

	public void constructRenameMap(){
		HashMap<String, Map<String, Map<String, String>>>  RenameMap = new HashMap<String, Map<String, Map<String, String>>>();
		for( EclassModif  ecm : theRootEcoreModif.getAllClassModifications()){
			String oldNameClass = ecm.getModif().getOldName();
			String newNameClass = ecm.getModif().getNewName();
			Map <String, String> featuresNameMap = new HashMap<String, String>();
			for(EattributeModif att : ecm.getAllAttributes()){
				String oldNameAtt = att.getModif().getOldName();
				String newNameAtt = att.getModif().getNewName();
				featuresNameMap.put(oldNameAtt, newNameAtt);
			}
			for(EreferenceModif ref : ecm.getAllReferences()){
				String oldNameRef = ref.getModif().getOldName();
				String newNameRef = ref.getModif().getNewName();
				featuresNameMap.put(oldNameRef, newNameRef);
			}
			Map<String, Map<String, String>> tempMap = new HashMap<String, Map<String,String>>();
			tempMap.put(newNameClass, featuresNameMap);
			renamemap.put(oldNameClass, tempMap);
		}
	}

	/**
	 * Generates the Migration specification
	 * 
	 * @param inputModel
	 * @param keyModelFileName
	 * @throws IOException
	 * 
	 * @return Name of the migrated model
	 */
	public String GenerateMigrationSpecification(String inputModel, String keyModelFileName, 
			ArrayList<String> hideClassesList, ArrayList<String> flattenClassesList) throws IOException{	
		Modifications theRootModif = modifIO.LoadModif(modifFile);	
		renamemap = new HashMap<String, Map<String, Map<String, String>>>();
		constructRenameMap();
		if(keyModelFileName.contains(theRootModif.getRootPackageModification().getOldName().toLowerCase())){
			migratedModelFile = inputModel.replace("."+theRootModif.getRootPackageModification().getOldName().toLowerCase(), "_migrated."+theRootModif.getRootPackageModification().getNewName().toLowerCase());
		}
		migrationSpecificationGenerator = new MigrationSpecificationGenerator(superTypesMap, attributesMap, theRootEcoreModif, theRootEcoreModifCopy, 
				theRootModif, projectFile, keyModelFileName, migratedModelFile, hideClassesList, flattenClassesList);
		migrationFile = migrationSpecificationGenerator.getMigrationFileName();
		hiddenInstances = migrationSpecificationGenerator.getHideInstances();
		newReferenceName = migrationSpecificationGenerator.getNewReferencesName();
		referencesToClassMap = migrationSpecificationGenerator.getReferencesToClassMap();
		System.out.println("[saving] migration specification : ok.");

		System.out.println(" migratedModelFile "+ migratedModelFile);
		return migratedModelFile;
	}

	/**
	 * 
	 * @param sourceModelPath
	 * @param sourceMetamodelPath
	 * @param targetModelPath
	 * @param targetMetamodelPath
	 * @return
	 * @throws IOException
	 */
	public String GenerateMigrationSpecification(String sourceModelPath, String sourceMetamodelPath,
			String targetModelPath, String targetMetamodelPath) throws IOException{	
		migratedModelFile = targetModelPath;
		migrationSpecificationGenerator = new MigrationSpecificationGenerator(theRootEcoreModif, projectFile, sourceModelPath, migratedModelFile);
		migrationFile = migrationSpecificationGenerator.getMigrationFileName();
		System.out.println("[saving] migration specification : ok.");
		return migratedModelFile;
	}

	/** Migration code generation or automatic migration
	 * @throws IOException 
	 * 
	 */
	public void Migrating(String projectSourceFolder, String sourceModelPath, String refactoredMetamodelPath, boolean withMigrationCodeGeneration) throws IOException {
		String sourceModelUUIDPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName(), ".umluuid.xmi");
		String sourceMetamodelUUIDPath = theRootEcoreModif.getRoot().getModif().getOldURIName();
		String migratedModelPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName(), "_migrated."+theRootEcoreModif.getRoot().getModif().getNewName().toLowerCase()+".xmi");
		//String refactoredMetamodelPath = theRootEcoreModif.getRoot().getModif().getNewURIName();

		// Adding UUIDs to the source model
		EObject modelUUID = UtilEMF.changeMetamodel(UtilEMF.loadModel(sourceModelPath, UMLPackage.eINSTANCE), projectSourceFolder+"/metamodel/UMLUUID.ecore");
		EObject modelUUID2 = UtilEMF.addUUIDValues(modelUUID);
		UtilEMF.saveModel(modelUUID2, sourceModelUUIDPath);			

		// Migration Specification generation
		String migrationSpecificationName = GenerateMigrationSpecification(sourceModelUUIDPath, sourceMetamodelUUIDPath, migratedModelPath, refactoredMetamodelPath);

		if(withMigrationCodeGeneration) {
			// Migration code generation
			File fout = new File(projectSourceFolder+"/srcgen/code/MigrationCode.java");
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.write("package code;\n");
			bw.newLine();
			bw.write("import migration.Migration;");
			bw.newLine();
			bw.write("import migration.MigrationPackage;");
			bw.newLine();
			bw.write("import migration.tools.MigrationRoundtrip;");
			bw.newLine();
			bw.write("import migration.tools.UtilEMF;\n");
			bw.newLine();
			bw.write("import org.eclipse.emf.ecore.EObject;");
			bw.newLine();
			bw.write("import org.eclipse.emf.ecore.EPackage;\n");
			bw.newLine();
			bw.write("import org.eclipse.uml2.uml.UMLPackage; \n");
			bw.newLine();
			bw.write("public class MigrationCode {");
			bw.newLine();
			bw.write("    public static void main(String[] args) {");
			bw.newLine();
			bw.write("      try {");
			bw.newLine();
			bw.write("          MigrationRoundtrip migrt = null;");
			bw.newLine();
			bw.write("          String migrationFile = "+migrationSpecificationName+";");
			bw.newLine();
			bw.write("          Migration migration = (Migration) UtilEMF.loadModel(migrationFile, MigrationPackage.eINSTANCE);");
			bw.newLine();
			bw.write("          // Migration execution");
			bw.newLine();
			bw.write("          migrt = new MigrationRoundtrip(migration);");
			bw.newLine();
			bw.write("          // Migrated model with UUID \n");
			bw.newLine();
			bw.write("          EObject migratedModelUUID = migrt.onwardMigration();");
			bw.newLine();
			bw.write("			// Serialisation of the migrated model with UUID \n");
			bw.write("          migrt.serializeMigratedModel();");
			bw.newLine();
			bw.write("          // Deletion of UUIDs");
			bw.newLine();
			bw.write("			EObject migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues("+getMigratedModel()+"), UMLPackage.eINSTANCE); \n");
			bw.newLine();
			bw.write("         // Serialisation of the migrated model \n");
			bw.newLine();
			//	bw.write(" 			UtilEMF.saveModel(migratedModel, projectSourceFolder+"/model/test2.uml");
			bw.write("      } catch (Exception ioe) {");
			bw.newLine();
			bw.write("          ioe.printStackTrace();");
			bw.newLine();
			bw.write("          return;");
			bw.newLine();
			bw.write("      }");
			bw.newLine();
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.newLine();
			bw.write("}");
			bw.newLine();

			bw.close();

		}else { 
			// Migration execution
			migrt = Migration();
			migrt.serializeMigratedModel();
			System.out.println("[saving] migrated file : ok.");	

			// Deletion of UUIDs
			EObject migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(getMigratedModel()), UMLPackage.eINSTANCE);	

			// Serialisation of the migrated model
			UtilEMF.saveModel(migratedModel, projectSourceFolder+"/model/test2.uml");
		}
	}


	/**
	 * 
	 * @return
	 */
	public String getMigratedModelFileName(){
		return migratedModelFile;
	}

	/**
	 * 
	 * @return
	 */
	public EObject getMigratedModel() {
		return migratedModel;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String,String> getNewReferencesNameMap(){
		return this.newReferenceName;
	}

	/**
	 * 
	 * @return
	 */
	public String getMigrationFileName(){
		return migrationFile;
	}

	/**
	 * Update the migration specification
	 * @param instanceUUID
	 * @param value
	 * @param migration
	 */
	public Migration modifyInstance(String instanceUUID, boolean value, Migration migration)
	{
		Migration newMigration = null;
		try { newMigration = migrationSpecificationGenerator.modifyInstance(instanceUUID, value, migration); } 
		catch (IOException e) { e.printStackTrace(); }
		return newMigration;
	}

	/**
	 * 
	 * @param migration
	 */
	public void addDeletedReferences(Migration migration)
	{
		migrationSpecificationGenerator.addDeleteReferences(migration);
	}

	/**
	 * Clean the custom migration specification
	 */
	public void cleanMigrationSpecification(Migration migration){
		migrationSpecificationGenerator.cleanMigrationSpecification(migration);
	}

	ArrayList<String> hiddenInstances = new ArrayList<String>();
	private boolean result;

	ArrayList<String> getHiddenInstances(){
		return hiddenInstances;
	}

	/**
	 * Fills the map of instances whose EClasses are hidden
	 * 
	 * @param migration migration specification
	 * @return hidemap
	 */
	public Map<String, Map<String, ArrayList<ArrayList<String>>>> createHideMap(Migration migration){
		hidemap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
		for(Instance instance : migration.getInstances()){
			if(!instance.getDerived().isEmpty()){
				Map<String, ArrayList<ArrayList<String>>> derivedReferences = new HashMap<String, ArrayList<ArrayList<String>>>();
				if((instance.getDerived()).size() ==  1){
					DerivedReference derived = instance.getDerived().get(0);
					String newReferenceName = derived.getNewReferenceName();
					ArrayList<ArrayList<String>> allDerived = new ArrayList<ArrayList<String>>();
					for(ReferencePath refPath : derived.getPath()){
						String refName = refPath.getReferenceName();
					}
					/*	for( DerivedReference derivedRef : derived.getDerivedReferences()){
						String refName = derivedRef.getReferenceName();
						String target = derivedRef.getTarget().getUUID();
						ArrayList<String> derivedR = new ArrayList<String>();
						derivedR.add(refName);
						derivedR.add(target);
						allDerived.add(derivedR);	
					}*/
					//derivedReferences.put(newReferenceName, allDerived);
				}
				hidemap.put(instance.getUUID(), derivedReferences);
			}
		}
		return hidemap;
	}

	/**
	 * Onward migration of a given input model to a new model
	 * conforming with the targeted tool's definition domain
	 */
	public MigrationRoundtrip Migration(Map<String,String> newReferenceNameMap, Map<String, Map<String, Map<String, String>>> renameMap) {
		MigrationRoundtrip migrt = null;
		try {
			Migration migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
			Map<String, Map<String, ArrayList<ArrayList<String>>>>  hideMap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
			hideMap = createHideMap(migration);
			migrt = new MigrationRoundtrip(migration);
			EObject migratedModel;
			if(hasHide(migration)){ 
				migratedModel = migrt.onwardMigrationHide(migration, newReferenceNameMap, renameMap); }
			else{ 
				//migratedModel = migrt.onwardMigration(); 
				migratedModel = migrt.onwardMigrationRename(renameMap);
			}
			migrt.serializeMigratedModel();
			System.out.println("[saving] migrated file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}

	/**
	 * Onward migration of a given input model to a new model
	 * conforming with the targeted tool's definition domain
	 */
	public MigrationRoundtrip Migration() {
		MigrationRoundtrip migrt = null;
		Migration migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
		migrt = new MigrationRoundtrip(migration);
		migratedModel = migrt.onwardMigration();
		return migrt;
	}

	/**
	 * 
	 * @param newReferenceNameMap
	 * @param renameMap
	 * @param migrationFile
	 * @return
	 */
	public MigrationRoundtrip Migration(Map<String,String> newReferenceNameMap, Map<String, Map<String, Map<String, String>>> renameMap, String migrationFile) {
		MigrationRoundtrip migrt = null;
		try {
			migration = (Migration) UtilEMF.loadModel(migrationFile, MigrationPackage.eINSTANCE);
			Map<String, Map<String, ArrayList<ArrayList<String>>>>  hideMap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
			hideMap = createHideMap(migration);
			migrt = new MigrationRoundtrip(migration);
			EObject migratedModel;
			if(hasHide(migration)){ 
				migratedModel = migrt.onwardMigrationHide(migration, newReferenceNameMap, renameMap); }
			else{ 
				//migratedModel = migrt.onwardMigration(); 
				migratedModel = migrt.onwardMigrationRename(renameMap);
			}
			migrt.serializeMigratedModel();
			System.out.println("[saving] migrated file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}

	/**
	 * Reverse migration of a processed model
	 * @param migrt migration
	 * @return migration object
	 */
	public MigrationRoundtrip ReverseMigration(MigrationRoundtrip migrt){
		try {
			this.migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
			EObject toolOutputModel = UtilEMF.loadModel(this.toolOutputModelFile, URI.createURI(migration.getOutputMetamodelURI()).path());
			String reversedModelName = null;
			if(isUML){
				String inputmodelName = migration.getInputModelURI();
				String[] strArray = inputmodelName.split("\\.");
				String modelName = strArray[0];
				reversedModelName = (inputmodelName.replace(modelName, modelName+"_reversed").replace("file:",""));
			}else{
				String inputmodelName = migration.getInputModelURI();
				String[] strArray = inputmodelName.split("\\.");
				String metamodelName = strArray[1];
				String[] strArrayTool = toolOutputModelFile.split("\\.");
				String toolPutputModelName = strArrayTool[0];
				String metamodelToolName = strArrayTool[1];
				reversedModelName = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_reversed").replace(metamodelToolName, metamodelName);			
			}
			Map<String,Map<String,Map<String,String>>> inversedMap = reversedMap(renamemap);
			if(hasHide(migration)){	UtilEMF.saveModel(migrt.reverseMigration(toolOutputModel, inversedMap, migration), reversedModelName); }
			else{ UtilEMF.saveModel(migrt.reverseMigration(toolOutputModel), reversedModelName); }
			System.out.println("[saving] reversed file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}

	/**
	 * Reversed hideMap for reverse migration
	 * 
	 * @param map
	 * @return map
	 */
	public Map<String, Map<String, ArrayList<ArrayList<String>>>> reversedHideMap(Map<String, Map<String, ArrayList<ArrayList<String>>>> map){
		Map<String, Map<String, ArrayList<ArrayList<String>>>> reversedMap = new HashMap<String, Map<String,ArrayList<ArrayList<String>>>>();		
		Map<String, ArrayList<ArrayList<String>>> derivedMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		Map<String, ArrayList<ArrayList<String>>> reversedDerivedMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		String key;
		String newKey2;
		for (Entry<String, Map<String, ArrayList<ArrayList<String>>>> e: map.entrySet()) {
			key = e.getKey();
			derivedMap = e.getValue();
			ArrayList<ArrayList<String>> derivedReferences = new ArrayList<ArrayList<String>>();
			String newReferenceName = null;
			for (Entry<String, ArrayList<ArrayList<String>>> entry: derivedMap.entrySet()) {
				newReferenceName = entry.getKey();
				derivedReferences = entry.getValue();
				ArrayList<ArrayList<String>> derivedRef = new ArrayList<ArrayList<String>>();
				String referenceName = null;
				for( ArrayList<String> dr : derivedReferences){
					referenceName = dr.get(0);
					String target = dr.get(1);
					ArrayList<String> newList = new ArrayList<String>();
					newList.add(newReferenceName);
					newList.add(target);
					derivedRef.add(newList);
					reversedDerivedMap.put(referenceName, derivedRef);
				}	
			}
			reversedMap.put(key, reversedDerivedMap);
		}
		return reversedMap;
	}

	/**
	 * Reversed names map for reverse migration
	 * 
	 * @param map
	 * @return map
	 */
	public Map<String, Map<String, Map<String, String>>> reversedMap(Map<String, Map<String,Map<String, String>>> map){
		Map<String, Map<String,Map<String, String>>> result = new HashMap<String, Map<String,Map<String, String>>>();
		Map<String, String> invfeaturesMap = new HashMap<String, String>();
		String key;
		Map<String, Map<String, String>> value = new HashMap<>();
		for (Entry<String, Map<String, Map<String, String>>> e: map.entrySet()) {
			key = e.getKey();
			value = e.getValue();
			String k = null;
			Map<String,String> v;
			Map<String, Map<String,String>> invertedValue = new HashMap<String, Map<String,String>>();
			for (Entry<String, Map<String,String>> ee: value.entrySet()) {
				k = ee.getKey();
				v = ee.getValue();
				for (Entry<String, String> entry : v.entrySet()){ invfeaturesMap.put(entry.getValue(), entry.getKey()); }
				invertedValue.put(key, invfeaturesMap);
			}
			result.put(k, invertedValue);
		}
		return result;
	}


	/**
	 * Recontextualization by keys of a reversed model
	 * 
	 * @param migrt migration
	 * @return migration object
	 */
	public void Recontextualization(MigrationRoundtrip migrt){
		try {
			String recontextualizedKeysModelFile = null;
			String inputmodelName = migration.getInputModelURI();
			File f = new File(inputmodelName);
			String[] strArray = inputmodelName.split("\\.");
			String modelName = strArray[0];		
			String metamodelName = strArray[1];
			String[] strArrayTool = toolOutputModelFile.split("\\.");
			String toolPutputModelName = strArrayTool[0];
			String metamodelToolName = strArrayTool[1];
			recontextualizedKeysModelFile = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_recontextkey").replace(metamodelToolName, metamodelName);	
			UtilEMF.saveModel(migrt.recontextualizationKey(), recontextualizedKeysModelFile);
			System.out.println("[saving] recontextualized by key file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		Graph g = (Graph) UtilEMF.loadModel(graphFile, DependencyPackage.eINSTANCE);
		try {
			String inputmodelName = migration.getInputModelURI();
			File f = new File(inputmodelName);
			String[] strArray = inputmodelName.split("\\.");
			String modelName = strArray[0];
			//recontextualizedGraphModelFile = (inputmodelName.replace(modelName, modelName+"_recontextgraph").replace("file:",""));
			recontextualizedFinalModelFile = (toolOutputModelFile.replace("_migrated", "_recontextgraph"));
			String[] strArrayTool = toolOutputModelFile.split("\\.");
			String toolPutputModelName = strArrayTool[0];
			String metamodelToolName = strArrayTool[1];
			String metamodelName = strArray[1];
			recontextualizedGraphModelFile = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_recontextgraph").replace(metamodelToolName, metamodelName);	
			UtilEMF.saveModel(migrt.recontextualizationGraph(g),recontextualizedGraphModelFile);
			System.out.println("[saving] recontextualized by graph file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
	}

	public String getRecontexGraphFileName(){
		return recontextualizedFinalModelFile;
	}

	/**
	 * Recontextualization by graph of a recontextualized by graph model
	 * 
	 * @param migrt migration 
	 * @return
	 */
	public MigrationRoundtrip RecontextualizationGraph(MigrationRoundtrip migrt) {
		Graph g = (Graph) UtilEMF.loadModel(graphFile, DependencyPackage.eINSTANCE);
		try {
			UtilEMF.saveModel(migrt.recontextualizationGraph(g),  recontextualizedGraphModelFile);
			System.out.println("[saving] recontextualized by graph file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return null;
	}

	public void buildSuperTypesMap(RootEcoreModif rootEcoreModif){
		superTypesMap = new HashMap<String, ArrayList<String>>();
		attributesMap = new HashMap<String, ArrayList<String>>();
		for( EClassifier c : rootEcoreModif.getRoot().getEcore().getEClassifiers()){
			ArrayList<String> supertypes = new ArrayList<String>();
			ArrayList<String> attributes = new ArrayList<String>();
			if(c instanceof EClass){
				for(EAttribute a : ((EClass)c).getEAttributes()){ attributes.add(a.getName()); }
				attributesMap.put(c.getName(), attributes);
				for(EClass st : ((EClass)c).getEAllSuperTypes()){ supertypes.add(st.getName()); }
				superTypesMap.put(c.getName(), supertypes);
			}
		}
	}

	private boolean isAbstract (RootEcoreModif rootEcoreModif, ClassModification ecm){
		boolean result = false;
		for(EClassifier ec : rootEcoreModif.getRoot().getEcore().getEClassifiers()){
			if(((EClass)ec).isAbstract()){
				if(ec.getName().equals(ecm.getOldName())){
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private boolean hasSuperTypes(RootEcoreModif rootEcoreModif, ClassModification ecm){
		boolean result = false;
		for(EClassifier ec : rootEcoreModif.getRoot().getEcore().getEClassifiers()){
			if(!((EClass)ec).getEAllSuperTypes().isEmpty()){
				if(ec.getName().equals(ecm.getOldName())){
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Builds the list of classes marked with the hide operator
	 * @param rootEcoreModif
	 * @return hideClassList
	 */
	public void buildHideList(RootEcoreModif rootEcoreModif){	
		hideClassList = new ArrayList<String>();
		for( ClassModification ecm : rootEcoreModif.getRoot().getModif().getClassModification()){
			if(ecm.isHide()){
				if(hasSuperTypes(rootEcoreModif, ecm)){
					hideClassList.add(ecm.getOldName());
				}
			}
		}
	}

	/**
	 * Builds the list of classes marked with the flatten operator
	 * @param rootEcoreModif
	 * @return flattenClassList
	 */
	public void buildFlattenList(RootEcoreModif rootEcoreModif){	
		flattenClassList = new ArrayList<String>();
		for( ClassModification ecm : rootEcoreModif.getRoot().getModif().getClassModification()){
			if(ecm.isFlatten()){ 
				if(hasSuperTypes(rootEcoreModif, ecm)){
					flattenClassList.add(ecm.getOldName()); 
				}
			}
		}
	}

	/**
	 * 
	 * @return list of classes marked with hide operator
	 */
	public ArrayList<String> getHideClassList(){
		return hideClassList;
	}

	/**
	 * 
	 * @return list of classes marked with flatten operator
	 */
	public ArrayList<String> getFlattenClassList(){
		return flattenClassList;
	}

	/**
	 * 
	 * @param migration
	 * @return
	 */
	public boolean hasHide(Migration migration){
		boolean hide = false;
		for(Instance i : migration.getInstances()){
			if(!i.getDerived().isEmpty()){
				hide = true;
				break;
			}
		}
		return hide;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, Map<String, Map<String, String>>>  getRenameMap(){
		return renamemap;
	}
}

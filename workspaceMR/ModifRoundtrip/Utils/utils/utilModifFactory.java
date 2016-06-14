/**
 * class to build by-default modif model from ecore model
 *  
 * Copyright (C) 2013 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 16 déc. 2013
 */
package utils;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.ModifFactoryImpl;

public class utilModifFactory {

	protected ModifFactory myFactory;

	public utilModifFactory() {
		myFactory = new ModifFactoryImpl();
	}

	public Modifications generateNoModif(EPackage epackage, boolean withKey) {

		Modifications noModifModel = myFactory.createModifications();

		noModifModel.setRemoveAllEStringAttributes(false);
		noModifModel.setRemoveAllOperations(false);
		noModifModel.setRemoveAllOpposites(false);
		noModifModel.setAddAllOpposite(false);
		noModifModel.setRemoveAllAnnotations(false);
		noModifModel.setAddRootClass(null);
		noModifModel.setAddNameClass(null);

		noModifModel.setRootPackageModification(generateNoModifPack (epackage, withKey));

		return noModifModel;
	}

	public Modifications generateNoModif(EPackage epackage) {

		Modifications noModifModel = myFactory.createModifications();

		noModifModel.setRemoveAllEStringAttributes(false);
		noModifModel.setRemoveAllOperations(false);
		noModifModel.setRemoveAllOpposites(false);
		noModifModel.setAddAllOpposite(false);
		noModifModel.setRemoveAllAnnotations(false);
		noModifModel.setAddRootClass(null);
		noModifModel.setAddNameClass(null);

		noModifModel.setRootPackageModification(generateNoModifPack (epackage));

		return noModifModel;
	}

	private PackageModification generateNoModifPack(EPackage epackage) {

		PackageModification noModifModel = myFactory.createPackageModification();
		String newName;
		String newPrefix;
		String newUri;
		newName = epackage.getName()+"2";
		newPrefix = epackage.getNsPrefix()+"2";
		newUri = epackage.getNsURI();		
		/*if(epackage.getNsURI().toLowerCase().contains((epackage.getName()+".ecore").toLowerCase())){
			newUri = epackage.getNsURI().toLowerCase().replace(epackage.getName()+"ecore", epackage.getName()+"2.ecore");
		}*/
		if(epackage.getNsURI().toLowerCase().contains(".ecore")){
			newUri = epackage.getNsURI().toLowerCase().replace(".ecore", "2.ecore");
		}

		noModifModel.setOldName(epackage.getName());
		noModifModel.setNewName(newName);
		noModifModel.setRemoveEAnnotations(false);
		noModifModel.setRemove(false);		

		noModifModel.setOldPrefixName(epackage.getNsPrefix());
		noModifModel.setNewPrefixName(newPrefix);
		noModifModel.setOldURIName(epackage.getNsURI());
		noModifModel.setNewURIName(newUri);
		noModifModel.setHide(false);

		for (EPackage subPackage : epackage.getESubpackages()) {
			noModifModel.getPackageModification().add(generateNoModifPack(subPackage));
		}
		for (EClassifier subClassifier : epackage.getEClassifiers()) {
			if (subClassifier instanceof EClass) {
				noModifModel.getClassModification().add(generateNoModifClass((EClass) subClassifier));
			}
			if (subClassifier instanceof EEnum) {
				noModifModel.getEnumModification().add(generateNoModifEnum((EEnum) subClassifier));
			} else if (subClassifier instanceof EDataType) {
				noModifModel.getDataTypeModification().add(generateNoModifDataType((EDataType) subClassifier));
			}
		}
		for (EAnnotation eannot : epackage.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private PackageModification generateNoModifPack(EPackage epackage, boolean withUUID) {
		PackageModification noModifModel = myFactory.createPackageModification();
		String newName;
		String newPrefix;
		String newUri = null;

		if(!withUUID){
			newName = epackage.getName()+'2';
			newPrefix = epackage.getNsPrefix()+'2';			
			newUri = epackage.getNsURI().toLowerCase().replace(epackage.getName()+".ecore", epackage.getName()+"2.ecore");

		}else{
			newName = epackage.getName()+"2UUID";
			newPrefix = epackage.getNsPrefix()+"2UUID";
			newUri = epackage.getNsURI();	

			if(epackage.getNsURI().toLowerCase().contains((epackage.getName()+"UUID.ecore").toLowerCase())){
				newUri = epackage.getNsURI().toLowerCase().replace((epackage.getName()+"UUID.ecore").toLowerCase(), epackage.getName()+"2UUID.ecore");
			}
		}

		noModifModel.setOldName(epackage.getName());
		noModifModel.setNewName(newName);
		noModifModel.setRemoveEAnnotations(false);
		noModifModel.setRemove(false);		

		noModifModel.setOldPrefixName(epackage.getNsPrefix());
		noModifModel.setNewPrefixName(newPrefix);
		noModifModel.setOldURIName(epackage.getNsURI());
		noModifModel.setNewURIName(newUri);
		noModifModel.setHide(false);

		for (EPackage subPackage : epackage.getESubpackages()) {
			noModifModel.getPackageModification().add(generateNoModifPack(subPackage, withUUID));
		}
		for (EClassifier subClassifier : epackage.getEClassifiers()) {
			if (subClassifier instanceof EClass) {
				noModifModel.getClassModification().add(generateNoModifClass((EClass) subClassifier));
			}
			if (subClassifier instanceof EEnum) {
				noModifModel.getEnumModification().add(generateNoModifEnum((EEnum) subClassifier));
			} else if (subClassifier instanceof EDataType) {
				noModifModel.getDataTypeModification().add(generateNoModifDataType((EDataType) subClassifier));
			}
		}
		for (EAnnotation eannot : epackage.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private ClassModification generateNoModifClass(EClass eclass) {

		ClassModification noModifModel = myFactory.createClassModification();

		noModifModel.setOldName(eclass.getName());
		noModifModel.setNewName(eclass.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		noModifModel.setChangeAbstract(false);
		noModifModel.setHide(false);
		noModifModel.setFlatten(false);
		noModifModel.setFlattenAll(false);
		noModifModel.setEnumerate(null);

		for (EStructuralFeature esf : eclass.getEStructuralFeatures()) {
			if (esf instanceof EAttribute) {
				noModifModel.getFeatureModification().add(generateNoModifAttribute((EAttribute) esf));
			}
			if (esf instanceof EReference) {
				noModifModel.getFeatureModification().add(generateNoModifReference((EReference) esf));
			}
		}
		for (EAnnotation eannot : eclass.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private AttributeModification generateNoModifAttribute(EAttribute eatt) {
		AttributeModification noModifModel = myFactory.createAttributeModification();

		noModifModel.setOldName(eatt.getName());
		noModifModel.setNewName(eatt.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);		

		ChangeBounds cb = myFactory.createChangeBounds();

		cb.setOldLower(eatt.getLowerBound());
		cb.setNewLower(eatt.getLowerBound());
		cb.setOldUpper(eatt.getUpperBound());
		cb.setNewUpper(eatt.getUpperBound());

		noModifModel.setChangeBounds(cb);
		//		noModifModel.setChangeBounds(null);

		noModifModel.setChangeType(false);

		for (EAnnotation eannot : eatt.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private ReferenceModification generateNoModifReference(EReference eref) {
		ReferenceModification noModifModel = myFactory.createReferenceModification();

		noModifModel.setOldName(eref.getName());
		noModifModel.setNewName(eref.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		ChangeBounds cb = myFactory.createChangeBounds();

		cb.setOldLower(eref.getLowerBound());
		cb.setNewLower(eref.getLowerBound());
		cb.setOldUpper(eref.getUpperBound());
		cb.setNewUpper(eref.getUpperBound());

		noModifModel.setChangeBounds(cb);
		//		noModifModel.setChangeBounds(null);

		noModifModel.setChangeContainement(false);
		noModifModel.setRemoveOpposite(false);
		noModifModel.setAddOpposite(null);
		noModifModel.setReify(null);

		for (EAnnotation eannot : eref.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private DataTypeModification generateNoModifDataType(EDataType edt) {
		DataTypeModification noModifModel = myFactory.createDataTypeModification();

		noModifModel.setOldName(edt.getName());
		noModifModel.setNewName(edt.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		noModifModel.setOldInstanceTypeName(edt.getInstanceTypeName());
		noModifModel.setNewInstanceTypeName(edt.getInstanceTypeName());

		for (EAnnotation eannot : edt.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private EnumModification generateNoModifEnum(EEnum enm) {
		EnumModification noModifModel = myFactory.createEnumModification();

		noModifModel.setOldName(enm.getName());
		noModifModel.setNewName(enm.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		// noModifModel.setOldInstanceTypeName(enm.getInstanceTypeName());
		// noModifModel.setNewInstanceTypeName(enm.getInstanceTypeName());
		noModifModel.setReify(false);

		for (EEnumLiteral enml : enm.getELiterals()) {
			noModifModel.getEnumLiteralModification().add(generateNoModifEnumLiteral(enml));
		}				
		for (EAnnotation eannot : enm.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private EnumLiteralModification generateNoModifEnumLiteral(EEnumLiteral enml) {
		EnumLiteralModification noModifModel = myFactory.createEnumLiteralModification();

		noModifModel.setOldName(enml.getName());
		noModifModel.setNewName(enml.getName());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		noModifModel.setOldLiteral(enml.getLiteral());
		noModifModel.setNewLiteral(enml.getLiteral());
		noModifModel.setOldValue(enml.getValue());
		noModifModel.setNewValue(enml.getValue());

		for (EAnnotation eannot : enml.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private AnnotationModification generateNoModifAnnotation(EAnnotation eann) {
		AnnotationModification noModifModel = myFactory.createAnnotationModification();

		noModifModel.setOldSource(eann.getSource());
		noModifModel.setNewSource(eann.getSource());
		noModifModel.setRemove(false);
		noModifModel.setRemoveEAnnotations(false);

		for ( Entry<String, String> detent : eann.getDetails()) {
			noModifModel.getDetailsEntryModification().add(generateNoModifDetailsEntry(detent));
		}		
		for (EAnnotation eannot : eann.getEAnnotations()) {
			noModifModel.getAnnotationModification().add(generateNoModifAnnotation(eannot));
		}

		return noModifModel;
	}

	private DetailsEntryModification generateNoModifDetailsEntry(Entry<String, String> detent) {
		DetailsEntryModification noModifModel = myFactory.createDetailsEntryModification();

		noModifModel.setOldKey(detent.getKey());
		noModifModel.setNewKey(detent.getKey());
		noModifModel.setOldValue(detent.getValue());
		noModifModel.setNewValue(detent.getValue());
		noModifModel.setRemove(false);

		return noModifModel;
	}

	/**
	 * 
	 * @param epackage
	 * @return
	 */
	public Modifications generateEraseAll(EPackage epackage) {
		Modifications eraseAllModel = generateNoModif(epackage);
		generateEraseAllPackage(eraseAllModel.getRootPackageModification());
		eraseAllModel.getRootPackageModification().setRemove(false);
		return eraseAllModel;
	}

	public Modifications generateEraseAll(EPackage epackage, boolean withKey) {

		Modifications eraseAllModel = generateNoModif(epackage, withKey);

		generateEraseAllPackage(eraseAllModel.getRootPackageModification());

		eraseAllModel.getRootPackageModification().setRemove(false);

		return eraseAllModel;
	}

	public void generateEraseAllPackage(PackageModification eraseAllModel) {

		eraseAllModel.setRemove(true);

		for (PackageModification subPackage : eraseAllModel.getPackageModification()) {
			generateEraseAllPackage(subPackage);
		}
		for (ClassModification subClass : eraseAllModel.getClassModification()) {
			generateEraseAllClass(subClass);
		}
		for (DataTypeModification dataType : eraseAllModel.getDataTypeModification()) {
			generateEraseAllDataType(dataType);
		}					
		for (EnumModification eNum : eraseAllModel.getEnumModification()) {
			generateEraseAllEnum(eNum);
		}
		for (AnnotationModification eAn : eraseAllModel.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn);
		}
	}

	private void generateEraseAllAnnotation(AnnotationModification eAn) {

		eAn.setRemove(true);

		for (AnnotationModification eAn2 : eAn.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}
		for ( DetailsEntryModification detent : eAn.getDetailsEntryModification()) {
			generateEraseAllDetailsEntry(detent);
		}	
	}

	private void generateEraseAllDetailsEntry(DetailsEntryModification detent) {

		detent.setRemove(true);

	}

	private void generateEraseAllEnum(EnumModification eNum) {

		eNum.setRemove(true);

		for (EnumLiteralModification enl : eNum.getEnumLiteralModification()) {
			generateEraseAllEnumLiteral(enl);
		}
		for (AnnotationModification eAn2 : eNum.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}

	}

	private void generateEraseAllEnumLiteral(EnumLiteralModification enl) {

		enl.setRemove(true);

		for (AnnotationModification eAn2 : enl.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}

	}

	private void generateEraseAllDataType(DataTypeModification dataType) {

		dataType.setRemove(true);

		for (AnnotationModification eAn2 : dataType.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}

	}

	private void generateEraseAllClass(ClassModification subClass) {

		subClass.setRemove(true);

		for (StructuralFeatureModification fm : subClass.getFeatureModification()) {
			if (fm instanceof AttributeModification) {
				generateEraseAllAttribute((AttributeModification) fm);
			}
			if (fm instanceof ReferenceModification) {
				generateEraseAllReference((ReferenceModification) fm);
			}
		}

		for (AnnotationModification eAn2 : subClass.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}

	}

	private void generateEraseAllReference(ReferenceModification rm) {

		rm.setRemove(true);

		for (AnnotationModification eAn2 : rm.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);
		}

	}

	private void generateEraseAllAttribute(AttributeModification am) {

		if(am.getOldName().equals("UUID")){
			am.setRemove(false);
		}else{
			am.setRemove(true);
		}


		for (AnnotationModification eAn2 : am.getAnnotationModification()) {
			generateEraseAllAnnotation(eAn2);

		}

	}

}

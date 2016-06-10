/**
 * comment
 *  
 * Copyright (C) 2016 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 27 mai 2016
 */
package migrationRoundtrip;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.SourceVersion;

import migration.Migration;
import modif.ClassModification;
import modif.Modifications;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import ecoremodif.RootEcoreModif;
import ecoremodif.utils.ModifIO;
import utils.IOModifSpecification;
import utils.UtilEMF;
import utils.UtilUUID;

/**
 * @author Paola Vallejo
 *
 */
public class ModifRoundtrip <S extends EObject, T extends EObject >{

	EPackage sourceMetamodel;
	EPackage sourceMetamodelUUID;
	EObject sourceModel;
	EObject sourceModelUUID;
	EPackage targetMetamodel;
	EPackage targetMetamodelUUID;
	EObject targetModel;
	EObject targetModelUUID;
	Modifications modifSpecification;
	Migration migrationSpecification;

	private static RootEcoreModif theRootEcoreModif;


	/**
	 * 
	 * @param theModel Model to be migrated
	 * @return migratedModel
	 */
	public EObject migrateModel(EObject theModel, boolean automaticMigration){
		String sourceMetamodelNsURI = theModel.eClass().getEPackage().getNsURI();

		// Source Metamodel
		@SuppressWarnings("deprecation")
		URI metamodelURI = URI.createDeviceURI(sourceMetamodelNsURI);
		sourceMetamodel = UtilEMF.loadMetamodel(metamodelURI);

		// Source Metamodel UUID
		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);

		System.out.println(" --- sourceMetamodelUUID : --- "+ sourceMetamodelUUID);
		for(EClassifier ec: sourceMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		// Modif specification generation. By default it produces a copy of the source metamodel
		ModifSpecification.setSourceMetamodel(sourceMetamodelUUID);
		ModifSpecification.generateModifSpecification(1);
		modifSpecification = ModifSpecification.getModifSpecification();
		IOModifSpecification.saveModifSpecification(modifSpecification, "C:/ModifRoundtrip-project/workspaceMR/RoundtripShapes/modif/RefactorShapes.modif");


		// Refactor
		/*	targetMetamodelUUID = refactor();

		System.out.println(" --- targetMetamodelUUID : --- "+ targetMetamodelUUID);
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}*/

		/*try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, "C:/ModifRoundtrip-project/workspaceMR/TestRoundtrip/model/targetMMUUID.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		/*	targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);

		System.out.println(" --- targetMetamodel : --- "+ targetMetamodel);
		for(EClassifier ec: targetMetamodel.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}


		// Source model
		sourceModel = theModel;

		System.out.println(" \n --- Source Model : --- ");
		for(EObject eo : sourceModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
		}	

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		String timestamp = UtilUUID.getTimeStampFromModel(sourceModelUUID);
		System.out.println(" --- Source Model UUID : --- "+ timestamp);
		for(EObject eo : sourceModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString() + "  "+ eo.eGet(eo.eClass().getEStructuralFeature(timestamp)).toString());
		}

		MigrationSpecification.setModifSpecification(modifSpecification);
		MigrationSpecification.setSourceMetamodel(sourceMetamodelUUID);
		MigrationSpecification.setSourceModel(sourceModelUUID);
		MigrationSpecification.setTargetMetamodel(targetMetamodelUUID);

		MigrationSpecification.generateMigrationSpecification();
		migrationSpecification = MigrationSpecification.getMigrationSpecification();

		System.out.println(" --- Migration specification : --- ");
		for(EObject eo : migrationSpecification.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("UUID")).toString());
			for(EObject o : eo.eContents()){
				System.out.println("  "+ o.eGet(o.eClass().getEStructuralFeature("deleteInstance")));
			}
		}

		// Migration

		Migrate.setSourceModel(sourceModelUUID);
		Migrate.setMigrationSpecification(migrationSpecification);
		Migrate.migrateModel(targetMetamodelUUID);

		targetModelUUID = Migrate.getTargetModel();
		System.out.println(" --- target Model UUID : --- ");
		for(EObject eo : targetModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString() + "  "+ eo.eGet(eo.eClass().getEStructuralFeature(timestamp)).toString());
		}

		// Delete UUIDs			
		targetModel = UtilUUID.removeUUIDModelAttribute(targetModelUUID, targetMetamodel);
		System.out.println(" --- target Model : --- ");
		for(EObject eo : targetModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
		}*/

		return theModel;
	}

	/**
	 * 
	 * @param theModel
	 * @param theMetamodel
	 * @param theModifSpecification
	 * @param automaticMigration
	 * @param serializeModel
	 * @return
	 */
	/*public EObject migrateModel(EObject theModel, EPackage theSourceMetamodel, EPackage theTargetMetamodel, Modifications theModifSpecification, boolean automaticMigration, boolean serializeModel){

		// Source Metamodel
		sourceMetamodel = theSourceMetamodel;

		// Source Metamodel UUID
		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);
		String timestamp = UtilUUID.getTimeStamp();

		System.out.println(" --- sourceMetamodelUUID : --- "+ sourceMetamodelUUID.getName() + "  "+ timestamp);
		for(EClassifier ec: sourceMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		// Modif specification
		modifSpecification = theModifSpecification;		

		// Target Metamodel UUID
		targetMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(theTargetMetamodel, timestamp);

		System.out.println(" --- targetMetamodelUUID : --- "+ targetMetamodelUUID.getName());
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		// Source model
		sourceModel = theModel;

		System.out.println(" \n --- Source Model : --- ");
		for(EObject eo : sourceModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString() );
			}
		}	

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		try {
			UtilEMF.saveModel(sourceModelUUID, "./model/test.xmi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("//// timestamp  ! "+timestamp);

		System.out.println(" --- Source Model UUID : --- ");
		for(EObject eo : sourceModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			//System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString() + "  "+ eo.eGet(eo.eClass().getEStructuralFeature(timestamp)).toString());

			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}

		MigrationSpecification.setModifSpecification(modifSpecification);
		MigrationSpecification.setSourceMetamodel(sourceMetamodelUUID);
		MigrationSpecification.setSourceModel(sourceModelUUID);
		MigrationSpecification.setTargetMetamodel(targetMetamodelUUID);

		MigrationSpecification.generateMigrationSpecification();
		migrationSpecification = MigrationSpecification.getMigrationSpecification();

		System.out.println(" --- Migration specification : --- ");
		System.out.println(migrationSpecification.getInputMetamodelURI());
		System.out.println(migrationSpecification.getInputModelURI());
		System.out.println(migrationSpecification.getOutputMetamodelURI());
		System.out.println(migrationSpecification.getOutputModelURI());
		for(EObject eo : migrationSpecification.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("UUID")).toString());
			for(EObject o : eo.eContents()){
				System.out.println("  "+ o.eGet(o.eClass().getEStructuralFeature("deleteInstance")));
			}
		}

		// Migration

		Migrate.setSourceModel(sourceModelUUID);
		Migrate.setMigrationSpecification(migrationSpecification);
		Migrate.migrateModel(sourceMetamodelUUID, targetMetamodelUUID);

		targetModelUUID = Migrate.getTargetModel();
		System.out.println(" --- target Model UUID : --- ");
		for(EObject eo : targetModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}

		/*	// Delete UUIDs			
		targetModel = UtilUUID.removeUUIDModelAttribute(targetModelUUID, targetMetamodel);
		System.out.println(" --- target Model : --- ");
		for(EObject eo : targetModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}*/

		/*return targetModel;
	}*/


	/**
	 * 
	 * @param theModel
	 * @param theModifSpecification
	 * @param automaticMigration
	 * @param serializeModel
	 * @return
	 */
	public EObject migrateModel(EObject theModel, EPackage theSourceMetamodel, EPackage theTargetMetamodel, Modifications theModifSpecification, boolean automaticMigration, boolean serializeModel){
		// Source Metamodel
		sourceMetamodel = theSourceMetamodel;
		targetMetamodel = theTargetMetamodel;

		// Source Metamodel UUID
		
		targetMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(targetMetamodel);
		try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, "./metamodel/test2.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);
		try {
			UtilEMF.saveMetamodel(sourceMetamodelUUID, "./metamodel/test1.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Modif specification
		modifSpecification = theModifSpecification;	

		// Target metamodel UUID
	/*	targetMetamodelUUID = refactor();
		
		System.out.println(" --- targetMetamodelUUID : --- "+ targetMetamodelUUID.getName());
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, "./metamodel/test1.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		

		/*System.out.println(" +++ targetMetamodelUUID : --- "+ targetMetamodelUUID.getName());
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}*/


		if(automaticMigration){

		}else{

		}

		if(serializeModel){

		}


	/*	// Source model
		sourceModel = theModel;

		System.out.println(" \n --- Source Model : --- ");
		for(EObject eo : sourceModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}	

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		timestamp = UtilUUID.getTimeStampFromModel(sourceModelUUID);
		System.out.println("timestamp : " +timestamp);
		System.out.println(" --- Source Model UUID : --- "+ timestamp);
		for(EObject eo : sourceModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString() + "  "+ eo.eGet(eo.eClass().getEStructuralFeature(timestamp)).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString() + "  "+ eo2.eGet(eo2.eClass().getEStructuralFeature(timestamp)).toString());
			}
		}

		MigrationSpecification.setModifSpecification(modifSpecification);
		MigrationSpecification.setSourceMetamodel(sourceMetamodelUUID);
		MigrationSpecification.setSourceModel(sourceModelUUID);
		MigrationSpecification.setTargetMetamodel(targetMetamodelUUID);

		MigrationSpecification.generateMigrationSpecification();
		migrationSpecification = MigrationSpecification.getMigrationSpecification();

		System.out.println(" --- Migration specification : --- ");
		System.out.println(migrationSpecification.getInputMetamodelURI());
		System.out.println(migrationSpecification.getInputModelURI());
		System.out.println(migrationSpecification.getOutputMetamodelURI());
		System.out.println(migrationSpecification.getOutputModelURI());
		for(EObject eo : migrationSpecification.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("UUID")).toString());
			for(EObject o : eo.eContents()){
				System.out.println("  "+ o.eGet(o.eClass().getEStructuralFeature("deleteInstance")));
			}
		}

		// Migration

		Migrate.setSourceModel(sourceModelUUID);
		Migrate.setMigrationSpecification(migrationSpecification);
		Migrate.migrateModel(targetMetamodelUUID);

		targetModelUUID = Migrate.getTargetModel();
		System.out.println(" --- target Model UUID : --- ");
		for(EObject eo : targetModelUUID.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString() + "  "+ eo.eGet(eo.eClass().getEStructuralFeature(timestamp)).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString() + "  "+ eo2.eGet(eo2.eClass().getEStructuralFeature(timestamp)).toString());
			}

		}

		// Delete UUIDs			
		targetModel = UtilUUID.removeUUIDModelAttribute(targetModelUUID, targetMetamodel);
		System.out.println(" --- target Model : --- ");
		for(EObject eo : targetModel.eContents()){
			System.out.println(eo.eGet(eo.eClass().getEStructuralFeature("name")).toString());
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}*/

		return targetModel;
	}

	/**
	 * Transform the source metamodel according to the operators of the modif specification.
	 */
	private EPackage refactor() {
		EPackage theSourceMetamodelUUID = EcoreUtil.copy(sourceMetamodelUUID);
		ModifIO modifIO = new ModifIO();
		modifIO.setModifIO(theSourceMetamodelUUID, modifSpecification);	
		theRootEcoreModif = modifIO.getEcoreModif();	
		if (theRootEcoreModif != null) {
			if (ApplyOperators.isOk(theRootEcoreModif)) {
				// launch refactoring operators
				ApplyOperators.operate(theRootEcoreModif);
			}
		}
		targetMetamodelUUID = theRootEcoreModif.getRoot().getEcore();
		return targetMetamodelUUID;
	}

	/**
	 * To be used when the sourceMetamodel is not serialized in a file
	 * @param sourceMetamodel 
	 * @param modifSpecification
	 * @param serialize
	 * @return
	 */
	public EPackage refactor(EPackage sourceMetamodel, Modifications modifSpecification, boolean serializeModif, boolean serializeTarget) {
		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);
		EPackage theSourceMetamodelUUID = EcoreUtil.copy(sourceMetamodelUUID);

		boolean compatible = checkModifMetamodelCompatibility(sourceMetamodelUUID, modifSpecification);

		if(compatible) {

			ModifIO modifIO = new ModifIO();
			modifIO.setModifIO(theSourceMetamodelUUID, modifSpecification);	
			theRootEcoreModif = modifIO.getEcoreModif();	

			if (theRootEcoreModif != null) {
				if (ApplyOperators.isOk(theRootEcoreModif)) {
					// launch refactoring operators
					ApplyOperators.operate(theRootEcoreModif);
				}
			}

			targetMetamodelUUID = theRootEcoreModif.getRoot().getEcore();
			targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);

			if(serializeModif){
				// Modif Specification serialization
				String modifSpecificationName = modifSpecification.getRootPackageModification().getOldName()+"-TO-"+modifSpecification.getRootPackageModification().getNewName();
				File modifFile = new File("./modif/"+modifSpecificationName+".modif");

				if(modifFile.exists()){
					boolean modifRewrite = readYesNot("Do you want to rewrite the "+ modifSpecificationName + ".modif file? [y/n] ", "Answer \'y\' or \'n\'");
					if(modifRewrite){
						IOModifSpecification.saveModifSpecification(modifSpecification, "./modif/"+modifSpecificationName +".modif");
					}else{
						String newName = readString("Give a file name: ");
						if(newName.contains(".modif")){
							IOModifSpecification.saveModifSpecification(modifSpecification, "./modif/"+newName);
						}else{
							IOModifSpecification.saveModifSpecification(modifSpecification, "./modif/"+newName +".modif");
						}
					}
				}else{
					IOModifSpecification.saveModifSpecification(modifSpecification, "./modif/"+modifSpecificationName +".modif");
				}
			}

			if(serializeTarget){
				// Refactored metamodel serialization
				String targetMetamodelFileName = "./metamodel/"+targetMetamodel.getName()+".ecore";

				File targetMetamodelFile = new File(targetMetamodelFileName);
				if(targetMetamodelFile.exists()){
					boolean targetRewrite = readYesNot("Do you want to rewrite the "+ targetMetamodelFileName + " file? [y/n] ", "Answer \'y\' or \'n\'");
					if(targetRewrite) {
						try {
							UtilEMF.saveMetamodel(targetMetamodel, "./metamodel/"+targetMetamodel.getName()+".ecore");
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("[saving] file "+targetMetamodel.getName() +".ecore : ok.");
					}else{
						String newName = readString("Give a file name: ");
						if(newName.contains(".ecore")){
							try {
								UtilEMF.saveMetamodel(targetMetamodel, "./metamodel/"+newName);
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("[saving] file "+newName +": ok.");
						}else{
							try {
								UtilEMF.saveMetamodel(targetMetamodel, "./metamodel/"+newName+".ecore");
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("[saving] file "+newName+".ecore"+": ok.");
						}
					}
				}else{
					try {
						UtilEMF.saveMetamodel(targetMetamodel, "./metamodel/"+targetMetamodel.getName()+".ecore");
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("[saving] file "+targetMetamodel.getName() +".ecore : ok.");
				}
			}
			System.out.println("[refactoring] " + sourceMetamodel.getName() +" : done.");
		}else {
			System.out.println(" Modif and Metamodel are not compatible. Correct the modif specification.");
		}
		return targetMetamodel;
	}

	/**
	 * 
	 * @return
	 */
	public EPackage getTargetMetamodel(){
		return targetMetamodel;
	}

	private static boolean readYesNot(String prompt, String error) {
		String s = readString(prompt);
		while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
			System.out.println(error);
			s = readString(prompt);
		}
		return s.equalsIgnoreCase("y");
	}

	private static String readString(String prompt) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		System.out.print(prompt);
		try {
			s = input.readLine();
		} catch (IOException e) {
			System.out.println("Input/output keyboard error");
		}
		return s;
	}

	/**
	 * Check if the modif specification and the metamodel are compatible.
	 * @return compatible. True, if the modif specification can be applied to the metamodel. False, otherwise.
	 */
	private static boolean checkModifMetamodelCompatibility(EPackage sourceMetamodel, Modifications modifSpecification) {
		boolean compatible = false;
		boolean compatiblePackage = checkPackageCompatibility(sourceMetamodel, modifSpecification);
		boolean compatibleClasses = checkClassesCompatibility(sourceMetamodel, modifSpecification);

		if(compatiblePackage && compatibleClasses){
			compatible = true;
		}

		return compatible;
	}

	/**
	 * 
	 * @param sourceMetamodel
	 * @param modifSpecification
	 * @return
	 */
	private static boolean checkPackageCompatibility(EPackage sourceMetamodel, Modifications modifSpecification) {	
		boolean compatiblePackage = false;
		String URI = sourceMetamodel.getNsURI();
		String modifURI = modifSpecification.getRootPackageModification().getOldURIName();
		String prefix = sourceMetamodel.getNsPrefix();
		String modiPrefix = modifSpecification.getRootPackageModification().getOldPrefixName();
		String name = sourceMetamodel.getName();
		String modifName = modifSpecification.getRootPackageModification().getOldName();
		if(!URI.equals(modifURI)){
			System.out.println("Modif and Metamodel are not compatible. Verify the URI.");
		}
		if(!prefix.equals(modiPrefix)){
			System.out.println("Modif and Metamodel are not compatible. Verify the Prefix.");
		}
		if(!name.equals(modifName)){
			System.out.println("Modif and Metamodel are not compatible. Verify the name.");
		}
		if(URI.equals(modifURI) && prefix.equals(modiPrefix) && name.equals(modifName)) {
			compatiblePackage = true;
		}
		return compatiblePackage;
	}

	/**
	 * 
	 * @param sourceMetamodel
	 * @param modifSpecification
	 * @return
	 */
	private static boolean checkClassesCompatibility(EPackage sourceMetamodel, Modifications modifSpecification) {
		boolean compatibleClasses = true;

		for( ClassModification cm : modifSpecification.getRootPackageModification().getClassModification()){
			EClass eClass = UtilEMF.getClass(sourceMetamodel, cm.getOldName());
			if(eClass == null){
				System.out.println(cm.getOldName() +" is not contained in the "+sourceMetamodel.getName()+ " EPackage.");
				compatibleClasses = false;
				break;
			}
		}
		return compatibleClasses;
	}

}

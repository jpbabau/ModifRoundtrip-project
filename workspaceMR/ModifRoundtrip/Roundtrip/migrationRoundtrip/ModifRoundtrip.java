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


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import migration.Migration;
import modif.Modifications;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
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
	 * @param theModifSpecification
	 * @return
	 */

	/**
	 * 
	 * @param theModel
	 * @param theMetamodel if the metamodel is not serialized
	 * @param theModifSpecification
	 * @return
	 */
	public EObject migrateModel(EObject theModel, EPackage theMetamodel, Modifications theModifSpecification, boolean automaticMigration){

		// Source Metamodel
		sourceMetamodel = theMetamodel;

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

		// Modif specification
		modifSpecification = theModifSpecification;		

		// Refactor
		targetMetamodelUUID = refactor();

		System.out.println(" --- targetMetamodelUUID : --- "+ targetMetamodelUUID);
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);

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
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}	

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		String timestamp = UtilUUID.getTimeStampFromModel(sourceModelUUID);
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
		Migrate.migrateModel(sourceMetamodelUUID, targetMetamodelUUID);

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
		}

		return targetModel;
	}



	public EObject migrateModel(EObject theModel, Modifications theModifSpecification, boolean automaticMigration){

		String sourceMetamodelNsURI = theModel.eClass().getEPackage().getNsURI();
		System.out.println(" sourceMetamodelNsURI "+sourceMetamodelNsURI);

		// Source Metamodel
		@SuppressWarnings("deprecation")
		URI metamodelURI = URI.createDeviceURI(sourceMetamodelNsURI);
		System.out.println(" metamodelURI "+metamodelURI);
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

		// Modif specification
		modifSpecification = theModifSpecification;		

		// Refactor
		targetMetamodelUUID = refactor();

		System.out.println(" --- targetMetamodelUUID : --- "+ targetMetamodelUUID);
		for(EClassifier ec: targetMetamodelUUID.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		/*try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, "C:/ModifRoundtrip-project/workspaceMR/TestRoundtrip/model/targetMMUUID.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);

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
			for(EObject eo2 : eo.eContents()){
				System.out.println("  "+eo2.eGet(eo2.eClass().getEStructuralFeature("name")).toString());
			}
		}	

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		String timestamp = UtilUUID.getTimeStampFromModel(sourceModelUUID);
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
		}

		return targetModel;
	}

	/**
	 * Transform the source metamodel according to the operators of the modif specification.
	 */
	private EPackage refactor() {
		EPackage theSourceMetamodelUUID = EcoreUtil.copy(sourceMetamodelUUID);

		//boolean compatible = checkModifMetamodelCompatibility();
		boolean compatible = true;

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
		}else {

			System.out.println(" Modif and Metamodel are not compatible ");
		}
		return targetMetamodelUUID;
	}

	/**
	 * To be used when the sourceMetamodel is not serialized in a file
	 * @param sourceMetamodel 
	 * @param modifSpecification
	 * @param serialize
	 * @return
	 */
	public EPackage refactor(EPackage sourceMetamodel, Modifications modifSpecification, boolean serializeModif, boolean serialize) {
		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);

		EPackage theSourceMetamodelUUID = EcoreUtil.copy(sourceMetamodelUUID);

		//boolean compatible = checkModifMetamodelCompatibility();
		boolean compatible = true;

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
				File modifFile = new File(modifSpecificationName+".modif");
				Scanner keyboard = new Scanner(System.in);
				if(modifFile.exists()){
					System.out.println("A file with the name: "+modifSpecificationName+ " exists. ");
					System.out.println("Do you want to rewrite it? y/n");
					String rewrite = keyboard.nextLine();
					if(rewrite.equals("y")) {
						IOModifSpecification.saveModifSpecification(modifSpecification, "./modif/"+modifSpecificationName +".modif");
					}else if(rewrite.equals("n")){
						System.out.println("Give a file name:");
						String newName = keyboard.nextLine();
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

			if(serialize){
				// Refactored metamodel serialization
				String targetMetamodelFileName = "./metamodel/"+targetMetamodel.getName()+".ecore";

				File targetMetamodelFile = new File(targetMetamodelFileName);
				if(targetMetamodelFile.exists()){
					System.out.println("A file with the name: "+targetMetamodelFileName+ " exists. ");
					System.out.println("Do you want to rewrite it? y/n");
					Scanner keyboard = new Scanner(System.in);
					String rewrite = keyboard.nextLine();
					if(rewrite.equals("y")) {
						try {
							UtilEMF.saveMetamodel(targetMetamodel, "./metamodel/"+targetMetamodel.getName()+".ecore");
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("[saving] file "+targetMetamodel.getName() +".ecore : ok.");
					}else if(rewrite.equals("n")){
						System.out.println("Give a file name:");
						String newName = keyboard.nextLine();
						
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

		}else {

			System.out.println(" Modif and Metamodel are not compatible ");
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


}

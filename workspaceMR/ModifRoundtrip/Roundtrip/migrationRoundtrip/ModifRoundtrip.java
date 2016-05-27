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

import java.io.IOException;

import migration.Migration;
import modif.Modifications;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodif.RootEcoreModif;
import ecoremodif.utils.ModifIO;
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

	public EObject migrateModel(EObject theModel, Modifications theModifSpecification){
		String sourceMetamodelNsURI = theModel.eClass().getEPackage().getNsURI();

		// Source Metamodel
		@SuppressWarnings("deprecation")
		URI metamodelURI = URI.createDeviceURI(sourceMetamodelNsURI);
		sourceMetamodel = UtilEMF.loadMetamodel(metamodelURI);

		// Source Metamodel UUID
		sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);
		try {
			UtilEMF.saveMetamodel(sourceMetamodelUUID, 
					"C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/sourceMetamodelUUID.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Modif specification
		modifSpecification = theModifSpecification;

		// Source model
		sourceModel = theModel;

		// Source model UUID
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(theModel, sourceMetamodelUUID);

		try {
			UtilEMF.saveModel(sourceModelUUID, 
					"C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/sourceModelUUID.xmi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Refactor
		targetMetamodelUUID = refactor();

		System.out.println(" targetMetamodelUUID   "+targetMetamodelUUID);

		try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, 
					"C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/targetMetamodelUUID.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);
		try {
			UtilEMF.saveMetamodel(targetMetamodel, 
					"C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/targetMetamodel.ecore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MigrationSpecification.setModifSpecification(modifSpecification);
		MigrationSpecification.setSourceMetamodel(sourceMetamodelUUID);
		MigrationSpecification.setSourceModel(sourceModelUUID);
		MigrationSpecification.setTargetMetamodel(targetMetamodelUUID);

		MigrationSpecification.generateMigrationSpecification();
		migrationSpecification = MigrationSpecification.getMigrationSpecification();

		// Migration

		Migrate.setSourceModel(sourceModelUUID);
		Migrate.setMigrationSpecification(migrationSpecification);
		Migrate.migrateModel(targetMetamodelUUID);

		targetModelUUID = Migrate.getTargetModel();

			try {
			UtilEMF.saveModel(targetModelUUID, "C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/targetModelUUID.xmi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Delete UUIDs			
		targetModel = UtilUUID.removeUUIDModelAttribute(targetModelUUID, targetMetamodel);
		try {
			UtilEMF.saveModel(targetModel, "C:/ModifRoundtrip-project/workspaceMR/GraphMigration/model/targetModel.xmi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return theModel;
	}

	/**
	 * Transform the source metamodel according to the operators of the modif specification.
	 */
	public EPackage refactor() {
		//boolean compatible = checkModifMetamodelCompatibility();
		boolean compatible = true;

		if(compatible) {

			ModifIO modifIO = new ModifIO();
			modifIO.setModifIO(sourceMetamodelUUID, modifSpecification);	
			theRootEcoreModif = modifIO.getEcoreModif();	

			System.out.println("theRootEcoreModif   "+theRootEcoreModif);

			if (theRootEcoreModif != null) {
				if (ApplyOperators.isOk(theRootEcoreModif)) {
					// launch refactoring operators
					ApplyOperators.operate(theRootEcoreModif);
				}
			}

			targetMetamodelUUID = theRootEcoreModif.getRoot().getEcore();
			
			//System.out.println(" targetMetamodelUUID -- "+targetMetamodelUUID);

		}else {

			System.out.println(" Modif and Metamodel are not compatible ");
		}
		return targetMetamodelUUID;
	}


}

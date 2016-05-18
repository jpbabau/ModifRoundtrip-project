package coevolution;

import java.io.IOException;

import migration.Migration;
import migration.UtilMigration;
import migrationSpecification.UtilMigrationSpecification;
import modif.Modifications;
import modifspecification.IOModifSpecification;
import modifspecification.UtilModifSpecification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emf.UtilEMF;
import refactor.UtilRefactor;
import uuids.UtilUUID;

/**
 * Class for handling coevolution.
 *
 * A target metamodel is produced from a source metamodel and a modif specification.
 * A migration specification si produced from a source model, a source metamodel and a modif specification.
 * A target model is produced from a source model and a migration specification.
 * This class gathers useful functions to coevolve metamodels and models.
 * 
 * @author P. Vallejo
 *
 */

public class Coevolution {

	// ATTRIBUTES ******************************************************************************

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

	// PRIVATE *********************************************************************************



	// PUBLIC **********************************************************************************

	/**
	 * Refactor the source metamodel (according to the modif specification) 
	 * and migrates the source model (according to the migration specification)
	 */
	public void coevolve(){

		// Refactoring

		UtilRefactor.setSourceMetamodel(this.sourceMetamodelUUID);
		UtilRefactor.setModifSpecification(this.modifSpecification);
		UtilRefactor.refactor();
		targetMetamodelUUID = UtilRefactor.getTargetMetamodel();

		try {
			UtilEMF.saveMetamodel(targetMetamodelUUID, modifSpecification.getRootPackageModification().getNewURIName().replace("file:/", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);		

		// Add UUIDs to model
		sourceModelUUID = UtilUUID.addUUIDModelAttribute(sourceModel, sourceMetamodelUUID);

		// Migration specification

		UtilMigrationSpecification.setModifSpecification(modifSpecification);
		UtilMigrationSpecification.setSourceMetamodel(sourceMetamodelUUID);
		UtilMigrationSpecification.setSourceModel(sourceModelUUID);
		UtilMigrationSpecification.setTargetMetamodel(targetMetamodelUUID);

		UtilMigrationSpecification.generateMigrationSpecification();
		migrationSpecification = UtilMigrationSpecification.getMigrationSpecification();

		// Migration

		UtilMigration.setSourceModel(sourceModelUUID);
		UtilMigration.setMigrationSpecification(migrationSpecification);
		UtilMigration.migrateModel();
		targetModelUUID = UtilMigration.getTargetModel();

		// Delete UUIDs
		targetModel = UtilUUID.removeUUIDModelAttribute(targetModelUUID, targetMetamodel);

	}

	/**
	 * Create a modif specification from the source model.
	 * @param modifSpecificationPath Path to save the modif specification
	 * @return theModifSpecification Modif specification compatible with the source metamodel 
	 */
	public Modifications createModif(String modifSpecificationPath){
		Modifications theModifSpecification = null; 

		// Add UUIDs to the source metamodel
		this.sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);

		UtilModifSpecification.setSourceMetamodel(this.sourceMetamodelUUID);

		// Generate the modif specification
		UtilModifSpecification.generateModifSpecification(1);
		theModifSpecification = UtilModifSpecification.getModifSpecification();

		// Save the modif specification in a file
		IOModifSpecification.saveModifSpecification(theModifSpecification, modifSpecificationPath);
		this.modifSpecification = theModifSpecification;

		return theModifSpecification; 
	}

	/**
	 * Get the target metamodel.
	 * @return targetMetamodel Refactored metamodel.
	 */
	public EPackage getTargetMetamodel(){
		return targetMetamodel;
	}

	/**
	 * Get the target model.
	 * @return targetModel. Migrated model.
	 */
	public EObject getTargetModel(){
		return targetModel;
	}

	/**
	 * Refactor the source metamodel (with UUIDs) according to the operators of the modif specification.
	 * @return targetMetamodel Refactored metamodel (whitout UUIDs).
	 */
	public EPackage refactor(){
		EPackage targetMetamodelUUID; 
		UtilRefactor.setSourceMetamodel(this.sourceMetamodelUUID);
		UtilRefactor.setModifSpecification(this.modifSpecification);
		UtilRefactor.refactor();
		targetMetamodelUUID = UtilRefactor.getTargetMetamodel();
		EPackage targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);
		return targetMetamodel;
	}

	/**
	 * Set the source metamodel.
	 * @param theSourceMetamodel Source metamodel.
	 */
	public void setSourceMetamodel(EPackage theSourceMetamodel){
		this.sourceMetamodel = theSourceMetamodel;
	}

	/**
	 * Set the source model.
	 * @param theSourceModel Source model.
	 */
	public void setSourceModel(EObject theSourceModel){
		this.sourceModel = theSourceModel;
	}	

}

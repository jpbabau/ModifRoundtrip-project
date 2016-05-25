package utils;

import migration.Migration;

import org.eclipse.emf.ecore.EObject;

import coevolution.MigrationRoundtrip;

public class UtilMigration {

	// ATTRIBUTES *******************************************************************************

	static Migration migrationSpecification;
	static EObject sourceModel;
	static EObject targetModel;

	// PRIVATE **********************************************************************************


	// PUBLIC **********************************************************************************

	/**
	 * Get the target model. 
	 * @return targetModel. Model modified.
	 */
	public static EObject getTargetModel(){
		return targetModel;
	}
	
	/**
	 * Migrate a source model, according to the modifications indicated in the migration specification.
	 */
	public static void migrateModel(){
		MigrationRoundtrip migrt = null;
		migrt = new MigrationRoundtrip(migrationSpecification);
		targetModel = migrt.onwardMigration();
	}
	
	/**
	 * Set the migration specification.
	 * @param theMigrationSpecification The migration specification containing the modifications to be applied to the source model.
	 */
	public static void setMigrationSpecification(Migration theMigrationSpecification){
		migrationSpecification = theMigrationSpecification;
	}

	/**
	 * Set the source model.
	 * @param theSourceModel Model to be migrated.
	 */
	public static void setSourceModel(EObject theSourceModel){
		sourceModel = theSourceModel;
	}

}

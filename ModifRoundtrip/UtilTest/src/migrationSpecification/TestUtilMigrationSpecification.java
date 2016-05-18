package migrationSpecification;

import migration.Migration;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class TestUtilMigrationSpecification {

	public static void main(String[] args) {

		/** TEST 1  - Generation **/

		// Load source metamodel (with UUIDs)
		EPackage sourceMetamodel = IOMigrationSpecification.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");

		// Set source metamodel
		UtilMigrationSpecification.setSourceMetamodel(sourceMetamodel);
		
		// Load targetMetamodel (with UUIDs)
		EPackage targetMetamodel = IOMigrationSpecification.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test1/MPLUUIDRefactored.ecore");

		// Set target metamodel
		UtilMigrationSpecification.setTargetMetamodel(targetMetamodel);
		
		// Load modif specification
		Modifications modifSpecification = IOMigrationSpecification.loadModifSpecification("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");
		
		// Set modif specification
		UtilMigrationSpecification.setModifSpecification(modifSpecification);
		
		// Load source model (with UUIDs)
		EObject sourceModel = IOMigrationSpecification.loadModel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Test3/model.mpluuid.xmi", sourceMetamodel);
		
		// Set source model
		UtilMigrationSpecification.setSourceModel(sourceModel);
		
		// Generate migration specification
		UtilMigrationSpecification.generateMigrationSpecification();
		
		// Get Migration specification
		Migration migrationSpecification = UtilMigrationSpecification.getMigrationSpecification();
				
		// Save migration specification
		IOMigrationSpecification.saveMigrationSpecification(migrationSpecification, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/migration/Test1/CopyMPL.migration.xmi");		
		
		/** TEST 2  - Loading **/
		
	/*	Migration migrationSpecification2 = IOMigrationSpecification.loadMigrationSpecification("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/migration/Test1/CopyMPL.migration.xmi");
		IOMigrationSpecification.saveMigrationSpecification(migrationSpecification2, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/migration/Test2/CopyMPL.migration.xmi");*/
	}
}

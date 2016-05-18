package migration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class TestMigration {

	public static void main(String[] args) {

		/** TEST 1  - Migrate **/

		// Load migration specification
		Migration migrationSpecification = IOMigration.loadMigrationSpecification("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/migration/Test2/CopyMPL.migration.xmi");

		// Set Migration specification
		UtilMigration.setMigrationSpecification(migrationSpecification);

		// Load source model
		EPackage sourceMetamodel = IOMigration.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");
		EObject sourceModel = IOMigration.loadModel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Test3/model.mpluuid.xmi", sourceMetamodel);

		// set sourceModel
		UtilMigration.setSourceModel(sourceModel);

		// Migrate
		UtilMigration.migrateModel();

		// Get target model
		EObject targetModel = UtilMigration.getTargetModel();

		// Save target model
		IOMigration.saveModel(targetModel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Test1/model.mplrefactoreduuid.xmi");
	}

}

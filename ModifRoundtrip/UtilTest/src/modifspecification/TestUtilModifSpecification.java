package modifspecification;

import org.eclipse.emf.ecore.EPackage;

import migration.tools.UtilEMF;
import modif.Modifications;

public class TestUtilModifSpecification {

	public static void main(String[] args) {


		/** TEST 1  - Generation **/

		// Source metamodel (with UUIDs)
	/*	EPackage sourceMetamodelUUID = UtilEMF.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");

		// Set seource metamodel
		UtilModifSpecification.setSourceMetamodel(sourceMetamodelUUID);

		// Generate the modif specification. 1 -> Copy
		UtilModifSpecification.generateModifSpecification(1);

		// Get the modif specification
		Modifications modifSpecification = UtilModifSpecification.getModifSpecification();

		// Save the modif specification
		IOModifSpecification.saveModifSpecification(modifSpecification, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");*/

		/** TEST 2  - Minimize **/

		Modifications modifSpecification2 = IOModifSpecification.loadModifSpecification("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");
		UtilModifSpecification.setModifSpecification(modifSpecification2);
		
		UtilModifSpecification.minimizeToUpdate();
		Modifications modifSpecificationMinUpdate = UtilModifSpecification.getModifSpecification();
		IOModifSpecification.saveModifSpecification(modifSpecificationMinUpdate, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test2/CopyMPLMinUpdate.modif");

		UtilModifSpecification.minimizeStrong();
		Modifications modifSpecificationMinStrong = UtilModifSpecification.getModifSpecification();
		IOModifSpecification.saveModifSpecification(modifSpecificationMinStrong, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test2/CopyMPLMinStrong.modif");


		/** TEST 3  - Load **/

	/*	Modifications modifSpecificationLoad = IOModifSpecification.loadModifSpecification("C:/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");
		
		UtilModifSpecification.minimizeToUpdate();
		Modifications modifSpecificationMinUpdate2 = UtilModifSpecification.getModifSpecification();
		IOModifSpecification.saveModifSpecification(modifSpecificationMinUpdate2, "C:/ModifRoundtrip/UtilTest/modif/Test3/CopyMPLMinUpdate2.modif");

		UtilModifSpecification.minimizeStrong();
		Modifications modifSpecificationMinStrong2 = UtilModifSpecification.getModifSpecification();
		IOModifSpecification.saveModifSpecification(modifSpecificationMinStrong2, "C:/ModifRoundtrip/UtilTest/modif/Test3/CopyMPLMinStrong2.modif");*/

	}

}

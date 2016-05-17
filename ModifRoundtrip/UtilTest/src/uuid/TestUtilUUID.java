package uuid;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import uuids.IOUUID;
import uuids.UtilUUID;

public class TestUtilUUID {

	public static void main(String[] args) {

		// metamodel
		EPackage metamodel = IOUUID.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/MPL.ecore");

		// model
		EObject model = IOUUID.loadModel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/model.mpl.xmi", metamodel);

		/** TEST 1  - All **/

		// Add UUID to metamodel
		EPackage metamodelUUID = UtilUUID.addUUIDMetamodelAttribute(metamodel);

		// Add UUID to model
		EObject modelUUID = UtilUUID.addUUIDModelAttribute(model, metamodelUUID);

		// Remove UUID from metamodel
		EPackage metamodelNoUUID = UtilUUID.removeUUIDMetamodelAttribute(metamodelUUID);

		// Remove UUID from model
		EObject modelNOUUID = UtilUUID.removeUUIDModelAttribute(modelUUID, metamodelNoUUID); 


		/** TEST 2  - Metamodel **/

		// Add UUID to metamodel
		EPackage metamodelUUID2 = UtilUUID.addUUIDMetamodelAttribute(metamodel);
		IOUUID.saveMetamodel(metamodelUUID2, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");

		// Remove UUID from metamodel
		EPackage metamodelNoUUID2 = UtilUUID.removeUUIDMetamodelAttribute(metamodelUUID2);
		IOUUID.saveMetamodel(metamodelNoUUID2, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLNOUUID.ecore");


		/** TEST 3  - Model **/

		// Add UUID to model
		EObject model3 = UtilUUID.addUUIDModelAttribute(model, metamodelUUID2);
		IOUUID.saveModel(model3, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Test3/model.mpluuid.xmi");

		// Remove UUID from model
		EObject modelNOUUID3 = UtilUUID.removeUUIDModelAttribute(model3, metamodelNoUUID2);
		IOUUID.saveModel(modelNOUUID3, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Test3/model.mplnouuid.xmi");

	}
}

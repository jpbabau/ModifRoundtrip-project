package coevolution;

import java.io.IOException;

import migration.tools.UtilEMF;
import migrationSpecification.IOMigrationSpecification;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class TestCoevolution {

	public static void main(String[] args){

		Coevolution coevolution = new Coevolution();

		// Load the source metamodel
		EPackage sourceMetamodel = UtilEMF.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/MPLtest.ecore");

		// Set the source metamodel
		coevolution.setSourceMetamodel(sourceMetamodel);

		// Generate modif specification
		Modifications modifSpecification = coevolution.createModif("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/coevolution/MPLtest.modif");

		// Load the source model
		EObject sourceModel = UtilEMF.loadModel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Expression.xmi", sourceMetamodel);
		
		// Set source model
		coevolution.setSourceModel(sourceModel);
		
		// Coevolution
		coevolution.coevolve();
		
		EPackage targetMetamodel = coevolution.getTargetMetamodel();
		try {
			UtilEMF.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/coevolution/MPL_final.ecore");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		EObject targetModel = coevolution.getTargetModel();
		try {
			UtilEMF.saveModel(targetModel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/coevolution/model_final.mpl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

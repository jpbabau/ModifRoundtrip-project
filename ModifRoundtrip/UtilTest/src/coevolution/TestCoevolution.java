package coevolution;

import migration.IOMigration;
import migrationSpecification.IOMigrationSpecification;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import refactor.IORefactor;

public class TestCoevolution {

	public static void main(String[] args){

		Coevolution coevolution = new Coevolution();

		// Load the source metamodel
		EPackage sourceMetamodel = IORefactor.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/MPLtest.ecore");

		// Set the source metamodel
		coevolution.setSourceMetamodel(sourceMetamodel);

		// Generate modif specification
		Modifications modifSpecification = coevolution.createModif("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/coevolution/MPLtest.modif");

		// Load the source model
		EObject sourceModel = IOMigrationSpecification.loadModel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/Expression.xmi", sourceMetamodel);
		
		// Set source model
		coevolution.setSourceModel(sourceModel);
		
		// Coevolution
		coevolution.coevolve();
		
		EPackage targetMetamodel = coevolution.getTargetMetamodel();
		IORefactor.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/coevolution/MPL_final.ecore");
	
		EObject targetModel = coevolution.getTargetModel();
		IOMigration.saveModel(targetModel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/model/coevolution/model_final.xmi");
	}

}

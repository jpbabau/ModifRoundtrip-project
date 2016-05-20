package refactoring;

import java.io.IOException;

import migration.tools.UtilEMF;
import modif.Modifications;

import org.eclipse.emf.ecore.EPackage;

public class TestRefactoring {

	public static void main(String[] args){

		// Refactoring
		Refactoring refactoring = new Refactoring();

		// Load the source metamodel
		EPackage sourceMetamodel = UtilEMF.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/MPL.ecore");

		// Set the source metamodel
		refactoring.setSourceMetamodel(sourceMetamodel);

		// Generate modif specification
		Modifications modifSpecification = refactoring.createModif("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/MPL_ID.modif");

		// Refactor
		EPackage targetMetamodel = refactoring.refactor();
		try {
			UtilEMF.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Ref.ecore");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

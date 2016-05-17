package refactoring;

import modif.Modifications;

import org.eclipse.emf.ecore.EPackage;

import refactor.IORefactor;

public class TestRefactoring {

	public static void main(String[] args){

		// Refactoring
		Refactoring refactoring = new Refactoring();

		// Load the source metamodel
		EPackage sourceMetamodel = IORefactor.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/MPL.ecore");

		// Set the source metamodel
		refactoring.setSourceMetamodel(sourceMetamodel);

		// Generate modif specification
		Modifications modifSpecification = refactoring.createModif("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/MPL_ID.modif");

		// Refactor
		EPackage targetMetamodel = refactoring.refactor();
		IORefactor.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Ref.ecore");
	}

}

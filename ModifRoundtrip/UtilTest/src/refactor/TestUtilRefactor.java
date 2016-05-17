package refactor;

import modif.Modifications;

import org.eclipse.emf.ecore.EPackage;

public class TestUtilRefactor {

	public static void main(String[] args) {

		/** TEST 1  - Refactoring **/

		// Load source metamodel (with UUIDs) 	
		EPackage sourceMetamodel = IORefactor.loadMetamodel("C:/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");	
		
		// Set source metamodel
		UtilRefactor.setSourceMetamodel(sourceMetamodel);	
		
		// Load modif specification
		Modifications modifSpecification = IORefactor.loadModifSpecification("C:/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");
		
		// Set modif specification
		UtilRefactor.setModifSpecification(modifSpecification);
		
		// Refactor
		UtilRefactor.refactor();
		
		// Get target metamodel
		EPackage targetMetamodel = UtilRefactor.getTargetMetamodel();
		
		// Save target metamodel
		IORefactor.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip/UtilTest/metamodel/Test1/MPLUUIDRefactored.ecore");
		
	}

}

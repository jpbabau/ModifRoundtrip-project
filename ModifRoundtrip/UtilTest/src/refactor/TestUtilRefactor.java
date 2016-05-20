package refactor;

import java.io.IOException;

import migration.tools.UtilEMF;
import modif.Modifications;
import modifspecification.IOModifSpecification;

import org.eclipse.emf.ecore.EPackage;

public class TestUtilRefactor {

	public static void main(String[] args) {

		/** TEST 1  - Refactoring **/

		// Load source metamodel (with UUIDs) 	
		EPackage sourceMetamodel = UtilEMF.loadMetamodel("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test2/MPLUUID.ecore");	
		
		// Set source metamodel
		UtilRefactor.setSourceMetamodel(sourceMetamodel);	
		
		// Load modif specification
		Modifications modifSpecification = IOModifSpecification.loadModifSpecification("C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/modif/Test1/CopyMPL.modif");
		
		// Set modif specification
		UtilRefactor.setModifSpecification(modifSpecification);
		
		// Refactor
		UtilRefactor.refactor();
		
		// Get target metamodel
		EPackage targetMetamodel = UtilRefactor.getTargetMetamodel();
		
		// Save target metamodel
		try {
			UtilEMF.saveMetamodel(targetMetamodel, "C:/ModifRoundtrip-project/ModifRoundtrip/UtilTest/metamodel/Test1/MPLUUIDRefactored.ecore");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

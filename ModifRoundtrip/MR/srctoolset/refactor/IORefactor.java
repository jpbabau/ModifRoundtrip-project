package refactor;

import java.io.IOException;

import modif.Modifications;
import modifspecification.UtilModifSpecification;

import org.eclipse.emf.ecore.EPackage;

import ecoremodifutils.ModifIO;
import emf.UtilEMF;

public class IORefactor {

	// ATTRIBUTES ******************************************************************************

	private static ModifIO modifIO;

	// PRIVATE *********************************************************************************

	/**
	 * Get modifIO.
	 * @return modifIO.
	 */
	public static ModifIO getModifIO() {
		return modifIO;
	}


	// PUBLIC **********************************************************************************

	/**
	 * Load a metamodel located at a given path.
	 * @param metamodelPath Path of the metamodel file.
	 * @return metamodel Loaded metamodel.
	 */
	public static EPackage loadMetamodel(String metamodelPath) {
		EPackage metamodel = UtilEMF.loadMetamodel(metamodelPath);
		return metamodel;
	}

	/**
	 * Load a modif specification located a the given path.
	 * @param modifSpecificationPath Path of the modif specification.
	 * @return modif Loaded modif specification.
	 */
	public static Modifications loadModifSpecification(String modifSpecificationPath) {
		ModifIO theModifIO = new ModifIO();
		Modifications modif = theModifIO.LoadModif(modifSpecificationPath);	
		UtilModifSpecification.setModifSpecification(modif);
		modifIO = theModifIO;
		return modif;
	}

	/**
	 * Save a metamodel in a file.
	 * @param matamodel Metamodel to be saved.
	 * @param metamodelPath Path to save the metamodel.
	 */
	public static void saveMetamodel(EPackage matamodel, String metamodelPath) {
		try {
			// TODO Warning is not contained in a resource
			UtilEMF.saveMetamodel(matamodel, metamodelPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

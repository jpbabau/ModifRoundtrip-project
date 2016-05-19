package uuids;

import java.io.IOException;

import migration.tools.UtilEMF;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * Utilitary class for load and save models and metamodels.
 * 
 * @author P. Vallejo
 *
 */

public class IOUUID {
	
	// PUBLIC ******************************************************************************

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
	 * Load a model located at a given path.
	 * @param modelPath Path of the model file.
	 * @param metamodel Metamodel to which the model conforms.
	 * @return metamodel Loaded model.
	 */
	public static EObject loadModel(String modelPath, EPackage metamodel) {
		EObject model = UtilEMF.loadModel(modelPath, metamodel);
		return model;
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

	/**
	 * Save a model in a file.
	 * @param model Model to be saved.
	 * @param modelPath Path to save the metamodel.
	 */
	public static void saveModel(EObject model, String modelPath) {
		try {
			UtilEMF.saveModel(model, modelPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

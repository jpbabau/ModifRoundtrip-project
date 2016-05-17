package migration;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emf.UtilEMF;

public class IOMigration {

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
	 * Load a migration specification.
	 * @param migrationSpecificationPath Path of the migration specification file.
	 * @return migrationSpecification. Loaded migration specification.
	 */
	public static Migration loadMigrationSpecification(String migrationSpecificationPath){
		Migration migrationSpecification = (Migration) UtilEMF.loadModel(migrationSpecificationPath, MigrationPackage.eINSTANCE);
		return migrationSpecification;
	}

	/**
	 * Load a model located at a given path.
	 * @param modelPath Path of the model file
	 * @param metamodel Metamodel to wich the model is conforms.
	 * @return model Loaded model.
	 */
	public static EObject loadModel(String modelPath, EPackage metamodel) {
		EObject model = UtilEMF.loadModel(modelPath, metamodel);
		return model;
	}

	/**
	 * Save the a model in a file.
	 * @param model Model to be saved.
	 * @param modelPath Path to save the model.
	 */
	public static void saveModel(EObject model, String modelPath){
		if(model != null){
			try {
				UtilEMF.saveModel(model, modelPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

package migrationSpecification;

import java.io.IOException;

import javax.rmi.CORBA.Util;

import migration.Migration;
import migration.MigrationPackage;
import modif.Modifications;
import modifspecification.UtilModifSpecification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodifutils.ModifIO;
import emf.UtilEMF;

public class IOMigrationSpecification {

	// ATTRIBUTES ************************************************************************


	// PUBLIC ****************************************************************************

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
	 * Load a modif specification.
	 * @param modifSpecificationPath Path of the modif specification to be loaded.
	 * @return modif Loaded modif specification.
	 */
	public static Modifications loadModifSpecification(String modifSpecificationPath) {
		ModifIO theModifIO = new ModifIO();
		Modifications modif = theModifIO.LoadModif(modifSpecificationPath);	
		UtilModifSpecification.setModifSpecification(modif);
		return modif;
	}

	/**
	 * Save a migration specification.
	 * @param migrationSpecification Migration specification to save in a file.
	 * @param migrationSpecificationPath Path to save the migration specification.
	 */
	public static void saveMigrationSpecification(Migration migrationSpecification, String migrationSpecificationPath) {		
		if(migrationSpecification != null) {
			try {
				UtilEMF.saveModel(migrationSpecification, migrationSpecificationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

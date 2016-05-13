package migrationSpecification;

import java.io.IOException;

import javax.rmi.CORBA.Util;

import migration.Migration;
import modif.Modifications;
import modifspecification.UtilModifSpecification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodifutils.ModifIO;
import emf.UtilEMF;

public class IOMigrationSpecification {
	
	// ATTRIBUTES ************************************************************************
	
	private static ModifIO modifIO;
	
	
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
	 * 
	 * @param modelPath
	 * @return
	 */
	public static EObject loadModel(String modelPath, EPackage metamodel) {
		EObject model = UtilEMF.loadModel(modelPath, metamodel);
		return model;
	}
	
	/**
	 * 
	 * @param modifSpecificationPath
	 * @return
	 */
	public static Modifications loadModifSpecification(String modifSpecificationPath) {
		ModifIO theModifIO = new ModifIO();
		Modifications modif = theModifIO.LoadModif(modifSpecificationPath);	
		UtilModifSpecification.setModifSpecification(modif);
		modifIO = theModifIO;
		return modif;
	}
	
	/**
	 * 
	 */
	public static void saveMigrationSpecification(Migration migrationSpecification, String migrationSpecificationPath) {		
		try {
			UtilEMF.saveModel(migrationSpecification, migrationSpecificationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

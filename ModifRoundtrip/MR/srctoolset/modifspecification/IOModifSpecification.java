package modifspecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import uiModif.modifService;
import modif.Modifications;
import ecoremodifutils.ModifIO;
import emf.UtilEMF;

public class IOModifSpecification {

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
	 * Load a modif specification located a the given path.
	 * @param modifSpecificationPath Path of the modif specification.
	 * @return modif Loaded modif specification.
	 */
	public static Modifications loadModifSpecification(String modifSpecificationPath) {
		ModifIO modifIO = new ModifIO();
		Modifications modif = modifIO.LoadModif(modifSpecificationPath);	
		UtilModifSpecification.setModifSpecification(modif);
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

	/**
	 * Save a modif specification.
	 * @param modifSpecification Modif specification to ba saved.
	 * @param modifPath Path to save the modif specification.
	 */
	public static void saveModifSpecification(Modifications modifSpecification, String modifPath) {
		try {
			OutputStream f = new FileOutputStream(modifPath) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ModifIO.SaveModif(modifSpecification, modifPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

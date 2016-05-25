package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import utils.UtilModifSpecification;
import modif.Modifications;
import ecoremodifutils.ModifIO;

public class IOModifSpecification {

	// PUBLIC ******************************************************************************

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

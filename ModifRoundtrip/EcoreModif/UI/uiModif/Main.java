/**
 * 
 * Main class for EcoreModif project
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package uiModif;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import migration.tools.UtilEMF;

import org.eclipse.emf.ecore.EPackage;

import ecoremodif.RootEcoreModif;

public class Main {

	/** 
	 * GUI = true -> with GUI
	 * GUI = false -> without GUI
	 */
	static boolean GUI = false;

	/**
	 * mode = 1 -> refactoring
	 * mode = 2 -> coevolution
	 * mode = 3 -> reuse
	 */
	static int mode;

	/**
	 * isUML = true -> the source metamodel is UML
	 * isUML = false -> the source metamodel is not UML
	 */
	static boolean isUML;

	/**
	 * withMigrationCodeGeneration = true -> the code for migration is generated
	 * withMigrationCodeGeneration = false -> the code for migration is not generated and the migration is applied automatically
	 */
	static boolean withMigrationCodeGeneration;

	static boolean multiEcore = false;

	static String domainMetamodel;
	static String modifSpecification;

	static modifService theModifService;

	// Map of package and storage path
	static Map<EPackage, String> packageLocationMap = new HashMap<EPackage, String>();

	/**
	 * Main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// GUI is false by default, change it to true for open the GUI
		//GUI = true;
		GUI = false;

		if(GUI) {
			System.out.println("Starting ModifRoundtrip with GUI");
			modifUI window = new modifUI();
			window.open();
		}else {
			System.out.println("Starting ModifRoundtrip without GUI");
			theModifService = new modifService();

			// Define the mode
			mode = 1;
			//mode = 2;

			// Define the path of the project source folder
			String projectSourceFolder = "C:/ModifRoundtrip-project/ModifRoundtrip/Test_UML";

			// Define the type of the by defautl modif specification: 
			// modifSpecificationType = 1 -> noModif, modifSpecificationType = 2 -> eraseAll
			int modifSpecificationType = 1;
			//int modifSpecificationType = 2;

			// Define the type of source metamodel
			isUML = true;
			// isUML = false;

			// Define the type of migration
			//withMigrationCodeGeneration = true;
			withMigrationCodeGeneration = false;

			switch (mode) {
			// refactoring
			case 1: 
				if(isUML) {
					theModifService.Refactoring(projectSourceFolder, modifSpecificationType, isUML);
				}else {
					if(multiEcore) {
						// Define the path of the metamodel to be refactored
						domainMetamodel = "path to the root ecore";

						theModifService.setFiles(domainMetamodel);

						// Loading the root ecore
						EPackage rootPackage = UtilEMF.loadMetamodel(domainMetamodel);

						// Verifying if the metamodel to be refactored has references to external ecores
						packageLocationMap.put(rootPackage, domainMetamodel);

						// Looking for external ecores et construction du map (rootPackage, relatedPackages)
						Map<EPackage, ArrayList<EPackage>> relatedPackages = UtilEMF.getRelatedPackages(rootPackage, packageLocationMap, null);

						// Gathering the external ecores (subpackages) in one ecore
						EPackage ExtendedPackage = UtilEMF.createExtendedEcore(relatedPackages, domainMetamodel, rootPackage);

						// Saving the extended ecore
						File f = new File(domainMetamodel);
						int idx = f.getAbsolutePath().lastIndexOf('.');
						String extendedName = f.getAbsolutePath().substring(0, idx)+"Extended.ecore";
						UtilEMF.saveMetamodel(ExtendedPackage, extendedName, false);

						// Create a by default modif specification
						RootEcoreModif theRootEcoreModif = theModifService.createModifSpecification(modifSpecificationType, ExtendedPackage, extendedName);

						// Choose a different (not by default) modif specification to be applied
						modifSpecification = "modif specification";
						if(modifSpecification != null) {
							theRootEcoreModif = theModifService.loadModifSpecification(extendedName, modifSpecification);
						}

						// Refactoring
						ArrayList<EPackage> refactoredPackages = theModifService.Refactoring(theRootEcoreModif);
						int temp = 1;
						for(EPackage refactored : refactoredPackages) {
							String ecoreName = " ecore name "+temp;
							UtilEMF.saveMetamodel(refactored, ecoreName+".ecore", false);
							temp = temp+1;
						}
					}
				}
				break;
				// coevolution
			case 2:
				// Define the path of the source model
				String sourceModelPath = "C:/ModifRoundtrip/Test_UML/model/model.uml";
				theModifService.Coevolution(projectSourceFolder, modifSpecificationType, isUML, sourceModelPath, withMigrationCodeGeneration);
				break;
				// reuse
			case 3:
				break;
			}
		}
	}
}

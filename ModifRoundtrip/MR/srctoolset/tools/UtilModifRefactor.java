package tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import migration.tools.UtilEMF;
import modif.Modifications;
import modif.PackageModification;
import modif.util.Minimize;
import modif.util.utilModifFactory;
import ecoremodif.RootEcoreModif;
import ecoremodifutils.ModifIO;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import refactor.Refactoring;

public class UtilModifRefactor <SS extends EPackage, SSI extends EPackage, TT extends EPackage, TTI extends EPackage, S extends EObject, SI extends EObject>{

	// ATTRIBUTES

	SS sourceMetamodel;
	SSI sourceMetamodelUUID;
	TT targetMetamodel;
	TTI targetMetamodelUUID;
	Modifications modifSpecification;

	S sourceModel;
	SI sourceModelUUID;

	protected ModifIO modifIO ;
	protected RootEcoreModif theRootEcoreModif;
	private int modifType;
	private String projectSourceFolder;
	private String modifSpecificationName;
	private boolean coevolution;

	// CONSTRUCTOR

	public UtilModifRefactor() {
		theRootEcoreModif = null;
		modifIO = new ModifIO();
	}


	// REFACTORING METHODS

	/**
	 * Set the project source folder
	 * @param sourceFolderPath It is the folder containing metamodel and model files.
	 * This folder will contain the genereted files
	 */
	public void setProjectSourceFolder(String sourceFolderPath) {
		this.projectSourceFolder = sourceFolderPath;
	}


	/** Set the source metamodel
	 * @param sourceMetamodel It is the metamodel that will be refactored
	 */
	public void setSourceMetamodel(SS sourceMetamodel) {
		this.sourceMetamodel = sourceMetamodel;
	}


	/**
	 * Transforms the sourceMetamodel according to the operators indicated 
	 * in the modif specification
	 * @param sourceMetamodel The metamodel to be refactored
	 * @param modifSpecification The modif specification containing the operators to be applied
	 */
	@SuppressWarnings("unchecked")
	public void Refactor(SS sourceMetamodel, Modifications modif) {

		System.out.println("Update the modif specification. Then press \'intro\' to continue");
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// TODO
		// Load the updated modif specification
		if(this.coevolution) {
			this.modifSpecification = loadModifSpecification(projectSourceFolder+"/modif/RefactoringMigCopyModifUML.modif");
		}else {
			this.modifSpecification = loadModifSpecification(projectSourceFolder+"/modif/CopyModifUML.modif");
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to simplify the modif specification ?. y/n");
		String minimize = scan.next();

		if(minimize.equals("y")) {
			minimizeModifSpecification();
		}

		// TODO
		// Load the simplified modif specification
		if(this.coevolution) {
			this.modifSpecification = loadModifSpecification(projectSourceFolder+"/modif/RefactoringMigCopyModifUML.modif");
		}else {
			this.modifSpecification = loadModifSpecification(projectSourceFolder+"/modif/RefactoringCopyModifUML.modif");
		}
		CreateModif();

		if (this.theRootEcoreModif != null) {
			if (Refactoring.isOk(this.theRootEcoreModif)) {
				// launch refactoring operators
				Refactoring.operate(this.theRootEcoreModif);
			}
		}	
		this.targetMetamodel = (TT) this.theRootEcoreModif.getRoot().getEcore();
	}

	/**
	 * Gives the refactored metamodel
	 * @return targetMetamodel The metamodel that has been refactored
	 */
	public TT getTargetMetamodel() {
		return this.targetMetamodel;
	}


	/**
	 * Saves a metamodel in a file
	 * @param targetMetamodel Metamodel to be saved
	 * @param targetMetamodelFile Path of the file to save the metamodel
	 */
	public void saveMetamodel(TT targetMetamodel, String targetMetamodelFile) {
		try {
			UtilEMF.saveMetamodel(targetMetamodel, targetMetamodelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// MODIF SPECIFICATION METHODS

	/**
	 * Set the modif specification
	 * @param modif The modif specification
	 */
	public void setModifSpecification(Modifications modif) {
		this.modifSpecification = modif;
	}

	/**
	 * Load a modif specification from a file
	 * @param modifSpecification Path to the modif specification
	 * @return modif specification 
	 */
	public Modifications loadModifSpecification(String modifSpecification) {
		Modifications modif = modifIO.LoadModif(modifSpecification);
		return modif;
	}

	/**
	 * Produces a by default modif specification
	 * @param atlModif Indicates the type of the modif specification to be generated. 
	 * 1 -> Copy, it is a modif specification which application produces a copy of the source metamodel.
	 * 2 -> EraseAll, it is a modif specification which application produces an empty target metamodel.
	 * @return modifSpecification A by default modif specification
	 */
	public void GenerateModif(int atlModif, boolean withMigrationSpecification) {
		this.coevolution = withMigrationSpecification;
		boolean UUID = false;
		ModifIO aModifIO = new ModifIO();
		utilModifFactory anUtilModifFactory = new utilModifFactory();
		EPackage theRootEcore; 

		if(withMigrationSpecification) {
			//theRootEcore = UtilEMF.removeOperations(UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(UtilEMF.addUUIDAttribute(this.sourceMetamodel))));
			/*try {
				//UtilEMF.saveMetamodel(theRootEcore, projectSourceFolder+"/metamodel/myUMLUUID.ecore", false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//this.sourceMetamodelUUID = (SSI) theRootEcore;
		}else {
			theRootEcore = UtilEMF.removeOperations(UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(this.sourceMetamodel)));
		}

		Modifications theRootModif = null;
		if (atlModif==1) {
			//theRootModif = anUtilModifFactory.generateNoModif(theRootEcore, UUID); 
			this.modifType = 1;
		}else if (atlModif==2) {
			//theRootModif = anUtilModifFactory.generateEraseAll(theRootEcore, UUID);
			this.modifType = 2;
		}
		this.modifSpecification = theRootModif;
		//return this.modifSpecification;
	}

	/**
	 * Creates a modif specification
	 * @return PackageModification
	 */
	private PackageModification CreateModif() {
		modifIO.setModifIO(this.sourceMetamodel, this.modifSpecification);	
		this.theRootEcoreModif = modifIO.getEcoreModif();
		return this.theRootEcoreModif.getRoot().getModif();
	}

	/**
	 * Simplifies a modif specification by removing unuseful information 
	 * @return simplifiedModifSpecification The simplified modif specification
	 */
	public void minimizeModifSpecification() {
		Minimize tool = new Minimize();
		tool.go(this.modifSpecification);
		try { ModifIO.SaveModif(this.modifSpecification, this.modifSpecificationName);
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * Simplifies the modif specification. All unused lines are deleted
	 * @param modifF Modif specification without unused information
	 * @return modif The simplified modif speficiation
	 */	
	private  Modifications Minimize(Modifications modif) {
		Minimize tool = new Minimize();
		tool.go(modif);
		return modif;
	}

	/**
	 * Saves a modif specification in the modif folder of the project source fodler, it takes a by default name
	 * @param modifSpecification The modif specification to be saved in a file
	 * @throws IOException
	 */
	public void saveModifSpecification(Modifications modifSpecification) throws IOException {
		this.modifSpecificationName = null;
		if(this.modifType == 1) {
			this.modifSpecificationName = projectSourceFolder+"/modif/CopyModif"+"UML"+".modif";
		}else if(this.modifType == 2) {
			this.modifSpecificationName = projectSourceFolder+"/modif/EraseAll"+"UML"+".modif";
		}
		OutputStream f = new FileOutputStream(this.modifSpecificationName) ;
		ModifIO.SaveModif(modifSpecification, this.modifSpecificationName);
	}

	/**
	 * Saves a modif specification, it takes the name given as parameter
	 * 
	 * @param modifSpecification Modif specfiication to be saved in a file
	 * @param modifSpecificationName Path to save the modif specification
	 * @throws IOException
	 */
	public void saveModifSpecification(Modifications modifSpecification, String modifSpecificationName) throws IOException {
		OutputStream f = new FileOutputStream(modifSpecificationName) ;
		ModifIO.SaveModif(modifSpecification, modifSpecificationName);
	}


	// MIGRATION SPECIFICATION METHODS

	/**
	 * Set the source model
	 * @param sourceModel Model to be migrated
	 */
	public void setSourceModel(EObject sourceModel) {
		this.sourceModel = (S) sourceModel;
		this.sourceModelUUID = (SI) UtilEMF.changeMetamodel(this.sourceModel,"C:/ModifRoundtrip/Test_UML_Reuse/metamodel/myUMLUUID.ecore");

	}

	/**
	 * Gives the source model with unique identifiers. Each instance of the model has the UUID attribute
	 * @return source model with unique identifiers
	 */
	public SI getSourceModelUUID() {
		return this.sourceModelUUID;
	}

}

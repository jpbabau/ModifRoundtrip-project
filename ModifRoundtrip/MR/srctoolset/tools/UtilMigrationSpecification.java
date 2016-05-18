package tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import migration.Instance;
import migration.Migration;
import migration.impl.MigrationFactoryImpl;
import migration.tools.UtilEMF;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodif.RootEcoreModif;


public class UtilMigrationSpecification <SS extends EPackage, SSI extends EPackage, S extends EObject, SI extends EObject>{

	// ATTRIBUTES

	S sourceModel;
	SI sourceModelUUID;
	Modifications modifSpecification;
	Migration migrationSpecification;

	
	private RootEcoreModif rootEcoreModif;
	private List<Instance> allInstances = new ArrayList<Instance>();

	// CONSTRUCTOR

	MigrationFactoryImpl factory = new MigrationFactoryImpl();

	// METHODS

	/**
	 * Set the modif specification
	 * @param modifSpecification specification containing the operators applied to the 
	 * source metamodel
	 */
	public void setModifSpecification(Modifications modifSpecification) {
		this.modifSpecification = modifSpecification;
	}

	/**
	 * Set the source model
	 * @param sourceModel Model to be migrated
	 */
	public void setSourceModel(EObject sourceModel) {
		this.sourceModel = (S) sourceModel;
		this.sourceModelUUID = (SI) UtilEMF.addUUIDValues(this.sourceModel);
		
	}
	
	
	public SI getSourceModelUUID() {
		return this.sourceModelUUID;
	}

	/**
	 * 
	 * @return Gives a migration specification
	 */
	public Migration generateMigrationSpecification() {
		Migration migrationSpecification = createMigrationSpecification();
		Migration migrationresult = this.migrationRoot(migrationSpecification, sourceModel);
				
		this.migrationSpecification = migrationSpecification;
		return this.migrationSpecification;
		
		
	}
	
	private Migration createMigrationSpecification() {
		Migration migration = factory.createMigration();
		String sourceMetamodelURI = this.modifSpecification.getRootPackageModification().getOldURIName();
		String targetMetamodelURI = this.modifSpecification.getRootPackageModification().getNewURIName();
		String sourceModel = "";
		String targetModel = "";
		
		migration.setInputMetamodelURI(sourceMetamodelURI);
		migration.setOutputMetamodelURI(targetMetamodelURI);
		migration.setInputModelURI(sourceModel);
		migration.setInputModel(sourceModelUUID);
		migration.setOutputModelURI(targetModel);
		
		/*
		migration.setInputModelURI(URI.createFileURI(new File(this.inputModelFile).getAbsolutePath()).toString());
		migration.setOutputModelURI(URI.createFileURI(new File(this.outputModelFile).getAbsolutePath()).toString());*/
		return migration;
		
	}

	public void customMigrationSpecification() {

	}

	/**
	 * 
	 * @return
	 */
	public Migration getMigrationSpecification() {
		return this.migrationSpecification;
	}


	
	public void saveMigrationSpecification(String migrationSpecification) {
		try {
			UtilEMF.saveModel(this.migrationSpecification, migrationSpecification);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param migrationSpecification
	 * @param sourceModel
	 * @return
	 */
	private Migration migrationRoot(Migration migrationSpecification, EObject sourceModel) {
		Migration result = migrationSpecification;
		Instance rootinstance = factory.createInstance();
	//	String rootuuid = (String) sourceModel.eGet(sourceModel.eClass().getEStructuralFeature("UUID"));
	//	rootinstance.setUUID(rootuuid);
		allInstances.add(rootinstance);
		if(!sourceModel.eContents().isEmpty()){
			//for(EObject object : sourceModel.eContents()){ this.createInstance(object); }
		}
		migrationSpecification.getInstances().addAll(allInstances);
		//result = this.addMigrationDeletion(migrationSpecification, sourceModel);
		//result = this.addMigrationHide(migration, rootObject);
		return result;
	}

}


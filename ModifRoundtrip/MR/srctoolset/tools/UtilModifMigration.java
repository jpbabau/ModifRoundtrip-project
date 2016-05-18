package tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import migration.Instance;
import migration.Migration;
import migration.MigrationPackage;
import migration.impl.MigrationFactoryImpl;
import migration.tools.MigrationRoundtrip;
import migration.tools.UtilEMF;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Utilitary class for ModifRoundtrip. 
 * This class enables to produce an target model fron a source model.
 * @param SS source metamodel
 * @param TT target metamodel
 * @param S source model
 * @param T target model
 * @author Paola Vallejo
 */

public class UtilModifMigration <SS extends EObject, TT extends EObject, S extends EObject, T extends EObject>{

	// ATTRIBUTES
	
	SS sourceMetamodel;
	TT targetMetamodel;
	S sourceModel;
	EObject sourceModelUUID;
	T targetModel;
	Migration migrationSpecification;
	Modifications modifSpecification;
	
	
	private List<Instance> allInstances = new ArrayList<Instance>();
	MigrationFactoryImpl factory = new MigrationFactoryImpl();

	
	// MODEL METHODS
	
	/**
	 * Set the source model
	 * @param sourceModel Source model to be migrated
	 */
	public void setSourceModel(S sourceModel) {
		this.sourceModel = sourceModel;
	}
	
	/**
	 * Seves a model in a file
	 * @param targetModel Model to save
	 * @param modelPath Path to save the model
	 */
	public void saveTargetModel(EObject targetModel, String modelPath) {
		try {
			UtilEMF.saveModel(this.targetModel, modelPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the target model 
	 * @return targetModel Migrated model without UUID
	 */
	public T getTargetModel() {
		return this.targetModel;
	}
	
	
	// MODIF SPECIFICATION METHODS
	
	/**
	 * Set the modif specification
	 * @param modifSpecification Modif specification containing the operators applied to the source metamodel
	 */
	public void setModifSpecification(Modifications modifSpecification) {
		this.modifSpecification = modifSpecification;
	}
	
	
	
	// MIGRATION METHODS
	
	
	/**
	 * Migrates a model according to the operators of the migration specification
	 * @return Migrated model
	 */
	@SuppressWarnings("unchecked")
	public T Migrate() {
		
		// Get SourceMetamodel with UUID
		EPackage sourceMetamodelUUID = UtilEMF.loadMetamodel(this.modifSpecification.getRootPackageModification().getOldURIName());
		
		// Add UUID to the source model
		this.sourceModelUUID = UtilEMF.addUUIDValues(UtilEMF.changeMetamodel(sourceModel, sourceMetamodelUUID));
		
		// Generate migration Specification
		this.migrationSpecification = generateMigrationSpecification();
		
		// Apply the operators of the migration specification to the source model
		EObject targetModelUUID = migrateModel();
		
		// Remove UUID from targetMetamodelUUID
		this.targetMetamodel = (TT) UtilEMF.removeUUIDAttribute(UtilEMF.loadMetamodel(this.modifSpecification.getRootPackageModification().getNewURIName()));
		
		// Delete UUID from the migrated mdoel
		this.targetModel = (T) UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(targetModelUUID), (EPackage) this.targetMetamodel);

		return this.targetModel;
	}
	
	/**
	 * Creates a migration roundtrip from a migration specification
	 * @return targetModelUUID Migrated model (with UUID)
	 */
	private EObject migrateModel() {
		MigrationRoundtrip migrt = null;
		migrt = new MigrationRoundtrip(this.migrationSpecification);
		EObject targetModelUUID = migrt.onwardMigration();
		return targetModelUUID;
	}
	
	/**
	 * Allows to modify the migration specification
	 * @return migrationSpecification Updated migration specification
	 */
	public Migration customMigrate() {
		return this.migrationSpecification;
	}
	
	
	// MIGRATION SPECIFICATION METHODS
	
	/**
	 * Generates a migration specification from a source model and a modif specification
	 * @return migrationSpecification This migration specification allows to migrate the source model with UUID
	 */
	public Migration generateMigrationSpecification() {
		Migration migrationSpecification = createMigrationSpecification();
		Migration migrationresult = this.migrationRoot(migrationSpecification, this.sourceModelUUID);
				
		this.migrationSpecification = migrationSpecification;
		return this.migrationSpecification;
	}
	
	/**
	 * Creates an instance of the migration model
	 * @return migration specification Migration specifications containing the modifications to apply to the source model
	 */
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
	
	/**
	 * Add instances to the migration specification
	 * @param migrationSpecification Empty migration specification
	 * @param sourceModel Model to be migrated
	 * @return migration Migration specification with all instances 
	 */
	private Migration migrationRoot(Migration migrationSpecification, EObject sourceModel) {
		Migration migration = migrationSpecification;
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
		return migration;
	}
	
}

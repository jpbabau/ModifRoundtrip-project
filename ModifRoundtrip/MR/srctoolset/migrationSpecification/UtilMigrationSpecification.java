package migrationSpecification;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import modif.Modifications;
import migration.Instance;
import migration.Migration;
import migration.impl.MigrationFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import uuids.UtilUUID;


/**
 * Utilitary class for handling migration specifications.
 * Source metamodel and source models have UUIDs.
 * A migration specification is produced from a modif specification and a source model.
 * This class gathers useful functions to generate and edit migration specifications.
 * 
 * @author P. Vallejo
 *
 */

public class UtilMigrationSpecification {

	
	// ATTRIBUTES ****************************************************************************
	
	public static EPackage sourceMetamodel;
	public static EPackage targetMetamodel;
	public static Modifications modifSpecification;
	public static EObject sourceModel;
	public static Migration migrationSpecification;
	private static MigrationFactoryImpl factory;
	private static List<Instance> allInstances;
	
	
	// PRIVATE ******************************************************************************
	
	/**
	 * 
	 * @return
	 */
	private static Migration createMigrationSpecification() {
		
		factory  = new MigrationFactoryImpl();
		
		Migration migration = factory.createMigration();
		String sourceMetamodelURI = modifSpecification.getRootPackageModification().getOldURIName();
		String targetMetamodelURI = modifSpecification.getRootPackageModification().getNewURIName();
		String sourceModelURI = "";
		String targetModel = "";
		
		migration.setInputMetamodelURI(sourceMetamodelURI);
		migration.setOutputMetamodelURI(targetMetamodelURI);
		migration.setInputModelURI(sourceModelURI);
		migration.setOutputModelURI(targetModel);
		
		/* migration.setInputModelURI(URI.createFileURI(new File(this.inputModelFile).getAbsolutePath()).toString()); */
		
		return migration;
		
	}
	
	/**
	 * 
	 * @param migrationSpecification
	 * @param sourceModel
	 * @return
	 */
	private static Migration migrationRoot(Migration migrationSpecification, EObject sourceModel) {
		allInstances = new ArrayList<Instance>();
		Migration result = migrationSpecification;
		Instance rootinstance = factory.createInstance();
		
		String UUIDname = UtilUUID.getTimeStampFromModel(sourceModel);
		
		System.out.println("UUIDname :  " + UUIDname);
		
		String rootuuid = (String) sourceModel.eGet(sourceModel.eClass().getEStructuralFeature("UUIDname"));
		rootinstance.setUUID(rootuuid);
		allInstances.add(rootinstance);
		if(!sourceModel.eContents().isEmpty()){
			//for(EObject object : sourceModel.eContents()){ this.createInstance(object); }
		}
		migrationSpecification.getInstances().addAll(allInstances);
		//result = this.addMigrationDeletion(migrationSpecification, sourceModel);
		//result = this.addMigrationHide(migration, rootObject);
		return result;
	}

	
	
	// PUBLIC *******************************************************************************
	
	/**
	 * 
	 */
	public static void generateMigrationSpecification() {
		Migration theMigrationSpecification = null;
		
		// create an empty migration specification
		theMigrationSpecification = createMigrationSpecification();
		Migration migrationresult = migrationRoot(theMigrationSpecification, sourceModel);
		
		migrationSpecification = migrationresult;
		
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static Migration getMigrationSpecification() {
		return migrationSpecification;
	}
	
	
	/**
	 * 
	 * @param theModifSpecification
	 */
	public static void setModifSpecification(Modifications theModifSpecification) {
		modifSpecification = theModifSpecification;
	}
	
	/**
	 * 
	 * @param theSourceMetamodel
	 */
	public static void setSourceMetamodel(EPackage theSourceMetamodel) {
		sourceMetamodel = theSourceMetamodel;
	}
	
	public static void setSourceModel(EObject model) {
		sourceModel = model;
	}
	
	/**
	 * Set the target metamodel
	 * @param theTargetMetamodel
	 */
	public static void setTargetMetamodel(EPackage theTargetMetamodel) {
		targetMetamodel = theTargetMetamodel;
	}
}

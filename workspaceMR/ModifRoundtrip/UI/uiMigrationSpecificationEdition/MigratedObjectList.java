package uiMigrationSpecificationEdition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.ecore.EClass;


/**
 * This class that plays the role of the domain model in the TableViewerExample
 * In real life, this class would access a persistent store of some kind.
 * 
 */

public class MigratedObjectList {

	private int COUNT = 0;
	private Vector migratedObjects = new Vector(COUNT);
	private Set changeListeners = new HashSet();

	// Combo box choices
	static final String[] DELETES_ARRAY = { "False", "True" };

	HashMap<String, Boolean> removeMap;
	HashMap<String, ArrayList<String>> featuresMap;
	HashMap<String, Integer> newIdMap;
	HashMap<String, String> classMap;


	/**
	 * Constructor 
	 * 
	 * @param theRemoveMap 
	 * @param theFeaturesMap
	 * @param theNewIdMap
	 * @param theClassMap
	 */
	public MigratedObjectList(HashMap<String, Boolean> theRemoveMap, HashMap<String, ArrayList<String>> theFeaturesMap, HashMap<String, Integer> theNewIdMap, HashMap<String, String> theClassMap){
		super();
		removeMap = theRemoveMap;
		featuresMap = theFeaturesMap;
		newIdMap = theNewIdMap;
		classMap = theClassMap;

		this.initData();
	}


	/**
	 * Initialize the table data. 
	 * It creates the migratedObjects and add them to the list of migrated objects.
	 */
	private void initData() {
		ArrayList<Integer> removedObjects = new ArrayList<Integer>();
		MigratedObject migratedObject;
		if(newIdMap != null){
			Iterator it = newIdMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry)it.next();
				String key = (String) e.getKey();
				boolean removed = removeMap.get(key);
				if(!removed){
					int iden = ((Integer) e.getValue());
					removedObjects.add(iden);
				}
			}
		}
		COUNT = removedObjects.size();
		for (int i = 0; i < COUNT; i++) {
			int id = removedObjects.get(i);

			// MigratedObject with its features (attributes et references)
			ArrayList<String> features = getFeatures(id);
			String featuresString = "";
			for(String f : features){ featuresString += "\n"+f; }
			migratedObject = new MigratedObject(featuresString);
			migratedObject.setId(id);
			migratedObject.setEClass(getclass(id));
			migratedObject.setDelete(DELETES_ARRAY[0]);
			migratedObjects.add(migratedObject);
		}
	};


	/**
	 * Return the class property of an object.

	 * @param id Identifier of the object.
	 * @return eclass Name of the class.
	 */
	public String getclass(int id){
		String eclass = "";
		Iterator it = newIdMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			String key = (String) e.getKey();
			Integer value =(Integer) e.getValue();
			if(value == id){ eclass = classMap.get(key); }
		}
		return eclass;
	}


	/**
	 * Return the array of deletes   
	 * 
	 * @return DELETES_ARRAY;
	 */
	public String[] getDeletes() {
		return DELETES_ARRAY;
	}


	/**
	 * Return the collection of migratedObjects
	 * @return migratedObjects Collection of migratedObjects
	 */
	public Vector getMigratedObjects() {
		return migratedObjects;
	}


	/**
	 * Set the delete property to False.
	 */
	public void resetMigratedObjects(){
		for( Object migratedObject : migratedObjects){
			((MigratedObject) migratedObject).setDelete("False");
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext()){ ((IMigratedObjectListViewer) iterator.next()).resetMigratedObjects((MigratedObject) migratedObject); }
		}

	}


	/**
	 * Update an objects.
	 * 
	 * @param migratedObject Object to be updated.
	 */
	public void migratedObjectChanged(MigratedObject migratedObject) {
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext()){ ((IMigratedObjectListViewer) iterator.next()).updateMigratedObject(migratedObject); }
	}


	public void removeChangeListener(IMigratedObjectListViewer viewer) {
		changeListeners.remove(viewer);
	}


	public void addChangeListener(IMigratedObjectListViewer viewer) {
		changeListeners.add(viewer);
	}


	/**
	 * Return the features of an object.
	 * 
	 * @param id Identifier of the object.
	 * @return features List of object features.
	 */
	public ArrayList<String> getFeatures(int id){
		ArrayList<String> features = new ArrayList<String>();
		int iden ;
		String key =  "" ;
		if(newIdMap != null){
			Iterator it = newIdMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry)it.next();
				int identity = ((Integer) e.getValue());
				if(identity == id){
					iden = id;
					key = (String) e.getKey();
					break;
				}
			}
		}
		if(!key.equals("")){ features = featuresMap.get(key); }
		return features;
	}

}

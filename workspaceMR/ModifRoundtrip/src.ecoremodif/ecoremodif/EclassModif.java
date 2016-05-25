/**
 *  interface for EclassModif 
 *  getter and setter of ecore part (EClass) and modif part (ClassModification)
 *  getter and setter of specific EclassModif features
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package ecoremodif;

import java.util.List;

import modif.ClassModification;

import org.eclipse.emf.ecore.EClass;

// EclassModif is compound of an ecore part (EClass) and a modif part (ClassModification)
// it also contains the correspondent EattributeModif and EreferenceModif objects

public interface EclassModif {

    // return the ecore part of EclassModif : EClass 	
	EClass getEcore();

	// set the ecore part of EclassModif : EClass value
	void setEcore(EClass value);

	// return the modif part of EclassModif : ClassModification 	
	ClassModification getModif();

	// set the modif part of EclassModif : ClassModification value
	void setModif(ClassModification value);
	
	// return the modif part of EclassModif : ClassModification 	
	EpackageModif getParent();
	
	// return the long name of ecore part before modification
	String getOldLongName();
	
	// return the long name of ecore part after modification
	String getNewLongName();
	
    // return a list of EclassModif : objects containing EClass which inherit from ecore part  	
	List<EclassModif> getSubTypes();

    // return a list of EclassModif : objects containing EClass which inherit directly
	// or implicitly from ecore part  	
	List<EclassModif> getAllSubTypes();
	
	// return a list of EclassModif : objects containing a supertype of ecore part  	
	List<EclassModif> getAllSuperTypes();
	
    // return a list of EreferenceModif : list of references to the class  	
	List<EreferenceModif> getTo();	

    // return a list of EreferenceModif : list of references to the class 
	// or to a superClass
	List<EreferenceModif> getAllTo();	
	
	// setters and getters for list of EattributeModif and EreferenceModif objects
	List<EattributeModif> getAttributeModif();	
	
	// get attributes and inherited attributes
	List<EattributeModif> getAllAttributes();
	// get references and inherited references
	List<EreferenceModif> getAllReferences();
	
    // return if is EclassModif is added
	boolean isAdded();
	
	// set the isAdded property
	void setIsAdded(boolean value);
	
    // return if is EclassModif is merged
	boolean isMerged();
	
	// set the isMerged property
	void setIsMerged(boolean value);
	
    // return if EclassModif inherits from add Name Class
	boolean inheritsFromNameClass();
	
	// set if EclassModif inherits from add Name Class
	void setInheritsFromNameClass(boolean value);
	
	void add(EattributeModif value);
	
	List<EreferenceModif> getReferenceModif();	
	
	void add(EreferenceModif value);
	
}  // EclassModif
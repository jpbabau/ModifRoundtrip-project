/**
 *  interface for RootEcoreModif 
 *  getter and setter for EpackageModif part 
 *  getter and setter of specific RootEcoreModif features
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

import modif.Modifications;

// this class is the root class for ecoremodif
// it contains a root EpackageModif

public interface RootEcoreModif {

    // return the root EpackageModif
	EpackageModif getRoot();

    // set the root EpackageModif to EpackageModif value
	void setRoot(EpackageModif value);
	
    // return the Modifications elements 
	Modifications getModifications();	
	
    // return the list of all EclassModif elements 
	List<EclassModif> getAllClassModifications();	
	
    // set the Modifications elements 	
	void setModifications(Modifications value);
	
	// return true if a class exist after modification with the same name
	boolean existClassModification(String name);
	
} // RootEcoreModif

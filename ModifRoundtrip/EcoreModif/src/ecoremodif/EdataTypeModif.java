/**
 *  interface for EattributeModif 
 *  getter and setter of ecore part (EDataType) and modif part (DataTypeModification)
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

import modif.DataTypeModification;

import org.eclipse.emf.ecore.EDataType;

// EdataTypeModif is compound of an ecore part (EDataType) and a modif part (DataTypeModification)

public interface EdataTypeModif {

    // return the ecore part of EdataTypeModif : EDataType 	
	EDataType getEcore();

	// set the ecore part of EdataTypeModif : EDataType value
	void setEcore(EDataType value);

	// return the modif part of EdataTypeModif : DataTypeModification 	
	DataTypeModification getModif();

	// set the modif part of EdataTypeModif : DataTypeModification value
	void setModif(DataTypeModification value);

	
}  // EdataTypeModif
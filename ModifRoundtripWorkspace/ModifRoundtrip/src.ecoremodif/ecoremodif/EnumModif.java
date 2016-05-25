/**
 *  interface for EnumModif 
 *  getter and setter of ecore part (EEnum) and modif part (EnumModification)
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

import modif.EnumModification;

import org.eclipse.emf.ecore.EEnum;

// EnumModif is compound of an ecore part (EEnum) and a modif part (EnumModification)
// it also contains the correspondent EnumLiteralModif objects

public interface EnumModif {

    // return the ecore part of EnumModif : EEnum 	
	EEnum getEcore();

	// set the ecore part of EnumModif : EEnum value
	void setEcore(EEnum value);

	// return the modif part of EnumModif : EnumModification 	
	EnumModification getModif();

	// set the modif part of EnumModif : EnumModification value
	void setModif(EnumModification value);
	
	// setters and getters for list of EnumLiteralModif

	List<EnumLiteralModif> getEnumLiteralModif();	
	
	void add(EnumLiteralModif value);
	
}  // EnumModif
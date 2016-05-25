/**
 *  interface for EnumLiteralModif 
 *  getter and setter of ecore part (EEnumLiteral) and modif part (EnumLiteralModification)
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

import modif.EnumLiteralModification;

import org.eclipse.emf.ecore.EEnumLiteral;

// EnumLiteralModif is compound of an ecore part (EEnumLiteral) and a modif part (EnumLiteralModification)

public interface EnumLiteralModif {

    // return the ecore part of EnumLiteralModif : EEnumLiteral 	
	EEnumLiteral getEcore();

	// set the ecore part of EnumLiteralModif : EEnumLiteral value
	void setEcore(EEnumLiteral value);

	// return the modif part of EnumLiteralModif : EnumLiteralModification 	
	EnumLiteralModification getModif();

	// set the modif part of EnumLiteralModif : EnumLiteralModification value
	void setModif(EnumLiteralModification value);

	// return the container of EnumLiteralModif : EnumModif	
	EnumModif getEnumModif();

	
}  // EnumLiteralModif
/**
 *  implementation for EnumLiteralModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package ecoremodif.impl;

import ecoremodif.*;
import modif.*;
import modif.util.UtilsEnumModif;

import org.eclipse.emf.ecore.*;

public class EnumLiteralModifImpl implements EnumLiteralModif,ModifElement {

	protected EEnumLiteral current;

	protected EnumLiteralModification modif;
	
	protected EnumModif enumModif;
	
	public EnumLiteralModifImpl(EEnumLiteral enumLiteral, EnumLiteralModification modifenum, EnumModif em) {
		current = enumLiteral;
		modif = modifenum;
		enumModif = em;

		UtilsEnumModif myUtils = new UtilsEnumModif();
		if (modif == null) modif = myUtils.Create(enumLiteral,em.getModif());
		
		myUtils.complete(current,modif);
	}
	
	public EEnumLiteral getEcore() {
		return current;
	}
	public void setEcore(EEnumLiteral newCurrent) {
		current = newCurrent;
	}

	public EnumLiteralModification getModif() {
		return modif;
	}
	public void setModif(EnumLiteralModification newModif) {
		modif = newModif;
	}
	
	// return the container of EnumLiteralModif : EnumModif	
	public EnumModif getEnumModif() {
		return enumModif;
	}
	
	public void accept(ModifElementVisitor visitor) { visitor.Visit(this);}
	
} //EnumLiteralModifImpl

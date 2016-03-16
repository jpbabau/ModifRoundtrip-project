/**
 *  implementation for EdataTypeModif 
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
import modif.util.*;

import org.eclipse.emf.ecore.*;

public class EdataTypeModifImpl implements EdataTypeModif,ModifElement {

	protected EDataType current;

	protected DataTypeModification modif;
	
	
	public EdataTypeModifImpl(EDataType edataType, DataTypeModification modifDataType, PackageModification pm) {
		current = edataType;
		modif = modifDataType;

		UtilsDataTypeModif myUtils = new UtilsDataTypeModif();
		if (modif == null) modif = myUtils.Create(edataType);
		
		myUtils.complete(current,modif);
		
	}
	
	public EDataType getEcore() {
		return current;
	}
	public void setEcore(EDataType newCurrent) {
		current = newCurrent;
	}

	public DataTypeModification getModif() {
		return modif;
	}
	public void setModif(DataTypeModification newModif) {
		modif = newModif;
	}
	
	public void accept(ModifElementVisitor visitor) { visitor.Visit(this);}
	
} //EdataTypeModifImpl

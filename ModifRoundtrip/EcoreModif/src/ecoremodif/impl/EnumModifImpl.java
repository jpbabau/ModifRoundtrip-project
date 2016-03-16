/**
 *  implementation for EnumModif 
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ecoremodif.*;
import modif.*;
import modif.util.*;

import org.eclipse.emf.ecore.*;

public class EnumModifImpl implements EnumModif,ModifElement {

	protected EEnum current;

	protected EnumModification modif;
	
	protected List<EnumLiteralModif> subLiteralModif;
	
	static protected List<EnumModif> allEnumModif = new ArrayList<EnumModif>();
		
	public EnumModifImpl(EEnum enum_, EnumModification modifEnum, PackageModification pm) {
		current = enum_;
		modif = modifEnum;
		
		subLiteralModif = new ArrayList<EnumLiteralModif>();
		
		UtilsEnumModif myUtils = new UtilsEnumModif();
		if (modif == null) modif = myUtils.Create(enum_);
		
		myUtils.complete(current,modif);
		
		Iterator<EEnumLiteral> it = 	enum_.getELiterals().iterator();
		// build literalModif properties of the enumModif
		while(it.hasNext()) {
			EEnumLiteral lit = it.next(); 
			EnumLiteralModification enumLitModif = null;
			
			if (modifEnum != null ) {
				enumLitModif = (EnumLiteralModification) myUtils.findEnumLiteral(lit.getName(), modifEnum.getEnumLiteralModification());
			} 
			EnumLiteralModif eNumLitModif = new EnumLiteralModifImpl(lit,enumLitModif, this);
						
			subLiteralModif.add(eNumLitModif);
		}
		
		// save the EnumModif in the static list of all the EnumModif
		allEnumModif.add(this);
		
	}
	
	// return the list of all EnumModif 
	public static List<EnumModif> getAllEnumModif() {
		return allEnumModif;
	}
	
	public EEnum getEcore() {
		return current;
	}
	public void setEcore(EEnum newCurrent) {
		current = newCurrent;
	}

	public EnumModification getModif() {
		return modif;
	}
	public void setModif(EnumModification newModif) {
		modif = newModif;
	}

	public List<EnumLiteralModif> getEnumLiteralModif() {
		return subLiteralModif;
	}
	public void add(EnumLiteralModif value) {
		subLiteralModif.add(value);
	}
	
	public void accept(ModifElementVisitor visitor) { visitor.Visit(this);}
	
} //EclassModifImpl

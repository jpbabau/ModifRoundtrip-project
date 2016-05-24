/**
 *  implementation for EattributeModif 
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

import org.eclipse.emf.ecore.*;
import modif.util.*;

public class EattributeModifImpl implements EattributeModif,ModifElement {

	protected EAttribute current;

	protected AttributeModification modif;
	
	protected EclassModif container;
	
	protected EnumModif enumModif;
	
	protected boolean isAdded;
	
	protected boolean isDerived;
	
	protected AddDerivedAttribute derived;	

	public EattributeModifImpl(EAttribute eattribute, AttributeModification modifAttribute, EclassModif cm) {
		current = eattribute;
		modif = modifAttribute;
		container = cm;
		enumModif = null;
		isAdded = false;
		derived = null;
		isDerived = false;
		
		UtilsFeatureModif myUtils = new UtilsFeatureModif();
		if (modif == null) modif = myUtils.Create(eattribute);
		
		myUtils.complete(current,modif);
		
	}

	public EAttribute getEcore() {
		return current;
	}
	public void setEcore(EAttribute newCurrent) {
		current = newCurrent;
	}

	public AttributeModification getModif() {
		return modif;
	}
	
	public void setModif(AttributeModification newModif) {
		modif = newModif;
	}

	// return the container of the attribute : EclassModif
	public EclassModif getClassModif() {
		return container;
	}
	
	// set the EnumModif type if it exists : EnumModif 
	public void setEnumModif(EnumModif value){
		enumModif = value;
	}
	
	// get the EnumModif type if it exists : EnumModif value
	public EnumModif getEnumModif(){
		return enumModif;
	}
	
    // return if is EattributeModif is added
	public boolean isAdded() {
		return isAdded;
	}
	
	// set the isAdded property
	public void setIsAdded(boolean value) {
		isAdded = value;
	}
	
    // return if is EattributeModif is derived 
	public boolean isDerived() {
		return isDerived;
	}

    // return Modif derived part 
	public AddDerivedAttribute getDerived() {
		return derived;
	}
	
	// set the isDerived property
	public void setIsDerived(boolean value, AddDerivedAttribute ada) {
		isDerived = value;
		derived = ada;
	}
	
	public void accept(ModifElementVisitor visitor) { visitor.Visit(this);}
	
} //EattributeModifImpl

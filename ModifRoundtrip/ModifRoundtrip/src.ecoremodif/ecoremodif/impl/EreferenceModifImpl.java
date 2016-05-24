/**
 *  implementation for EreferenceModif 
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

public class EreferenceModifImpl implements EreferenceModif,ModifElement {

	protected EclassModif from;
	
	protected EclassModif to;
	
	protected EReference current;
	
	protected ReferenceModification modif;
	
	protected boolean isAdded;
	
	protected boolean isDerived;
	
	protected boolean wasContainment;
	
	protected AddDerivedReference derived;

	public EreferenceModifImpl(EReference ereference, ReferenceModification modifReference, EclassModif cm) {
		current = ereference;
		modif = modifReference;
		from = cm;
		isDerived = false;
		isAdded = false;
		derived = null;
		wasContainment = current.isContainment();
		
		UtilsFeatureModif myUtils = new UtilsFeatureModif();
		if (modif == null) modif = myUtils.Create(ereference);
		
		myUtils.complete(current,modif);
		
	}

	public EReference getEcore() {
		return current;
	}
	public void setEcore(EReference newCurrent) {
		current = newCurrent;
	}
	
	public ReferenceModification getModif() {
		return modif;
	}
	public void setModif(ReferenceModification newModif) {
		modif = newModif;
	}
	
	public EclassModif getFrom() {
		return from;
	}

	public void setTo(EclassModif cm) {
		to = cm;
	}
	
	public EclassModif getTo() {
		return to;
	}

    // return if is EattributeModif is added
	public boolean isAdded() {
		return isAdded;
	}
	
	// set the isAdded property
	public void setIsAdded(boolean value) {
		isAdded = value;
	}
	
    // return true if is EreferenceModif is derived 
	public boolean isDerived() {
		return isDerived;
	}

    // return Modif derived part 
	public AddDerivedReference getDerived() {
		return derived;
	}

	// set the isDerived property
	public void setIsDerived(boolean value, AddDerivedReference adr) {
		isDerived = value;
		derived = adr;
	}
	
    // return true if is Ecore part is containment before refactoring
	public boolean wasContainment() {
		return wasContainment;
	}
	
	
	public void accept(ModifElementVisitor visitor) { visitor.Visit(this);}
	
} //EclassModifImpl

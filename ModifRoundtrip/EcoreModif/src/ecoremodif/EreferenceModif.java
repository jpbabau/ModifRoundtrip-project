/**
 *  interface for EreferenceModif 
 *  getter and setter of ecore part (EReference) and modif part (ReferenceModification)
 *  getter and setter of specific EreferenceModif features
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

import modif.*;
import org.eclipse.emf.ecore.EReference;

//EreferenceModif is compound of an ecore part (EReference) and a modif part (ReferenceModification)

public interface EreferenceModif {

    // return the ecore part of EreferenceModif : EReference 	
	EReference getEcore();

	// set the ecore part of EreferenceModif : EReference value
	void setEcore(EReference value);

    // return the modif part of EreferenceModif : ReferenceModification 	
	ReferenceModification getModif();

	// set the modif part of EreferenceModif : ReferenceModification value
	void setModif(ReferenceModification value);
	
	// return the container of the reference : EclassModif
	EclassModif getFrom();
	
	// set the referenced EclassModif
	void setTo(EclassModif cm);
	
	// return the referenced EclassModif
	EclassModif getTo();
	
    // return if is EattributeModif is added
	boolean isAdded();
	
	// set the isAdded property
	void setIsAdded(boolean value);
	
    // return true if is EreferenceModif is derived 
	boolean isDerived();

    // return Modif derived part 
	public AddDerivedReference getDerived();

	// set the isDerived property
	void setIsDerived(boolean value, AddDerivedReference adr);
	
    // return true if is Ecore part is containment before refactoring
	boolean wasContainment();	
} // EreferenceModif

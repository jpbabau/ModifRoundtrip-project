/**
 *  interface for EattributeModif 
 *  getter and setter of ecore part (EAttribute) and modif part (AttributeModification)
 *  getter and setter of specific EattributeModif features
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

import modif.AddDerivedAttribute;
import modif.AttributeModification;
import org.eclipse.emf.ecore.EAttribute;



public interface EattributeModif {

    // return the ecore part of EattributeModif : EAttribute 
	EAttribute getEcore();

	// set the ecore part of EattributeModif : EAttribute value
	void setEcore(EAttribute value);

    // return the modif part of EattributeModif : AttributeModification 
	AttributeModification getModif();

	// set the modif part of EattributeModif : AttributeModification value
	void setModif(AttributeModification value);
	
	// return the container of the attribute : EclassModif
	EclassModif getClassModif();
	
	// set the EnumModif type if it exists : EnumModif value
	void setEnumModif(EnumModif value);
	
	// get the EnumModif type if it exists : EnumModif 
	EnumModif getEnumModif();
	
    // return true if is EattributeModif is added
	boolean isAdded();
	
	// set the isAdded property
	void setIsAdded(boolean value);
	
    // return if is EattributeModif is derived 
	boolean isDerived();
	
    // return Modif derived part 
	public AddDerivedAttribute getDerived();
		
	// set the isDerived property
	void setIsDerived(boolean value, AddDerivedAttribute ada);


}  // EattributeModif
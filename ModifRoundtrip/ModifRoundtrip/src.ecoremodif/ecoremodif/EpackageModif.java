/**
 *  interface for EpackageModif 
 *  getter and setter of ecore part (EPackage) and modif part (PackageModification)
 *  getter and setter of specific EpackageModif features
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

import modif.PackageModification;

import org.eclipse.emf.ecore.*;

//EpackageModif is compound of an ecore part (EPackage) and a modif part (PackageModification)
//it also contains the correspondent EpackageModif, EclassModif objects, EdataTypeModif and EnumModif


public interface EpackageModif  {

    // return the ecore part of EpackageModif : EPackage 	
	EPackage getEcore();

	// set the ecore part of EpackageModif : EPackage value
	void setEcore(EPackage value);

    // return the modif part of EpackageModif : PackageModification 	
	PackageModification getModif();

	// set the modif part of EpackageModif : PackageModification value
	void setModif(PackageModification value);

    // return the long name of ecore Package before modification
	String getOldLongName();

    // return the long name of ecore Package after modification
	String getNewLongName();
	
    // return the name of ecore Package after modification (or its non null container if null)
	String getNewName();
	
	// setters and getters for list of EpackageModif, EclassModif objects, EdataTypeModif and EnumModif

	List<EpackageModif> getPackageModif();	
	
	void add(EpackageModif value);
	
	List<EclassModif> getClassModif();	
	
	// return all the EclassModif (including those contained in subpackages)
	List<EclassModif> getAllClassModif();	
	
	void add(EclassModif value);
	
	List<EdataTypeModif> getDataTypeModif();	
	
	void add(EdataTypeModif value);	
	
	List<EnumModif> getEnumModif();	
	
	EpackageModif getFather();
	
	void add(EnumModif value);	
	
} // EpackageModif

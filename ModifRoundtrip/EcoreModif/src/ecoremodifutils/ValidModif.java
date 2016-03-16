/**
 *  class to valid RootEcoreModif object 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package ecoremodifutils;

import modif.AddNameClass;
import ecoremodif.*;
import ecoremodif.impl.*;

	public class ValidModif {
		
		public boolean isValid(RootEcoreModif rm){
			// access to the root package 
			EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
			
			boolean valid = true;
		
			if (rm.getModifications().getAddRootClass()!=null && rm.getModifications().getAddNameClass()!=null)  {
				if (rm.getModifications().getAddRootClass().getName().equals(rm.getModifications().getAddNameClass().getName())) {
					valid = false;
					System.out.println("Error : the new root class and the new Named Class cannot have the same name");
				}	
			}
			AddNameClass anc = rm.getModifications().getAddNameClass();
			if ( (anc!=null) && (rm.existClassModification(anc.getName()) ) ) {
				rm.getModifications().setAddNameClass(null);
				System.out.println(" Warning : it already exists a class with the same name as the new Named Class");
			}
			
			// visitor call for root package
			valid = valid && isValid(root);

			return valid;
		}
		
		public boolean isValid(EpackageModif pm) {

			boolean valid = true;
			
			// for each  subpackage	
			for (EpackageModif subPackage : pm.getPackageModif()) {
				//  visitor call for each subpackage
				valid = valid && isValid(subPackage);
			}
			// for each subclass	
			for (EclassModif subClass : pm.getClassModif()) {
				//  visitor call for each subclass
				valid = valid && isValid(subClass);			
			}
			// for each subDataType	
			for (EdataTypeModif subDataType : pm.getDataTypeModif()) {
				//  visitor call for each subclass
				valid = valid && isValid(subDataType);			
			}
			// for each subEnum	
			for (EnumModif subEnum : pm.getEnumModif()) {
				//  visitor call for each subclass
				valid = valid && isValid(subEnum);			
			}
			return valid;
		}
		
		public boolean isValid(EclassModif cm){

			boolean valid = true;
			
			// for each attribute	
			for (EattributeModif att : cm.getAttributeModif()) {
				//  visitor call for attribute
				valid = valid && isValid(att);		
			}
			// for each reference	
			for (EreferenceModif ref : cm.getReferenceModif()) {
				//  visitor call for reference
				valid = valid && isValid(ref);			
			}
			return valid;
		}
		
		public  boolean isValid(EattributeModif am){
			boolean valid = true;
			return valid;
		}
		
		public boolean isValid(EreferenceModif rm){
			boolean valid = true;
			return valid;
		}
		
		public boolean isValid(EdataTypeModif dtm){	
			boolean valid = true;
			return valid;
		}
		
		public boolean isValid(EnumModif enm){	
			
			boolean valid = true;
			
			// for each subEnumLiteral	
			for  (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
				//  visitor call for each subEnumLiteral
				valid = valid && isValid(subEnumLit);			
			}
			return valid;				
		}

		public boolean isValid(EnumLiteralModif elm){	
			boolean valid = true;
			return valid;
		}
	}


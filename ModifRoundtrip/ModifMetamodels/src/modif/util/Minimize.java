/**
 * class to build by-default modif model from ecore model
 *  
 * Copyright (C) 2013 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 16 déc. 2013
 */
package modif.util;

import modif.*;

public class Minimize {
	
	public void go(Modifications modif) {
						
		go(modif.getRootPackageModification());
	}
	
	private void go(PackageModification modif) {
		
		for (PackageModification subPackage : modif.getPackageModification()) {
			go(subPackage);
		}
		for (ClassModification subClass : modif.getClassModification()) {
			go(subClass);
		}
		for (DataTypeModification dataType : modif.getDataTypeModification()) {
			go(dataType);
		}					
		for (EnumModification eNum : modif.getEnumModification()) {
			go(eNum);
		}
	}
	
	private void go(ClassModification subClass) {
		
		if (subClass.isRemove() || subClass.isHide()) {
			subClass.setNewName(null);
			
			if (subClass.isRemove() ) {
				subClass.getFeatureModification().clear();
			}
			
			subClass.getAddFeatures().clear();
			subClass.getAddDeriveds().clear();
			subClass.getAnnotationModification().clear();
			
			subClass.setRemoveEAnnotations(false);
			
			subClass.setChangeAbstract(false);
			
			if (subClass.isRemove()) {
				subClass.setHide(false);			
				subClass.setFlatten(false);
				subClass.setFlattenAll(false);
			}
			subClass.setEnumerate(null);
			
		} else {
			
			if (subClass.getOldName().equals(subClass.getNewName())) {
				subClass.setNewName(null);
			}
			for (StructuralFeatureModification fm : subClass.getFeatureModification()) {
				if (fm instanceof AttributeModification) {
					go((AttributeModification) fm);
				}
				if (fm instanceof ReferenceModification) {
					go((ReferenceModification) fm);
				}
			}
		}
		
	}
	
	private void go(AttributeModification am) {
		
		if (am.isRemove()) {
			am.setNewName(null);
			am.getAnnotationModification().clear();
			am.setRemoveEAnnotations(false);	
			am.setChangeType(false);
			
		} else {
			if (am.getOldName().equals(am.getNewName())) {
				am.setNewName(null);
			}
		}
	}
	
	private void go(ReferenceModification fm) {
		
		if (fm.isRemove()) {
			fm.setNewName(null);
			fm.getAnnotationModification().clear();
			fm.setRemoveEAnnotations(false);	
			fm.setChangeContainement(false);
			fm.setRemoveOpposite(false);
			fm.setAddOpposite(null);
			fm.setReify(null);
			
		} else {
			if (fm.getOldName().equals(fm.getNewName())) {
				fm.setNewName(null);
			}
		}
	}
	
	private void go(DataTypeModification edm) {
		
		if (edm.isRemove()) {
			edm.setNewName(null);
			edm.setOldInstanceTypeName(null);
			edm.setNewInstanceTypeName(null);
			edm.getAnnotationModification().clear();
			edm.setRemoveEAnnotations(false);
		} else {
			if (edm.getOldName().equals(edm.getNewName())) {
				edm.setNewName(null);
			}
		}
	}
	
	private void go(EnumModification enm) {
		
		if (enm.isRemove()) {
			enm.setNewName(null);
			enm.setOldInstanceTypeName(null);
			enm.setNewInstanceTypeName(null);
			enm.getEnumLiteralModification().clear();
			enm.getAnnotationModification().clear();
			enm.setRemoveEAnnotations(false);			
			enm.setReify(false);	
		} else {
			if (enm.getOldName().equals(enm.getNewName())) {
				enm.setNewName(null);
			}
		}
	}
	
}

/**
 * 
 *  operator to remove hided classes 
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package operators;

import org.eclipse.emf.ecore.util.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifCleanHidedClasses implements ModifElementVisitor {
	
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
		
		// visitor call for root package
		root.accept(this);
	}
	
	public void Visit(EpackageModif pm) {
			
		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}
		// for each subclass	
		for (EclassModif subClass: pm.getClassModif()) {		
			//  visitor call for each subclass
			((EclassModifImpl)subClass).accept(this);			
		}	
	}
	
	public void Visit(EclassModif cm){
		
		if (cm.getEcore()!=null && cm.getModif()!=null){
			if (! cm.getModif().isRemove() && cm.getModif().isHide()){	
				
				EcoreUtil.delete(cm.getEcore());
				
				cm.setEcore(null);
			}
		}
	}
	
	public void Visit(EreferenceModif rm)  {	}
	public void Visit(EattributeModif am)  {    }
	public void Visit(EdataTypeModif dtm)  {	}
	public void Visit(EnumModif enm)	   {	}
	public void Visit(EnumLiteralModif elm){    }
}

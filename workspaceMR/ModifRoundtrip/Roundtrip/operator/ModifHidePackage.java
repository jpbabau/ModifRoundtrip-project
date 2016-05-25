/**
 * 
 *  operator to hide packages
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package operator;

import org.eclipse.emf.ecore.util.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifHidePackage implements ModifElementVisitor {
	
	
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
		
		// visitor call for root package
		root.accept(this);
	}	
	
	public void Visit(EpackageModif pm) {
			
		// apply hide to subpackages first
		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}
		
		// move the containment of the package in its container
		if (pm.getEcore()!=null && pm.getModif()!=null){		
			if (! pm.getModif().isRemove() && pm.getModif().isHide()){			
	
				pm.getEcore().getESuperPackage().getESubpackages().addAll(pm.getEcore().getESubpackages());
				
				pm.getEcore().getESuperPackage().getEClassifiers().addAll(pm.getEcore().getEClassifiers());
				
				EcoreUtil.delete(pm.getEcore());
				
				pm.setEcore(null);
				
			}
		}
	}
	
	public void Visit(EclassModif cm)      {	}
	public void Visit(EreferenceModif rm)  {	}
	public void Visit(EattributeModif am)  {    }
	public void Visit(EdataTypeModif dtm)  {	}
	public void Visit(EnumModif enm)	   {	}
	public void Visit(EnumLiteralModif elm){    }
	
}

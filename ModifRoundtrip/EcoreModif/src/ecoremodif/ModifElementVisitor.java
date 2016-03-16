/**
 *  interface for ecoremodif element visitor
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

// standard interface of a visitor class for ecoremodif elements
// defines a Visit Method for each element
// except for RootEcoreModif, with the VisitRoot method

public interface ModifElementVisitor {

	void Visit(EpackageModif pm);
	void Visit(EclassModif cm);
	void Visit(EattributeModif am);	
	void Visit(EreferenceModif am);	
	void Visit(EdataTypeModif dtm);		
	void Visit(EnumModif enm);		
	void Visit(EnumLiteralModif elm);		
	void VisitRoot(RootEcoreModif rm);
	
}

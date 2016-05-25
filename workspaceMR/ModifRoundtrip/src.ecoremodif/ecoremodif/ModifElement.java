/**
 *  interface for ecoremodif element 
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

//standard operation to be implemented by an ecoremodif elements to be visited

public interface ModifElement {

	void accept(ModifElementVisitor visitor);
	
}

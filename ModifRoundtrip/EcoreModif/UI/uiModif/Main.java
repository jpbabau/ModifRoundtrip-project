/**
 * 
 * Main class for EcoreModif project
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau, Paola Vallejo, Mickaël Kerboeuf
 *  22/11/2013
 */

package uiModif;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		modifUI window = new modifUI();
		window.open();
	}
}

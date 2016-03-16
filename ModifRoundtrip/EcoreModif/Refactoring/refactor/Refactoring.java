/**
 * 
 * sequence call of refactoring operators 
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package refactor;

import ecoremodif.*;

public class Refactoring {

	
	public static boolean isOk(RootEcoreModif theRootEcoreModif) {

		// test if the ecore + modif element is valid
		return (new ecoremodifutils.ValidModif().isValid(theRootEcoreModif));
	}
	
	/**
	 * @param args
	 */
	public static void operate(RootEcoreModif theRootEcoreModif) {

		// propagate macro modif operators
		new operator.ModifPropagate().VisitRoot(theRootEcoreModif);
		
		if (Refactoring.isOk(theRootEcoreModif)) {
		
			// rename (if necessary) all ecore elements	
			new operator.ModifRename().VisitRoot(theRootEcoreModif);				
		
			// merge (if necessary) classes
			new operator.ModifMergeClasses().VisitRoot(theRootEcoreModif);
		
			// merge (if necessary) references
			new operator.ModifMergeReferences().VisitRoot(theRootEcoreModif);

			// change (if necessary) the properties (abstract, containment, lower and upper bounds, attribute type) 
			// of all concerned ecore elements
			new operator.ModifChangeProperties().VisitRoot(theRootEcoreModif);
		
			// flatten (if necessary) the corresponding structural features	
			new operator.ModifFlattenClass().VisitRoot(theRootEcoreModif);		
			new operator.ModifFlattenAllClass().VisitRoot(theRootEcoreModif);
		
			// hide (if necessary) all EPackages	
			new operator.ModifHidePackage().VisitRoot(theRootEcoreModif);

			// hide (if necessary) all EClasses		
			new operator.ModifHideClass().VisitRoot(theRootEcoreModif);				
		
			// add derived (if necessary) to all EClasses	
			new operator.ModifAddDerived().VisitRoot(theRootEcoreModif);		
		
			// remove (if necessary) all ecore elements
			// remove all EOperations
			// remove (if necessary) all EAnnotations and EOpposite of references				
			new operator.ModifRemove().VisitRoot(theRootEcoreModif);
		
			// add (if necessary) attributes			
			new operator.ModifAddFeature().VisitRoot(theRootEcoreModif);
			
			// reify (if necessary) references and enums				
			new operator.ModifReify().VisitRoot(theRootEcoreModif);

			// enumerate (if necessary) subclasses			
			new operator.ModifEnumerate().VisitRoot(theRootEcoreModif);
			
			// add (if necessary) a rootClass containing all the classes			
			new operator.ModifAddRootClass().VisitRoot(theRootEcoreModif);
	
			// add (if necessary) an abstract namedElement Class, and all the classes inherits from it		
			new operator.ModifAddAllName().VisitRoot(theRootEcoreModif);
		
			// print the resulting ecore model
		//	new operator.ModifPrint().VisitRoot(theRootEcoreModif);	
		
		} 		
	}

}

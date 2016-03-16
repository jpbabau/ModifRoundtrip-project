/**
 *  class to build a RootEcoreModif object from Modif and Ecore files
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Mickaël kerboeuf, Jean-Philippe Babau
 *  22/11/2013
 */

package ecoremodifutils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import modif.*;
import ecoremodif.*;
import ecoremodif.impl.RootEcoreModifImpl;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import xtext.XModifStandaloneSetup;

import com.google.inject.Injector;

public class ModifIO {

	// EcoreModif object
	private RootEcoreModif theRootEcoreModif;
	
	public RootEcoreModif getEcoreModif() {	return theRootEcoreModif; }	
	
	/**
	 * build an ecore model from an ecore file
	 */
	
	public EPackage LoadEcore(String inputFile) {

		// EMF resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// register a factory (XMI) :
		resourceSet
		.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	
		// register the Epackage root :
		resourceSet.getPackageRegistry()
		.put( EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		System.out.println("inputFile   "+inputFile);
		// uri of ecore file
		File file = new File(inputFile);
		URI uri = file.isFile() ?
				  URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(inputFile);

		// load the file
		Resource resource = resourceSet.getResource(uri, true);
		
		System.out.println("[loading] file "+ file.getName() + ": ok.");
		
		// return the EPakage root
		return ((EPackage) resource.getContents().get(0));
	}
	
	/**
	 * Fonction utilitaire de désérialisation d'un fichier modif ou ecore
	 * @param inputFile fichier à charger
	 * @param isModif précise la nature du fichier : Modif (true) ou Ecore (false)
	 * @return Objet racine du fichier fourni
	 */
	public Modifications LoadModif(String inputFile) {

		Injector injector = new XModifStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		File file = new File(inputFile);
		URI uri = URI.createFileURI(file.getAbsolutePath());
				  
		// register the S2PMiner EPackage root
		resourceSet.getPackageRegistry().put( ModifPackage.eNS_URI, ModifPackage.eINSTANCE );
		
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		
		System.out.println("[loading] file "+ file.getName() + ": ok.");
		
		return ((Modifications) resource.getContents().get(0));

	}

	/** ecore and modif files reading to build theRootEcoreModif
	 */
	public void setModifIO(String inputEcoreFile, String modifFile) {
		System.out.println("inputEcoreFile  "+inputEcoreFile);
		System.out.println("modifFile  "+modifFile);
		
		Modifications theRootModif  = LoadModif(modifFile);
		EPackage theRootEcore       = LoadEcore(inputEcoreFile);
		
		this.theRootEcoreModif      = null;
		this.theRootEcoreModif      = new RootEcoreModifImpl(theRootEcore,theRootModif);
	}
		
	/**
	 * Sauvegarde de l'objet racine du métamodèle d'entrée dans le fichier
	 * indiqué en paramètre.
	 * @param outputEcoreFile fichier de sauvegarde à créer
	 * @throws IOException 
	 */
	public void save(String outputEcoreFile) throws IOException {

		// Ensemble de ressources EMF à remplir et à sauvegarder :
		ResourceSet resourceSet = new ResourceSetImpl();

		// Enregistre une usine à objets générique (XMI) :
		resourceSet.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Désigne ou crée les fichiers de sortie :
		File file = new File(outputEcoreFile);
		URI uriOut = URI.createFileURI(file.getAbsolutePath());
		
		// Creation d'une resource :
		Resource resource = resourceSet.createResource(uriOut);

		// Ajout dans la resource de l'objet racine du métamodèle de sortie :
		resource.getContents().add(this.theRootEcoreModif.getRoot().getEcore());

		// Sauvegarde :
		resource.save(Collections.EMPTY_MAP);

		System.out.println("[saving] file "+ file.getName() + ": ok.");
	}
	
	public static void SaveModif(Modifications modif, String outputFile) throws IOException{
		
		Injector injector = new XModifStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		File file = new File(outputFile);
		System.out.println("file  "+file);

		URI uri = URI.createFileURI(file.getAbsolutePath());
				  
		// register the Modif EPackage root
		resourceSet.getPackageRegistry().put( ModifPackage.eNS_URI, ModifPackage.eINSTANCE);
		
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		System.out.println("resource  "+resource);
		
		resource.getContents().clear();
		
		resource.getContents().add(modif);
		
		resource.save(Collections.EMPTY_MAP);
		
		/*
		
		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		File file = new File(outputFile);
		URI uriOut = URI.createFileURI(file.getAbsolutePath());
		
		Resource resource = resourceSet.createResource(uriOut);

		resource.getContents().add(modif);

		// Sauvegarde :
		resource.save(Collections.EMPTY_MAP);*/

		System.out.println("[saving] file "+ file.getName() + ": ok.");
	}
}

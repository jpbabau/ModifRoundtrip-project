/**
 * 
 * User Interface for Modif project
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Mickael Kerbeouf, Jean-Philippe Babau, Paola Vallejo
 *  22/11/2013
 */

package uiModif;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import migration.Migration;
import migration.MigrationPackage;
import migration.tools.MigrationRoundtrip;
import migration.tools.UtilEMF;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

import codeGeneration.MigrationGenerator;

public class modifUI {

	protected Shell shell;
	private Text txtDomainMetamodelSimpleRefactor;
	private Text txtDomainMetamodelSimpleMigration;
	private Text txtDomainMetamodel;
	private Text txtDomainModelSimpleMigration;
	private Text txtDomainModel;
	private Text txtToolMetamodel;
	private Text txtModifSpecification;
	private Text txtModifSpecificationSimpleRefactoring;
	private Text txtTargetMetamodelSimpleRefactoring;
	private Text txtTargetMetamodelSimpleMigration;
	private Text txtModifSpecificationSimpleMigration;
	private Text txtTool;
	private Text txtFunction;
	private Text txtMigrationSpecification;

	Button btnNoModifSimpleRefactoring;
	Button btnNoModifSimpleMigration;
	Button btnNoModif;
	Button btnEraseAllSimpleRefactoring;
	Button btnEraseAllSimpleMigration;
	Button btnEraseAll;
	Button btnMigrateSimpleMigration;
	Button btnAutomaticSimpleMigration;
	Button btnCustomSimpleMigration;
	Button btnMigrationEditionSimpleMigration;
	Button btnMigrationSpecificationEdition;
	Button btnCheckUML;
	Button btnCheckUMLCoevolution;
	Button btnDomainMetamodel;
	Button btnTargetMetamodelSimpleRefactoring;
	Button btnTargetMetamodelSimpleMigration;
	Button btnProjectSourceFolder;

	protected ArrayList<String> hideClasses;
	protected ArrayList<String> flattenClasses;

	protected boolean finish;

	protected String processedModel;
	protected String graphModel;

	Composite compositeModifSimpleRefactoring;
	Composite compositeModifSimpleMigration;
	Composite compositeModifSimpleMigrationEdition;
	Composite compositeCheckSimpleRefactoring;
	Composite compositeRefactorSimpleMigration;
	Composite compositeCheck;
	Composite compositeModif;
	Composite compositeMigration;
	Composite compositeReuse;
	Composite compositeMigrationSimpleMigration;

	protected modifService theModifService;
	protected EPackage rootkeyPackage;
	protected String refactoredWithoutKFileName;
	protected String keyEcoreFile;
	protected File projectFolder;
	protected String migratedFileName;
	protected MigrationRoundtrip migrt;
	protected boolean isUML;
	protected String packageWithoutKName;
	protected String modifFileName;
	protected String refactoredMetamodelPath;

	protected boolean simpleMigrationInterface;
	protected boolean reuseInterface;
	protected boolean isSimpleRefactor;

	/**
	 * Constructor
	 */
	public modifUI(){
		/* facade access */
		theModifService = new modifService();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) { display.sleep(); }
		}
	}

	public Text getTxtDomainMetamodelSimpleMigration(){
		return txtDomainMetamodelSimpleMigration;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(710, 400);
		shell.setText("Modif Roundtrip");

		// logo
		//SWTResourceManager swtManager = new SWTResourceManager();
		shell.setImage(SWTResourceManager.getImage("..\\EcoreModif\\UI\\MR.png"));
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		// Menu New
		MenuItem mntmNew = new MenuItem(menu, SWT.CASCADE);
		mntmNew.setText("New");
		Menu menu_1 = new Menu(mntmNew);
		mntmNew.setMenu(menu_1);

		new MenuItem(menu, SWT.SEPARATOR);

		// Menu Finish
		MenuItem mntmFinish = new MenuItem(menu, SWT.NONE);
		mntmFinish.setText("Finish");
		mntmFinish.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				finish= true;
				compositeModifSimpleRefactoring.setVisible(false);
				compositeCheckSimpleRefactoring.setVisible(false);
				compositeRefactorSimpleMigration.setVisible(false);
				compositeModif.setVisible(false);
				compositeCheck.setVisible(false);
				compositeMigration.setVisible(false);
				compositeReuse.setVisible(false);
			}
		});

		// Item Simple Refactoring
		final MenuItem mntmSimpleRefactor = new MenuItem(menu_1, SWT.RADIO);
		mntmSimpleRefactor.setText("Refactoring");
		mntmSimpleRefactor.setEnabled(true);
		mntmSimpleRefactor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(mntmSimpleRefactor.getSelection()){
					compositeModifSimpleRefactoring.setVisible(true);
					compositeModifSimpleMigration.setVisible(false);
					compositeCheckSimpleRefactoring.setVisible(true);
					compositeRefactorSimpleMigration.setVisible(false);
					compositeModif.setVisible(false);
					compositeCheck.setVisible(false);
					compositeMigration.setVisible(false);
					compositeMigrationSimpleMigration.setVisible(false);
					compositeReuse.setVisible(false);
				}
			}
		});

		// Item Simple Migration
		final MenuItem mntmSimpleMigration = new MenuItem(menu_1, SWT.RADIO);
		mntmSimpleMigration.setText("Co-evolution");
		mntmSimpleMigration.setEnabled(true);
		mntmSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(mntmSimpleMigration.getSelection()){			
					compositeModifSimpleRefactoring.setVisible(false);
					compositeModifSimpleMigration.setVisible(true);
					compositeCheckSimpleRefactoring.setVisible(false);
					compositeRefactorSimpleMigration.setVisible(true);
					compositeModif.setVisible(false);
					compositeCheck.setVisible(false);
					compositeMigration.setVisible(false);
					compositeMigrationSimpleMigration.setVisible(true);
					compositeReuse.setVisible(false);
				}
			}
		});

		// Item Reuse
		final MenuItem mntmReuse = new MenuItem(menu_1, SWT.RADIO);
		mntmReuse.setText("Reuse");
		mntmReuse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(mntmReuse.getSelection()){
					compositeModifSimpleRefactoring.setVisible(false);
					compositeModifSimpleMigration.setVisible(false);
					compositeCheckSimpleRefactoring.setVisible(false);
					compositeRefactorSimpleMigration.setVisible(false);
					compositeModif.setVisible(true);
					compositeCheck.setVisible(true);
					compositeMigration.setVisible(true);
					compositeMigrationSimpleMigration.setVisible(false);
					compositeReuse.setVisible(true);
				}
			}
		});

		// composite Modif Simple Refactoring

		compositeModifSimpleRefactoring = new Composite(shell, SWT.BORDER);
		compositeModifSimpleRefactoring.setBounds(10, 10, 680, 65);
		compositeModifSimpleRefactoring.setVisible(false);

		final Label lblDomainMetamodelSimpleRefactor = new Label(compositeModifSimpleRefactoring, SWT.NONE);
		lblDomainMetamodelSimpleRefactor.setBounds(10, 35, 116, 15);
		lblDomainMetamodelSimpleRefactor.setText("Domain Metamodel");

		txtDomainMetamodelSimpleRefactor = new Text(compositeModifSimpleRefactoring, SWT.BORDER);
		txtDomainMetamodelSimpleRefactor.setBounds(132, 33, 250, 21);

		btnDomainMetamodel = new Button(compositeModifSimpleRefactoring, SWT.NONE);
		btnDomainMetamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Ecore file (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();
				if (fn != null) {
					txtDomainMetamodelSimpleRefactor.setText(fn);
					File f = new File(txtDomainMetamodelSimpleRefactor.getText());
					projectFolder = new File(f.getParent());
				}
			}
		});

		btnDomainMetamodel.setBounds(385, 31, 75, 25);
		btnDomainMetamodel.setText("Select");
		//btnDomainMetamodel.setEnabled(true);

		btnCheckUML = new Button(compositeModifSimpleRefactoring, SWT.CHECK);
		btnCheckUML.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckUML.getSelection()){
					isUML = true;
					//habilitar pero pedir metamodel folder
					//lblDomainMetamodelSimpleRefactor.setEnabled(!isUML);
					lblDomainMetamodelSimpleRefactor.setText("Project source folder");
					//txtDomainMetamodelSimpleRefactor.setEnabled(!isUML);
					//btnDomainMetamodel.setEnabled(!isUML);
				}else if(!btnCheckUML.getSelection()){
					isUML = false;
					//lblDomainMetamodelSimpleRefactor.setEnabled(!isUML);
					//txtDomainMetamodelSimpleRefactor.setEnabled(!isUML);
					//btnDomainMetamodel.setEnabled(!isUML);
					lblDomainMetamodelSimpleRefactor.setText("Domain metamodel");
				}
			}
		});
		btnCheckUML.setBounds(132, 9, 93, 16);
		btnCheckUML.setText("UML");
		btnCheckUML.setEnabled(true);
		btnCheckUML.setVisible(true);

		btnNoModifSimpleRefactoring = new Button(compositeModifSimpleRefactoring, SWT.RADIO);
		btnNoModifSimpleRefactoring.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnNoModifSimpleRefactoring.setBounds(490, 9, 75, 16);
		btnNoModifSimpleRefactoring.setText("NoModif");

		btnEraseAllSimpleRefactoring = new Button(compositeModifSimpleRefactoring, SWT.RADIO);
		btnEraseAllSimpleRefactoring.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnEraseAllSimpleRefactoring.setBounds(580, 9, 90, 16);
		btnEraseAllSimpleRefactoring.setText("EraseAll");

		Button btnGenerateModifSimpleRefactor = new Button(compositeModifSimpleRefactoring, SWT.NONE);
		btnGenerateModifSimpleRefactor.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnGenerateModifSimpleRefactor.setBounds(480, 31, 180, 25);
		btnGenerateModifSimpleRefactor.setText("Generate Modif Specification");

		btnGenerateModifSimpleRefactor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				// no metamodel selected because it is UML
				if(txtDomainMetamodelSimpleRefactor.getText().equals("") && !isUML){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();	
				}else if(txtDomainMetamodelSimpleRefactor.getText().equals("") && isUML) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select the project source folder");
					messageBox.open();	
				}else{
					if(!btnNoModifSimpleRefactoring.getSelection() && !btnEraseAllSimpleRefactoring.getSelection()){
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Select the modif to be generated");
						messageBox.open();	
					}else{
						boolean key = false;
						if(isUML){
							int modifSpecificationType = 0;
							if(btnNoModifSimpleRefactoring.getSelection()){
								modifSpecificationType = 1;
							}else if(btnEraseAllSimpleRefactoring.getSelection()) {
								modifSpecificationType = 2;
							}	
							try {
								theModifService.Refactoring(txtDomainMetamodelSimpleRefactor.getText(), modifSpecificationType, isUML, false, true);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							modifFileName = theModifService.getModifFileName();

							/*theModifService.setFiles(null, txtDomainMetamodelSimpleRefactor.getText(), null, null, null, null, null, null, isUML);
							//EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleRefactor.getText());
							//EPackage domainMM = UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(UtilEMF.removeOperations(EcoreUtil.copy(UMLPackage.eINSTANCE))));
							String domainMetamodelPath = txtDomainMetamodelSimpleRefactor.getText(); 
							File f = new File(domainMetamodelPath);
							int idx = f.getName().lastIndexOf('.');*/
						}else{
							theModifService.setFiles(null, txtDomainMetamodelSimpleRefactor.getText(), null, null, null, null, null, null, isUML);
							EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleRefactor.getText());

							String domainMetamodelPath = txtDomainMetamodelSimpleRefactor.getText(); 
							File f = new File(domainMetamodelPath);
							int idx = f.getName().lastIndexOf('.');

							String modifNoModif;
							String modifEraseAll;

							File modifFolder = new File(f.getParent().replace("metamodel", "modif"));
							// modif folder does not exist
							if(!modifFolder.exists()){
								//modif folder creation
								File dir = new File(f.getParent()+"/../modif");
								dir.mkdir();
							}
							// NoModif is selected
							if(btnNoModifSimpleRefactoring.getSelection()){
								modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+".modif";
								File noModif = new File(modifNoModif);
								// There is a NoModif file
								if(noModif.exists()){
									MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
									messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+".modif ?");
									int response = messageBox.open();
									if (response == SWT.YES){
										try {
											theModifService.generateModifFile(txtDomainMetamodelSimpleRefactor.getText(), 1, modifNoModif, key);

											///TEST
											//theModifService.generateModifFile("C:/ModifProject/Test_Vehicles/metamodel/Vehicles.ecore", 1, modifNoModif, key);
											///TEST

										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}else{
									try {
										theModifService.generateModifFile(txtDomainMetamodelSimpleRefactor.getText(), 1, modifNoModif, key);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								// EraseAll is selected
							}else if(btnEraseAllSimpleRefactoring.getSelection()){
								modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+".modif";
								File eraseAll = new File(modifEraseAll);
								if(eraseAll.exists()){
									MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
									messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+".modif ?");
									int response = messageBox.open();
									if (response == SWT.YES){
										try {
											theModifService.generateModifFile(txtDomainMetamodelSimpleRefactor.getText(), 2, modifEraseAll, key);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}else{
									try {
										theModifService.generateModifFile(txtDomainMetamodelSimpleRefactor.getText(), 2, modifEraseAll, key);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					}							
				}
			}
		});


		// composite Modif Simple Migration

		compositeModifSimpleMigration = new Composite(shell, SWT.BORDER);
		compositeModifSimpleMigration.setBounds(10, 10, 680, 65);
		compositeModifSimpleMigration.setVisible(false);

		final Label lblDomainMetamodelSimpleMigration = new Label(compositeModifSimpleMigration, SWT.NONE);
		lblDomainMetamodelSimpleMigration.setBounds(10, 35, 116, 15);
		lblDomainMetamodelSimpleMigration.setText("Domain Metamodel");

		txtDomainMetamodelSimpleMigration = new Text(compositeModifSimpleMigration, SWT.BORDER);
		txtDomainMetamodelSimpleMigration.setBounds(132, 33, 250, 21);

		btnCheckUMLCoevolution = new Button(compositeModifSimpleMigration, SWT.CHECK);
		btnCheckUMLCoevolution.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckUMLCoevolution.getSelection()){
					isUML = true;
					lblDomainMetamodelSimpleMigration.setText("Project source folder");
					//lblDomainMetamodelSimpleMigration.setVisible(false);
				}else if(!btnCheckUMLCoevolution.getSelection()){
					isUML = false;
					lblDomainMetamodelSimpleMigration.setText("Domain metamodel");
					//btnDomainMetamodel.setVisible(true);
				}
			}
		});
		btnCheckUMLCoevolution.setBounds(132, 9, 93, 16);
		btnCheckUMLCoevolution.setText("UML");
		btnCheckUMLCoevolution.setEnabled(true);
		btnCheckUMLCoevolution.setVisible(true);

		btnProjectSourceFolder = new Button(compositeModifSimpleMigration, SWT.NONE);
		btnProjectSourceFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(shell);
				dlg.setFilterPath("C:/ModifRoundtrip-project/ModifRoundtrip");	    	  
				String fn = dlg.open();
				if (fn != null) {
					txtDomainMetamodelSimpleMigration.setText(fn);
				}
			}
		});	 

		btnProjectSourceFolder.setBounds(385, 31, 75, 25);
		btnProjectSourceFolder.setText("Select");


		btnDomainMetamodel = new Button(compositeModifSimpleMigration, SWT.NONE);
		btnDomainMetamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Ecore file (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();
				if (fn != null) {
					txtDomainMetamodelSimpleMigration.setText(fn);
					File f = new File(txtDomainMetamodelSimpleMigration.getText());
					projectFolder = new File(f.getParent());
				}
			}
		});

		btnDomainMetamodel.setBounds(385, 31, 75, 25);
		btnDomainMetamodel.setText("Select");

		btnNoModifSimpleMigration = new Button(compositeModifSimpleMigration, SWT.RADIO);
		btnNoModifSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnNoModifSimpleMigration.setBounds(490, 9, 75, 16);
		btnNoModifSimpleMigration.setText("NoModif");

		btnEraseAllSimpleMigration = new Button(compositeModifSimpleMigration, SWT.RADIO);
		btnEraseAllSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnEraseAllSimpleMigration.setBounds(580, 9, 90, 16);
		btnEraseAllSimpleMigration.setText("EraseAll");

		/****
		 * Modif for simple migration
		 */

		Button btnGenerateModifSimpleMigration = new Button(compositeModifSimpleMigration, SWT.NONE);
		btnGenerateModifSimpleMigration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnGenerateModifSimpleMigration.setBounds(480, 31, 180, 25);
		btnGenerateModifSimpleMigration.setText("Generate Modif Specification");

		btnGenerateModifSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				// no metamodel selected because it is UML
				if(txtDomainMetamodelSimpleMigration.getText().equals("") && !isUML){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();	
				}else if(txtDomainMetamodelSimpleMigration.getText().equals("") && isUML) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select the project source folder");
					messageBox.open();	
				}else{
					if(!btnNoModifSimpleMigration.getSelection() && !btnEraseAllSimpleMigration.getSelection()){
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Select the modif to be generated");
						messageBox.open();	
					}else {
						boolean key = false;
						if(isUML) {
							int modifSpecificationType = 0;
							if(btnNoModifSimpleMigration.getSelection()){
								modifSpecificationType = 1;
							}else if(btnEraseAllSimpleMigration.getSelection()) {
								modifSpecificationType = 2;
							}
							try {
								theModifService.Refactoring(txtDomainMetamodelSimpleMigration.getText(), modifSpecificationType, isUML, true, true);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							modifFileName = theModifService.getModifFileName();

						}else {
							theModifService.setFiles(null, txtDomainMetamodelSimpleMigration.getText(), null, null, null, null, null, null, isUML);					
							EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleMigration.getText());
							boolean addKeys = true;
							key = true;

							// verifying if keys were already added
							for(TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();){
								EObject next = it.next();
								if(next instanceof EClass){
									EClass c = (EClass) next;
									for(EAttribute ea : c.getEAllAttributes()){
										if(ea.getName().equals("UUID")){
											addKeys = false;
											break;
										}
									}
								}
							}

							// adding keys
							if(addKeys){ rootkeyPackage = theModifService.addUUIDAttributes(); }
							else{ rootkeyPackage = domainMM; }

							String domainMetamodelPath = txtDomainMetamodelSimpleMigration.getText();
							File f = new File(domainMetamodelPath);
							int idx = f.getName().lastIndexOf('.');

							String modifNoModif;
							String modifEraseAll;

							File modifFolder = new File(f.getParent().replace("metamodel", "modif"));

							// modif folder does not exist
							if(!modifFolder.exists()){
								//modif folder creation
								File dir = new File(f.getParent()+"/../modif");
								dir.mkdir();
							}
							// has to add keys
							if(addKeys){
								// metamodel with keys
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0,idx)+"K"+f.getName().substring(idx,idx+6);

								// NoModif is selected
								if(btnNoModifSimpleMigration.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+"K.modif";
									File noModif = new File(modifNoModif);
									// There is a NoModif file with the same name
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+"K.modif ?");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile(keyEcoreFile, 1, modifNoModif, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}
									}else{
										try {theModifService.generateModifFile(keyEcoreFile, 1, modifNoModif, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
									// EraseAll is selected
								}else if(btnEraseAllSimpleMigration.getSelection()){
									modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+"K.modif";
									File eraseAll = new File(modifEraseAll);
									if(eraseAll.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+"K.modif ?");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile(keyEcoreFile, 2, modifEraseAll, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}
									}else{
										try { theModifService.generateModifFile(keyEcoreFile, 2, modifEraseAll, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
								}
								// do not need to add keys 
							}else{
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0,idx)+f.getName().substring(idx, idx+6);
								// NoModif is selected
								if(btnNoModifSimpleMigration.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+"K.modif";
									File noModif = new File(modifNoModif);
									// There is a NoModif file with the same name
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+"K.modif ?");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile(keyEcoreFile, 1, modifNoModif, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}
									}else{
										try { theModifService.generateModifFile(keyEcoreFile, 1, modifNoModif, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
									// EraseAll is selected
								}else if(btnEraseAllSimpleMigration.getSelection()){
									modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+"K.modif";
									File eraseAll = new File(modifEraseAll);
									if(eraseAll.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+"K.modif ?");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile(keyEcoreFile, 2, modifEraseAll, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}
									}else{
										try { theModifService.generateModifFile(keyEcoreFile, 2, modifEraseAll, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
								}
							}
						}
					}
				}
			}
		});


		//composite Modif

		compositeModif = new Composite(shell, SWT.BORDER);
		compositeModif.setBounds(10, 10, 680, 65);
		compositeModif.setVisible(false);

		Label lblDomainMetamodel = new Label(compositeModif, SWT.NONE);
		lblDomainMetamodel.setBounds(10, 35, 116, 15);
		lblDomainMetamodel.setText("Domain Metamodel");

		//btnCheckUML = new Button(compositeModif, SWT.CHECK);
		/*btnCheckUML.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckUML.getSelection()){
					isUML = true;
					compositeCheck.setVisible(true);
				}else{
					btnDomainMetamodel.setEnabled(true);
					txtDomainMetamodel.setEnabled(true);
					isUML = false;
					compositeCheck.setVisible(false);
				}
			}
		});
		btnCheckUML.setBounds(132, 9, 93, 16);
		btnCheckUML.setText("UML");
		btnCheckUML.setEnabled(true);
		btnCheckUML.setVisible(true);*/

		txtDomainMetamodel = new Text(compositeModif, SWT.BORDER);
		txtDomainMetamodel.setBounds(132, 33, 250, 21);

		btnDomainMetamodel = new Button(compositeModif, SWT.NONE);
		btnDomainMetamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Ecore file (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();
				if (fn != null) {
					txtDomainMetamodel.setText(fn);
					File f = new File(txtDomainMetamodel.getText());
					projectFolder = new File(f.getParent());
				}
			}
		});

		btnDomainMetamodel.setBounds(385, 31, 75, 25);
		btnDomainMetamodel.setText("Select");

		btnNoModif = new Button(compositeModif, SWT.RADIO);
		btnNoModif.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { 	}
		});
		btnNoModif.setBounds(490, 9, 75, 16);
		btnNoModif.setText("NoModif");

		btnEraseAll = new Button(compositeModif, SWT.RADIO);
		btnEraseAll.setBounds(580, 9, 90, 16);
		btnEraseAll.setText("EraseAll");

		// Modif Specification Generation

		Button btnGenerateModif = new Button(compositeModif, SWT.NONE);
		btnGenerateModif.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnGenerateModif.setBounds(480, 31, 180, 25);
		btnGenerateModif.setText("Generate Modif Specification");
		btnGenerateModif.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				if(txtDomainMetamodel.getText().equals("") && !isUML){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();	
				}else{
					if(!btnNoModif.getSelection() && !btnEraseAll.getSelection()){
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Select the modif to be generated");
						messageBox.open();	
					}
					theModifService.setFiles(null, txtDomainMetamodel.getText(), null, null, null, null, null, null, isUML);					
					EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodel.getText());
					boolean addKeys;
					boolean key;

					if(isSimpleRefactor){
						addKeys = false;
						key = false;
					}else{
						addKeys = true;
						key = true;
						for (TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();) {
							EObject next = it.next();
							if (next instanceof EClass) {
								EClass c = (EClass) next;
								for(EAttribute ea : c.getEAllAttributes()){
									if(ea.getName().equals("UUID")){
										addKeys = false;
										break;
									}
								}
							}
						}
						if(addKeys){ rootkeyPackage =  theModifService.addUUIDAttributes(); }
						else{ rootkeyPackage =  domainMM; }
						String domainMetamodelPath = txtDomainMetamodel.getText();
						File f = new File(domainMetamodelPath);
						int idx = f.getName().lastIndexOf('.');

						String modifNoModif;
						String modifEraseAll;
						File modifFolder = new File(f.getParent().replace("metamodel", "modif"));
						if(modifFolder.exists()){
							if(addKeys){
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0, idx)+"K"+f.getName().substring(idx,idx+6);
								//Create noModif file
								if(btnNoModif.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+"K.modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+"K.modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}else{ 	}
									}else{
										try { theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
									//Create eraseAll file
								}else if(btnEraseAll.getSelection()){
									modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+"K.modif";
									File eraseAll = new File(modifEraseAll);
									if(eraseAll.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+"K.modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key); } 
											catch (IOException e1) { e1.printStackTrace(); }
										}else{ 	}
									}else{
										try { theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key); } 
										catch (IOException e1) { e1.printStackTrace(); }
									}
								}
								// do not need to add keys
							}else{
								modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+".modif";
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0, idx)+f.getName().substring(idx,idx+6);
								if(btnNoModif.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+".modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+".modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try {
												theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
											} catch (IOException e1) { e1.printStackTrace(); }
										}else{ 	}
									}else{
										try {
											theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
										} catch (IOException e1) { e1.printStackTrace(); }
									}
								}else if(btnEraseAll.getSelection()){
									modifNoModif = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+".modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+".modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try {
												theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
											} catch (IOException e1) { e1.printStackTrace(); }
										}else{ 	}
									}else{
										try {
											theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
										} catch (IOException e1) { e1.printStackTrace(); }
									}
								}
							}
							// modif folder does not exist
						}else{ 
							//modif folder creation
							File dir = new File(f.getParent()+"/../modif");
							dir.mkdir();
							if(addKeys){
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0, idx)+"K"+f.getName().substring(idx,idx+6);
								//Create noModif file
								if(btnNoModif.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+"K.modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+"K.modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try {
												theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
											} catch (IOException e1) {	e1.printStackTrace(); }
										}else{ 	}
									}else{
										try {
											theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									//Create eraseAll file
								}else if(btnEraseAll.getSelection()){
									modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+"K.modif";
									File eraseAll = new File(modifEraseAll);
									if(eraseAll.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+"K.modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
											} catch (IOException e1) { 	e1.printStackTrace(); }
										}else{ 	}
									}else{
										try {
											theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
										} catch (IOException e1) { e1.printStackTrace(); }
									}
								}
							}else{
								modifEraseAll = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+".modif";
								keyEcoreFile = f.getParent()+"/"+f.getName().substring(0, idx)+f.getName().substring(idx,idx+6);
								if(btnNoModif.getSelection()){
									modifNoModif = f.getParent()+"/../modif/NoModif"+f.getName().substring(0,idx)+".modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "NoModif"+f.getName().substring(0,idx)+".modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try {
												theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}else{

										}
									}else{
										try { theModifService.generateModifFile( keyEcoreFile, 1, modifNoModif, key);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}else if(btnEraseAll.getSelection()){
									modifNoModif = f.getParent()+"/../modif/EraseAll"+f.getName().substring(0,idx)+".modif";
									File noModif = new File(modifNoModif);
									if(noModif.exists()){
										MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
										messageBox.setMessage("Do you want to rewrite "+ "EraseAll"+f.getName().substring(0,idx)+".modif ?");
										//messageBox.setText("Exiting Application");
										int response = messageBox.open();
										if (response == SWT.YES){
											try { theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}else{
										}
									}else{
										try { theModifService.generateModifFile( keyEcoreFile, 2, modifEraseAll, key);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							}
						}
					}
				}
			}
		});

		// Composite Check Simple Refactoring
		compositeCheckSimpleRefactoring = new Composite(shell,  SWT.BORDER);
		compositeCheckSimpleRefactoring.setBounds(10, 81, 680, 65);
		compositeCheckSimpleRefactoring.setVisible(false);

		Label lblModifSpecificationSimpleRefactoring = new Label(compositeCheckSimpleRefactoring, SWT.NONE);
		lblModifSpecificationSimpleRefactoring.setBounds(10, 10, 120, 15);
		lblModifSpecificationSimpleRefactoring.setText("Modif Specification");

		txtModifSpecificationSimpleRefactoring = new Text(compositeCheckSimpleRefactoring, SWT.BORDER);
		txtModifSpecificationSimpleRefactoring.setBounds(132, 7, 250, 21);

		Button btnModifSpecificationSimpleRefactoring = new Button(compositeCheckSimpleRefactoring, SWT.NONE);
		btnModifSpecificationSimpleRefactoring.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"modif file (*.modif)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.modif", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				//dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "modif"));
				String fn = dlg.open();
				if (fn != null) {
					txtModifSpecificationSimpleRefactoring.setText(fn);
				}
			}
		});
		btnModifSpecificationSimpleRefactoring.setBounds(385, 5, 75, 25);
		btnModifSpecificationSimpleRefactoring.setText("Select");

		Button btnMinimize = new Button(compositeCheckSimpleRefactoring, SWT.NONE);
		btnMinimize.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMinimize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtDomainMetamodelSimpleRefactor.getText().equals("")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select the project source folder");
					messageBox.open();
				}else if(txtModifSpecificationSimpleRefactoring.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a modif specification");
					messageBox.open();
				}else{
					theModifService.Minimize(modifFileName);
				}
			}
		});
		btnMinimize.setBounds(480, 5, 75, 25);
		btnMinimize.setText("Minimize");
		if(isUML) {
			btnMinimize.setEnabled(false);
		}else {
			btnMinimize.setEnabled(true);
		}


		Button btnRefactor = new Button(compositeCheckSimpleRefactoring, SWT.NONE);
		btnRefactor.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnRefactor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtDomainMetamodelSimpleRefactor.getText().equals("")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if(txtModifSpecificationSimpleRefactoring.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a modif specification");
					messageBox.open();
				}else{
					if(isUML) {
						theModifService.CreateModifUML();
						theModifService.Minimize(modifFileName);
						theModifService.Refactor(txtTargetMetamodelSimpleRefactoring.getText());
					}else {
						theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodelSimpleRefactor.getText(), txtModifSpecificationSimpleRefactoring.getText(), null, null, null, null, null, isUML);
						long start = System.nanoTime();
						theModifService.CreateModif(true, null);
						theModifService.Refactor();
						System.out.print("Refactoring   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
						btnMigrateSimpleMigration.setEnabled(true);
					}
				}
			}
		});
		btnRefactor.setBounds(580, 5, 75, 25);
		btnRefactor.setText("Refactor");


		Label lblTargetMetamodelSimpleRefactoring = new Label(compositeCheckSimpleRefactoring, SWT.NONE);
		lblTargetMetamodelSimpleRefactoring.setBounds(10, 35, 120, 15);
		lblTargetMetamodelSimpleRefactoring.setText("Target Metamodel");


		txtTargetMetamodelSimpleRefactoring = new Text(compositeCheckSimpleRefactoring, SWT.BORDER);
		txtTargetMetamodelSimpleRefactoring.setBounds(132, 35, 250, 21);


		btnTargetMetamodelSimpleRefactoring = new Button(compositeCheckSimpleRefactoring, SWT.NONE);
		btnTargetMetamodelSimpleRefactoring.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"ecore (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				//dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "modif"));
				String fn = dlg.open();
				if (fn != null) {
					txtTargetMetamodelSimpleRefactoring.setText(fn);
				}
			}
		});
		btnTargetMetamodelSimpleRefactoring.setBounds(385, 35, 75, 25);
		btnTargetMetamodelSimpleRefactoring.setText("Select");


		// Composite Refactor Simple Migration
		compositeRefactorSimpleMigration = new Composite(shell,  SWT.BORDER);
		compositeRefactorSimpleMigration.setBounds(10, 81, 680, 65);
		compositeRefactorSimpleMigration.setVisible(false);

		Label lblModifSpecificationSimpleMigration = new Label(compositeRefactorSimpleMigration, SWT.NONE);
		lblModifSpecificationSimpleMigration.setBounds(10, 10, 120, 15);
		lblModifSpecificationSimpleMigration.setText("Modif Specification");

		txtModifSpecificationSimpleMigration = new Text(compositeRefactorSimpleMigration, SWT.BORDER);
		txtModifSpecificationSimpleMigration.setBounds(132, 7, 250, 21);

		Button btnModifSpecificationSimpleMigration = new Button(compositeRefactorSimpleMigration, SWT.NONE);
		btnModifSpecificationSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"modif file (*.modif)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.modif", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				if(!isUML) {
					dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "modif"));
				}
				String fn = dlg.open();
				if (fn != null) {
					txtModifSpecificationSimpleMigration.setText(fn);
				}
			}
		});
		btnModifSpecificationSimpleMigration.setBounds(385, 5, 75, 25);
		btnModifSpecificationSimpleMigration.setText("Select");


		Button btnMinimizeSimpleMigration = new Button(compositeRefactorSimpleMigration, SWT.NONE);
		btnMinimizeSimpleMigration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMinimizeSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtDomainMetamodelSimpleMigration.getText().equals("")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select the project source folder");
					messageBox.open();
				}else if(txtModifSpecificationSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a modif specification");
					messageBox.open();
				}else{
					theModifService.Minimize(modifFileName);
				}
			}
		});
		btnMinimizeSimpleMigration.setBounds(480, 5, 75, 25);
		btnMinimizeSimpleMigration.setText("Minimize");
		if(isUML) {
			btnMinimizeSimpleMigration.setEnabled(false);
		}else {
			btnMinimizeSimpleMigration.setEnabled(true);
		}

		Button btnRefactorSimpleMigration = new Button(compositeRefactorSimpleMigration, SWT.NONE);
		btnRefactorSimpleMigration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnRefactorSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
				if (txtDomainMetamodelSimpleMigration.getText().equals("")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if(txtModifSpecificationSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a modif specification");
					messageBox.open();
				}else{
					if(isUML) {
						theModifService.CreateModifUML();
						theModifService.Minimize(modifFileName);
						refactoredMetamodelPath = theModifService.Refactor(txtTargetMetamodelSimpleMigration.getText());
					}else {
						theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, null, null, null, null, isUML);
						long start = System.nanoTime();
						theModifService.CreateModif(false, txtDomainMetamodelSimpleMigration.getText());
						hideClasses = theModifService.getHideClassList();
						flattenClasses = theModifService.getFlattenClassList();
						EPackage refactoredWithoutK = theModifService.RefactorSimpleMigration();
						packageWithoutKName = refactoredWithoutK.getName();
						refactoredWithoutKFileName = theModifService.getRefactoredWithoutKFileName();
						System.out.print("Refactoring   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
					}
				}
			}
		});
		btnRefactorSimpleMigration.setBounds(580, 5, 75, 25);
		btnRefactorSimpleMigration.setText("Refactor");


		Label lblTargetMetamodelSimpleMigration = new Label(compositeRefactorSimpleMigration, SWT.NONE);
		lblTargetMetamodelSimpleMigration.setBounds(10, 35, 120, 15);
		lblTargetMetamodelSimpleMigration.setText("Target Metamodel");

		txtTargetMetamodelSimpleMigration = new Text(compositeRefactorSimpleMigration, SWT.BORDER);
		txtTargetMetamodelSimpleMigration.setBounds(132, 35, 250, 21);


		btnTargetMetamodelSimpleMigration = new Button(compositeRefactorSimpleMigration, SWT.NONE);
		btnTargetMetamodelSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"ecore (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				//dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "modif"));
				String fn = dlg.open();
				if (fn != null) {
					txtTargetMetamodelSimpleMigration.setText(fn);
				}
			}
		});
		btnTargetMetamodelSimpleMigration.setBounds(385, 35, 75, 25);
		btnTargetMetamodelSimpleMigration.setText("Select");


		// composite Check

		compositeCheck = new Composite(shell, SWT.BORDER);
		compositeCheck.setBounds(10, 81, 680, 65);
		compositeCheck.setVisible(false);

		Label lblModifSpecification = new Label(compositeCheck, SWT.NONE);
		lblModifSpecification.setBounds(10, 10, 120, 15);
		lblModifSpecification.setText("Modif Specification");

		txtModifSpecification = new Text(compositeCheck, SWT.BORDER);
		txtModifSpecification.setBounds(132, 7, 250, 21);

		Button btnModifSpecification = new Button(compositeCheck, SWT.NONE);
		btnModifSpecification.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Modif file (*.modif)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.modif", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "modif"));
				String fn = dlg.open();
				if (fn != null) {
					txtModifSpecification.setText(fn);
				}
			}
		});
		btnModifSpecification.setBounds(385, 5, 75, 25);
		btnModifSpecification.setText("Select");

		Button btnCheck = new Button(compositeCheck, SWT.NONE);
		btnCheck.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCheck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtDomainMetamodel.getText().equals("")) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if(txtModifSpecification.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a modif specification");
					messageBox.open();
				}else if(txtToolMetamodel.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
					messageBox.setMessage("Is it an intermediate metamodel?");
					int response = messageBox.open();
					if (response == SWT.YES){
						theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodel.getText(), txtModifSpecification.getText(), txtToolMetamodel.getText(), null, null, null, null, isUML);
						long start = System.nanoTime();
						theModifService.CreateModif();
						theModifService.Refactor();
						System.out.print("Refactoring   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
					}else{
						MessageBox messageBox2 = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox2.setMessage("Select a tool metamodel");
						messageBox2.open();
					}
				}else{
					theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodel.getText(), txtModifSpecification.getText(), txtToolMetamodel.getText(), null, null, null, null, isUML);
					long start = System.nanoTime();
					theModifService.CreateModif();
					theModifService.Refactor();
					boolean check = theModifService.Compare();
					if(check == true){
					}else{
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Refactored metamodel does not fully matches with Tool metamodel");
						messageBox.open();
					}
					System.out.print("Refactoring   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
				}
			}
		});
		btnCheck.setBounds(530, 35, 75, 25);
		btnCheck.setText("Check");

		Label lblToolMetamodel = new Label(compositeCheck, SWT.NONE);
		lblToolMetamodel.setBounds(10, 35, 120, 15);
		lblToolMetamodel.setText("Tool Metamodel");

		txtToolMetamodel = new Text(compositeCheck, SWT.BORDER);
		txtToolMetamodel.setBounds(132, 34, 250, 21);

		Button btnToolMetamodel = new Button(compositeCheck, SWT.NONE);
		btnToolMetamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Ecore file (*.ecore)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.ecore", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();
				if (fn != null) {
					txtToolMetamodel.setText(fn);
				}
			}
		});
		btnToolMetamodel.setBounds(385, 31, 75, 25);
		btnToolMetamodel.setText("Select");

		// composite Migration

		compositeMigration = new Composite(shell, SWT.BORDER);
		compositeMigration.setBounds(10, 152, 680, 65);
		compositeMigration.setVisible(false);

		Label lblTool = new Label(compositeMigration, SWT.NONE);
		lblTool.setBounds(10, 10, 75, 15);
		lblTool.setText("RootClass");

		txtTool = new Text(compositeMigration, SWT.BORDER);
		txtTool.setBounds(132, 7, 250, 21);

		Label lblFunction = new Label(compositeMigration, SWT.NONE);
		lblFunction.setBounds(10, 35, 55, 15);
		lblFunction.setText("Function");

		txtFunction = new Text(compositeMigration, SWT.BORDER);
		txtFunction.setBounds(132, 34, 250, 21);

		Button btnTool = new Button(compositeMigration, SWT.NONE);
		btnTool.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Java file (*.java)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.java", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();
				if (fn != null) {
					txtTool.setText(fn);
				}
			}
		});
		btnTool.setBounds(385, 5, 75, 25);
		btnTool.setText("Select");

		// composite Reuse

		compositeReuse = new Composite(shell, SWT.BORDER);
		compositeReuse.setBounds(10, 223, 680, 114);
		compositeReuse.setVisible(false);

		Label lblDomainModel = new Label(compositeReuse, SWT.NONE);
		lblDomainModel.setBounds(10, 5, 95, 15);
		lblDomainModel.setText("Domain Model");

		Button btnDomainModel = new Button(compositeReuse, SWT.NONE);
		btnDomainModel.setBounds(385, 0, 75, 25);
		btnDomainModel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"XMI file (*.xmi)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.xmi", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "model"));
				String fn = dlg.open();
				if (fn != null) {
					txtDomainModel.setText(fn);
				}
			}
		});
		btnDomainModel.setText("Select");

		txtDomainModel = new Text(compositeReuse, SWT.BORDER);
		txtDomainModel.setBounds(132, 6, 250, 21);


		Button btnMigrationSpecificationGeneration = new Button(compositeReuse, SWT.NONE);
		btnMigrationSpecificationGeneration.setBounds(480, 0, 192, 25);
		btnMigrationSpecificationGeneration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMigrationSpecificationGeneration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtDomainMetamodel.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if (txtDomainModel.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain model");
					messageBox.open();
				}else{
					try{
						// Add UUID Value
						theModifService.setFiles(projectFolder.getAbsolutePath().replace("metamodel", ""), txtDomainMetamodel.getText(), txtModifSpecification.getText(), null, txtDomainModel.getText(), null, null, null, isUML);
						EPackage originalPackage = UtilEMF.loadMetamodel(txtDomainMetamodel.getText());
						boolean hasUUID = UtilEMF.hasUUIDAttribute(originalPackage);
						String keyModelFileName;
						if(hasUUID){
							keyModelFileName = txtDomainModel.getText();

						}else{
							keyModelFileName = theModifService.addUUIDValues(rootkeyPackage);
						}
						// Generate Migration Specification
						migratedFileName = theModifService.GenerateMigrationSpecification(txtDomainModel.getText(), keyModelFileName, null, null);
						btnMigrationSpecificationEdition.setEnabled(true);
					}catch (Exception e1){
						e1.printStackTrace();
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Fatal error (see console for details)");
						messageBox.open();
					}
				}
			}
		});
		btnMigrationSpecificationGeneration.setText("Generate Migration Specification");


		Label lblMigrationSpecification = new Label(compositeReuse, SWT.NONE);
		lblMigrationSpecification.setBounds(10, 30, 123, 15);
		lblMigrationSpecification.setText("Migration Specification");

		txtMigrationSpecification = new Text(compositeReuse, SWT.BORDER);
		txtMigrationSpecification.setBounds(133, 32, 249, 21);

		Button btnMigrationSpecification = new Button(compositeReuse, SWT.NONE);
		btnMigrationSpecification.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"Migration file (*.xmi)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.xmi", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "migration"));
				String fn = dlg.open();
				if (fn != null) {
					txtMigrationSpecification.setText(fn);
				}
			}
		});
		btnMigrationSpecification.setBounds(385, 30, 75, 25);
		btnMigrationSpecification.setText("Select");


		btnMigrationSpecificationEdition = new Button(compositeReuse, SWT.NONE);
		btnMigrationSpecificationEdition.setBounds(485, 30, 179, 25);
		btnMigrationSpecificationEdition.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMigrationSpecificationEdition.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMigrationSpecificationEdition.setText("Migration Specification Edition");

		Button btnGenerateCode = new Button(compositeReuse, SWT.NONE);
		btnGenerateCode.setBounds(65, 79, 172, 25);
		btnGenerateCode.setText("Generate Reuse Code");
		btnGenerateCode.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnGenerateCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// Migration
				theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodel.getText(), txtModifSpecification.getText(), txtToolMetamodel.getText(), txtDomainModel.getText(), txtMigrationSpecification.getText(), null, null, isUML);

				long start = System.nanoTime();
				migrt = theModifService.Migration(null, null);
				System.out.print("Migration   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");

				// Code generation
				MigrationGenerator migrationgenerator = new MigrationGenerator(projectFolder.getAbsolutePath(), txtTool.getText(), txtFunction.getText(), migratedFileName, txtToolMetamodel.getText());
				processedModel = migrationgenerator.getProcessedModelName();
				graphModel = migrationgenerator.getGraphModelName();
			}
		});

		Button btnReuse_1 = new Button(compositeReuse, SWT.NONE);
		btnReuse_1.setBounds(300, 79, 75, 25);
		btnReuse_1.setText("Reuse");
		btnReuse_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnReuse_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtMigrationSpecification.getText().equals("")){

				}else{					
					//Reuse
					// execute manually 

					//Reverse Migration
					System.out.println("************************** Reverse  *********************");
					theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodel.getText(), txtModifSpecification.getText(), txtToolMetamodel.getText(), txtDomainModel.getText(), txtMigrationSpecification.getText(), processedModel, null, isUML);
					long start2 = System.nanoTime();
					migrt = theModifService.ReverseMigration(migrt);
					System.out.print("Reverse Migration   Ok ("+(System.nanoTime()-start2)/1000000.0+" ms).");

					// Recontextualisation
					theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodel.getText(), txtModifSpecification.getText(), txtToolMetamodel.getText(), txtDomainModel.getText(), txtMigrationSpecification.getText(), processedModel, graphModel, isUML);
					long start3 = System.nanoTime();
					System.out.println("************************** Recontextualization  *********************");
					theModifService.Recontextualization(migrt);
					System.out.print("Recontextualization   Ok ("+(System.nanoTime()-start3)/1000000.0+" ms).");

					// Final model
					String recontexGraphFileName = theModifService.getRecontexGraphFileName();
					EPackage toolMM = UtilEMF.loadMetamodel(txtToolMetamodel.getText());
					//EObject recontextGraphModel = UtilEMF.loadModel(recontexGraphFileName, toolMM);
					theModifService.removeUUIDValue();
				}
			}
		});

		Button btnClose = new Button(compositeReuse, SWT.NONE);

		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		//btnClose.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnClose.setBounds(420, 79, 75, 25);
		btnClose.setText("Close");

		// composite migration simple migration

		compositeMigrationSimpleMigration = new Composite(shell, SWT.BORDER);
		compositeMigrationSimpleMigration.setBounds(10, 152, 680, 114);
		compositeMigrationSimpleMigration.setVisible(false);

		Label lblDomainModelSimpleMigration = new Label(compositeMigrationSimpleMigration, SWT.NONE);
		lblDomainModelSimpleMigration.setBounds(10, 7, 95, 15);
		lblDomainModelSimpleMigration.setText("Domain Model");

		Button btnDomainModelSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.NONE);
		btnDomainModelSimpleMigration.setBounds(385, 2, 75, 25);
		btnDomainModelSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final String[] FILTER_NAMES = {"XMI file (*.xmi)", "All Files (*.*)"};
				final String[] FILTER_EXTS =  { "*.xmi", "*.*"};
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFilterPath(projectFolder.getAbsolutePath().replace("metamodel", "model"));
				String fn = dlg.open();
				if (fn != null) {
					txtDomainModelSimpleMigration.setText(fn);
				}
			}
		});
		btnDomainModelSimpleMigration.setText("Select");

		txtDomainModelSimpleMigration = new Text(compositeMigrationSimpleMigration, SWT.BORDER);
		txtDomainModelSimpleMigration.setBounds(132, 8, 250, 21);

		btnAutomaticSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.RADIO);
		btnAutomaticSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnAutomaticSimpleMigration.setBounds(500, 9, 75, 16);
		btnAutomaticSimpleMigration.setText("Automatic");

		btnCustomSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.RADIO);
		btnCustomSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btnCustomSimpleMigration.setBounds(580, 9, 90, 16);
		btnCustomSimpleMigration.setText("Custom");

		Button btnGenerateMigrationCode = new Button(compositeMigrationSimpleMigration, SWT.NONE);
		btnGenerateMigrationCode.setBounds(470, 28, 100, 25);
		btnGenerateMigrationCode.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnGenerateMigrationCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					theModifService.Migrating(txtDomainMetamodelSimpleMigration.getText(), txtDomainModelSimpleMigration.getText(), refactoredMetamodelPath, true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});		
		btnGenerateMigrationCode.setText("Generate Code");
		
		
		btnMigrateSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.NONE);
		btnMigrateSimpleMigration.setBounds(580, 28, 75, 25);
		//btnMigrateSimpleMigration.setEnabled(false);
		btnMigrateSimpleMigration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMigrateSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtDomainMetamodelSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if (txtDomainModelSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain model");
					messageBox.open();
				}else{
					final Map<String, String> newReferencesNameHide = theModifService.getNewReferencesNameMap();
					final Map<String, Map<String, Map<String, String>>> renameMap;
					if(!btnAutomaticSimpleMigration.getSelection() && !btnCustomSimpleMigration.getSelection()){
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Select the way to migrate the model");
						messageBox.open();	
					}else{
						String migrationSpecification = null;
						// Add UUID Value
						theModifService.setFiles(projectFolder.getAbsolutePath().replace("metamodel", ""), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, txtDomainModelSimpleMigration.getText(), null, null, null, isUML);
						EPackage originalPackage = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleMigration.getText());
						boolean hasUUID = UtilEMF.hasUUIDAttribute(originalPackage);

						System.out.println(" // hasUUID "+ hasUUID);
						String keyModelFileName;
						if(hasUUID){
							keyModelFileName = txtDomainModelSimpleMigration.getText();
							System.out.println("  ++  keyModelFileName  "+keyModelFileName);
						}else{
							if(rootkeyPackage == null){
								EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleMigration.getText());
								boolean addKeys = true;
								// verifying if keys were already added
								for(TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();){
									EObject next = it.next();
									if(next instanceof EClass){
										EClass c = (EClass) next;
										for(EAttribute ea : c.getEAllAttributes()){
											if(ea.getName().equals("UUID")){
												addKeys = false;
												break;
											}
										}
									}
								}
								// adding keys
								if(addKeys){ rootkeyPackage = theModifService.addUUIDAttributes(); }
								else{ rootkeyPackage = domainMM; }
							}
							keyModelFileName = theModifService.addUUIDValues(rootkeyPackage);
							System.out.println("  -- keyModelFileName  "+keyModelFileName);
						}
						// Generate Migration Specification
						try {
							migratedFileName = theModifService.GenerateMigrationSpecification(txtDomainModelSimpleMigration.getText(), keyModelFileName, hideClasses, flattenClasses);
							Map<String, ArrayList<String>> referencesToInstanceMap = theModifService.buildMapReferencesToInstance(rootkeyPackage);
							//System.out.println("refToInstance  : "+referencesToInstanceMap);
						} catch (IOException e2) { e2.printStackTrace(); }
						migrationSpecification = theModifService.getMigrationFileName();
						//newReferencesNameHide = theModifService.getNewReferencesNameMap();
						renameMap = theModifService.getRenameMap();
						// Migration

						/*	long start = System.nanoTime();
							migrt = theModifService.Migration(newReferencesNameHide, renameMap);
							// TODO : Message rewrite migrated file
							//File migration = new File(theModifService.getMigratedModelFileName());

							System.out.print("Migration   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
							// UUID value deletion
							theModifService.removeUUIDSimpleMigration(migratedFileName, refactoredWithoutKFileName, packageWithoutKName);*/

						if(btnAutomaticSimpleMigration.getSelection()){
							theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, txtDomainModelSimpleMigration.getText(), migrationSpecification, null, null, isUML);
							//theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, txtDomainModelSimpleMigration.getText(), "C:/ModifProject/Test_Vehicles/migration/vehiclestocarsK.migration2.xmi", null, null, isUML);
							long start = System.nanoTime();
							migrt = theModifService.Migration(newReferencesNameHide, renameMap);
							// TODO : Message rewrite migrated file
							File migration = new File(theModifService.getMigratedModelFileName());
							System.out.print("Migration   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
							// UUID value deletion
							try {
								theModifService.removeUUIDSimpleMigration(migratedFileName, refactoredWithoutKFileName, packageWithoutKName);
							} catch (IOException e1) {
								e1.printStackTrace();
								MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
								messageBox.setMessage("Fatal error (see console for details)");
								messageBox.open();
							}
						}else if (btnCustomSimpleMigration.getSelection()){
							final String migrationSpecificationName;
							final Migration migration;

							final ArrayList<String> strs = new ArrayList<String>();
							//migrationSpecificationName = "C:/ModifProject/Test_Vehicles/migration/vehiclestocarsK.migration.xmi";
							migrationSpecificationName = migrationSpecification;
							migration = (Migration) UtilEMF.loadModel(migrationSpecificationName, MigrationPackage.eINSTANCE);
							for(EObject instance : migration.eContents()){
								String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
								for(EObject deletion : instance.eContents()){
									boolean deleteinstance = (boolean) deletion.eGet(deletion.eClass().getEStructuralFeature("deleteInstance"));
									if(!deleteinstance){ strs.add(instanceuuid); }
								}
							}

							final CheckableItem[] data = createData(strs);
							final JList list = new JList(data);

							list.setCellRenderer(new CheckListRenderer());
							list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							list.setBorder(new EmptyBorder(0, 4, 0, 0));
							list.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {
									int index = list.locationToIndex(e.getPoint());
									CheckableItem item = (CheckableItem) list.getModel()
											.getElementAt(index);
									item.setSelected(!item.isSelected());
									Rectangle rect = list.getCellBounds(index, index);
									list.repaint(rect);
								}
							});
							JScrollPane sp = new JScrollPane(list);
							JButton validateButton = new JButton("Validate");
							validateButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									ListModel model = list.getModel();
									int n = model.getSize();
									for (int i = 0; i < n; i++) {
										CheckableItem item = (CheckableItem) model.getElementAt(i);
										// modify the migration specification
										Migration newMigration = theModifService.modifyInstance(strs.get(i), item.isSelected, migration);
										theModifService.addDeletedReferences(newMigration);
										theModifService.cleanMigrationSpecification(migration);
										// Save a new migration specification (the custom one)
										String customMigrationSpecificationName = migrationSpecificationName.replace(".migration", "Customized.migration");
										try {
											UtilEMF.saveModel((EObject)migration,customMigrationSpecificationName);
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										// validate the result by applying the new migration specification
										//TODO
										if(isValidMigration()){
											migrt = theModifService.Migration(newReferencesNameHide, renameMap, customMigrationSpecificationName);
											try {
												theModifService.removeUUIDSimpleMigration(migratedFileName, refactoredWithoutKFileName, packageWithoutKName);
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								}
							});
							JButton resetButton = new JButton("Reset");
							resetButton.setSize(20, 40);
							resetButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									//textArea.setText("");
									resetData(strs.size(), data);
									Rectangle rect = list.getCellBounds(0, strs.size()-1);
									list.repaint(rect);
								}
							});

							JPanel panelButton = new JPanel(new GridLayout(1, 2));
							//panel.add(panel0);
							panelButton.add(validateButton);
							panelButton.add(resetButton);
							JDialog dialog = new JDialog();
							dialog.setTitle("Check to delete instance");
							JPanel contentPanel = new JPanel(new GridLayout(2, 1));
							contentPanel.add(sp);
							JPanel emptypanel1 = new JPanel();
							contentPanel.add(emptypanel1);
							emptypanel1.setLayout(new GridLayout(2, 1));
							JPanel emptypanel2 = new JPanel();
							emptypanel1.add(emptypanel2);
							emptypanel1.add(panelButton);
							contentPanel.add(emptypanel1);
							dialog.add(contentPanel);
							dialog.pack();
							dialog.setVisible(true);
						}
					}
				}
			}
		});
		btnMigrateSimpleMigration.setText("Migrate");

		/*btnMigrationEditionSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.NONE);
		btnMigrationEditionSimpleMigration.setBounds(600, 2, 90, 25);
		btnMigrationEditionSimpleMigration.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnMigrationEditionSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtDomainMetamodelSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain metamodel");
					messageBox.open();
				}else if (txtDomainModelSimpleMigration.getText().equals("")){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
					messageBox.setMessage("Select a domain model");
					messageBox.open();
				}else{
					try{
						// Add UUID Value
						theModifService.setFiles(projectFolder.getAbsolutePath().replace("metamodel", ""), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, txtDomainModelSimpleMigration.getText(), null, null, null, isUML);
						EPackage originalPackage = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleMigration.getText());
						boolean hasUUID = UtilEMF.hasUUIDAttribute(originalPackage);
						String keyModelFileName;
						if(hasUUID){
							keyModelFileName = txtDomainModelSimpleMigration.getText();
						}else{
							if(rootkeyPackage == null){
								EPackage domainMM = UtilEMF.loadMetamodel(txtDomainMetamodelSimpleMigration.getText());
								boolean addKeys = true;
								// verifying if keys were already added
								for(TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();){
									EObject next = it.next();
									if(next instanceof EClass){
										EClass c = (EClass) next;
										for(EAttribute ea : c.getEAllAttributes()){
											if(ea.getName().equals("UUID")){
												addKeys = false;
												break;
											}
										}
									}
								}
								// adding keys
								if(addKeys){ rootkeyPackage = theModifService.addUUIDAttributes(); }
								else{ rootkeyPackage = domainMM; }
							}
							keyModelFileName = theModifService.addUUIDValues(rootkeyPackage);
						}
						// Generate Migration Specification
						migratedFileName = theModifService.GenerateMigrationSpecification(txtDomainModelSimpleMigration.getText(), keyModelFileName, hideClasses, flattenClasses);
						String migrationSpecification = theModifService.getMigrationFileName();

						Map<String, String> newReferencesNameHide = theModifService.getNewReferencesNameMap();
						Map<String, Map<String, Map<String, String>>> renameMap = theModifService.getRenameMap();

						// Migration
						theModifService.setFiles(projectFolder.getAbsolutePath(), txtDomainMetamodelSimpleMigration.getText(), txtModifSpecificationSimpleMigration.getText(), null, txtDomainModelSimpleMigration.getText(), migrationSpecification, null, null, isUML);
						long start = System.nanoTime();
						migrt = theModifService.Migration(newReferencesNameHide, renameMap);


						// TODO : Message rewrite migrated file
						//File migration = new File(theModifService.getMigratedModelFileName());

						System.out.print("Migration   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
						// UUID value deletion
						theModifService.removeUUIDSimpleMigration(migratedFileName, refactoredWithoutKFileName, packageWithoutKName);
					}catch (Exception e1){
						e1.printStackTrace();
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
						messageBox.setMessage("Fatal error (see console for details)");
						messageBox.open();
					}
				}
			}
		});
		btnMigrationEditionSimpleMigration.setText("Migration Edition");*/


		Button btnCloseSimpleMigration = new Button(compositeMigrationSimpleMigration, SWT.NONE);
		btnCloseSimpleMigration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
				messageBox.setMessage("Do you want to close this form ?");
				int response = messageBox.open();
				if (response == SWT.YES){
					shell.dispose();
				}
			}
		});
		//btnClose.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCloseSimpleMigration.setBounds(420, 79, 75, 25);
		btnCloseSimpleMigration.setText("Close");
	}

	private CheckableItem[] createData(String[] strs) {
		int n = strs.length;
		CheckableItem[] items = new CheckableItem[n];
		for (int i = 0; i < n; i++) { items[i] = new CheckableItem(strs[i]); }
		return items;
	}

	private CheckableItem[] createData(ArrayList<String> strs) {
		int n = strs.size();
		CheckableItem[] items = new CheckableItem[n];   
		for (int i = 0; i < n; i++) { items[i] = new CheckableItem(strs.get(i)); }
		return items;
	}

	private CheckableItem[] resetData(int n, CheckableItem[] items) {
		for (int i = 0; i < n; i++) { items[i].setSelected(false); }
		return items;
	}

	class CheckableItem {
		private String str;
		private boolean isSelected;

		public CheckableItem(String str) {
			this.str = str;
			isSelected = false;
		}

		public void setSelected(boolean b) {
			isSelected = b;
		}

		public boolean isSelected() {
			return isSelected;
		}

		public String toString() {
			return str;
		}
	}

	class CheckListRenderer extends JCheckBox implements ListCellRenderer {
		public CheckListRenderer() {
			setBackground(UIManager.getColor("List.textBackground"));
			setForeground(UIManager.getColor("List.textForeground"));
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus) {
			setEnabled(list.isEnabled());
			setSelected(((CheckableItem) value).isSelected());
			setFont(list.getFont());
			setText(value.toString());
			return this;
		}
	}

	/**
	 * TODO : EMF diagnostician
	 * @return
	 */
	public boolean isValidMigration(){
		return true;
	}
}

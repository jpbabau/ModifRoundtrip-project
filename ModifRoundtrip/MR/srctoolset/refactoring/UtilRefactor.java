package refactoring;

import org.eclipse.emf.ecore.EPackage;

import modif.Modifications;

public class UtilRefactor<SS> {
	
	// PRIVATE **********************************************************************************
	
	private static EPackage sourceMetamodel;
	private static Modifications modifSpecification;
	private EPackage targetMetamodel;
	

	// PUBLIC **********************************************************************************

	public static void setSourceMetamodel() {
		
	}
	
	public EPackage getTargetMetamodel() {
		return null;
	}
	
	public static void setModifSpecification() {
		
	}
	
	
	public static boolean CheckModifEcoreCompatibility() {
		boolean compatible = false;
		String URI = sourceMetamodel.getNsURI();
		String modifURI = modifSpecification.getRootPackageModification().getOldURIName();
		String prefix = sourceMetamodel.getNsPrefix();
		String modiPrefix = modifSpecification.getRootPackageModification().getOldPrefixName();
		String name = sourceMetamodel.getNsURI();
		String modifName = modifSpecification.getRootPackageModification().getOldName();
		
		if(URI.equals(modifURI) && prefix.equals(modiPrefix) && name.equals(modifName)) {
			compatible = true;
		}
		return compatible;
	}
	
	
	public static void Refactor() {
		
	}
	
	
}

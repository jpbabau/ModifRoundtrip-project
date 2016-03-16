
package xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XModifStandaloneSetup extends XModifStandaloneSetupGenerated{

	public static void doSetup() {
		new XModifStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


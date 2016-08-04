package reuse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
public class Reuse_flatten {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file = new File("C:/ModifRoundtrip-project/workspaceMR/Flattener/bin/tool/flattenerService.class");
		try {
			FileInputStream streamTemp1 = new FileInputStream(file);
			FileChannel channel1 = streamTemp1.getChannel();
			File dir = new File("C:/ModifRoundtrip-project/workspaceMR/DemoCoffeeMaker//bin/tool");
			dir.mkdir();
			File tempFile2 = new File("C:/ModifRoundtrip-project/workspaceMR/DemoCoffeeMaker/bin/tool/flattenerService.class");
			FileOutputStream outputStream = new FileOutputStream(tempFile2);
			FileChannel channel2 = outputStream.getChannel();
			try { channel1.transferTo(0, file.length(), channel2); } 
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		Class classToLoad = Class.forName("tool.flattenerService");
		Method[] methods = classToLoad.getMethods();
		for(Method m : methods){
			if(m.getName().equals("flatten")){
				String[] argsMeth = {"C:/ModifRoundtrip-project/workspaceMR/Flattener",
						"C:/ModifRoundtrip-project/workspaceMR/Flattener/metamodel/hfsm.ecore",
						"C:/ModifRoundtrip-project/workspaceMR/DemoCoffeeMaker/model/CoffeeMakerModel_migrated.xmi",
						"C:/ModifRoundtrip-project/workspaceMR/DemoCoffeeMaker/model/CoffeeMakerModel_flatten.xmi",
						"C:/ModifRoundtrip-project/workspaceMR/DemoCoffeeMaker/graph/CoffeeMaker_flatten.dependency.xmi"};
				m.invoke(null, argsMeth);
			}
		}
	}
}

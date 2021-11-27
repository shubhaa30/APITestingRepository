package apitesting.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataUtilities {
	
	public static String readJSON(String inputFile) throws IOException {
		Path path = Paths.get(System.getProperty("user.dir")+"/src/test/java/apitesting/testData/"+inputFile+".json");
		byte[] bytes = Files.readAllBytes(path);
		
		return new String(bytes, StandardCharsets.UTF_8);
	}

}

package apitesting.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apitesting.utilities.BasicUtilities;

public class GetDataAPI {
private String token = null;
	
	@BeforeMethod
	public void getToken() {
		try {
			token = BasicUtilities.getApiToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC11() {
		
		System.out.println("addDataAPI token: " +token);
	}

}

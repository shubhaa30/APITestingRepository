package apitesting.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apitesting.utilities.BasicUtilities;
import io.restassured.response.Response;

public class LoginAPI {
	private Response loginResponse = null;
	
	@BeforeMethod
	public void intializeTestCase() {
		try {
			loginResponse = BasicUtilities.attemptLogin();
		} catch (IOException e) {
			System.out.println("Unable to login "+e.getMessage());
		}
	}
	
	@Test
	public void TC1() {
		loginResponse.then().assertThat().statusCode(201).extract().response();
		try {
			System.out.println("response is " + BasicUtilities.getApiToken());
		} catch (IOException e) {
			System.out.println("Unable to execute TC1");
		}
	}

}

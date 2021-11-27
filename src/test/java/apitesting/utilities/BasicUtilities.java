package apitesting.utilities;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class BasicUtilities {

	private static String apiToken = null;

	public static String getApiToken() throws IOException {
		if (null == apiToken) {
			setApiToken(generateAPIToken());
		}
		return apiToken;
	}

	public static void setApiToken(String apiToken) {
		BasicUtilities.apiToken = apiToken;
	}
	
	private static String generateAPIToken() throws IOException {
		Response response = attemptLogin();
		return retrieveJsonValue(response, "token[0]");
	}
	
	public static Response attemptLogin() throws IOException {
		
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.when().body(DataUtilities.readJSON("login")).post();
		
		setApiToken(retrieveJsonValue(response, "token[0]"));
		
		return response;
	}
	
	public static String retrieveJsonValue(Response response, String key) {
		
		return response.jsonPath().getString(key);
		
	}
}

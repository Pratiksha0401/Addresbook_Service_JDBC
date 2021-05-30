package Addressbook_RestAPI;

import static io.restassured.RestAssured.*;

import org.junit.*;

public class RestAPI_JSONServerTests {
	
	@Test
	public void givenemployeeDataInJSONServer_WhenRetrieved_ShouldMatchTheCount()
	{
		given().
			get("http://localhost:3000/Contacts").
		then().
			statusCode(200). 
			log().all();
	}
	
}

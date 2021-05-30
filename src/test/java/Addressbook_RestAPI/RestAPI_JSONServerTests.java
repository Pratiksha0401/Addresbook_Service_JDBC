package Addressbook_RestAPI;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
//import org.junit.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

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
	
	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost() {
		return new Object[][] {
			{"Mark","Smith","WestVilla","Kentucky","NewStates","9000056102","mark123@gmail.com"},
			{"Sam","Sam","OxfordRoad","Vegas","LasVegas","990156102","sam@outlook.com"}
		};	
	}
	
	@Test(dataProvider = "dataForPost")
	public void addMultipleRecords_shouldReturn_201statusCode(String firstName, String lastName, String address, String city, String state, String phoneNumber ,String emailId) {
		JSONObject request = new JSONObject();
		
		request.put("FirstName", firstName);
		request.put("LastName",  lastName);
		request.put("Address", address);
		request.put("City", city);
		request.put("State", state);
		request.put("PhoneNumber", phoneNumber);
		request.put("EmailId", emailId);
		
		baseURI ="http://localhost";
		port = 3000;
		
		given().
		       contentType(ContentType.JSON).
		       accept(ContentType.JSON).
		       header("Content-Type", "application/json").
		       body(request.toJSONString()).
		when().
		      post("/Contacts").
		then().
		      statusCode(201).
		      log().all();
	}
	
	//run with junit as well
	@Test
	public void addSingleRecords_shouldReturn_201statusCode() {
		JSONObject request = new JSONObject();
		
		request.put("FirstName", "Nikhita");
		request.put("LastName",  "Pardhi");
		request.put("Address", "Tilak Nagar");
		request.put("City","Nagpur");
		request.put("State", "MH");
		request.put("PhoneNumber", "13254678");
		request.put("EmailId", "nikita@rediffmail.com");
		
		baseURI ="http://localhost";
		port = 3000;
		
		given().
		       contentType(ContentType.JSON).
		       accept(ContentType.JSON).
		       header("Content-Type", "application/json").
		       body(request.toJSONString()).
		when().
		      post("/Contacts").
		then().
		      statusCode(201).
		      log().all();
	}
}

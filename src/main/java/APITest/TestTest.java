package APITest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payloads.PetStorePayloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestTest {
	
	@Test(dataProvider="MyData")
	public void AddAPIMEthod(String id,String Name,String Status)
	{
RestAssured.baseURI="https://petstore.swagger.io";
		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
				body(PetStorePayloads.AddPetApiPayload(id, Name,Status)). 
				when().post("/v2/pet"). 
				then().log().all().assertThat().statusCode(200).extract().response().asString();
  
	
	System.out.println(AddPetResponse);
	
	JsonPath path=new JsonPath(AddPetResponse);
	
	System.out.println(path.get("id"));
		
		
		
	}
	
	
	@DataProvider(name="MyData")
	public Object[][] getData()
	{
		
		 return new Object[][] {{"100","Java","available"},{"200","Spring","Sold"}};
	}

}

package APITest;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import Payloads.PetStorePayloads;

public class Basic {
	
	public static void main(String args[]) throws Throwable
	{
		
RestAssured.baseURI="https://petstore.swagger.io";
		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
				body( new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\RESTAssuredBasicConcept\\src\\main\\java\\APiPayloadWithExternalFile\\AddPayload.json")))). 
				when().post("/v2/pet"). 
				then().log().all().assertThat().statusCode(200).extract().response().asString();
  
	
	System.out.println(AddPetResponse);
	
	JsonPath path=new JsonPath(AddPetResponse);
	
	
	System.out.println(path.get("id"));
	
	
		
	
	}
	
	//body( new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\RESTAssuredBasicConcept\\src\\main\\java\\APiPayloadWithExternalFile\\AddPayload.json")))

	// readAllByte read the data fromn the  file in byte and new SString will convert it into String 
}

package APiPayloadWithExternalFile;

import static io.restassured.RestAssured.given;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class APIPayloadWithExternalJsonFile {

	public static void main(String[] args) throws Throwable {
		
RestAssured.baseURI="https://petstore.swagger.io";
		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
				body( new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\RESTAssuredBasicConcept\\src\\main\\java\\APiPayloadWithExternalFile\\AddPayload.json")))). 
				when().post("/v2/pet"). 
				then().log().all().assertThat().statusCode(200).extract().response().asString();
  
	
	
	
	     JsonPath path=new JsonPath(AddPetResponse);
	
	     System.out.println(AddPetResponse);
	
	
	     System.out.println(path.get("id"));
	     System.out.println(path.get("name"));
	
	
		
	
	}

}

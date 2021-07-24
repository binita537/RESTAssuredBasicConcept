package RequestAndResponseSpecBuilder;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.io.PrintStream;

import Payloads.PetStorePayloads;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqAndResSpecBuilder { 
	
	
	
	
static RequestSpecification requestspacification;
static ResponseSpecification responsespacification;

	public static void main(String[] args) throws Throwable {
		
		
		
		
		
		
        RestAssured.baseURI="https://petstore.swagger.io";		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().spec(ReqAndResSpecBuilder.createRequestSpecification()).
				body(PetStorePayloads.AddPetApiPayload("1234567890", "bb","available")). 
				when().post("/v2/pet"). 
				then().spec(ReqAndResSpecBuilder.createResponseSpecification()).extract().asString();
 
	
	    //System.out.println(AddPetResponse);
	    System.out.println();
	
	
	    JsonPath path=new JsonPath(AddPetResponse);
	    System.out.println(path);
	    
	    System.out.println(path.get("id"));
	    System.out.println(path.get("name"));
		
	
}


public static RequestSpecification createRequestSpecification() throws Exception
{
	
	
	PrintStream printstream=new PrintStream(new FileOutputStream("Logging.txt"));
    requestspacification= new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io")
		                                           .addFilter(RequestLoggingFilter.logRequestTo(printstream))
		                                           .addFilter(ResponseLoggingFilter.logResponseTo(printstream))
                                                   .setContentType(ContentType.TEXT)
                                                   .setContentType(ContentType.JSON)           
                                                   .build(); 
       return  requestspacification;
	
}




public  static ResponseSpecification createResponseSpecification() throws Exception
{
	return responsespacification = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
			                                               .expectStatusCode(200).build();
	
	
}
}

package EndToEndWithBasicAPIPayload;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class AllPetStoreAPI {
	
	
	public static void main(String args[])
	{
		
		
		RestAssured.baseURI="https://petstore.swagger.io";
		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
				body("{\r\n" + 
						"  \"id\": 0,\r\n" + 
						"  \"category\": {\r\n" + 
						"    \"id\": 101,\r\n" + 
						"    \"name\": \"string\"\r\n" + 
						"  },\r\n" + 
						"  \"name\": \"doggie\",\r\n" + 
						"  \"photoUrls\": [\r\n" + 
						"    \"string\"\r\n" + 
						"  ],\r\n" + 
						"  \"tags\": [\r\n" + 
						"    {\r\n" + 
						"      \"id\": 0,\r\n" + 
						"      \"name\": \"string\"\r\n" + 
						"    }\r\n" + 
						"  ],\r\n" + 
						"  \"status\": \"available\"\r\n" + 
						"}"). 
				when().post("/v2/pet"). 
				then().log().all().assertThat().statusCode(200).extract().response().asString();
 
	
	System.out.println(AddPetResponse);
	System.out.println();
	
				
	System.out.println("________________Update Pet API____________________________________________________________________________________________________________________________________");
	
	
	String UpdatePetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
			body("{\r\n" + 
					"  \"id\": 0,\r\n" + 
					"  \"category\": {\r\n" + 
					"    \"id\": 101,\r\n" + 
					"    \"name\": \"string\"\r\n" + 
					"  },\r\n" + 
					"  \"name\": \"doggie\",\r\n" + 
					"  \"photoUrls\": [\r\n" + 
					"    \"string\"\r\n" + 
					"  ],\r\n" + 
					"  \"tags\": [\r\n" + 
					"    {\r\n" + 
					"      \"id\": 0,\r\n" + 
					"      \"name\": \"string\"\r\n" + 
					"    }\r\n" + 
					"  ],\r\n" + 
					"  \"status\": \"available\"\r\n" + 
					"}"). 
			when().put("/v2/pet"). 
			then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		
		System.out.println(UpdatePetResponse); 
		System.out.println();
		
		System.out.println("__________________Get Pet By Status API __________________________________________________________________________________________________________________________________");
		
		
		//https://petstore.swagger.io/v2/pet/findByStatus?status=available    
		
		//Three status : available/pending/sold 
			
			
			
		         String FindPetByStatusResponse=given().log().all().header("Content-Type","application/json").
		                 queryParam("status","available").
				         when().get("/v2/pet/findByStatus").
				         then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			
		  System.out.println(FindPetByStatusResponse);		  
		  System.out.println();
		  
		  
		 
		  
			System.out.println("__________________Get Pet By ID API __________________________________________________________________________________________________________________________________");
		  
			
			
			   String FindPetByIDResponse=given().log().all().header("Content-Type","application/json").
		                 pathParam("id", "101").
				         when().get("/v2/pet/{id}").
				         then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			
		  System.out.println(FindPetByIDResponse);		  
		  System.out.println();
		  
		  
		  

			System.out.println("__________________Delete pet API __________________________________________________________________________________________________________________________________");
		  
			
			
			   String DeletePetResponse=given().log().all().header("Content-Type","application/json").
		                 pathParam("id", "101").
				         when().delete("/v2/pet/{id}").
				         then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			
		  System.out.println(DeletePetResponse);		  
		  System.out.println();
		  
		  
		  
		  
		
	}
	
	
	

}

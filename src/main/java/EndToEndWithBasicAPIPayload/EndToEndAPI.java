package EndToEndWithBasicAPIPayload;
import static io.restassured.RestAssured.given;

import Payloads.PetStorePayloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class EndToEndAPI {
	
	static String PetID;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
RestAssured.baseURI="https://petstore.swagger.io";
		
		System.out.println("_______________Add Pet API_______________________________________________________________________________________________");
		
		String AddPetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
				body(PetStorePayloads.AddPetApiPayload("1234567890", "bb","available")). 
				when().post("/v2/pet"). 
				then().log().all().assertThat().statusCode(200).extract().response().asString();
 
	
	    //System.out.println(AddPetResponse);
	    System.out.println();
	
	
	    JsonPath path=new JsonPath(AddPetResponse);
	
	     PetID=path.getString("id");
	
	     System.out.println(PetID);
	
	System.out.println("_______________update Pet API_______________________________________________________________________________________________");
	
	
	String UpdatePetResponse=	given().log().all().header("accept","application/json").header("Content-Type","application/json").	
			body(PetStorePayloads.UpdatePetApiPayload("22", "binitab","sold")). 
			when().put("/v2/pet"). 
			then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		
		//System.out.println(UpdatePetResponse); 
		System.out.println();
	    JsonPath pathh=new JsonPath(UpdatePetResponse);
		
	     PetID=pathh.getString("id");
	
	     System.out.println(PetID);
	
	
	System.out.println("__________________Get Pet By ID API __________________________________________________________________________________________________________________________________");
	  
	
	
	    String FindPetByIDResponse=given().log().all().header("Content-Type","application/json").
              pathParam("id", PetID).
		         when().get("/v2/pet/{id}").
		         then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	
           //System.out.println(FindPetByIDResponse);	

           JsonPath path2=new JsonPath(FindPetByIDResponse);
           
          System.out.println(path2.get("id") +"  Pet is get successfully ");


System.out.println("__________________Delete pet API __________________________________________________________________________________________________________________________________");



           String DeletePetResponse=given().log().all().header("Content-Type","application/json").
          pathParam("id", PetID).
	         when().delete("/v2/pet/{id}").
	         then().log().all().assertThat().statusCode(200).extract().response().asString();

           
           JsonPath path3=new JsonPath(FindPetByIDResponse);

          //System.out.println(DeletePetResponse);		  
          System.out.println();
          
          
          System.out.println(path3.get("id") +"  Pet is delete successfully ");







		
		
		
	}

}

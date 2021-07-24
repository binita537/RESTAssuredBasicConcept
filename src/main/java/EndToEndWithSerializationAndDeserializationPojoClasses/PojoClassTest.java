package EndToEndWithSerializationAndDeserializationPojoClasses;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class PojoClassTest {
	
	
	
	
	 
	

	public static void main(String[] args) {
	
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
		
		ApiREsponsePOjoCLass AddPetResponse=	given().header("accept","application/json").header("Content-Type","application/json").	
				body( PojoClassTest.GetPayloadBySerilization("001", "Java", "Java Is programming Langauge","200" ,"binita" , "2021-07-11T08:23:25.162Z")). 
				when().post("/api/v1/Books").as(ApiREsponsePOjoCLass.class);
		
		System.out.println(AddPetResponse); 
		
		System.out.println(AddPetResponse.getId());
		System.out.println(AddPetResponse.getTitle());
		System.out.println(AddPetResponse.getDescription());
		System.out.println(AddPetResponse.getPageCount());
		System.out.println(AddPetResponse.getExcerpt());
		System.out.println(AddPetResponse.getPublishDate());
		
		
  

	}
	
	
	
	public static APIPayloadPojoClass GetPayloadBySerilization(String id,String title,String description,String pagecount,String Excerpt,String publishdate)
	{
		
		APIPayloadPojoClass ApiObject=new APIPayloadPojoClass();
		
		ApiObject.setId(id);
		ApiObject.setTitle(title);
		ApiObject.setDescription(description);
		ApiObject.setPageCount(pagecount);
		ApiObject.setExcerpt(Excerpt);
		ApiObject.setPublishDate(publishdate);
		
		
		
		
		return ApiObject;
		
		
		
	}
	
	

}

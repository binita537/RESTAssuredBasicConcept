package ValidateTheComplexJsonResponse;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;



public class ComplexJson {
	
	
	
	public static void main(String args[])
	{
			
			String Response= "{\r\n" + 
					"  \"dashboard\": {\r\n" + 
					"    \"purchaseAmount\": 1162,\r\n" + 
					"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
					"  },\r\n" + 
					"  \"courses\": [\r\n" + 
					"    {\r\n" + 
					"      \"title\": \"Selenium Python\",\r\n" + 
					"      \"price\": 50,\r\n" + 
					"      \"copies\": 6\r\n" + 
					"    },\r\n" + 
					"    {\r\n" + 
					"      \"title\": \"Cypress\",\r\n" + 
					"      \"price\": 40,\r\n" + 
					"      \"copies\": 4\r\n" + 
					"    },\r\n" + 
					"    {\r\n" + 
					"      \"title\": \"RPA\",\r\n" + 
					"      \"price\": 45,\r\n" + 
					"      \"copies\": 10\r\n" + 
					"    },\r\n" + 
					"     {\r\n" + 
					"      \"title\": \"Appium\",\r\n" + 
					"      \"price\": 36,\r\n" + 
					"      \"copies\": 7\r\n" + 
					"    }\r\n" + 
					"    \r\n" + 
					"    \r\n" + 
					"    \r\n" + 
					"  ]\r\n" + 
					"}\r\n" + 
					"";
			
			
			
		
	
	JsonPath RawREsponseTopath=new JsonPath(Response);
	
	System.out.println(Response);
	System.out.println(RawREsponseTopath);
	
	
	
	System.out.println(RawREsponseTopath.getInt("dashboard.purchaseAmount"));
	System.out.println(RawREsponseTopath.getString("dashboard.website")); 
	
	
	//  [] it will indicate as array // we can use size method 
		
	
	System.out.println(RawREsponseTopath.getInt("courses.size()"));  
	
	
	
   //  {}  it will be indicate as element  :child element we can access by . 
	
	System.out.println(RawREsponseTopath.getString("courses[0].title")); 
	
	
	//To get total cources
	int TotalCources=RawREsponseTopath.getInt("courses.size()");
	
	
	int Prisesum=0;
	int CopiesSum=0;
	for(int i=0;i<TotalCources;i++)
	{
		
		System.out.println(RawREsponseTopath.get("courses["+i+"].title"));
		System.out.println(RawREsponseTopath.get("courses["+i+"].price"));
		System.out.println(RawREsponseTopath.get("courses["+i+"].copies"));
		
		
		Prisesum=Prisesum+ RawREsponseTopath.getInt("courses["+i+"].price");
		CopiesSum=CopiesSum+ RawREsponseTopath.getInt("courses["+i+"].copies");  
          
       System.out.println();   
		
	}
	
	System.out.println("Sum of Price  :"+Prisesum);
	System.out.println("Sum of Price  :"+CopiesSum);

	
	
	
	int TotalpriceAndCopies=0;
	
	for(int i=0;i<TotalCources;i++)
	{
		
		int price=RawREsponseTopath.get("courses["+i+"].price");
		int copies=RawREsponseTopath.get("courses["+i+"].copies"); 
         
	       int priceAndCopies=price*copies;
	       
	       TotalpriceAndCopies=TotalpriceAndCopies+priceAndCopies;
	 	
	}
	
    System.out.println(RawREsponseTopath.getInt("dashboard.purchaseAmount")+" is equal to "+TotalpriceAndCopies);  
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	

	
	
	
	
	
	
	
		}


}

package com.maheshrestassured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoserialization.AddPlace;
import pojoserialization.Location;

public class SpecBuilderTest {

	public static void main(String[] args) {
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, hyd 39");
		p.setLanguage("Spanish");
		p.setPhone_number("(+91) 123 456 7890");
		p.setName("Mahesh");
		p.setWebsite("https://www.mahesh.com");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		System.out.println(myList);
		p.setTypes(myList);
		
		Location loc=new Location();
		loc.setLang(33.427362);
		loc.setLat(-38.383494);
		p.setLocation(loc);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification respspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification res=given().spec(req).body(p);
		
		Response respone=res.when().post("maps/api/place/add/json")
		.then().spec(respspec).extract().response();
		
		System.out.println(respone);

	}

}

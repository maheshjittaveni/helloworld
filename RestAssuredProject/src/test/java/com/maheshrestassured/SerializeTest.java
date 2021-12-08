package com.maheshrestassured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoserialization.AddPlace;
import pojoserialization.Location;

public class SerializeTest {

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
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(p).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").extract().response();
		
		System.out.println(response);

	}

}

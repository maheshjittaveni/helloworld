package com.maheshrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Basics {
	@Test
	public void POST() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lang\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Mahesh Jittaveni Academy\",\r\n"
				+ "  \"phone_number\": \"(+91) 123 456 7890\",\r\n"
				+ "  \"address\": \"29, side layout, hyd 39\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"English\"\r\n"
				+ "}").when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}
			@Test
		    public void  GET(){
			RestAssured.baseURI="https://reqres.in";
			given().log().all()
			.queryParam("page", "2").header("Content-Type","application/json")
			.when().get("/api/users").then().log().all()
			.assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8")
			.body("total", equalTo(12)); // header- server validation is must
}
}

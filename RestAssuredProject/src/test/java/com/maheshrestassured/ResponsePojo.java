package com.maheshrestassured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.GetUers;

public class ResponsePojo {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
		GetUers gc=given().expect().defaultParser(Parser.JSON)// we can avoid this parser if content-type=application/json in response header
				.when().get("/api/users/2").then().extract().as(pojo.GetUers.class);
		
		
		System.out.println(gc.getPage());
		System.out.println(gc.getPer_page());
		System.out.println(gc.getSupport().getUrl());
		System.out.println(gc.getSupport().getText());
		System.out.println(gc.getTotal());
		System.out.println(gc.getTotal_pages());
		
	}
//		RestAssured.baseURI="https://reqres.in";
//		String response1=given().log().all()		    
//				.when().get("/api/users/2").then().log().all()
//				.assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
//				.header("Content-Type", "application/json; charset=utf-8").extract().asString();
//		
//		System.out.println(response1);
//		//System.out.println(gc.getSupport().getUrl());
}


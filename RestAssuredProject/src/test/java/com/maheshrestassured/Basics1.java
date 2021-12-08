package com.maheshrestassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath; 

public class Basics1 {
	@Test
	public void POST_PUT_GET(){
		//POST- add user. PUT-update job and GET-get user details to validate the job is present in response or not
		RestAssured.baseURI="https://reqres.in";

		//POST- add user.
		String response=given().log().all()
				.header("Content-Type","application/json")
				.body(Payload.data())
				//.body(new String(Files.readAllBytes(Paths.get("<path to .json file>"))))- to read json file from external
				.when().post("/api/users").then().log().all()
				.assertThat().statusCode(201).statusLine("HTTP/1.1 201 Created")
				.header("Content-Type", "application/json; charset=utf-8")
				.body("name", equalTo("mahesh")).extract().asString(); // header- server validation is must		

		JsonPath js=new JsonPath(response);//for parsing JSON
		String name=js.getString("name");

		System.out.println(name);

		//PUT-update job
		given().log().all()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \"automation tester\"\r\n"
				+ "}")
		.when().put("/api/users").then().log().all()
		.assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.header("Content-Type", "application/json; charset=utf-8")
		.body("job", equalTo("automation tester"));

		//GET-get user details to validate the job is present in response or not
		String response1=given().log().all()		    
				.when().get("/api/users/2").then().log().all()
				.assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("Content-Type", "application/json; charset=utf-8").extract().asString();

		JsonPath jp1=Payload.rawToJson(response1);
		String email="janet.weaver@reqres.in";
		String actualEmail=jp1.getString("data.email");
		System.out.println(actualEmail);
		Assert.assertEquals(actualEmail, email);
	}
}


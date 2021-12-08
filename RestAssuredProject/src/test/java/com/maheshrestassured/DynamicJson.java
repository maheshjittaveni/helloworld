package com.maheshrestassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all()
				.header("Content-Type","application/json")
				.body(Payload.addBook(isbn, aisle))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js=Payload.rawToJson(response);
		System.out.println(js.get("Msg").toString());
		System.out.println(js.get("ID").toString());
	}
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"abdcef","4563"},{"abdcer","4561"},{"abdcet","4562"}};

	}
}

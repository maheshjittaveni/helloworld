package com.maheshrestassured;

import io.restassured.path.json.JsonPath;

public class Payload {
	public static String data(){
		return "{\r\n"
				+ "    \"name\": \"mahesh\",\r\n"
				+ "    \"job\": \"engineer\"\r\n"
				+ "}";
	}
	public static  JsonPath rawToJson(String response){
		JsonPath jp=new JsonPath(response);
		return jp;
	}

	public static String CoursePrice() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 1155,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    },\r\n"
				+ "     {\r\n"
				+ "      \"title\": \"Appium\",\r\n"
				+ "      \"price\": 35,\r\n"
				+ "      \"copies\": 7\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	public static String addBook(String aisle, String isbn) {
		String payload="\r\n"
				+ "{\r\n"
				+ "\"name\":\"Learn Appium automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"mahesh\"\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}

}

package com.maheshrestassured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
public class OAuthTest {

	public static void main(String[] args) {		
		//client password and client credentials we don't need code. code can be used only when "grant_type", "authorization_code"
		String accessTokenResponse=given().urlEncodingEnabled(false).log().all()
				//4%2F- we should use urlEncodingEnabled(false) to not to encode % symbol
		//.queryParams("code", "4%2FqgGx5G4YMKAQOJ0OouBdEG0salosXGjkl2bVNkSMV1HFvE-bmQtjf3dAxESn4t2Z23hDdVf4EszLhhOshf_6oag")
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
		
		String response=given().queryParam("access_token", accessToken)
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(response);
	}

}

package stepdefinitions;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiEnumResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils {

	RequestSpecification res;
	ResponseSpecification respspec;
	Response response;
	TestDataBuild data=new TestDataBuild();

	@Given("add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
		System.out.println("In Given section");
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method)  {

		ApiEnumResources resourceApi=ApiEnumResources.valueOf(resource);
		System.out.println(resourceApi.getResource());

		respspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
			response=res.when().post(resourceApi.getResource());
		else if(method.equalsIgnoreCase("get"))
			response=res.when().get(resourceApi.getResource());

		System.out.println("In When section");


	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		System.out.println("In Then section");
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions
		String resp=response.asString();
		JsonPath jp=new JsonPath(resp);
		assertEquals(jp.get(keyValue).toString(), expectedValue);
		System.out.println("In And section");
	}
}

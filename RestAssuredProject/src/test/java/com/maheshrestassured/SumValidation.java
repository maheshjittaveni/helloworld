package com.maheshrestassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfCourses() {
		int sum=0;
		JsonPath jp=new JsonPath(Payload.CoursePrice());
		int count=jp.getInt("courses.size()");
		for(int i=0;i<count;i++) {
			int price=jp.getInt("courses["+i+"].price");
			int copies=jp.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			sum=sum+amount;
			
		}
		System.out.println(sum);
		int purchaseAmount=jp.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);

	}
}

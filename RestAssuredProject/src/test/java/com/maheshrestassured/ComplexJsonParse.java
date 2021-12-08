package com.maheshrestassured;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// Moc response
		JsonPath jp=new JsonPath(Payload.CoursePrice());

		//print # of courses returned by API
		int count=jp.getInt("courses.size()");
		System.out.println(count);

		//print purchase amount
		int purchaseAmount=jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		//print title of the first course
		String AllCoursesTitle=jp.getString("courses.title");
		System.out.println(AllCoursesTitle);

		//print title of the first course
		String firstCourseTitle=jp.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
		//print title of the 3rd course
		String thirdCourseTitle=jp.getString("courses[2].title");
		System.out.println(thirdCourseTitle);
		
		//print all course titles and their respective prices
		for(int i=0;i<count;i++) {
			String courseTitles=jp.get("courses["+i+"].title");
			int coursePrice=jp.getInt("courses["+i+"].price");
			System.out.println(jp.get("courses["+i+"].price").toString());
			System.out.println(courseTitles+"  "+coursePrice);
		}
		
		//print no of copies sold by RPA course
		System.out.println("print no of copies sold by RPA course");
		for(int i=0;i<count;i++) {
			String courseTitles=jp.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA")) {
				//copies sold by RPA course
				int copiesCount=jp.get("courses["+i+"].copies");
				System.out.println(copiesCount);
				break;
				
			}
			
		}
	}

}

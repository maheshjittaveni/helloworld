package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		// without the if block the log file will be overridden with last test case run, if we use this if condition all the test cases logs will be available in the log file
		if(req==null) {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));//in runtime it creates the file
		
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)) // to log request
				.addFilter(ResponseLoggingFilter.logResponseTo(log))//to log response
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}

	//method to extract values/data from .properties file
	public static String getGlobalValue(String key) throws IOException{
		Properties prop=new Properties(); // to read properties file this class helps
		FileInputStream fis=new FileInputStream("D:\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\resources\\global.properties");
		
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}

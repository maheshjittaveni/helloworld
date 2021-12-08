package com.maheshselenium;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverDemo {
	@Test
public void testDemo() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://facebook.com");
	driver.manage().window().maximize();
	driver.navigate().to("https://google.com");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	driver.navigate().back();
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	driver.close();
}
}

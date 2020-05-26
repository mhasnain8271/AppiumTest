
package com.qa.appiumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class LoginTest {
	
public static void main(String[] args) throws InterruptedException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel XL API 24");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		//Set ChromeDriver location
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		//Initialize Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
				
		//Launch URL in Chrome Browser
		driver.get("https://ess-staging.ttconline.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("TestUserName");
		driver.findElement(By.id("password")).sendKeys("TestPassword");
		driver.findElement(By.id("button")).click();
	} 

}

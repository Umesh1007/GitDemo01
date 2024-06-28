package Umesh1stAppium.Appium1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium_Basic extends BaseClass{

	@Test
	public void AppiumTest() throws MalformedURLException
	{
		
		//AndroidDriver,IOSDriver
		//Appium code - Appium Server - Mobile	
		
				
		//Actual Automation
		//By - Xpath,id,   AppiumBy - accessibilityId,className,androidUIAutomator		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		System.out.println("Assertion is Passed");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("umeshWifi");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		System.out.println("In Wifi Name is Inserted Successfully");
		
		
	}

}

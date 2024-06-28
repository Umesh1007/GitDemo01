package Umesh1stAppium.Appium1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SwipeDemo extends BaseClass{

	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.TextView)[0]"));
		Assert.assertEquals
		(driver.findElement(By.xpath("(//android.widget.TextView)[0]")).getAttribute("focusable"),"true");
		//Swipe
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)firstImage).getId(),
		    "direction", "left",
		    "percent", 0.75
		));
		
		
		Assert.assertEquals
		(driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getAttribute("focusable"),"false");
		
		System.out.println("Complete swapping");
		
	}

}

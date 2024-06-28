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

public class ScrollDemo extends BaseClass{

	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		/*
		 ***When to scroll is known Prior
		 
		The "new UiScrollable(new UiSelector())" method is used to create an instance of the UiScrollable class, 
		which allows scrolling through a view.
		The ".scrollIntoView(text("WebView"))" method is used to scroll until an element with the 
		text "WebView" is found.
		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		*/
		
		//No Prior idea
		
		scrollToEndAction();
		
		System.out.println("Complete scrolling");
		
	}

}

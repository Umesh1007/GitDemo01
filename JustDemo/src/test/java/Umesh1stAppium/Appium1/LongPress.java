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

public class LongPress extends BaseClass{

	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElements(AppiumBy.className("android.widget.TextView")).get(1).click();
		System.out.println("Passed Thread sleep 2 sec");
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		System.out.println("Successfully click on People Names");
		
		longPressAction(ele);
		/*
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
        */

		String Text = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(Text, "Sample menu");
		System.out.println("Assert Passed Text matched");
		
		//text displayed or not
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		System.out.println("Assert is true");
	}

}

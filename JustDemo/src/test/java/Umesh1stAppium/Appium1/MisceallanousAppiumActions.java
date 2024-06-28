package Umesh1stAppium.Appium1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MisceallanousAppiumActions extends BaseClass{

	@Test
	public void Miscellanous() throws MalformedURLException
	{
		
		//AndroidDriver,IOSDriver
		//Appium code - Appium Server - Mobile	
		
				
		//Actual Automation
		//By - Xpath,id,   AppiumBy - accessibilityId,className,androidUIAutomator		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//Device Rotated in 90degree
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		System.out.println("Assertion is Passed");
		
		//Copy Paste - Copy to Clipboard  - Paste it Clipboard
		
		driver.setClipboardText("umeshWifi");		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("In Wifi Name is Inserted Successfully");
		
		
	}

}

package Umesh1stAppium.Appium1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_TC_5_HandleThroght_Browser extends BaseClass{
	
	@Test
	public void FillForm() throws InterruptedException 
	{
	//add credential,shop,submit
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Umesh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'])[1]")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
				
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//Hybrid - Google
		//How to handle Hybrid app?
		
		Thread.sleep(3000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts)
		{
			System.out.println(contextName);
		}		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("CHESTERFIELD ROYAL HOSPITAL");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
				System.out.println("Test Passed");
		
		Thread.sleep(3000);
	}
	
	

}

package Umesh1stAppium.Appium1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC_1 extends BaseClass{
	
	@Test
	public void FillForm() throws InterruptedException 
	{
	
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Umesh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Zambia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Zambia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		/*
		//Error message 
		String tostMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(tostMessage, "Please enter your name");
		*/
		
		System.out.println("Test Passed");
		
		Thread.sleep(3000);
	}
	
	

}

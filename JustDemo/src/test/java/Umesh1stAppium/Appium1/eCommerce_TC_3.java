package Umesh1stAppium.Appium1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC_3 extends BaseClass{
	
	@Test
	public void FillForm() throws InterruptedException 
	{
	
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Umesh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'])[1]")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.attributeContains
				(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum =0;
		for (int i=0;i<count;i++)
		{
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
			
		}
		
		String displaySum= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		//Assert.assertEquals(totalSum, displayFormattedSum);
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		/*
		 * 
		 * driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		//if same button and attributes values are present then 
		for (int i=0;i<productCount;i++)
		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		//check title then move a head
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		
		*/	
		
		System.out.println("Test Passed");
		
		Thread.sleep(3000);
	}
	
	

}

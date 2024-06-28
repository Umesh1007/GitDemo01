package Umesh1stAppium.Appium1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//Umesh//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		//service.start();
		
		
		//This line declares a new instance of the UiAutomator2Options class, which provides a way to customize the behavior of the AndroidDriver.
				UiAutomator2Options options = new UiAutomator2Options();
				
				//This line sets the name of the platform that will be used for testing. In this case, it is set to "Pixel 6 Pro API 30_Um1".
				options.setPlatformName("Pixel 6 Pro API 30_Um1");
				
				options.setChromedriverExecutable("C:\\Users\\Umesh\\Documents\\chromedriver_83.exe");
				
				//This line sets the path of the APK file that will be tested.
				//options.setApp("C:\\Users\\Umesh\\eclipse-workspace\\Appium1\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				options.setApp("C:\\Users\\Umesh\\eclipse-workspace\\Appium1\\src\\test\\java\\resources\\General-Store.apk");

				//This line creates a new instance of the AndroidDriver class using the URL of the Appium server and the UiAutomator2Options object created earlier.
				driver = new AndroidDriver (new URL ("http://127.0.0.1:4723"), options);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	 public void longPressAction(WebElement ele) {
		 ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
							"duration",2000));
	 }
	 
	 public Double getFormattedAmount (String amount)
	 
	 {
		 Double price = Double.parseDouble(amount.substring(1));
		 return price;
	 }
	 
	 public void scrollToEndAction() {
		 boolean canScrollMore;
			
			do
			{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			}
			while(canScrollMore);
	 }
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		//service.stop();
	}

}

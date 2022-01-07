package Activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity1 {
	AndroidDriver<MobileElement> driver = null;
	WebDriver wait=null;
    @BeforeClass
    public void calc() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceId", "Pixel 4 API 28 ");
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Uiautomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
    
        // Instantiate Appium Driver
       // try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
            wait=(WebDriver) new WebDriverWait(driver,10);
    }
      //  } catch (MalformedURLException e) {
        //	System.out.println(e.getMessage());
      //  }
      //  }
    
        
        @Test
    	public void add() {
    		driver.findElementById("digit_5").click();
        	driver.findElementById("plus").click();
        	driver.findElementById("digit_9").click();
        	driver.findElementById("eq").click();
        	((FluentWait<WebDriver>) wait).until(ExpectedConditions.textToBePresentInElement(driver.findElementById("result"), "14"));
        	
        	String result = driver.findElement(MobileBy.id("result")).getText();
        	System.out.println(result);
	}
        
    @AfterClass
	public void closedriver() {
		driver.quit();
		
	}


}
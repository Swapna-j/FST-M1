package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTaskapp {
	AndroidDriver<MobileElement> driver=null;
	WebDriverWait wait=null;
	List<String> elementTask=new ArrayList<String>();
	
	@BeforeClass()
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskActivity");
        
       URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
        wait=new WebDriverWait(driver,10);
	}
	
	@Test
	public void TaskActivity() {
		addTask("Complete Activity with Google Tasks");
		addTask("Complete Activity with Google Keep");
		addTask("Complete the second Activity Google Keep");
		List<MobileElement> element=driver.findElementsById("task_name");		
		List<String> elementTask = null;
		for(MobileElement el : element) {
			elementTask.add(el.getText());
		}
		Assert.assertTrue(elementTask.contains("Complete Activity with Google Tasks"));
		Assert.assertTrue(elementTask.contains("Complete Activity with Google Keep"));
		Assert.assertTrue(elementTask.contains("Complete the second Activity Google Keep"));
	}
	public void addTask(String taskName) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tasks_fab")));
		driver.findElementById("tasks_fab").click();
	
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
		driver.findElementById("add_task_title").sendKeys(taskName);
				
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_done")));
		driver.findElementById("add_task_done").click();
	}
	
	@AfterClass()
    public void closeDriver() {
    	driver.quit();
    }
	
}
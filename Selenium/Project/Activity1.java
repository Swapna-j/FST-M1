
package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

	
	    WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	       
	        driver = new ChromeDriver();
	        driver.get("http://alchemy.hguy.co/crm");
	    }

	    @Test
	    public void Titlepage() {
	    	String title= driver.getTitle();
	    	
	    	System.out.println("page title is: " + title);
	    	
	          Assert.assertEquals("SuiteCRM", title);
	    }

	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }

	}


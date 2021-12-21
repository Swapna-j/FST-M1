package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	
	

	 WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        
	        driver = new ChromeDriver();
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    
	    @Test
	    public void consoletext() {
	    	
	    	String Copyrighttext = driver.findElement(By.id("admin_options")).getText();
	    	System.out.println("Text console is " + Copyrighttext );
	    }
	    
	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }
}

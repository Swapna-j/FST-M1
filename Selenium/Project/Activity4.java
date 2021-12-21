package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

	
	 WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        
	        driver = new ChromeDriver();
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    
	   
	    @Test  
	   public void login() {
	    	
	    	driver.findElement(By.id("user_name")).sendKeys("admin");
	    	driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	    	driver.findElement(By.id("bigbutton")).click();
	    	String currnturl = driver.getCurrentUrl();
	    	   System.out.println("current url is : " + currnturl );
	    	   System.out.println("homepage is opened");
	    }
	    
	    @AfterMethod
	    public void afterMethod() {
	        driver.quit();
	    }
}

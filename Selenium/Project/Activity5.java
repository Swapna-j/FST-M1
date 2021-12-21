package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

	
	WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void Navigationcolor() {
    	
    	driver.findElement(By.id("user_name")).sendKeys("admin");
    	driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    	driver.findElement(By.id("bigbutton")).click();
    	String Navigationbarcolor = driver.findElement(By.xpath("//*[@id=\"ajaxHeader\"]/nav/div/div[1]")).getCssValue("color");
    	System.out.println("Navigation menu color is :" + Navigationbarcolor);
    }
    
    @AfterMethod
    public void afterMethod() {
       driver.quit();
    }
}

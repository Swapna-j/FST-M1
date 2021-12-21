package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
	
    @Test
    public void Activitiesmenu() throws InterruptedException {
    	
    	driver.findElement(By.id("user_name")).sendKeys("admin");
    	driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    	driver.findElement(By.id("bigbutton")).click();
    	Thread.sleep(1000);
    	driver.manage().window().maximize();
    	WebElement Activitiesmenu= driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
    	System.out.println("Activities item menu is displayed :" + Activitiesmenu.isDisplayed() );
    	driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]")).click();
    	System.out.println("Activities item menu is displayed :" + Activitiesmenu.isDisplayed() );
    }
    
    @AfterMethod
    public void afterMethod() {
       driver.quit();
    }
}

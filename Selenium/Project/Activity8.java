package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {

		WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        
	        driver = new ChromeDriver();
	        driver.get("http://alchemy.hguy.co/crm");
	    }

	    @Test
	    public void Traversing() throws InterruptedException {
	    	 driver.findElement(By.id("user_name")).sendKeys("admin");
	     	driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	     	driver.findElement(By.id("bigbutton")).click();
	     	driver.manage().window().maximize();
	     	
	     	WebElement element = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	     	Actions act = new Actions(driver);
	     	act.moveToElement(element).build().perform();
	     	driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]")).click();
	     	Thread.sleep(5000);
	     	for(int i=1; i<=9;i++) {
	     		WebElement row = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr["+ i +"]/td[3]/b/a"));
	     		
				System.out.println("coloumn data:" + row.getText());
	     		i++;
	     	}
	     		
	    }   


   @AfterMethod
   public void afterMethod() {
   driver.quit();
}
}
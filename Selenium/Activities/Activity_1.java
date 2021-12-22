import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity_1 {

	public static void main(String[] args) {
	    
        // Create a new instance of the Firefox driver
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver96\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		
        // Open the browser
        driver.get("https://www.training-support.net");
		
        // Close the browser
        //driver.close();
    }
}

package org.automation.melorra.base;

import java.io.IOException;

import org.automation.melorra.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws IOException {
		
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
			
		driver.get(Utility.fetchPropertyValue("applicationURL").toString());
	}
	
@AfterMethod
	public void closeDriverInstance() {
		
		driver.quit();
	}

}

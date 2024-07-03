package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




import utilities.PropertyReader;

public class BaseTest {
	public WebDriver driver;
	public PropertyReader propertyReader;


	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		propertyReader = new PropertyReader();
		driver.get(propertyReader.getApplicationUrl());
		

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			

		}
	}
}

package utilities;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	/************************* Driver Setup *****************/
	public WebDriver driverSetup(WebDriver driver) {
		
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		Properties prop = objProp.readPropertiesFile();		
		try {
			if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.silentOutput","true");
				WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
			} else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
			} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
			} 
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	

}

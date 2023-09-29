package pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;

public class FlightBookingPage extends PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(CabsPage.class);
	Properties prop;

	public FlightBookingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}

	
	@FindBy(id = "fromCity")
	WebElement FROMInput_Element;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement FROMPlaceholder_Element;
	
	@FindBys(@FindBy(className = "react-autosuggest__input react-autosuggest__input--open"))
	public List<WebElement> suggestionList_Elements;
	public void enterFROMCity(String city) {
		try {
			FROMInput_Element.click();
			logger.log(Status.INFO, "Clicked on FROM City Lebel");
			Logger.info("Clicked on FROM City Lebel");
			for (int i = 0; i < city.length(); i++) {
				Thread.sleep(200);
				FROMPlaceholder_Element.sendKeys(Character.toString(city.charAt(i)));
			}
			logger.log(Status.INFO, "Entered " + city + " in appeared placeholder.");
			Logger.info("Entered " + city + " in appeared placeholder.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Wait Till Suggestion ********************/
	public void waitForSuggestions() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList_Elements));
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Select City From Suggestion *************/
	public void selectFromSuggestion(String selectCity) {
		try {
			boolean falg = false;
			for (WebElement element : suggestionList_Elements) {
				if (element.getText().equals(selectCity)) {
					WebElement targetElement = element;
					targetElement.click();
					falg = true;
					break;
				}
			}
			//Assert.assertTrue(falg);
			logger.log(Status.PASS, "City Selected from suggestions.");
			Logger.info("City Selected from suggestions.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
}

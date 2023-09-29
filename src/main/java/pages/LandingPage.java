package pages;


import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pages.GiftCardsPage;

public class LandingPage extends PagesBaseClass{
	private static final Logger Logger = LogManager.getLogger(LandingPage.class);
	Properties prop;
	
	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);		
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
		}


	@FindBy(xpath = "//a[@data-cy='mmtLogo']")
	WebElement knownElement;

	@FindBy(linkText = "Cabs")
	WebElement cabsPage_linkTextElement;
	@FindBy(xpath = "//span[contains(text(),'Gift Cards')]")
	WebElement GiftCardsPage_Element;

	

	/***************** Getting Main Landing Page *********/
	public void getLandingPage() {
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
		driver.get(prop.getProperty("baseURL"));
	}

	/***************** Closing Login PopUp **************/
	public void closeLoginPopUp() {
		try {
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(knownElement));
		
		action.moveToElement(knownElement).click(knownElement).build().perform();
		logger.log(Status.PASS, "Login Pop Up Closed sucessfully. ");
		Logger.info("Login Pop Up Closed sucessfully.");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/**************** Navigate to Cabs Page ***********/
	public CabsPage getCabsPage() {
		try {
		cabsPage_linkTextElement.click();
		logger.log(Status.PASS, "Clicked on Cabs icon.");
		Logger.info("Clicked on Cabs icon.");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}		
		CabsPage cabsPage = new CabsPage(driver, logger);
		PageFactory.initElements(driver,cabsPage);
		return cabsPage;
		
	}

	/**************** Check Cabs Option ****************/
	public void checkCabsOption() {
		try {
			Assert.assertTrue(cabsPage_linkTextElement.isDisplayed());
			logger.log(Status.PASS, "PASS : Element is present on Landing page.");
			Logger.info("PASS : Element is present on Landing page.");
			Assert.assertTrue(cabsPage_linkTextElement.isEnabled());
			logger.log(Status.PASS, "PASS : Element is Enabled on Landing page.");
			Logger.info("PASS : Element is Enabled on Landing page.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
		
	
	
}

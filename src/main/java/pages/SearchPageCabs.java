package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import net.bytebuddy.utility.privilege.GetMethodAction;
import utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPageCabs extends PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(SearchPageCabs.class);
	Properties prop;

	public SearchPageCabs(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}

	@FindBy(id = "List")
	WebElement searchList_Element;	
	//span[contains(text(),'BOOK NOW')]
	
	@FindBy(xpath="//div[@id='List']/div[3]/div/div[3]/div/a/span")
	public WebElement bookNowBtn;
	//div[@id='List']/div[3]/div/div[3]/div/a/span
	//span[contains(text(),'BOOK NOW')]
	@FindBy(xpath="//div[@class='container']/div/div[2]/div/div[3]/div/a")
	public WebElement payNowBtn;
	
	@FindBy(xpath="//div[@class='cabPickupDetails'][1]/div/div/div/div/input")
	public WebElement addressTxt;
	
	//div[@class='pickupAddress makeFlex column']//input[@class='inputBox error']
	
	@FindBy(xpath="//div[@class='pickupAddress makeFlex column']/input[@class='inputBox error']")
	public WebElement addressTxtclick;
	
	//input[@class='inputBox error']
	@FindBys(@FindBy(className = "react-autosuggest__input"))
	public List<WebElement> addressSuggestionList_Elements;
	
	@FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li/div/p[2]/span")
	public WebElement selectAddressTxtclick;
	
	@FindBy(xpath="//div[@class='cabReviewLeftWrapper']/div[5]/div/div/div[2]/div/input")
	public WebElement selectDropAddressTxtclick;
	
	@FindBy(xpath="//input[@class='react-autosuggest__input']")
	public WebElement addressDropTxt;
	
	//ul[@class='react-autosuggest__suggestions-list']/li/div/p[2]/span
	
	@FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li/div/p[2]/span")
	public WebElement addressDropDownTxt;
	
	
	@FindBy(xpath="//div[@class='makeFlex spaceBetween']/div/input")
	public WebElement nameTxt;
	
	//span[@class='makeFlex']/span
	
	@FindBy(xpath="//span[@class='makeFlex']/span")
	public WebElement genderRadioBtn;
	
	
	@FindBy(xpath="//div[@class='makeFlex column appendBottom30']/input")
	public WebElement emailIdTxt;
	
	
	
	@FindBy(xpath="//div[@class='makeRelative']/input[2]")
	public WebElement phoneNumberTxt;
	
	
	
	/************************* verify Search List Present ****************/
	public void verifySearchListPresent() {
		try {
			searchList_Element.isDisplayed();
			logger.log(Status.PASS, "Search List  appeared ");
			Logger.info("Search List  appeared ");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void bookNow() {
		try {
			bookNowBtn.click();
			logger.log(Status.PASS, "Clicked on Book Now btn.");
			logger.log(Status.PASS, "Clicked on book now btn.");
					} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void payNow() {
		try {
//			Actions actions = new Actions(driver);

			//actions.moveToElement(payNowBtn).click().perform();
			
			 JavascriptExecutor j = (JavascriptExecutor) driver;
		      j.executeScript("arguments[0].click();", payNowBtn);
			
			logger.log(Status.PASS, "Clicked on PayNow btn.");
			logger.log(Status.PASS, "Clicked on pay now btn");
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void waitForSuggestions() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(addressSuggestionList_Elements));
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void addAdress() {
		try {
			addressTxtclick.click();
			//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			// set the text
			//jsExecutor.executeScript("arguments[0].value='Pune'", addressTxt);
			addressTxt.sendKeys("Pune");
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void selctAddAdress() {
		try {
			selectAddressTxtclick.click();
			//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			// set the text
			//jsExecutor.executeScript("arguments[0].value='Pune'", addressTxt);
			//addressTxt.sendKeys("Pune");
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void selectFromSuggestion(String selectCity) {
		try {
			boolean falg = false;
			for (WebElement element : addressSuggestionList_Elements) {
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
	public void addDropAdress() {
		try {
			 //JavascriptExecutor j = (JavascriptExecutor) driver;
		     // j.executeScript("arguments[0].click();", selectDropAddressTxtclick);
			selectDropAddressTxtclick.click();
			addressDropTxt.sendKeys("Mumbai");
			//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			// set the text
			//jsExecutor.executeScript("arguments[0].value='Pune'", addressTxt);
			//addressTxt.sendKeys("Pune");
			addressDropDownTxt.click();
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void enterName() {
		try {
			 nameTxt.sendKeys("Amol");
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void selectGender() {
		try {
			 genderRadioBtn.click();
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void enterEmailId() {
		try {
			emailIdTxt.sendKeys("AK@gmail.com");
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void enterPhoneNumber() {
		try {
			phoneNumberTxt.sendKeys("7738255531");
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
}


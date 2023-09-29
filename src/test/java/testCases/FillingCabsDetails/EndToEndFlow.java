package testCases.FillingCabsDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;



public class EndToEndFlow extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(CitySelection_FROMTest.class);
	
	@Test(groups= {"Regression"})
	public void citySelection_FROM() throws InterruptedException {
		logger = report.createTest("FROM City Selection");
		Logger.info("'FROM'City Selection test case is initiated.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.enterFROMCity("Delhi");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Delhi, India");
		//cabsPage.verifyFROMSelectedCity("Delhi, India");
		cabsPage.clickOnToCity();
		cabsPage.enterTOCity("Manali");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Manali, Himachal Pradesh, India");
		//cabsPage.verifyTOSelectedCity("Manali, Himacha...");
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("30/09/2023");
		
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("10:00 AM");
		cabsPage.applyPickupTimeApply();
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		searchPageCabs.bookNow();
		Thread.sleep(100);
		searchPageCabs.payNow();
		//Thread.sleep(100);
		searchPageCabs.addAdress();
		searchPageCabs.selctAddAdress();
		searchPageCabs.addDropAdress();
		searchPageCabs.enterName();
		searchPageCabs.selectGender();
		searchPageCabs.enterEmailId();
		searchPageCabs.enterPhoneNumber();
	      //searchPageCabs.waitForSuggestions();
	     // searchPageCabs.selectFromSuggestion("Pune Railway Station, Agarkar Nagar, Pune, Maharashtra, India");
		Logger.info("Searching Cabs from Delhi to Manali---> Successful");
		
	}
	
}

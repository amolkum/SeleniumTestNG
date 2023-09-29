package testCases.FillingCabsDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class FlightBooking extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(CitySelection_FROMTest.class);
	@Test(groups= {"Regression"})
	public void citySelection_FROM() throws InterruptedException {
		logger = report.createTest("FROM City Selection");
		Logger.info("'FROM'City Selection test case is initiated.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		//cabsPage = landingPage.getCabsPage();
		flightBookingPage.enterFROMCity("Delhi");
		flightBookingPage.waitForSuggestions();
		flightBookingPage.selectFromSuggestion("Delhi, India");
		
	}


}

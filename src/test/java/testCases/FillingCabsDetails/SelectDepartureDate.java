package testCases.FillingCabsDetails;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import bsh.ParseException;

public class SelectDepartureDate extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(SelectDepartureDate.class);
	
	@Test(groups= {"Regression"})
	public void selectDepatureDate() throws java.text.ParseException, ParseException {
		logger = report.createTest("Select Departure Date ");
		Logger.info("Departure Date Selection--->Successful");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("30/09/2023");
		cabsPage.verifyDepatureDate("30/09/2023");
	}
	

	

}

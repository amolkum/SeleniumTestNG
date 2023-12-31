package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CaptureScreenshot {
	
	public static String captureScreenShot(WebDriver driver, String screenshotName) throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir")+"//ScreenShots//"+screenshotName+".png";
		
		File target = new File(dest);
		FileUtils.copyFile(src,target);
		
		
		return dest;
	}
	
	public static String generateFileName(ITestResult result) {
		String filename = result.getName()+DateUtil.getTimeStamp();
		return filename;
	}
	public static String generateFileName(String name) {
		String filename = name+DateUtil.getTimeStamp();
		return filename;
	}

}

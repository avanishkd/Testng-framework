package com.mindtree.util;

import java.io.File;

import org.testng.ITestResult;

import com.mindtree.constants.Path;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent {

	static ExtentReports extent = new ExtentReports(Path.EXTENT_REPORT);
	ExtentTest logger;

	public Extent() {
		extent.loadConfig(new File(Path.EXTENT_CONFIG_FILE));
	}
	
	public void startTest(String testName) {
		logger = extent.startTest(testName);
	}

	public void log(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());	
		}
		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenShotUtil.getSnapName()));
		extent.endTest(logger);
	}

	public void endReport() {
		extent.flush();
		extent.close();
	}
}

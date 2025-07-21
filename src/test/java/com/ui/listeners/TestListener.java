package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	ExtentSparkReporter extentSparkReport;
	ExtentReports extentReport;
	ExtentTest extentTest;
	Logger log = LoggerUtility.getLogger(getClass());

	public void onTestStart(ITestResult result) {
		log.info(result.getMethod().getMethodName());
		log.info(result.getMethod().getDescription());
		log.info(Arrays.toString(result.getMethod().getGroups()));

		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {

		log.info(result.getMethod().getMethodName() + "   " + "PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "   " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		log.error(result.getMethod().getMethodName() + "  " + "FAILED");
		log.error(result.getThrowable().getMessage());
		extentTest.log(Status.FAIL, result.getMethod().getMethodName() + "   " + "FAILED");
		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((BaseTest)testclass).getInstence();
		String screenSJotPath =browserUtility.takeScreenShot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenSJotPath);
	}

	public void onTestSkipped(ITestResult result) {
		log.warn(result.getMethod().getMethodName() + "   " + "SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "   " + "PASSED");
	}

	public void onStart(ITestContext context) {
		log.info("Test suite started");
		ExtentReportUtility.setupSparkReporter("report.html");
		

		
	}

	public void onFinish(ITestContext context) {
		log.info("Test Suite completed");
		ExtentReportUtility.flushReport();
	}

}

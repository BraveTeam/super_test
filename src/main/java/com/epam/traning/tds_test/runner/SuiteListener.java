package com.epam.traning.tds_test.runner;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IConfigurationListener;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.selenium.driver.DriverManager;
import com.utils.ScreenshotUtils;

public class SuiteListener implements ISuiteListener, ITestListener, IConfigurationListener {

	private static final Logger LOGGER = Logger.getLogger(SuiteListener.class);

	@Override
	public void onTestFailure(ITestResult result) {

		ScreenshotUtils.takeResizedScreenshot(DriverManager.getInstance(LocalBrowserFactory.getCurrentWebDriverFactory()).getWebDriver(),
				"Test_failed_" + result.getName(), CommonConstants.RESIZE_FACTOR);

	}

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("================================== TEST " + result.getName() + " STARTED ==================================");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {

		DriverManager.quitAll();

		boolean isFailed = false;

		IResultMap failedConfigs;
		IResultMap failedTests;
		IResultMap skippedConfigs;
		IResultMap skippedTests;

		Map<String, ISuiteResult> suiteResults = suite.getResults();

		for (ISuiteResult res : suiteResults.values()) {
			failedConfigs = res.getTestContext().getFailedConfigurations();
			failedTests = res.getTestContext().getFailedTests();
			skippedConfigs = res.getTestContext().getSkippedConfigurations();
			skippedTests = res.getTestContext().getSkippedTests();

			if (failedConfigs.size() != 0 || failedTests.size() != 0 || skippedConfigs.size() != 0 || skippedTests.size() != 0) {
				isFailed = true;
				break;
			}
		}

		if (isFailed) {
			LOGGER.info("================================== SUITE " + suite.getName().toUpperCase()
					+ " FAILED ==================================");
		} else {
			LOGGER.info("================================== SUITE " + suite.getName().toUpperCase()
					+ " PASSED ==================================");
		}

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

	}
}

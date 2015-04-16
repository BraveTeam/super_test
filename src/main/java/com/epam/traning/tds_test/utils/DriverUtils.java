package com.epam.traning.tds_test.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.common.wait.Sleeper;
import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.constants.JSCommands;
import org.openqa.selenium.WebElement;

public class DriverUtils {

	/**
	 * Waiting for page load. Default timeout = 120 seconds
	 * 
	 * @param driver
	 *            WebDriver
	 */
	public static void waitForPageLoad(WebDriver driver) {
		String status;
		int i = 0;
		do {
			status = ((JavascriptExecutor) driver).executeScript(JSCommands.GET_READY_STATE).toString();
			Sleeper.SYSTEM_SLEEPER.sleep(1000);
			i++;
		} while ((!status.equals("complete")) && (i <= CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT));
	}

	public static boolean isElementPresent(WebElement element){
		return element.isEnabled();
	}

}

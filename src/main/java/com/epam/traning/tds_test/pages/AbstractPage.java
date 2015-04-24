package com.epam.traning.tds_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.utils.DriverUtils;

public abstract class AbstractPage {

	private static Logger LOG = Logger.getLogger(MainPage.class);

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPage(String url) {
		driver.get(url);
		LOG.info("Opened URL: " + url);
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
	}

	public abstract boolean check();

}

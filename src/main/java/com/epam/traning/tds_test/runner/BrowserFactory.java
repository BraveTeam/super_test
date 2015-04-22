package com.epam.traning.tds_test.runner;

import com.selenium.driver.DriverTypes;
import com.selenium.driver.factory.WebDriverFactory;

public class BrowserFactory {

	private static ThreadLocal<WebDriverFactory> webDriverFactory = new ThreadLocal<WebDriverFactory>();

	public static WebDriverFactory getInstance(DriverTypes driverTypes, int port) {

		if (webDriverFactory.get() == null) {

			webDriverFactory.set(LocalBrowserFactory.createLocalFactory(driverTypes, port));

		}
		return webDriverFactory.get();
	}

}
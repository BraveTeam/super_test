package com.epam.traning.tds_test.runner;

import com.selenium.driver.DriverType;
import com.selenium.driver.factory.WebDriverFactory;

public class BrowserFactory {

	private static ThreadLocal<WebDriverFactory> webDriverFactory = new ThreadLocal<WebDriverFactory>();

	public static WebDriverFactory getInstance(DriverType driverType) {

		if (webDriverFactory.get() == null) {

			webDriverFactory.set(LocalBrowserFactory.createLocalFactory(driverType));
			
		}
		return webDriverFactory.get();
	}

}
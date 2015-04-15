package com.epam.traning.tds_test.runner;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.selenium.driver.DriverType;
import com.selenium.driver.factory.WebDriverFactory;
import com.selenium.driver.factory.impl.FirefoxDriverFactory;
import com.selenium.driver.factory.impl.SafariDriverFactory;
import com.selenium.driver.factory.impl.chrome.ChromeDriverFactory;
import com.selenium.driver.factory.impl.ie.IEDriverFactory;

public class LocalBrowserFactory {

	private static final String CHROME_DRIVER_LOCAL_PATH = "exec/chrome/";

	private static final String IE_DRIVER_LOCAL_PATH = "exec/ie/IEDriverServer.exe";

	public static synchronized WebDriverFactory createLocalFactory(DriverType driverType) {

		DesiredCapabilities caps = new DesiredCapabilities();

		switch (driverType) {
		case FIREFOX:
			return new FirefoxDriverFactory(caps);

		case CHROME:
			return new ChromeDriverFactory(caps, CHROME_DRIVER_LOCAL_PATH);

		case SAFARI:
			return new SafariDriverFactory(caps);

		case IE:
			return new IEDriverFactory(caps, IE_DRIVER_LOCAL_PATH);

		default:
			throw new EnumConstantNotPresentException(DriverType.class, "There is no rules for " + driverType.getDriverType());
		}
	}

}

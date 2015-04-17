package com.epam.traning.tds_test.runner;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.selenium.driver.DriverType;
import com.selenium.driver.factory.WebDriverFactory;
import com.selenium.driver.factory.impl.FirefoxDriverFactory;
import com.selenium.driver.factory.impl.SafariDriverFactory;
import com.selenium.driver.factory.impl.chrome.ChromeDriverFactory;
import com.selenium.driver.factory.impl.ie.IEDriverFactory;
import com.thoughtworks.selenium.SeleniumException;

public class LocalBrowserFactory {

	private static final String CHROME_DRIVER_LOCAL_PATH = "exec/chrome/";

	private static final String IE_DRIVER_LOCAL_PATH = "exec/ie/IEDriverServer.exe";

	private static final Logger LOGGER = Logger
			.getLogger(LocalBrowserFactory.class);

	public static synchronized WebDriverFactory createLocalFactory(
			DriverType driverType, int port) {

		DesiredCapabilities caps = new DesiredCapabilities();

		if ((port != -1)) {
			try {
				caps.setCapability(CapabilityType.PROXY, seleniumProxy(port));
				LOGGER.info("Port for selenium proxy: " + port);
			} catch (UnknownHostException e) {
				throw new SeleniumException(e.getMessage(), e);
			}
		}

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
			throw new EnumConstantNotPresentException(DriverType.class,
					"There is no rules for " + driverType.getDriverType());
		}
	}

	/**
	 * Configure selenium proxy if needed
	 * 
	 * @param port
	 * @return proxy
	 * @throws UnknownHostException
	 */
	private static synchronized Proxy seleniumProxy(int port)
			throws UnknownHostException {
		Proxy proxy = new Proxy();
		proxy.setProxyType(Proxy.ProxyType.MANUAL);
		String proxyStr = String.format("%s:%d", InetAddress.getLocalHost()
				.getCanonicalHostName(), port);
		proxy.setHttpProxy(proxyStr);
		proxy.setSslProxy(proxyStr);

		return proxy;
	}
}

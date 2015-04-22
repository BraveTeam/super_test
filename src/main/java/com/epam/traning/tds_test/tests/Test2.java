package com.epam.traning.tds_test.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.guice.module.ProxiedDriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.pages.WatchNowPage;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import com.proxy.AbstractProxy;
import com.proxy.ProxyLog;
import com.selenium.driver.DriverManager;

@Modules(modules = { ProxiedDriverModule.class })
public class Test2 {

	private static Logger LOG = Logger.getLogger(Test2.class);

	protected static final String EXPECTED_SEND_REQUEST_URL_FRAGMENT = "http://sc.cc.com/";

	@Inject
	DriverManager driverManager;

	@Inject
	protected WebDriver driver;

	@Inject
	protected MainPage mainPage;

	@Inject
	private AbstractProxy proxy;

	@BeforeClass(alwaysRun = true)
	public void injectMembers() {
		TestInjector.injectMembers(this);
	}

	@BeforeClass(alwaysRun = true, dependsOnMethods = "injectMembers")
	public void setUpTest() {
		mainPage.openPage();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
	}

	@Test
	public void watchNowRequest() {

		ProxyLog proxyLog = proxy.getProxyLog();
		proxyLog.clearLog();

		WatchNowPage watchNowPage = mainPage.goToWatchNowPage();
		Assert.assertTrue(watchNowPage.check(), "WatchNow Page couldn't be identified");

		boolean expectedUrlFragmentFound = false;
		for (String url : proxyLog.getRequestUrls()) {
			if (url.contains(EXPECTED_SEND_REQUEST_URL_FRAGMENT)) {
				expectedUrlFragmentFound = true;
				break;
			}
		}

		Assert.assertTrue(expectedUrlFragmentFound, "Expected fragment was not found in sent requests list: "
				+ EXPECTED_SEND_REQUEST_URL_FRAGMENT);

	}

	@AfterSuite()
	public void shutdown() {
		LOG.info("Stopping WebDriver and Proxy");
		driverManager.quit();
		proxy.stop();
	}
}

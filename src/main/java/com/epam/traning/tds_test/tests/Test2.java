package com.epam.traning.tds_test.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.traning.tds_test.guice.module.ProxiedDriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.utils.ProxyUtils;
import com.google.inject.Inject;
import com.google.inject.name.Named;
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
	@Named("proxied")
	private DriverManager driverManager;

	@Inject
	@Named("proxied")
	private WebDriver driver;

	@Inject
	@Named("proxied")
	private MainPage mainPage;

	@Inject
	private AbstractProxy proxy;

	@BeforeClass(alwaysRun = true)
	public void injectMembers() {
		TestInjector.injectMembers(this);
	}

	@Test
	public void watchNowRequest() {

		ProxyLog proxyLog = proxy.getProxyLog();
		proxyLog.clearLog();

		mainPage.goToWatchNowPage();
		Assert.assertTrue(ProxyUtils.checkRequestIsSent(proxyLog, EXPECTED_SEND_REQUEST_URL_FRAGMENT),
				"Expected fragment was not found in sent requests list: " + EXPECTED_SEND_REQUEST_URL_FRAGMENT);

	}

	@AfterSuite()
	public void shutdown() {
		LOG.info("Stopping WebDriver and Proxy");
		DriverManager.quitAll();
		proxy.stop();
	}
}

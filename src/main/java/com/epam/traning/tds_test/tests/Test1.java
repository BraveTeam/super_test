package com.epam.traning.tds_test.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.guice.module.ProxiedDriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.pages.VideoPage;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import com.selenium.driver.DriverManager;

@Modules(modules = { ProxiedDriverModule.class })
public class Test1 {

	private static Logger LOG = Logger.getLogger(Test1.class);

	private VideoPage videoPage;

	@Inject
	DriverManager driverManager;

	@Inject
	protected WebDriver driver;

	@Inject
	protected MainPage mainPage;

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
	public void CheckExistingOfVideoBlock() {
		videoPage = mainPage.goToVideoPage();
		DriverUtils.waitForPageLoad(driver);
		Assert.assertTrue(videoPage.ChekVideoBlockPresent(), "VideoBlock does not exist");
	}

	@Test(dependsOnMethods = "CheckExistingOfVideoBlock")
	public void CheckEntityOfVideoBlock() {
		videoPage.CheckVideoBlockSize();
		Assert.assertTrue(videoPage.CheckVideoBlockSize(), " Size of the VideoBlock is not equal to 3");
	}

}

package com.epam.traning.tds_test.tests;

import com.epam.traning.tds_test.constants.ProjectConstants;
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
	private DriverManager driverManager;

	@Inject
	private WebDriver driver;

	@Inject
	private MainPage mainPage;

	@BeforeClass(alwaysRun = true)
	public void injectMembers() {
		TestInjector.injectMembers(this);
	}

	@BeforeClass(alwaysRun = true, dependsOnMethods = "injectMembers")
	public void setUpTest() {
		mainPage.openPage();
		driver.navigate();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
	}

	@Test
	public void checkExistingOfVideoBlock() {
		videoPage = mainPage.goToVideoPage();
		DriverUtils.waitForPageLoad(driver);
		Assert.assertTrue(videoPage.cheсkVideoBlockPresent(), "VideoBlock does not exist");
	}

	@Test(dependsOnMethods = "checkExistingOfVideoBlock")
	public void checkEntityOfVideoBlock() {
		videoPage.checkVideoBlockSize();
		Assert.assertTrue(videoPage.checkVideoBlockSize()== ProjectConstants.VIDEO_BLOCK_SIZE, " Size of the VideoBlock is not equal to 3");
	}

}

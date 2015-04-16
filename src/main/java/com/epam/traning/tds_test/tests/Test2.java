package com.epam.traning.tds_test.tests;

import com.epam.traning.tds_test.guice.module.DriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.pages.WatchNowPage;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Modules(modules = { DriverModule.class })
public class Test2 {

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
		DriverUtils.waitForPageLoad(driver);
	}

	@Test
	public void watchNowRequest() {

		WatchNowPage watchNowPage = mainPage.goToWatchNowPage();
		Assert.assertTrue(watchNowPage.check(),"WatchNow Page couldn't be identified");

	}
}

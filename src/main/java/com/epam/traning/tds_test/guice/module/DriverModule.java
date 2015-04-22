package com.epam.traning.tds_test.guice.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.runner.BrowserFactory;
import com.epam.traning.tds_test.runner.cli.FrameworkSettings;
import com.google.inject.AbstractModule;
import com.selenium.driver.DriverManager;

public class DriverModule extends AbstractModule {

	protected WebDriver wd;

	protected DriverManager driverManager;

	@Override
	protected void configure() {
		driverManager = DriverManager.getInstance(BrowserFactory.getInstance(FrameworkSettings.getInstance().getDriverType(), -1));
		wd = driverManager.getWebDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().pageLoadTimeout(CommonConstants.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(CommonConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		bind(DriverManager.class).toInstance(driverManager);
		bind(WebDriver.class).toInstance(wd);
		bind(MainPage.class).toInstance(new MainPage(wd));

	}
}

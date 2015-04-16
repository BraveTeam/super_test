package com.epam.traning.tds_test.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.reflections.ReflectionUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.traning.tds_test.guice.module.DriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import com.selenium.driver.DriverManager;

@Test(groups = { "TDS" })
@Modules(modules = { DriverModule.class })
public class Test2 {

	@Inject
	protected WebDriver driver;

	@Inject
	protected DriverManager driverManager;

	@Inject
	protected MainPage mainPage;
	
	private String className;

	@BeforeClass(alwaysRun = true)
	public void injectMembers() {
		TestInjector.injectMembers(this);
	}

	@BeforeClass(alwaysRun = true, dependsOnMethods = "injectMembers")
	public void setUpTest(String pageName, String filePath) {
		
		mainPage.openPage();
		DriverUtils.waitForPageLoad(driver);
	}

	@Test
	public void checkModule(String pageName, String moduleName) {

/*		className = moduleService.getModuleClassName(pageName, moduleName);

		if (!moduleService.isModuleExists(pageName, moduleName, driver)) {
			Assert.assertFalse(moduleService.isModuleRequired(pageName, moduleName),
					String.format(MessageConstants.NO_MODULE_MESSAGE, moduleName));
		}*/

	}
}

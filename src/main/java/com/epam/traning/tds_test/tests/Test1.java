package com.epam.traning.tds_test.tests;

import com.epam.traning.tds_test.guice.module.DriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.pages.VideoPage;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Modules(modules = { DriverModule.class})
public class Test1 {

    private static Logger LOG = Logger.getLogger(Test1.class);
    private VideoPage videoPage;


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
	
    @Test()
    public void CheckExistingOfVideoBlock(){
        videoPage = mainPage.goToVideoPage();
        DriverUtils.waitForPageLoad(driver);
        Assert.assertTrue( videoPage.ChekVideoBlockPresent() , "VideoBlock doesn't exists" );
    }

    @Test(dependsOnMethods = "CheckExistingOfVideoBlock")
    public void CheckEntityOfVideoBlock(){
        videoPage.CheckVideoBlockSize();
        Assert.assertTrue( videoPage.CheckVideoBlockSize() , " Size of the VideoBlock doesn't equal to 3");
    }

}

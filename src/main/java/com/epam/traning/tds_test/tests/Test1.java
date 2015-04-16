package com.epam.traning.tds_test.tests;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.guice.module.DriverModule;
import com.epam.traning.tds_test.pages.MainPage;
import com.epam.traning.tds_test.pages.VideoPage;
import com.google.inject.Inject;
import com.guice.TestInjector;
import com.guice.annotation.Modules;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@Modules(modules = { DriverModule.class})
public class Test1 {

    private static Logger LOG = Logger.getLogger(Test1.class);
    private VideoPage videoPage;


    @Inject
    protected WebDriver webDriver;

    @Inject
    protected MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void injectElements(){
        TestInjector.injectMembers(this);
    }

    @BeforeTest(dependsOnMethods ="injectElements" )
    public void getConnection(){
        webDriver.get(ProjectConstants.HOME_URL);

    }


    @Test(dependsOnMethods = "getConnection")
    public void CheckExistingOfVideoBlock(){
        videoPage = mainPage.goToVideoPage();
        Assert.assertTrue(videoPage.check());
        Assert.assertTrue( videoPage.ChekVideoBlockPresent() , "VideoBlock doesn't exists" );
    }

    @Test(dependsOnMethods = "CheckExistingOfVideoBlock")
    public void CheckEntityOfVideoBlock(){
        videoPage.CheckVideoBlockSize();
        Assert.assertTrue( videoPage.CheckVideoBlockSize() , " Size of the VideoBlock doesn't equal to 3");
    }

}

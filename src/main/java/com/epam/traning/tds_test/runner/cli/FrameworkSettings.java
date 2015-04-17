package com.epam.traning.tds_test.runner.cli;

import java.util.List;

import org.testng.ISuite;

import com.selenium.driver.DriverType;

public class FrameworkSettings {

    private static FrameworkSettings browserSettings = new FrameworkSettings();

    private DriverType driverType;

    private List<ISuite> suites;

    private String version;

    private String appiumPort;

    private Boolean rerun;

    public List<ISuite> getSuites() {
	return suites;
    }

    public void setSuites(List<ISuite> suits) {
	this.suites = suits;
    }

    public Boolean getRerun() {
	return rerun;
    }

    public void setRerun(Boolean rerun) {
	this.rerun = rerun;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public static FrameworkSettings getInstance() {
	return browserSettings;
    }

    public DriverType getDriverType() {
	return driverType;
    }

    public void setDriverType(DriverType driverType) {
	this.driverType = driverType;
    }

    public String getAppiumPort() {
	return appiumPort;
    }

    public void setAppiumPort(String appiumPort) {
	this.appiumPort = appiumPort;
    }
}

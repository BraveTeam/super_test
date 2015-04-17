package com.epam.traning.tds_test.pages;

import org.openqa.selenium.WebDriver;

import com.epam.traning.tds_test.constants.ProjectConstants;

public class WatchNowPage extends AbstractPage {

	public WatchNowPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean check() {
		return driver.getCurrentUrl().contains(
				ProjectConstants.WATCHNOWPAGE_URL);
	}
}

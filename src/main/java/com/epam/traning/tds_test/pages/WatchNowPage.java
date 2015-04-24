package com.epam.traning.tds_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.selenium.loader.decorator.LoggedElementDecorator;

public class WatchNowPage extends AbstractPage {

	public WatchNowPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);

		if (!check())
			throw new CurrentPageDownloadException("WatchNowPage couldn't be identified");
	}

	@Override
	public boolean check() throws CurrentPageDownloadException {
		return driver.getTitle().contains(ProjectConstants.WATCHNOW_PAGE_TITLE);
	}
}

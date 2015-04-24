package com.epam.traning.tds_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.selenium.loader.decorator.LoggedElementDecorator;

public class MainPage extends AbstractPage {

	private static Logger LOG = Logger.getLogger(MainPage.class);

	private CommonPanelBlock commonPanelBlock;

	public MainPage(WebDriver driver, boolean openOnCreation) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);

		if (openOnCreation) {
			openPage(ProjectConstants.MAIN_PAGE_URL);
		}
		if (!check())
			throw new CurrentPageDownloadException("MainPage couldn't be identified");
	}

	@Override
	public boolean check() throws CurrentPageDownloadException {
		return driver.getTitle().contains(ProjectConstants.MAIN_PAGE_TITLE);
	}

	public VideoPage goToVideoPage() {
		commonPanelBlock.clickOnVideos();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
		return new VideoPage(driver, false);
	}

	public WatchNowPage goToWatchNowPage() {
		commonPanelBlock.clickOnWatchNow();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
		return new WatchNowPage(driver);
	}

}

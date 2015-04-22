package com.epam.traning.tds_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;

public class MainPage extends AbstractPage {

	private static Logger LOG = Logger.getLogger(MainPage.class);

	private CommonPanelBlock commonPanelBlock;

	public MainPage(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
		check();
	}

	@Override
	public boolean check() {
		return driver.getCurrentUrl().equals(ProjectConstants.HOME_URL);
	}

	public void openPage() {
		driver.get(ProjectConstants.HOME_URL);
		LOG.info("Opened URL: " + ProjectConstants.HOME_URL);
	}

	public VideoPage goToVideoPage() {
		commonPanelBlock.clickOnVideos();
		return new VideoPage(driver);
	}

	public WatchNowPage goToWatchNowPage() {
		commonPanelBlock.clickOnWatchNow();
		return new WatchNowPage(driver);
	}

}

package com.epam.traning.tds_test.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.annotations.Name;

import com.epam.traning.tds_test.constants.CommonConstants;
import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.selenium.element.Element;
import com.selenium.loader.decorator.LoggedElementDecorator;
import com.selenium.page.annotation.FindBy;

public class VideoPage extends AbstractPage {

	private static Logger LOG = Logger.getLogger(VideoPage.class);

	private CommonPanelBlock commonPanelBlock;

	public VideoPage(WebDriver driver, boolean openOnCreation) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);

		if (openOnCreation) {
			openPage(ProjectConstants.VIDEO_PAGE_URL);
		}
		if (!check())
			throw new CurrentPageDownloadException("VideoPage couldn't be identified");
	}

	@Name("Block with videos")
	@FindBy(xpath = "//div[contains(@class,'module ent_m043')]")
	private Element videoBlock;

	@Name("Watch Now button ")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Element buttonWatchNow;

	@Name("List of videos")
	@FindBy(xpath = "//div[@class='module ent_m043_tds_v1 generic section']//li")
	private List<Element> videoBlockEntity;

	@Override
	public boolean check() throws CurrentPageDownloadException {
		return driver.getTitle().contains(ProjectConstants.VIDEO_PAGE_TITLE);
	}

	public boolean checkVideoBlockPresent() {
		return DriverUtils.isElementPresent(videoBlock);
	}

	public int checkVideoBlockSize() {
		return videoBlockEntity.size();
	}

	public MainPage goToMainPage() {
		commonPanelBlock.clickOnMainPageLink();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
		return new MainPage(driver, false);
	}

	public WatchNowPage goToWachNowPage() {
		buttonWatchNow.click();
		LOG.info("Waiting for page load. Timeout=" + CommonConstants.DEFAULT_PAGE_LOAD_TIMEOUT + " sec.");
		DriverUtils.waitForPageLoad(driver);
		return new WatchNowPage(driver);
	}

}

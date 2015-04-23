package com.epam.traning.tds_test.pages;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.selenium.element.Element;
import com.selenium.loader.decorator.LoggedElementDecorator;
import com.selenium.page.annotation.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class MainPage extends AbstractPage {

//	private static Logger LOG = Logger.getLogger(MainPage.class);

	private CommonPanelBlock commonPanelBlock;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);
		try {
			check();
		}catch (CurrentPageDownloadException e){
		}
	}

	@Name("Title of Mainpage")
	@FindBy(xpath = "//title[contains(text(),'The Daily Show with Jon Stewart - Political Comedy | Comedy Central')]")
	private Element mainPageTitle;

	@Override
	public void check() throws CurrentPageDownloadException{
		if(!mainPageTitle.isExists()){
			throw new CurrentPageDownloadException("MainPage couldn't be identified");
		}
	}



	public void openPage() {
		driver.get(ProjectConstants.HOME_URL);
//		LOG.info("Opened URL: " + ProjectConstants.HOME_URL);
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

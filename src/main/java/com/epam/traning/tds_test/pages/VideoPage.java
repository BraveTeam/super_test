package com.epam.traning.tds_test.pages;

import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.selenium.element.Element;
import com.selenium.loader.decorator.LoggedElementDecorator;
import com.selenium.page.annotation.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class VideoPage extends AbstractPage {

	private CommonPanelBlock commonPanelBlock;


	public VideoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);
		DriverUtils.waitForPageLoad(driver);
		try {
			check();
		}catch (CurrentPageDownloadException e){
		}

	}

	@Name("Title of VideoPage")
	@FindBy(xpath = "//title[contains(text(),'The Daily Show | Recent and Popular Videos | Comedy Central']")
	private Element videoPageTitle;


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
	public void check() throws CurrentPageDownloadException{
		if(!videoPageTitle.isExists()){
			throw new CurrentPageDownloadException("VideoPage couldn't be identified");
		}
	}

	public boolean checkVideoBlockPresent() {
		return DriverUtils.isElementPresent(videoBlock);
	}

	public int checkVideoBlockSize() {
		return videoBlockEntity.size();
	}

	public MainPage goToMainPage() {
		commonPanelBlock.clickOnMainPageLink();
		return new MainPage(driver);
	}

	public void goToWachNowPage() {
		buttonWatchNow.click();
	}

}

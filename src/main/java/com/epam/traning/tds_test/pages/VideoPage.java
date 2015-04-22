package com.epam.traning.tds_test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.annotations.Name;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.epam.traning.tds_test.utils.DriverUtils;
import com.selenium.element.Element;
import com.selenium.loader.decorator.LoggedElementDecorator;
import com.selenium.page.annotation.FindBy;

public class VideoPage extends AbstractPage {

	private CommonPanelBlock commonPanelBlock;

	public VideoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new LoggedElementDecorator(driver), this);
	}

	@Name("Block with videos")
	@FindBy(xpath = "//div[contains(@class,'module ent_m043')]")
	private Element video_block;

	@Name("Watch Now button ")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Element button_watchNow;

	@Name("List of videos")
	@FindBy(xpath = "//div[@class='module ent_m043_tds_v1 generic section']//li")
	private List<Element> video_block_entity;

	@Override
	public boolean check() {
		return driver.getCurrentUrl().equals(ProjectConstants.HOME_URL);
	}

	public boolean ChekVideoBlockPresent() {
		return DriverUtils.isElementPresent(video_block);
	}

	public boolean CheckVideoBlockSize() {
		return video_block_entity.size() == 3;
	}

	public MainPage goToMainPage() {
		commonPanelBlock.clickOnMainPageLink();
		return new MainPage(driver);
	}

	public void goToWachNowPage() {
		button_watchNow.click();
	}

}

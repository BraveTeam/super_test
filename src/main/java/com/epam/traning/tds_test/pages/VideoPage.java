package com.epam.traning.tds_test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.pages.blocks.CommonPanelBlock;
import com.epam.traning.tds_test.utils.DriverUtils;

public class VideoPage extends AbstractPage {

	private CommonPanelBlock commonPanelBlock;

	public VideoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
		HtmlElementLoader.populatePageObject(this, driver);

	}

	@Name("Block with videos")
	@FindBy(xpath = "//div[contains(@class,'module ent_m043')]")
	private WebElement video_block;

	@Name("Watch Now button ")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Button button_watchNow;

	@Name("List of videos")
	@FindBy(xpath = "//div[@class='module ent_m043_tds_v1 generic section']//li")
	private List<WebElement> video_block_entity;

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

package com.epam.traning.tds_test.pages.blocks;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Block(@FindBy(id = "header"))
public class CommonPanelBlock extends HtmlElement {

	private static Logger LOG = Logger.getLogger(CommonPanelBlock.class);

	@Name("Full Episodes section")
	@FindBy(className = " full_episodes")
	private Button button_episodes;

	@Name("Videos section")
	@FindBy(xpath = "//a[@class=' videos']")
	private Button button_videos;

	@Name("Interviews section")
	@FindBy(className = " extended_interviews")
	private Button button_interviews;

	@Name("Guests section")
	@FindBy(className = " guests")
	private Button button_guests;

	@Name("News Team section")
	@FindBy(className = "  news_team")
	private Button button_news_team;

	@Name("Podcast section")
	@FindBy(className = "  podcast")
	private Button button_podcast;

	@Name("Tickets section")
	@FindBy(className = " tickets")
	private Button button_tickets;

	@Name("GoHome section")
	@FindBy(xpath = "//a[href='http://thedailyshow.cc.com/']")
	private Link button_main_page;

	@Name("Watch now Button")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Button button_watch_now;

	public void clickOnVideos() {
		button_videos.click();
		LOG.info("Pressed the 'Video' button");
	}

	public void clickOnWatchNow() {
		button_watch_now.click();
		LOG.info("Pressed the 'Watch Now' button");
	}

	public void clickOnMainPageLink() {
		button_main_page.click();
	}
}

package com.epam.traning.tds_test.pages.blocks;

import org.apache.log4j.Logger;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import com.selenium.element.Element;
import com.selenium.page.annotation.Block;
import com.selenium.page.annotation.FindBy;

@Block(@FindBy(id = "header"))
public class CommonPanelBlock extends HtmlElement {

	private static Logger LOG = Logger.getLogger(CommonPanelBlock.class);

	@Name("Full Episodes section")
	@FindBy(className = " full_episodes")
	private Element button_episodes;

	@Name("Videos section")
	@FindBy(xpath = "//a[@class=' videos']")
	private Element button_videos;

	@Name("Interviews section")
	@FindBy(className = " extended_interviews")
	private Element button_interviews;

	@Name("Guests section")
	@FindBy(className = " guests")
	private Element button_guests;

	@Name("News Team section")
	@FindBy(className = "  news_team")
	private Element button_news_team;

	@Name("Podcast section")
	@FindBy(className = "  podcast")
	private Element button_podcast;

	@Name("Tickets section")
	@FindBy(className = " tickets")
	private Element button_tickets;

	@Name("GoHome section")
	@FindBy(xpath = "//a[href='http://thedailyshow.cc.com/']")
	private Element button_main_page;

	@Name("Watch now Button")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Element button_watch_now;

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

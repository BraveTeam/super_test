package com.epam.traning.tds_test.pages.blocks;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import com.selenium.element.Element;
import com.selenium.page.annotation.Block;
import com.selenium.page.annotation.FindBy;

@Block(@FindBy(id = "header"))
public class CommonPanelBlock extends HtmlElement {



	@Name("Full Episodes section")
	@FindBy(className = " full_episodes")
	private Element buttonEpisodes;

	@Name("Videos section")
	@FindBy(xpath = "//a[@class=' videos']")
	private Element buttonVideos;

	@Name("Interviews section")
	@FindBy(className = " extended_interviews")
	private Element buttonInterviews;

	@Name("Guests section")
	@FindBy(className = " guests")
	private Element buttonGuests;

	@Name("News Team section")
	@FindBy(className = "  news_team")
	private Element buttonNewsTeam;

	@Name("Podcast section")
	@FindBy(className = "  podcast")
	private Element buttonPodcast;

	@Name("Tickets section")
	@FindBy(className = " tickets")
	private Element buttonTickets;

	@Name("GoHome section")
	@FindBy(xpath = "//a[href='http://thedailyshow.cc.com/']")
	private Element buttonMainPage;

	@Name("Watch now Button")
	@FindBy(xpath = "//div[@class='watch-now']")
	private Element buttonWatchNow;

	public void clickOnVideos() {
		buttonVideos.click();
	}

	public void clickOnWatchNow() {
		buttonWatchNow.click();
	}

	public void clickOnMainPageLink() {
		buttonMainPage.click();
	}
}

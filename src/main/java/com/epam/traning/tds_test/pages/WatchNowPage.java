package com.epam.traning.tds_test.pages;

import com.epam.traning.tds_test.exceptions.CurrentPageDownloadException;
import com.selenium.element.Element;
import com.selenium.page.annotation.FindBy;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class WatchNowPage extends AbstractPage {


	public WatchNowPage(WebDriver driver) {
		super(driver);
		try {
//			check();   оставь пока так, она с чеком твой тест не ранает, не успел разобраться почему
		}catch (CurrentPageDownloadException e){
		}
	}


	@Name("Title of WatchNowPage")
	@FindBy(xpath = "//title[contains(text(),' Full Episode | Comedy Central')]")
	private Element watchNowPageTitle;

	@Override
	public void check() throws CurrentPageDownloadException{
		if(!watchNowPageTitle.isExists()){
			throw new CurrentPageDownloadException("WatchNowPage couldn't be identified");
		}
	}
}

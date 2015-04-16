package com.epam.traning.tds_test.pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import com.epam.traning.tds_test.constants.ProjectConstants;
import com.epam.traning.tds_test.pages.yandex_elements.CommonPanelBlock;

public class MainPage  extends AbstractPage{

    private CommonPanelBlock commonPanelBlock;

    public MainPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);

    }

    @Override
    public boolean check() {
        return false;
    }

	public void openPage(){
		driver.get(ProjectConstants.HOME_URL);
	}

    public VideoPage goToVideoPage(){
        commonPanelBlock.clickOnVideos();
        return new VideoPage(driver);
    }

}

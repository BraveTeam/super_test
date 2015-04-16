package com.epam.traning.tds_test.pages;

import com.epam.traning.tds_test.constants.ProjectConstants;
import org.openqa.selenium.WebDriver;

public class WatchNowPage extends AbstractPage {


    public WatchNowPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean check() {
        return driver.getCurrentUrl().equals(ProjectConstants.WATCHNOWPAGE_URL);
    }
}

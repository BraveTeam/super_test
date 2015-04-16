package com.epam.traning.tds_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  abstract class AbstractPage {

    protected WebDriver driver;


    public AbstractPage(WebDriver driver){
        this.driver=driver;
    }


    public abstract boolean check();





}

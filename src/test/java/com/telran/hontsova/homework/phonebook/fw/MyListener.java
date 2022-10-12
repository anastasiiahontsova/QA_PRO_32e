package com.telran.hontsova.homework.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    protected Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Trying to find element by locator:" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Found element by locator" + by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.debug("Exception caught!" + throwable.getMessage());
        logger.debug(throwable.fillInStackTrace().toString());
    }
}

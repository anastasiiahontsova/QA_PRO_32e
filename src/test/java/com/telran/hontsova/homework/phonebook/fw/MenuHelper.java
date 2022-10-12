package com.telran.hontsova.homework.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuHelper extends BaseHelper {

    public static final String LOGOUT_BTN_XPATH_SELECTOR_STR = "//button[text()='Sign Out']";


    public MenuHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isUserSignedIn() {
        return isWebElementPresent(By.xpath(LOGOUT_BTN_XPATH_SELECTOR_STR));
    }

    public boolean isUserRegistered() {
        return isWebElementPresent(By.xpath(LOGOUT_BTN_XPATH_SELECTOR_STR));
    }


}
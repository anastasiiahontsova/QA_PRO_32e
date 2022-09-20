package com.telran.hontsova.qa.pro.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static final String PHONE_BOOK_HOME_PAGE_STR = "https://contacts-app.tobbymarshall815.vercel.app/home";
    static final int IMPLICIT_WAIT_TIME_SEC = 10;
    static final int TIMEOUT_SLEEP_TIME_SEC = 3;
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver = new ChromeDriver();
        // create a user - skipped to simplify
        // open web page
        webDriver.navigate().to(PHONE_BOOK_HOME_PAGE_STR);
        //wait till it's loaded
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(TIMEOUT_SLEEP_TIME_SEC);
        webDriver.quit();
    }
}
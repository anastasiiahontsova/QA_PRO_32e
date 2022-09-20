package com.telran.hontsova.qa.pro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestProject {
    WebDriver webDriver;


    //beforeSteps
    @BeforeMethod
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiahontsova/Desktop/TelRan/QA_lessons/QA_PRO/Tools/chromedriver");
        webDriver = new ChromeDriver();
    }
    //test
    @Test
    public void openGooglePage(){
        webDriver.get("https://www.google.com/");

    }
    //afterSteps
    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        webDriver.quit();

    }
}

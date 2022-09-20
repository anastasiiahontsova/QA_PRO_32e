package com.telran.hontsova.qa.pro.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework9 {
    WebDriver webDriver;

//    @BeforeMethod
//    public void SetUp()
//    {
//        System.setProperty("webdriver.chrome.driver","/Users/anastasiiahontsova/Desktop/TelRan/QA_lessons/QA_PRO/Tools/chromedriver");
//        webDriver = new ChromeDriver();
//    }
//
//    @Test
//    public void openWebSitePage(){
//        webDriver.get("https://www.saucedemo.com/");
//    }
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
//        //TimeUnit.MINUTES.sleep(1);
//        webDriver.quit();
//    }
//}

    @BeforeMethod
    public void SetUp (){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiahontsova/Desktop/TelRan/QA_lessons/QA_PRO/Tools/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/");
    }

//    @Test
//    public void testLocatorsByTagName(){
//        WebElement webElementByTagName1 = webDriver.findElement(By.tagName("input"));
//        System.out.println("webElementByTagName:  " + webElementByTagName1.getText());
//
//        List<WebElement> webElementsByTagName1 = webDriver.findElements(By.tagName("input"));
//        System.out.println("webElements.size(): " + webElementsByTagName1.size());
//
//        WebElement webElementByTagName2 = webDriver.findElement(By.tagName("script"));
//        System.out.println("webElementByTagName:  " + webElementByTagName2.getText());
//
//        List<WebElement> webElementsByTagName2 = webDriver.findElements(By.tagName("script"));
//        System.out.println("webElements.size(): " + webElementsByTagName2.size());
//    }

    @Test
    public void testLocatorsByID(){
        WebElement webElementById1 = webDriver.findElement(By.id("root"));
        System.out.println("webElementById: " + webElementById1.getText());

        List<WebElement> webElementsByID1 = webDriver.findElements(By.tagName("root"));
        System.out.println("webElements by tagName size(): " + webElementsByID1.size());

        WebElement webElementById2 = webDriver.findElement(By.id("user-name"));
        System.out.println("webElementById: " + webElementById2.getText());

        List<WebElement> webElementsByID2 = webDriver.findElements(By.tagName("user-name"));
        System.out.println("webElements by tagName size(): " + webElementsByID2.size());

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        webDriver.quit();
    }
}



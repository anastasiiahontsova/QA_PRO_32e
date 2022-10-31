//package com.telran.hontsova.homework;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class Homework10 {
//    WebDriver webDriver;
//
//    @BeforeMethod
//    public void setUp() {
//        //System.setProperty("webdriver.chrome.driver","/Users/anastasiiahontsova/Desktop/TelRan/QA_lessons/QA_PRO/Tools/chromedriver");
//        webDriver = new ChromeDriver();
//        webDriver.navigate().to("http://automationpractice.com/");
//    }
//
//    @Test
//    public void testLocatorsForSearchInput() {
//        WebElement searchInputWebElement1 = webDriver.findElement(By.id("search_query_top"));                           //by ID (by.id selector)
//        System.out.println("Search Input web element 1: " + searchInputWebElement1.isDisplayed());                      //the best way to find a web element
//
//        WebElement searchInputWebElement2 = webDriver.findElement(By.cssSelector("#search_query_top"));                  //by ID (css selector) is also the best way
//        System.out.println("Search Input web element 2: " + searchInputWebElement2.isDisplayed());                       //the best way to find a web element
//
//        WebElement searchInputWebElement3 = webDriver.findElement(By.name("search_query"));                              //by name (by.name selector)
//        System.out.println("Search Input web element 3: " + searchInputWebElement3.isDisplayed());
//
//        WebElement searchInputWebElement4 = webDriver.findElement(By.className("search_query"));                         //by class name (by.className selector)
//        System.out.println("Search Input web element 4: " + searchInputWebElement4.isDisplayed());
//
//        WebElement searchInputWebElement5 = webDriver.findElement(By.cssSelector(".search_query"));                      //by class name (css selector)
//        System.out.println("Search Input web element 5: " + searchInputWebElement5.isDisplayed());
//
//        WebElement searchInputWebElement6 = webDriver.findElement(By.cssSelector(".search_query.form-control.ac_input"));//by full class name if containing
//        System.out.println("Search Input web element 6: " + searchInputWebElement6.isDisplayed());                       //several class names inside one class
//
//        WebElement searchInputWebElement7 = webDriver.findElement(By.cssSelector("[class*='ac_input']"));               //by class name (substring) - contains text
//        System.out.println("Search Input web element 7: " + searchInputWebElement7.isDisplayed());
//
//        WebElement searchInputWebElement8 = webDriver.findElement(By.cssSelector("[class^='search_query']"));           //by class name (substring) - begins with text
//        System.out.println("Search Input web element 8: " + searchInputWebElement8.isDisplayed());
//
//        WebElement searchInputWebElement9 = webDriver.findElement(By.cssSelector("[class$='ac_input']"));               //by class name (substring) - ends with text
//        System.out.println("Search Input web element 9: " + searchInputWebElement9.isDisplayed());
//
//        WebElement searchInputWebElement10 = webDriver.findElement(By.cssSelector(".col-sm-4 .search_query"));           //by parent and descendant short class names
//        System.out.println("Search Input web element 10: " + searchInputWebElement10.isDisplayed());
//
//        WebElement searchInputWebElement11 = webDriver.findElement(By.cssSelector(".col-sm-4 .search_query.form-control.ac_input")); //by parent and descendant
//        System.out.println("Search Input web element 11: " + searchInputWebElement11.isDisplayed());                                 //full class names
//
//        WebElement searchInputWebElement12 = webDriver.findElement(By.xpath("//*[@id=\"search_query_top\"]")); //by.xpath-also a good way to find web el
//        System.out.println("Search Input web element 12: " + searchInputWebElement12.isDisplayed());
//
////        WebElement searchInputWebElement13 = webDriver.findElement(By.tagName("input"));                               //by tag name (by.tag.name selector)
////        System.out.println("Search Input web element 13: " + searchInputWebElement13.getText());
////
////        WebElement searchInputWebElement14 = webDriver.findElement(By.cssSelector(".input"));                          //by tag name (css selector)
////        System.out.println("Search Input web element 14: " + searchInputWebElement14.getText());
//
//    }
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
//        webDriver.quit();
//    }
//
//}

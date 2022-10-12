package com.telran.hontsova.homework.phonebook.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseHelper {

    public static final String VALID_USER_EMAIL = "testaddcontact@gmail.com";
    public static final String VALID_USER_PSW = "Test123456789!_";
    public static final String INVALID_USER_EMAIL = "invalidtestaddcontact@gmail.com";
    public static final String INVALID_USER_PSW = "invalidTest123456789!_";
    protected WebDriver webDriver;
    public BaseHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillInputField(By locator, String key) {
        WebElement inputFieldWebElement = webDriver.findElement(locator);
        inputFieldWebElement.clear();
        inputFieldWebElement.click();
        inputFieldWebElement.sendKeys(key);

    }

    public void selectInputField(By locator) {
        WebElement inputFieldWebElement = webDriver.findElement(locator);
        inputFieldWebElement.clear();
        inputFieldWebElement.click();
    }

    public boolean isWebElementPresent(By locator) {

        return webDriver.findElements(locator).size() > 0;

    }

    public void clickButton(By buttonLocator) {
        WebElement existingContact = webDriver.findElement(buttonLocator);
        existingContact.click();
    }

    public void clickOnErrorAlert() {
        Alert invalidEmailOrPwdAlert = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        invalidEmailOrPwdAlert.accept();
    }

    public void isWebElementDisplayed(By locator, String message) {
        int webElementSize = webDriver.findElements(locator).size();
        if (webElementSize > 0)
            System.out.println("Web element is present");
        else
            System.out.println("Web element is absent!");
    }


}


package com.telran.hontsova.qa.pro.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class PhoneBookLoginPage extends TestBase {
    static final String SIGNED_IN_MESSAGE_STR = "Signed in!";
    static final String LOG_OUT_BUTTON_CSS_STR = "button";
    static final String MESSAGE_DISPLAYED_SIZE_OF_ARRAY_STR = "Size of array of WebElements by cssSelector('button'): ";
    static final String LOG_OUT_BUTTON_IS_PRESENT_1_ASSERTION_MSG_STR = "Log Out button is present";
    static final String LOG_OUT_BUTTON_IS_PRESENT_2_ASSERTION_MSG_STR = "Log Out button is present (second aassertion)";
    static final String USER_PWR_STR = "ZZxcv_1!";
    static final String LOGIN_BUTTON_CSS_SELECTOR_STR = "button:nth-child(4)";
    static final String CONTACT_PAGE_CLASS_NAME = "contact-page_main__32Irj";
    static final String PWD_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(2)";
    static final int WAITING_TIME_SEC = 10;
    static final String LOGIN_PAGE_URL_STR = "https://contacts-app.tobbymarshall815.vercel.app/login";
    static final String LOGIN_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(1)";
    static final String LOGIN_FORM_CLASS_NAME = "login_login__3EHKB";
    static final String USER_EMAIL_STR = "michael@gmail.com";

    @BeforeMethod
    public void loginSetUp(){
        // navigate straight to the login page
        webDriver.navigate().to(LOGIN_PAGE_URL_STR);
        //wait till it's loaded
        webDriver.manage().timeouts().implicitlyWait(WAITING_TIME_SEC, TimeUnit.SECONDS);
        WebElement loginFormLoaded = webDriver.findElement(By.className(LOGIN_FORM_CLASS_NAME));
    }

    @Test
    public void testLoginForm() throws InterruptedException {
        // enter email
        WebElement loginInputField = webDriver.findElement(By.cssSelector(LOGIN_CSS_SELECTOR_STR));
        loginInputField.click();
        loginInputField.sendKeys(USER_EMAIL_STR);
        // enter pwd
        WebElement pwdInputField = webDriver.findElement(By.cssSelector(PWD_CSS_SELECTOR_STR));
        pwdInputField.click();
        pwdInputField.sendKeys(USER_PWR_STR);
        // click Login Btn
        WebElement loginBtn = webDriver.findElement(By.cssSelector(LOGIN_BUTTON_CSS_SELECTOR_STR));
        loginBtn.click();
        //wait till the page is loaded
        WebElement firstContactPageResult = new WebDriverWait(webDriver, WAITING_TIME_SEC)
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.className(CONTACT_PAGE_CLASS_NAME))));
        // check that the user is signed in
        // Option 1:
        int logOutButtonArraySize = webDriver.findElements(By.cssSelector(LOG_OUT_BUTTON_CSS_STR)).size();
        System.out.println(MESSAGE_DISPLAYED_SIZE_OF_ARRAY_STR + logOutButtonArraySize);
        // todo: change to xpath
        Assert.assertTrue(logOutButtonArraySize == 1,LOG_OUT_BUTTON_IS_PRESENT_1_ASSERTION_MSG_STR);
        Assert.assertEquals(logOutButtonArraySize,1,LOG_OUT_BUTTON_IS_PRESENT_2_ASSERTION_MSG_STR);
        // Option 2: try-catch

        System.out.println(SIGNED_IN_MESSAGE_STR);
    }

}

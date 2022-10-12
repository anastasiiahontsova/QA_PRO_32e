package com.telran.hontsova.homework.phonebook.fw;

import com.telran.hontsova.homework.phonebook.model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PhoneBookLoginPageHelper extends BaseHelper {
    public static final String LOGIN_FAILED_400_ERROR_MSG_TEXT_STR = "Login Failed with code 400";
    public static final String LOGIN_ERROR_MSG_XPATH_SELECTOR_STR = "//div[text() = '$loginFailedMessageTxt']";
    public static final String LOGIN_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(1)";
    public static final String PWD_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(2)";
    public static final String LOGIN_BTN_XPATH_SELECTOR_STR = "//button[contains(text(), 'Login')]";


    public PhoneBookLoginPageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void loginUser() {
        fillAndSubmitLoginFormWithParameters(new User(VALID_USER_EMAIL, VALID_USER_PSW));
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        isUserSignedIn();
    }


    public void fillAndSubmitLoginForm() {
        fillInputField(By.cssSelector(LOGIN_CSS_SELECTOR_STR), VALID_USER_EMAIL);
        fillInputField(By.cssSelector(PWD_CSS_SELECTOR_STR), VALID_USER_PSW);
        WebElement loginBtn = webDriver.findElement(By.xpath(LOGIN_BTN_XPATH_SELECTOR_STR));
        loginBtn.click();
    }

    public void fillAndSubmitLoginFormWithParameters(User user) {
        fillInputField(By.cssSelector(LOGIN_CSS_SELECTOR_STR), user.getEmail());
        fillInputField(By.cssSelector(PWD_CSS_SELECTOR_STR), user.getPwd());
        WebElement loginBtn = webDriver.findElement(By.xpath(LOGIN_BTN_XPATH_SELECTOR_STR));
        loginBtn.click();
    }

    public boolean isUserSignedIn() {
        if (isWebElementPresent(By.cssSelector("button:nth-child(4)"))) {
            isWebElementPresent(By.className("login_login__3EHKB"));
            return true;
        } else return false;
    }

    public boolean isLoginErrorMessagePresent(String errorMsgTextStr) {
        return webDriver.findElements(By.xpath(LOGIN_ERROR_MSG_XPATH_SELECTOR_STR.replace
                ("$loginFailedMessageTxt", LOGIN_FAILED_400_ERROR_MSG_TEXT_STR))).size() > 0;
    }

    public void clickOnErrorAlert() {
        Alert invalidEmailOrPwdAlert = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert();
        invalidEmailOrPwdAlert.accept();
    }

    public boolean isWebElementPresent(By locator) {

        return webDriver.findElements(locator).size() > 0;
    }

}




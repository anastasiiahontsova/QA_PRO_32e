package com.telran.hontsova.homework.phonebook.fw;

import com.telran.hontsova.homework.phonebook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PhoneBookRegistrationPageHelper extends BaseHelper {

    public PhoneBookRegistrationPageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void registerUser(User user) throws InterruptedException {
        fillInputField(By.cssSelector(".login_login__3EHKB input:nth-child(1)"), generateUserEmail());
        TimeUnit.SECONDS.sleep(3);
        fillInputField(By.cssSelector(".login_login__3EHKB input:nth-child(2)"), VALID_USER_PSW);
        TimeUnit.SECONDS.sleep(3);
        WebElement registerBtn = webDriver.findElement(By.cssSelector("button:nth-child(5)"));
        registerBtn.click();

    }

    public String generateUserEmail() {
        return "mail" + System.currentTimeMillis() + "@mail.com";
    }
}




package com.telran.hontsova.homework.phonebook.tests;


import com.telran.hontsova.homework.phonebook.fw.DataProviders;
import com.telran.hontsova.homework.phonebook.fw.TestBase;
import com.telran.hontsova.homework.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PhoneBookLoginPageTests extends TestBase {


    @Test(dataProvider = "newUsersFromFilePositive", dataProviderClass = DataProviders.class)
    public void testLoginFormWithDataProviderFromFilePositive(User user) {
        app.goToLoginPage();
        app.getPhoneBookLoginPageHelper().fillAndSubmitLoginFormWithParameters(user);
        app.getPhoneBookLoginPageHelper().waitForPageToLoad();
        Assert.assertTrue(app.getMenuHelper().isUserSignedIn(), "Log Out button is present");
    }


    @Test(dataProvider = "newUsersFromFileNegative", dataProviderClass = DataProviders.class)
    public void testLoginFormWithDataProviderFromFileNegative(User user) {
        app.goToLoginPage();
        app.getPhoneBookLoginPageHelper().fillAndSubmitLoginFormWithParameters(user);
        app.getPhoneBookLoginPageHelper().clickOnErrorAlert();
        app.getPhoneBookLoginPageHelper().waitForPageToLoad();
        Assert.assertTrue(app.getPhoneBookLoginPageHelper().isFailedLoginMessagePresent("Login Failed with code"), "Login error message is present");
    }
}






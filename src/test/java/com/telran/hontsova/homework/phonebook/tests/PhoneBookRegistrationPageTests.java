package com.telran.hontsova.homework.phonebook.tests;


import com.telran.hontsova.homework.phonebook.fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PhoneBookRegistrationPageTests extends TestBase {


    @BeforeMethod
    public void SetUp() {
        app.goToRegistrationPage();
    }

    @Test
    public void TestRegistration() throws InterruptedException {

        app.getPhoneBookRegistrationPageHelper().registerUser(NewGeneratedUser);
        Assert.assertTrue(app.getMenuHelper().isUserSignedIn(), "New user is registered and signed in");
    }


}






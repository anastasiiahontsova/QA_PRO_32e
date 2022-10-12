package com.telran.hontsova.homework.phonebook.tests;


import com.telran.hontsova.homework.phonebook.fw.TestBase;
import com.telran.hontsova.homework.phonebook.model.Contact;
import com.telran.hontsova.homework.phonebook.fw.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhoneBookContactsPageTests extends TestBase {


    @BeforeMethod
    public void loginUserSetUp() {
        app.goToLoginPage();
        app.getPhoneBookLoginPageHelper().loginUser();
    }


    @Test(dataProvider = "userDataToAddNewContact", dataProviderClass = DataProviders.class)
    public void testAddAndRemoveContactPositive(Contact contact) throws InterruptedException {
        app.goToAddContactsPage();
        app.getPhoneBookContactsPageHelper().fillUserInfoFieldsFormToAddContact(contact);
        Assert.assertTrue(app.getPhoneBookContactsPageHelper().getContactCardsAmount() > 0, "Contact is added");
        app.getPhoneBookContactsPageHelper().removeContact();
        //app.getPhoneBookContactsPageHelper().setImplicitWaitTimeSec();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(app.getPhoneBookContactsPageHelper().getContactCardsAmount() == 0, "Contact is deleted");
    }


    @Test(dataProvider = "UserDataFromFileToAddNewContact", dataProviderClass = DataProviders.class)
    public void testAddAndRemoveContactPositiveFromFile(Contact contact) throws InterruptedException {
        app.goToAddContactsPage();
        app.getPhoneBookContactsPageHelper().fillUserInfoFieldsFormToAddContact(contact);
        Assert.assertTrue(app.getPhoneBookContactsPageHelper().getContactCardsAmount() > 0, "Contact is added");
        app.getPhoneBookContactsPageHelper().removeContact();
        //app.getPhoneBookContactsPageHelper().setImplicitWaitTimeSec();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(app.getPhoneBookContactsPageHelper().getContactCardsAmount() == 0, "Contact is deleted");
    }


}



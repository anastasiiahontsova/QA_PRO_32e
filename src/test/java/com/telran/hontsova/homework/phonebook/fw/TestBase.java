package com.telran.hontsova.homework.phonebook.fw;


import com.telran.hontsova.homework.phonebook.model.User;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    public static final String VALID_USER_EMAIL = "testaddcontact@gmail.com";
    public static final String VALID_USER_PSW = "Test123456789!_";
    public static final String INVALID_USER_EMAIL = "invalidtestaddcontact@gmail.com";
    public static final String INVALID_USER_PSW = "invalidTest123456789!_";
    public static final String HOME_PAGE_URL_STR = "https://contacts-app.tobbymarshall815.vercel.app/home";
    public static final String LOGIN_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(1)";
    public static final String PWD_CSS_SELECTOR_STR = ".login_login__3EHKB input:nth-child(2)";
    public static final String LOGIN_BTN_CSS_SELECTOR_STR = "button:nth-child(4)";
    public static final String ERROR_MSG_TEXT_STR = "Login Failed with code 400";
    public static final String LOGIN_FAILED_400_ERROR_MSG_TEXT_STR = "Login Failed with code 400";
    public static final String VALID_USER_PWD_STR = "ZZxcv_1!";
    public static final String SIGN_OUT_BTN_XPATH_SELECTOR_STR = "//button[text()='Sign Out']";
    public static final String LOGIN_PAGE_URL_STR = "https://contacts-app.tobbymarshall815.vercel.app/login";
    public static final String LOGIN_FORM_CLASS_NAME = "login_login__3EHKB";
    //public static final String VALID_USER_EMAIL_STR = "michael@gmail.com";
    //public static final String INVALID_USER_PWD_STR = "invalid_user_pwd";
    public static final String LOGIN_ERROR_MSG_XPATH_SELECTOR_STR = "//div[text() = '$loginFailedMessageTxt']";
    public static final String FAIL_MESSAGE_STR = "Fail!";
    public static final String ADD_CONTACT_PAGE_URL = "https://contacts-app.tobbymarshall815.vercel.app/add";
    public static final String VALID_EMAIL_FOR_ADD_REMOVE_CONTACT_TEST = "testaddcontact@gmail.com";
    public static final String VALID_PSW_FOR_ADD_REMOVE_CONTACT_TEST = "Test123456789!_";
    public static final String CONTACTS_PAGE_URL = "https://contacts-app.tobbymarshall815.vercel.app/contacts";
    public static final String LOG_OUT_BTN_PRESENT_MESSAGE = "User is signed in. Log out button is present.";
    public static final String EXISTING_CONTACT_CSS = ".contact-item_card__2SOIM";
    public static final String REMOVE_CONTACT_BTN_XPATH = "//button[contains(text(),'Remove')]";
    public static final String NO_CONTACTS_HERE_XPATH = "//h1[contains(text(),  'No Contacts here!')]";
    public static final String NO_CONTACTS_HERE_MESSAGE = "Contact deleted. No contacts here!";
    static final int WAITING_TIME_SEC = 10;
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    public User NewGeneratedUser = new User(generateUserEmail(), "Test123456789!_");
    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    public String generateUserEmail() {
        return "email" + System.currentTimeMillis() + "@gmail.com";
    }

    @BeforeMethod
    public void setUp() {
        app.initApp();
    }

    @BeforeMethod
    public void setBeforeTestLogger(Method method) {
        logger.info("Start test by Anastasiia.");
    }

    @AfterMethod
    public void setAfterTestLogger(Method method) {
        logger.info("Stop test" + method.getName() + "by Anastasiia.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws InterruptedException {
        if (!result.isSuccess()) app.takeScreenShot();
        app.stopApp();
    }


}





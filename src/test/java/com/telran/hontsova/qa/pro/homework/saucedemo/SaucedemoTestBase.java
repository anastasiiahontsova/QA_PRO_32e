package com.telran.hontsova.qa.pro.homework.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaucedemoTestBase {
    static WebDriver webDriver;
    static final int SLEEP_TIME_SEC = 3;
    static final String SAUCEDEMO_HOME_PAGE_URL = "https://www.saucedemo.com./";
    static final int IMPLICIT_WAIT_TIME_SEC = 10;
    static final String USERNAME_FIELD_ID = "user-name";
    static final String EMAIL_FOR_LOGIN = "standard_user";
    static final String PSW_FIELD_ID = "password";
    static final String PSW_FOR_LOGIN = "secret_sauce";
    static final String LOGIN_BUTTON_ID = "login-button";
    static final String BURGER_MENU_ID = "react-burger-menu-btn";
    static final String MESSAGE_IF_LOGIN_SUCCESS = "User is logged in";
    static final String MESSAGE_IF_LOGIN_FAIL = "Fail! User is not logged in";
    static final String SAUCEDEMO_PRODUCTS_PAGE_URL = "https://www.saucedemo.com./inventory.html";
    static final String ADD_TO_CART_BOLT_T_SHIRT_BTN_ID = "add-to-cart-sauce-labs-bolt-t-shirt";
    static final String REMOVE_FROM_CART_BOLT_T_SHIRT_BTN_ID = "remove-sauce-labs-bolt-t-shirt";
    static final String ADD_TO_CART_LABS_BACKPACK_BTN_ID = "add-to-cart-sauce-labs-backpack";
    static final String ADD_TO_CART_LABS_BIKE_LIGHT_BTN_ID = "add-to-cart-sauce-labs-bike-light";
    static final String SHOPPING_CART_BTN_Xpath = "//*[@id=\"shopping_cart_container\"]/a";
    static final String SHOPPING_CART_LIST_CSS = ".cart_list";
    static final String REMOVE_LABS_BIKE_LIGHT_BTN_ID = "remove-sauce-labs-bike-light";
    static final String CART_ITEM_BTN_CSS = ".cart_item";
    static final String SUCCESS_MSG_IF_ONLY_1_ITEM_IN_CART_STR = "Success! Only one item left in the shopping cart.";
    static final String FAIL_MESSAGE_STR = "Fail!";
    static final String CONTINUE_SHOPPING_BTN_ID = "continue-shopping";
    static final String ADD_TO_CART_LABS_ONESIE_BTN_ID = "add-to-cart-sauce-labs-onesie";
    static final String SHOPPING_CART_CONTAINER_ID = "shopping_cart_container";
    static final String CHECKOUT_BTN_CSS = "#checkout";
    static final String CHECKOUT_INFO_WRAPPER_CSS = ".checkout_info_wrapper";
    static final String MESSAGE_IF_CHECKOUT_SUCCESS = "Success! Checkout process.";

    @BeforeMethod
    public void loginSetUp()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(SAUCEDEMO_HOME_PAGE_URL);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown () throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(SLEEP_TIME_SEC);
        webDriver.quit();
    }

    public void fillTheInputField(By selector, String key) {
        WebElement inputFieldWebElement = webDriver.findElement(selector);
        inputFieldWebElement.clear();
        inputFieldWebElement.click();
        inputFieldWebElement.sendKeys(key);
    }

    protected void loginForm(String emailForLogin, String pswForLogin) {
        fillTheInputField(By.id(USERNAME_FIELD_ID), emailForLogin);
        fillTheInputField(By.id(PSW_FIELD_ID), pswForLogin);
        WebElement loginButton = webDriver.findElement(By.id(LOGIN_BUTTON_ID));
        loginButton.click();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
        List<WebElement> burgerMenu = webDriver.findElements(By.id(BURGER_MENU_ID));
        if (burgerMenu.size () == 1) System.out.println(MESSAGE_IF_LOGIN_SUCCESS);
        else
            System.out.println(MESSAGE_IF_LOGIN_FAIL);
    }

    protected void clickButton(By buttonName) {
        WebElement shoppingCart = webDriver.findElement(buttonName);
        shoppingCart.click();
    }

    protected void removeItemFromShoppingCart(By selector) {
        WebElement removeLabsBoltTShirt = webDriver.findElement(selector);
        removeLabsBoltTShirt.click();
    }

    protected void addItemToShoppingCart(By selector) {
        WebElement addLabsBoltTShirt = webDriver.findElement(selector);
        addLabsBoltTShirt.click();
    }

    public boolean isWebElementIsPresentWithTryCatch (By selector){
       try {
           WebElement webElement = webDriver.findElement(selector);
           return true;
       }
       catch (NoSuchElementException noSuchElementException) {
           return false;
       }
    }
}

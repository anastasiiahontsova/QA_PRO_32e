package com.telran.hontsova.qa.pro.homework.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaucedemoMyCart extends SaucedemoTestBase{


    @BeforeMethod
    public void shoppingCartSetUp()
    {
        loginForm(EMAIL_FOR_LOGIN, PSW_FOR_LOGIN);
        webDriver.navigate().to(SAUCEDEMO_PRODUCTS_PAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
    }

    @Test
    public void testShoppingCart()
    {
        addItemToShoppingCart(By.id(ADD_TO_CART_BOLT_T_SHIRT_BTN_ID));
        removeItemFromShoppingCart(By.id(REMOVE_FROM_CART_BOLT_T_SHIRT_BTN_ID));
        addItemToShoppingCart(By.id(ADD_TO_CART_LABS_BACKPACK_BTN_ID));
        addItemToShoppingCart(By.id(ADD_TO_CART_LABS_BIKE_LIGHT_BTN_ID));
        clickButton(By.xpath(SHOPPING_CART_BTN_Xpath));
        WebElement shoppingCartResult = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector(SHOPPING_CART_LIST_CSS))));
        System.out.println(shoppingCartResult);
        removeItemFromShoppingCart(By.id(REMOVE_LABS_BIKE_LIGHT_BTN_ID));
//        Assert.assertTrue(shoppingCartContainsOnlyBackpackItemSize == 1, "Success! Shopping cart contains only backpack item.");
//        Assert.assertEquals(shoppingCartContainsOnlyBackpackItemSize, 1, "Success! Shopping cart contains only backpack item.");
//        List<WebElement> shoppingCartContainsOnlyBackpackItemSize = webDriver.findElements(By.cssSelector(CART_ITEM_BTN_CSS));
        int shoppingCartContainsOnlyBackpackItemSize = webDriver.findElements(By.cssSelector(CART_ITEM_BTN_CSS)).size();
        if(shoppingCartContainsOnlyBackpackItemSize == 1)
            System.out.println(SUCCESS_MSG_IF_ONLY_1_ITEM_IN_CART_STR);
        else
            System.out.println(FAIL_MESSAGE_STR);
        clickButton(By.id(CONTINUE_SHOPPING_BTN_ID));
        addItemToShoppingCart(By.id(ADD_TO_CART_LABS_ONESIE_BTN_ID));
        clickButton(By.id(SHOPPING_CART_CONTAINER_ID));
        clickButton(By.cssSelector(CHECKOUT_BTN_CSS));
        int checkOutInformationSize = webDriver.findElements(By.cssSelector(CHECKOUT_INFO_WRAPPER_CSS)).size();
        if (checkOutInformationSize == 1)
            System.out.println(MESSAGE_IF_CHECKOUT_SUCCESS);
        else
            System.out.println(FAIL_MESSAGE_STR);
    }

}



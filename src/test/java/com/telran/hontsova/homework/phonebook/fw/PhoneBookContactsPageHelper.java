package com.telran.hontsova.homework.phonebook.fw;

import com.telran.hontsova.homework.phonebook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhoneBookContactsPageHelper extends BaseHelper {

    public static final String EXISTING_CONTACT_CARD_CSS_STR = ".contact-item_card__2SOIM";
    public static final String BUTTON_REMOVE_TO_REMOVE_CONRACR_CARD_XPATH_STR = "//button[contains(text(),'Remove')]";
    public static final String WEB_ELEMENT_TABLE_NO_CONTACTS_HERE_XPATH_STR = "//h1[contains(text(),  'No Contacts here!')]";
    public static final String INPUT_FIELD_NAME_XPATH_STR = "//input[@placeholder='Name']";
    public static final String INPUT_FIELD_LAST_NAME_XPATH_STR = "//input[@placeholder='Last Name']";
    public static final String INPUT_FIELD_PHONE_XPATH_STR = "//input[@placeholder='Phone']";
    public static final String INPUT_FIELD_EMAIL_STR = "//input[@placeholder='email']";
    public static final String INPUT_FIELD_ADDRESS_XPATH_STR = "//input[@placeholder='Address']";
    public static final String INPUT_FIELD_DESCRIPTION_XPATH_STR = "//input[@placeholder='description']";
    public static final String BUTTON_SAVE_TO_ADD_CONTACT_XPATH_STR = "//b[contains(text(), 'Save')]";
    public static final int IMPLICIT_WAIT_TIME_SEC = 5;

    public PhoneBookContactsPageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillUserInfoFieldsFormToAddContact(Contact contact) {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        fillInputField(By.xpath(INPUT_FIELD_NAME_XPATH_STR), contact.getName());
        fillInputField(By.xpath(INPUT_FIELD_LAST_NAME_XPATH_STR), contact.getLastName());
        fillInputField(By.xpath(INPUT_FIELD_PHONE_XPATH_STR), contact.getPhone());
        fillInputField(By.xpath(INPUT_FIELD_EMAIL_STR), contact.getEmail());
        fillInputField(By.xpath(INPUT_FIELD_ADDRESS_XPATH_STR), contact.getAddress());
        fillInputField(By.xpath(INPUT_FIELD_DESCRIPTION_XPATH_STR), contact.getDescription());
        WebElement saveButton = webDriver.findElement(By.xpath(BUTTON_SAVE_TO_ADD_CONTACT_XPATH_STR));
        saveButton.click();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
    }

    public void removeContact() {
        clickButton(By.cssSelector(EXISTING_CONTACT_CARD_CSS_STR));
        clickButton(By.xpath(BUTTON_REMOVE_TO_REMOVE_CONRACR_CARD_XPATH_STR));
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    public void removeContact(String lastName) throws InterruptedException {
        clickButton(By.cssSelector(EXISTING_CONTACT_CARD_CSS_STR));
        clickButton(By.xpath(BUTTON_REMOVE_TO_REMOVE_CONRACR_CARD_XPATH_STR));
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    public boolean isWebElementPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }

    public int getContactCardsAmount() {
        List<WebElement> contactCardsArray = webDriver.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        return contactCardsArray.size();
    }

    public void setImplicitWaitTimeSec() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);
    }

}

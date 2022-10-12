package com.telran.hontsova.homework.phonebook.fw;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //public static WebDriver webDriver;
    protected EventFiringWebDriver webDriver;
    protected String browser;
    BaseHelper baseHelper;
    MenuHelper menuHelper;
    PhoneBookContactsPageHelper phoneBookContactsPageHelper;
    PhoneBookRegistrationPageHelper phoneBookRegistrationPageHelper;
    PhoneBookLoginPageHelper phoneBookLoginPageHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public MenuHelper getMenuHelper() {
        return menuHelper;
    }

    public PhoneBookContactsPageHelper getPhoneBookContactsPageHelper() {
        return phoneBookContactsPageHelper;
    }

    public PhoneBookRegistrationPageHelper getPhoneBookRegistrationPageHelper() {
        return phoneBookRegistrationPageHelper;
    }

    public PhoneBookLoginPageHelper getPhoneBookLoginPageHelper() {
        return phoneBookLoginPageHelper;
    }


    public void initApp() {
        //webDriver = new EventFiringWebDriver(new ChromeDriver());

        if (browser.equals(BrowserType.CHROME))
            webDriver = new EventFiringWebDriver(new ChromeDriver());
        else if (browser.equals(BrowserType.FIREFOX))
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        else if (browser.equals(BrowserType.SAFARI))
            webDriver = new EventFiringWebDriver(new SafariDriver());


        menuHelper = new MenuHelper(webDriver);
        phoneBookContactsPageHelper = new PhoneBookContactsPageHelper(webDriver);
        phoneBookRegistrationPageHelper = new PhoneBookRegistrationPageHelper(webDriver);
        phoneBookLoginPageHelper = new PhoneBookLoginPageHelper(webDriver);


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        goToLoginPage();

        webDriver.register(new MyListener());
    }

    public void stopApp() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        webDriver.quit();
    }

    public void goToLoginPage() {
        webDriver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
    }

    public void goToContactsPage() {
        webDriver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/contacts");
    }

    public void goToAddContactsPage() {
        webDriver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/add");
    }

    public void goToRegistrationPage() {
        webDriver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
    }


    public String takeScreenShot() {
        String pathName = "screenshots/" + System.currentTimeMillis() + "png";
        File tmpScreenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File screenShotFile = new File(pathName);
        try {
            Files.copy(tmpScreenshotFile, screenShotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathName;

    }

}



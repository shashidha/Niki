package com.niki.bjetf.androidmobile.pages.actions;

import com.niki.bjetf.androidmobile.pages.repo.Chat;

import com.niki.bjetf.mobile.base.config.AndroidAppConfig;
import com.niki.bjetf.mobile.base.utils.RetryTillPass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.niki.bjetf.mobile.base.MobileUIBase;


public class ChatActions extends Chat {

    private AndroidDriver driver;
    public static Logger LOGGER = LoggerFactory.getLogger("StaticLogger");

    public ChatActions(AndroidDriver driver) {
        this.driver = driver;

    }

    public Boolean isElementDisplayed(WebElement element) throws Exception {
        LOGGER.debug("Inside isElementDisplayed");
        Boolean isItDisplayed;
        try {
            isItDisplayed = element.isDisplayed();
        } catch (Exception e) {
            isItDisplayed = false;
        }
        return isItDisplayed;
    }

    private Boolean waitAndPollForElementToBeDisplayed(WebElement element) throws Exception {
        boolean found = false;
        try {

            LOGGER.info("entering a class");
            RetryTillPass rtp = new RetryTillPass("com.niki.bjetf.mobile.base.MobileUIBase");
            Class[] signature = new Class[]{WebElement.class};
            LOGGER.info("entering a class 2");
            Object result = rtp.waitForCodeToPassUtil("isElementDisplayed", true, signature, 60000 , element);
            LOGGER.info("entering a class 3");
            if (result instanceof Boolean) {
                found = (Boolean) result;
            } else if (result instanceof Integer) {
                found = false;
            }
        } catch (Exception e) {
            LOGGER.error("Error in waitForElementToBeDisplayed: " + e);
        }
        LOGGER.info("value of the element" +found);
        return found;
    }

    public Boolean waitForElementToBeDisplayed(WebElement webElement) throws Exception {
        LOGGER.info("============== ELEMENT ==================");
        LOGGER.info("waiting for element to be displayed");
        boolean isDisplayed = waitAndPollForElementToBeDisplayed(webElement);
        if (isDisplayed) {
            LOGGER.debug("Is Element Displayed Status : " + isDisplayed);
        }
        Assert.assertTrue(isDisplayed); //fail if not found
        return isDisplayed;
    }


    public void clickOnDisplayedElement(WebElement webElement) throws Exception {
        LOGGER.info("============== ELEMENT ==================");
        if (webElement != null) {
            LOGGER.info("" + webElement);
        } else {
            LOGGER.info("NULL WEB ELEMENT");
        }
        LOGGER.info("============== ELEMENT ==================");
        boolean isDisplayed = waitAndPollForElementToBeDisplayed(webElement);
        if (isDisplayed) {
            LOGGER.debug("Is Element Displayed Status : " + isDisplayed);
            webElement.click();
        }
        Assert.assertTrue(isDisplayed);
    }

    public boolean isElementDisplayedOnPoll(WebElement webElement) throws Exception {

        if (webElement != null) {
            LOGGER.info("Inside isElementDisplayedOnPoll ");
        } else {
            LOGGER.info("insideisElementDisplayedOnPoll " + "Received Null value");
        }
        boolean isDisplayed = waitAndPollForElementToBeDisplayed(webElement);
        return isDisplayed;

    }

    public WebElement getDisplayedElement(WebElement webElement) {
        // System.out.println(webElement);
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = waitAndPollForElementToBeDisplayed(webElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isElementDisplayed);
        return webElement;
    }

    public void enterTextValue(WebElement webElement, String text) throws Exception {

        LOGGER.info("Inside enterTextValue" + webElement);
        getDisplayedElement(webElement);
        webElement.click();
        LOGGER.info("Clicked the webElement");
        webElement.clear();
        LOGGER.info("Cleared the TextField");
        Thread.sleep(100);
        webElement.sendKeys(text);
        Thread.sleep(100);
    }





    public void navigateToChat() throws Exception {
        waitForElementToBeDisplayed(toolbar);
        clickOnDisplayedElement(toolbar);
        enterTextValue(toolbar,"Hi");
        driver.sendKeyEvent(66);  //pressing enter to send chat
    }


    public void clickOnUser() throws Exception {



        waitForElementToBeDisplayed(addedUser);
        clickOnDisplayedElement(addedUser);
    }

    public void enterUsername() throws Exception {

        waitForElementToBeDisplayed(username);
        clickOnDisplayedElement(username);
        enterTextValue(username,"hi@xyz.com");
        driver.sendKeyEvent(4);  //pressing back button to hide keyboard
        waitForElementToBeDisplayed(startChatButton);
        clickOnDisplayedElement(startChatButton);
    }



}




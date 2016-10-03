package com.niki.bjetf.mobile.base;

import com.niki.bjetf.mobile.base.config.AndroidAppConfig;
import com.niki.bjetf.mobile.base.config.BrowserConfig;
import com.niki.bjetf.mobile.base.utils.RetryTillPass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by shashidhar on 02/10/16.
 */
public class MobileUIBase {




        public static Logger LOGGER = LoggerFactory.getLogger("StaticLogger");

        public static WebDriver driver;

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
                RetryTillPass rtp = new RetryTillPass("com.niki.bjetf.mobile.base.MobileUIBase");
                Class[] signature = new Class[]{WebElement.class};
                Object result = rtp.waitForCodeToPassUtil("isElementDisplayed", true, signature, AndroidAppConfig.getElementMaxTimeout(), element);
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













        public void AndroidKeyCode() throws InterruptedException {
            int BACK = 4;
            int BACKSPACE = 67;
            int DEL = 67;
            int ENTER = 66;
            int HOME = 3;
            int MENU = 82;
            int SETTINGS = 176;
            int SPACE = 62;

        }








}


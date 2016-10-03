package com.niki.bjetf.android.tests.hooks;

import com.niki.bjetf.androidmobile.utils.TextFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class AndroidInitializer {


    protected static AndroidDriver androiddriver;



    private static Logger LOGGER = LoggerFactory.getLogger("StaticLogger");
    private static final String propertiesFile = "src/test/resources/configs/";
    String environmentDetails = TextFileReader.getTextFromFile("environment.txt");
    String hubUrl = environmentDetails.substring(environmentDetails.indexOf("&") + 1, environmentDetails.indexOf("%"));
    String hubUrl1 = environmentDetails.substring(environmentDetails.indexOf("%") + 1, environmentDetails.length());
    String IPAddress = environmentDetails.substring(environmentDetails.indexOf(":") + 3, environmentDetails.indexOf("w") - 6);
    String capabilityDetails = TextFileReader.getTextFromFile("capability.txt");
    String package1 = capabilityDetails.substring(0, capabilityDetails.indexOf("|"));
    String activity = capabilityDetails.substring(capabilityDetails.indexOf("|") + 1, capabilityDetails.indexOf("*"));
    String platformVersion = capabilityDetails.substring(capabilityDetails.indexOf("*") + 1, capabilityDetails.indexOf("@"));
    String platformName = capabilityDetails.substring(capabilityDetails.indexOf("@") + 1, capabilityDetails.indexOf("!"));
    String devicename = capabilityDetails.substring(capabilityDetails.indexOf("!") + 1, capabilityDetails.length());
    public static ArrayList<AndroidDriver> driverArrayMultiHub = new ArrayList<AndroidDriver>(); //Storing the driver in a array


    String credentails;
    String reportDate;
    String failedTest;

    public static AndroidDriver getAndroiddriver() {
        return androiddriver;
    }

    public static void setCurrentAndroidDriver(AndroidDriver driver) {

        androiddriver = driver;
    }



    @Before
    public void setUp() throws Throwable {
        try {
            File classpathRoot = new File(System.getProperty("user.dir"));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", devicename);
            capabilities.setCapability(CapabilityType.VERSION, platformVersion);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("app-package", package1);
            capabilities.setCapability("app-activity", activity);
            capabilities.setCapability("fullReset", "false");

            androiddriver = new AndroidDriver(new URL(hubUrl), capabilities);
            LOGGER.info("####Creating first driver");
            setCurrentAndroidDriver(androiddriver);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", devicename);
            capabilities.setCapability(CapabilityType.VERSION, platformVersion);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("app-package", package1);
            capabilities.setCapability("app-activity", activity);
            capabilities.setCapability("fullReset", "false");

            androiddriver = new AndroidDriver(new URL(hubUrl), capabilities);
            LOGGER.info("####Attempted to create first driver again");

            setCurrentAndroidDriver(androiddriver);


        }



    }


    @Before
    public void printTestInfoBeforeScenario(Scenario scenario) {
        LOGGER.info("Upcoming Test: " + scenario.getSourceTagNames());
        LOGGER.info("*****************STARTING*********************************************");
        LOGGER.info("Scenario Name:" + scenario.getName());
        LOGGER.info("***********************************************************************");
    }





    @After
    public void tearDown() throws Exception {

        try {

            LOGGER.info("quitting driver now");

            Thread.sleep(4000);
            androiddriver.quit();

            LOGGER.info("driver is quit");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }










}
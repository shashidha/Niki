package com.niki.bjetf.mobile.base.config;

import com.niki.bjetf.mobile.base.utils.ResourceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public abstract class BrowserConfig {

    public static final String ENV_BROWSER_VERSION = "env.browser.version";
    public static final String OS_PLATFORM = "os.platform";
    public static final String BROWSER_DIMENSION_Y = "browser.dimension.y";
    public static final String BROWSER_DIMENSION_X = "browser.dimension.x";
    public static final String BROWSER_TYPE = "browser.type";
    public static final String BROWSER_PROPERTIES = "browser.properties";
    public static final String HUB_URL = "hub.url";
    public static final String ENV_PROP = "envProperties";
    public static final String ELEMENT_MIN_TIMEOUT = "selenium.element.maxtimeout";
    public static final String ELEMENT_MAX_TIMEOUT = "selenium.element.mintimeout";
    public static final String PAGELOAD_MIN_TIMEOUT = "selenium.pageload.maxtimeout";
    public static final String PAGELOAD_MAX_TIMEOUT = "selenium.pageload.mintimeout";


    public static Logger LOGGER = LoggerFactory.getLogger("StaticLogger");
    protected Logger classlogger = LoggerFactory.getLogger(getClass());
    public static String separator = System.getProperty("file.separator");

    private static String resourceFile = System.getProperty("PROPERTY_FILE");


    public static String getHubURL() throws Exception {
        Properties properties = getProperties();
        System.out.println("The loaded resource is" + properties.toString());
        System.out.println("Asked Hub Url is" + System.getProperty(HUB_URL));
        return System.getProperty(HUB_URL) != null ?
                System.getProperty(HUB_URL) : properties.getProperty(HUB_URL);
    }

    public static String getEnvProp() throws Exception {
        Properties properties = getProperties();
        System.out.println("The loaded resource is" + properties.toString());
        return System.getProperty(ENV_PROP) != null ?
                System.getProperty(ENV_PROP) : properties.getProperty(ENV_PROP);
    }

    public static String getBrowserType() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(BROWSER_TYPE) != null ?
                System.getProperty(BROWSER_TYPE) : properties.getProperty(BROWSER_TYPE);
    }

    private static Properties getProperties() throws Exception {
     //   return ResourceHandler.loadGradleResource(resourceFile);
        return null;
    }

    public static String getBrowserProperties() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(BROWSER_PROPERTIES) != null ?
                System.getProperty(BROWSER_PROPERTIES) : properties.getProperty(BROWSER_PROPERTIES);
    }

    public static String getBrowserDimensionX() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(BROWSER_DIMENSION_X) != null ?
                System.getProperty(BROWSER_DIMENSION_X) : properties.getProperty(BROWSER_DIMENSION_X);
    }

    public static String getBrowserDimensionY() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(BROWSER_DIMENSION_Y) != null ?
                System.getProperty(BROWSER_DIMENSION_Y) : properties.getProperty(BROWSER_DIMENSION_Y);
    }

    public static String getOsPlatform() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(OS_PLATFORM) != null ?
                System.getProperty(OS_PLATFORM) : properties.getProperty(OS_PLATFORM);
    }

    public static String getBrowserVersion() throws Exception {
        Properties properties = getProperties();
        return System.getProperty(ENV_BROWSER_VERSION) != null ?
                System.getProperty(ENV_BROWSER_VERSION) : properties.getProperty(ENV_BROWSER_VERSION);
    }

    public static int getElementMinTimeout() throws Exception {
        Properties properties = getProperties();
        return Integer.parseInt(System.getProperty(ELEMENT_MIN_TIMEOUT) != null ?
                System.getProperty(ELEMENT_MIN_TIMEOUT) : properties.getProperty(ELEMENT_MIN_TIMEOUT));
    }

    public static int getElementMaxTimeout() throws Exception {
        Properties properties = getProperties();
        return Integer.parseInt(System.getProperty(ELEMENT_MAX_TIMEOUT) != null ?
                System.getProperty(ELEMENT_MAX_TIMEOUT) : properties.getProperty(ELEMENT_MAX_TIMEOUT));
    }

    public static int getPageloadMinTimeout() throws Exception {
        Properties properties = getProperties();
        return Integer.parseInt(System.getProperty(PAGELOAD_MIN_TIMEOUT) != null ?
                System.getProperty(PAGELOAD_MIN_TIMEOUT) : properties.getProperty(PAGELOAD_MIN_TIMEOUT));
    }

    public static int getPageLoadMaxTimeOut() throws Exception {
        Properties properties = getProperties();
        return Integer.parseInt(System.getProperty(PAGELOAD_MAX_TIMEOUT) != null ?
                System.getProperty(PAGELOAD_MAX_TIMEOUT) : properties.getProperty(PAGELOAD_MAX_TIMEOUT));
    }

    protected BrowserConfig() {
        // do nothing
    }

}

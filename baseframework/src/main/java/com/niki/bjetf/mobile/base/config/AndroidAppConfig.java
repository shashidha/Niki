package com.niki.bjetf.mobile.base.config;

import com.niki.bjetf.mobile.base.utils.ResourceHandler;

import java.util.Properties;


public class AndroidAppConfig {




    public static final String ELEMENT_MIN_TIMEOUT = "50000";
    public static final String ELEMENT_MAX_TIMEOUT = "60000";




















    public static int getElementMaxTimeout() throws Exception {
        Properties properties = getProperties();
        return Integer.parseInt(System.getProperty(ELEMENT_MAX_TIMEOUT) != null ?
                System.getProperty(ELEMENT_MAX_TIMEOUT) : properties.getProperty(ELEMENT_MAX_TIMEOUT));
    }

    private static Properties getProperties() throws Exception {
        //   return ResourceHandler.loadGradleResource(resourceFile);
        return null;
    }



}
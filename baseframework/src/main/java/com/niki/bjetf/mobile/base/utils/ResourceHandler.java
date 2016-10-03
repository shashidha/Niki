package com.niki.bjetf.mobile.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceHandler {

    public static Properties loadGradleResource(String fileName) throws Exception {
        //BrowserConfig.LOGGER.info("The file '" + fileName + "' exists.");

        File resourceFile = new File(fileName);
        if (resourceFile.exists()) {
           // BrowserConfig.LOGGER.info("The file '" + resourceFile.getAbsolutePath() + "' exists.");
//            InputStream a = getResourceLocation(fileName);

            Properties properties = new Properties();
            FileInputStream props = new FileInputStream(resourceFile);
            properties.load(props);
            return properties;
        } else {
           // BrowserConfig.LOGGER.info("File doesn't exist in location: " + resourceFile.getAbsolutePath());
        }
        return null;
    }

    public static InputStream getResourceLocation(String fileName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(fileName).openStream();
//        URL url = ClassLoader.getSystemResource(fileName);
//        System.out.println("The url path is" + url.getPath());
//        return url.openStream();
    }
}
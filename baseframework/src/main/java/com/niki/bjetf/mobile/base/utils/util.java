package com.niki.bjetf.mobile.base.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class util {



    /**
     *
     * @return String
     */
    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("_MM-dd_HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     *
     * @return String
     */
    public static String getDateTimeE() {
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     *
     * @return String
     */
    public static String getDateStandardFormat() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateFormat() {
        DateFormat dateFormat = new SimpleDateFormat("MMMdyyyyh");
        Date date = new Date();
        return dateFormat.format(date);
    }

}



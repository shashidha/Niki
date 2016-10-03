package com.niki.bjetf.androidmobile.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by svasudevajois on 27/04/14.
 */
public class TextFileReader {
    public static String getTextFromFile(String filename) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}

package com.niki.bjetf.mobile.base.utils.dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CSVDataProvider {

    public Collection<String[]> getTestData(String fileLocation)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;

        URL url = ClassLoader.getSystemResource(fileLocation);
        BufferedReader file = new BufferedReader(new FileReader(url.getFile()));

        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }

        file.close();
        return records;
    }
}
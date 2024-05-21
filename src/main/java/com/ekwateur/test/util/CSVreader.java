package com.ekwateur.test.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVreader {
    public static List<String[]> readAllDataAtOnce(String file)
    {
        try {
            ClassLoader classLoader = CSVreader.class.getClassLoader();

            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(classLoader.getResource(file).getFile());

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            return allData;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

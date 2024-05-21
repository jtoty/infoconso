package com.ekwateur.test.repository;

import com.ekwateur.test.entity.Client;
import com.ekwateur.test.entity.Consumption;
import com.ekwateur.test.util.CSVreader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumptionRepository {
    public Consumption getProClientConsumptionByDate(String clientReference, String date) {
        List<String[]> allData = CSVreader.readAllDataAtOnce("consommations_pro.csv");
        for (String[] row : allData) {
            if (clientReference.equals((row[0].trim())) && date.equals(row[3].trim())) {
                return new Consumption(row[1], row[2], row[4]);
            }
        }
        return null;
    }
    public Consumption getNonProClientConsumptionByDate(String clientReference, String date) {
        List<String[]> allData = CSVreader.readAllDataAtOnce("consommations_particuliers.csv");
        System.out.println("On cherche + "+ clientReference + " "  + date);
        for (String[] row : allData) {
            if (clientReference.equals((row[0].trim())) && date.equals(row[3].trim())) {
                return new Consumption(row[1], row[2]);
            }
        }
        return null;
    }
}

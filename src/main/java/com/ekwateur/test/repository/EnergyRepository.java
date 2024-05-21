package com.ekwateur.test.repository;

import com.ekwateur.test.entity.Consumption;
import com.ekwateur.test.entity.Energy;
import com.ekwateur.test.util.CSVreader;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class EnergyRepository {

    public Energy getProEnergyPriceByMonth(long chiffreDaffaire, String date) {
//        return new Energy(0.133, 0.110);

        List<String[]> allData = CSVreader.readAllDataAtOnce("prix_energie_pro.csv");
        allData = allData.stream()
                .filter(row -> row.length > 0 && date.equals(row[2].trim()))
                .sorted(Comparator.comparingLong((String[] row) -> Long.parseLong(row[3].trim())).reversed())
                .toList();
        for (String[] row : allData) {
            if (chiffreDaffaire >= Long.parseLong(row[3].trim())) {
                return new Energy(row[0], row[1]);
            }
        }
        return null;
    }

    public Energy getNonProEnergyPriceByMonth(String date) {

        List<String[]> allData = CSVreader.readAllDataAtOnce("prix_energie_particuliers.csv");
        for (String[] row : allData) {
            if (date.equals((row[2].trim()))) {
                return new Energy(row[0], row[1]);
            }
        }
        return null;
    }
}

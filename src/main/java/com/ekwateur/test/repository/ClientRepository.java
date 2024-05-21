package com.ekwateur.test.repository;

import com.ekwateur.test.entity.Client;
import com.ekwateur.test.util.CSVreader;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClientRepository {
    public Client findCliendByReference(String clientReference) {
        List<String[]> allData = CSVreader.readAllDataAtOnce("clients.csv");
        for (String[] row : allData) {
            if (clientReference.equals((row[0].trim()))) {
                return new Client(row[0], row[1], row[2], row[3], row[4], row[5] ,row[6]);
            }
        }
        return null;
    }
}

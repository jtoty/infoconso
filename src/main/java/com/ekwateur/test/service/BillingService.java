package com.ekwateur.test.service;

import com.ekwateur.test.entity.Client;
import com.ekwateur.test.entity.Consumption;
import com.ekwateur.test.entity.Energy;
import com.ekwateur.test.repository.ClientRepository;
import com.ekwateur.test.repository.ConsumptionRepository;
import com.ekwateur.test.repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private EnergyRepository energyRepository;

    public String getBillofMonth(String clientReference, String date) {
        Consumption consumption;
        Energy energy;
        Client client = clientRepository.findCliendByReference(clientReference);
        if (client == null) {
            return "Client non trouvé";
        }
        if (client.isPro()) {
            consumption = consumptionRepository.getProClientConsumptionByDate(clientReference, date);
            energy = energyRepository.getProEnergyPriceByMonth(client.getChiffreDaffaire(), date);
        } else {
            consumption = consumptionRepository.getNonProClientConsumptionByDate(clientReference, date);
            energy = energyRepository.getNonProEnergyPriceByMonth(date);
        }
        if (consumption == null || energy == null) {
            return "Date demandée non disponible";
        }
        double billingElec = consumption.getElectricConsumption() * energy.getElectricPrice();
        double billingGas = consumption.getGasConsumption() * energy.getGasPrice();
        double billingAmout = consumption.getElectricConsumption() * energy.getElectricPrice() + consumption.getGasConsumption() * energy.getGasPrice();
        return client.toString()
                + "\nVotre consommation pour la période du " + date
                + "\nElectricité : " + Integer.toString(consumption.getElectricConsumption()) + "kwH à " + Double.toString(energy.getElectricPrice()) + "€" + " = " + Double.toString(billingElec) + "€"
                + "\nGaz : " + Integer.toString(consumption.getGasConsumption()) + "kwH à " + Double.toString(energy.getGasPrice()) + "€" + " = " + Double.toString(billingGas) + "€"
                + "\nTotal " + Double.toString(billingAmout) + "€";
    }
}

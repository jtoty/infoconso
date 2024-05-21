package com.ekwateur.test.entity;

public class Consumption {
    private int electricConsumption;
    private int gasConsumption;
    private long chiffreDaffaire;

    public Consumption(String electricConsumption, String gasConsumption) {
        this.electricConsumption = Integer.parseInt(electricConsumption.trim());
        this.gasConsumption = Integer.parseInt(gasConsumption.trim());
        this.chiffreDaffaire = 0;
    }

    public Consumption(String electricConsumption, String gasConsumption, String chiffreDaffaire) {
        this.electricConsumption = Integer.parseInt(electricConsumption.trim());
        this.gasConsumption = Integer.parseInt(gasConsumption.trim());
        this.chiffreDaffaire = Long.parseLong(chiffreDaffaire.trim());
    }

    public int getElectricConsumption() {
        return electricConsumption;
    }

    public void setElectricConsumption(int electricConsumption) {
        this.electricConsumption = electricConsumption;
    }

    public int getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(int gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public long getChiffreDaffaire() {
        return chiffreDaffaire;
    }

    public void setChiffreDaffaire(long chiffreDaffaire) {
        this.chiffreDaffaire = chiffreDaffaire;
    }
}

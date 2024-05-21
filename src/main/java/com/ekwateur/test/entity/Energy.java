package com.ekwateur.test.entity;

public class Energy {
    private double electricPrice;
    private double gasPrice;

    public Energy(String electricPrice, String gasPrice) {
        this.electricPrice = Double.parseDouble(electricPrice.trim());
        this.gasPrice = Double.parseDouble(gasPrice.trim());
    }

    public double getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(double electricPrice) {
        this.electricPrice = electricPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}

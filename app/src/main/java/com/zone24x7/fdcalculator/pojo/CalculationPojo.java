package com.zone24x7.fdcalculator.pojo;

public class CalculationPojo {
    private int amount;
    private int noOfMonths;
    private double interestRate;

    public CalculationPojo(int amount, int noOfMonths, double interestRate) {
        this.amount = amount;
        this.noOfMonths = noOfMonths;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public int getNoOfMonths() {
        return noOfMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

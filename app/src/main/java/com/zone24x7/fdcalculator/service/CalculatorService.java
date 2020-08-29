package com.zone24x7.fdcalculator.service;

import com.zone24x7.fdcalculator.pojo.CalculationPojo;

public class CalculatorService {

    private CalculationPojo calculationPojo;

    public CalculatorService(CalculationPojo calculationPojo){
        this.calculationPojo = calculationPojo;
    }

    public double getTotal(){
        return this.calculationPojo.getAmount() * ( 1 + (this.calculationPojo.getInterestRate()*(this.calculationPojo.getNoOfMonths()/12)/100));
    }

    public double getInterest(){
        return this.calculationPojo.getAmount() * (this.calculationPojo.getInterestRate()*(this.calculationPojo.getNoOfMonths()/12)/100);
    }

}

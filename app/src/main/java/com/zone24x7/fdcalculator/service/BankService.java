package com.zone24x7.fdcalculator.service;

import com.zone24x7.fdcalculator.constant.InterestRate;

public class BankService {

    public Integer[] getAvailableMonths(){
        return new InterestRate().getInterestRates().keySet().toArray(new Integer[new InterestRate().getInterestRates().keySet().size()]);
    }

    public Double[] getAvailableRates(){
        return new InterestRate().getInterestRates().values().toArray(new Double[new InterestRate().getInterestRates().entrySet().size()]);
    }

}

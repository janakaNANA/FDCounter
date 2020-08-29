package com.zone24x7.fdcalculator.constant;

import java.util.HashMap;
import java.util.Map;

public class InterestRate {

    private Map<Integer, Double> interestRates;

    public InterestRate() {
        this.interestRates = new HashMap<>();
        this.interestRates.put(1,6.8);
        this.interestRates.put(3,6.8);
        this.interestRates.put(6,6.8);
        this.interestRates.put(12,6.9);
        this.interestRates.put(24,7.0);
        this.interestRates.put(36,7.1);
        this.interestRates.put(48,7.1);
        this.interestRates.put(60,7.1);
    }

    public Map<Integer, Double> getInterestRates() {
        return interestRates;
    }
}

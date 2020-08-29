package com.zone24x7.fdcalculator.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

public interface CalculationDao {

    @Transaction()
    @Query("SELECT * FROM calculation")
    LiveData<List<Calculation>> getAll();

    @Insert()
    void addCalculation(Calculation calculation);

}

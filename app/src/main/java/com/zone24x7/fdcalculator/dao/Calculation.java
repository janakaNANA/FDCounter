package com.zone24x7.fdcalculator.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculation")
public class Calculation {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "amount")
    private int amount;

    @ColumnInfo(name = "months")
    private int months;

    @ColumnInfo(name = "rate")
    private double rate;

    @ColumnInfo(name = "interest")
    private double interest;

    @ColumnInfo(name = "total")
    private double total;
}

package com.zone24x7.fdcalculator.dao.db;

import com.zone24x7.fdcalculator.dao.Calculation;
import com.zone24x7.fdcalculator.dao.CalculationDao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Calculation.class}, version = 1)
public abstract class CalculationDatabase extends RoomDatabase {

    private static volatile CalculationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    public static CalculationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CalculationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CalculationDatabase.class, "calculation_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract CalculationDao phraseDao();

}
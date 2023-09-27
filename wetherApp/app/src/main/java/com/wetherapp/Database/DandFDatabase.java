package com.wetherapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.wetherapp.Model.DandF;

@Database(entities = DandF.class, version = 2)

public abstract class DandFDatabase extends RoomDatabase {

     private static DandFDatabase instance;
    public abstract DandFDao dandFDao();

    public static synchronized DandFDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DandFDatabase.class, "DandF_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



}

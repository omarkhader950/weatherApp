package com.wetherapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.wetherapp.Database.DandFDao;
import com.wetherapp.Database.DandFDatabase;
import com.wetherapp.Model.DandF;

import java.util.List;

public class WeatherRepository {

    private static final String TAG = "WeatherRepository";

    private DandFDao dandFDao;

    public WeatherRepository(Application application) {

        DandFDatabase dandFDatabase = DandFDatabase.getDatabase(application);
        dandFDao= dandFDatabase.dandFDao();
    }


    public void insert(DandF dandF){
        DandFDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dandFDao.insert(dandF);
            }
        });
    };


   public void delete(DandF dandF){
        DandFDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dandFDao.delete(dandF);
            }
        });
    };




   public LiveData<List<DandF>> getPosts(){

       return dandFDao.getPosts();
};
};

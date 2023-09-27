package com.wetherapp.Repository;

import android.app.Application;

import com.wetherapp.Database.DandFDao;
import com.wetherapp.Database.DandFDatabase;
import com.wetherapp.Model.DandF;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class WeatherRepository {

    private static final String TAG = "WeatherRepository";

    private DandFDao dandFDao;

    public WeatherRepository(Application application) {

        DandFDatabase dandFDatabase = DandFDatabase.getInstance(application);
        dandFDao= dandFDatabase.dandFDao();
    }

     void insert(DandF dandF){

        dandFDao.insert(dandF);
     }


    void delete(DandF dandF){
        dandFDao.delete(dandF);
    }





    Single<List<DandF>> getPosts(){

       return dandFDao.getPosts();
    }




}

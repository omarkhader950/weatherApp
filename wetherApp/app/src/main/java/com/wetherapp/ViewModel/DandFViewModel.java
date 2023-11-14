package com.wetherapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.wetherapp.Model.DandF;
import com.wetherapp.Repository.WeatherRepository;

import java.util.List;

public class DandFViewModel extends AndroidViewModel {
    WeatherRepository weatherRepository;
    public DandFViewModel(@NonNull Application application) {
        super(application);

        weatherRepository = new WeatherRepository(application);
    }
public void insert(DandF dandF){
        weatherRepository.insert(dandF);
    };

   public void delete(DandF dandF){
        weatherRepository.delete(dandF);
    };


   public LiveData<List<DandF>> getPosts(){

       return weatherRepository.getPosts() ;
};



}

package com.wetherapp.data;

import com.wetherapp.Model.Main;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private WeatherInterface weatherInterface;
        private static WeatherClient INSTANCE;

        public WeatherClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        weatherInterface = retrofit.create(WeatherInterface.class);
    }
 public static WeatherClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new WeatherClient();
        }
        return INSTANCE;
    }

    public Observable<Main> getData(){
        return weatherInterface.getData();
    }



}






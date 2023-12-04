package com.wetherapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.wetherapp.Model.Model;
import com.wetherapp.data.WeatherClient;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

 private static final  String TAG = "MainViewModel";
   public MutableLiveData<Model> dataMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Model> dataCityMutableLiveData = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public  void getdata(){
      Observable<Model> observable = WeatherClient.getINSTANCE().getData()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(o-> dataMutableLiveData.setValue(o) , e-> Log.d(TAG,"getdata :"+e));


    }

    public  void getCitydata(String q){
        Observable<Model> observable = WeatherClient.getINSTANCE().getCityData(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(o-> dataCityMutableLiveData.setValue(o) , e-> Log.d(TAG,"getCitydata :"+e));


    }






}
//Log.d(TAG,"onERORR : "+e);
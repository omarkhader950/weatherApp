package com.wetherapp.Model;

import androidx.room.Entity;

@Entity(tableName = "DandF_table")
public class DandF {


   private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public DandF(String food, String drink) {
        this.food = food;

    }


}

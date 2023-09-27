package com.wetherapp.Model;

import androidx.room.Entity;

@Entity(tableName = "DandF_table")
public class DandF {


   private String food;

    private String drink;









    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public DandF(String food, String drink) {
        this.food = food;
        this.drink = drink;
    }


}

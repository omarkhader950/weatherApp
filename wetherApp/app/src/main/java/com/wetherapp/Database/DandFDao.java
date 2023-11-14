package com.wetherapp.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.wetherapp.Model.DandF;

import java.util.List;

@Dao
public interface DandFDao {

    @Insert
    void insert(DandF dandF);

    @Delete
    void delete(DandF dandF);



    @Query("SELECT * FROM DandF_table")
    LiveData<List<DandF>> getPosts();




}

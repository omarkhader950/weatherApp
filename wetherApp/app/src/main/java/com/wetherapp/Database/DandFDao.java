package com.wetherapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wetherapp.Model.DandF;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface DandFDao {

    @Insert
    void insert(DandF dandF);

    @Delete
    void delete(DandF dandF);

    @Update
    void update(DandF dandF);

    @Query("select * from DandF_table")
    Single<List<DandF>> getPosts();




}

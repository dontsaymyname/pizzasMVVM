package com.example.pizzariafamiliahappy.model.dao;

import com.example.pizzariafamiliahappy.model.Pizza;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface PizzaDao {

    @Query("select * from pizza")
    Flowable<List<Pizza>> getListaPizza ();

    @Insert
    Completable inserir(Pizza pizza);

    @Delete
    Completable delete (Pizza pizza);

    @Update
    Completable  update(Pizza pizza);




}

package com.example.drinksapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DrinkViewDao {
    @Query("select * from drinkviews")
    fun getDrinkViews(): LiveData<List<DrinkViewTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DrinkViewTable>)
}

@Dao
interface DrinkDao {
    @Query("select * from Drinks")
    fun getDrink(): LiveData<DrinkTable>

    @Query("select * from Drinks where id=:id")
    fun getItem(id:String):LiveData<List<DrinkTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(video: DrinkTable)
}


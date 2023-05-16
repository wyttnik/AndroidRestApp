package com.example.drinksapp

import android.app.Application
import com.example.drinksapp.database.DrinkDatabase
import com.example.drinksapp.repository.DrinksRepository

class DrinkApplication : Application() {

    val database by lazy { DrinkDatabase.getDrinksDatabase(this) }
    val repository by lazy { DrinksRepository(database.drinkViewDao(), database.drinkDao())}
}
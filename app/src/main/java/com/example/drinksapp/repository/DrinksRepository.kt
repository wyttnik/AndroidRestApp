package com.example.drinksapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.drinksapp.database.DrinkDao
import com.example.drinksapp.database.DrinkViewDao
import com.example.drinksapp.database.getDetails
import com.example.drinksapp.database.getDrinks
import com.example.drinksapp.network.CocktailApi
import com.example.drinksapp.network.Drink
import com.example.drinksapp.network.DrinkView
import com.example.drinksapp.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DrinksRepository(private val drinkViewDao: DrinkViewDao, private val drinkDao: DrinkDao) {
    val allDrinkViews: LiveData<List<DrinkView>> = Transformations.map(drinkViewDao.getDrinkViews()) {
        it.getDrinks()
    }

    fun getDetails(id:String): LiveData<List<Drink>> = Transformations.map(drinkDao.getItem(id)) {
            it.getDetails()
        }

    suspend fun refreshDrinkViews() {
        withContext(Dispatchers.IO) {
            drinkViewDao.insertAll(CocktailApi.cocktailService.getCocktails().asDatabaseModel())
        }
    }

    suspend fun refreshDrinkDetails(id:String) {
        withContext(Dispatchers.IO) {
            drinkDao.insert(CocktailApi.cocktailService.getCocktailDetails(id).asDatabaseModel())
        }
    }
}
package com.example.drinksapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.drinksapp.repository.DrinksRepository
import kotlinx.coroutines.launch
import java.io.IOException

class CocktailViewModel(private val repository: DrinksRepository) : ViewModel() {

    val drinks = repository.allDrinkViews

    init {
        Log.d("testCycleOverview-CocktailViewModel", "init")
        refreshDataFromRepository()
    }

    fun updateDrinks() {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository(){
        viewModelScope.launch {
            try {
                repository.refreshDrinkViews()
            } catch (e:IOException) {}
        }
    }
}

class CocktailViewModelFactory(private val repository: DrinksRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CocktailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
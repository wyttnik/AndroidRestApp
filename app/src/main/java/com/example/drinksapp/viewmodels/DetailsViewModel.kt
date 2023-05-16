package com.example.drinksapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.drinksapp.repository.DrinksRepository
import kotlinx.coroutines.launch
import java.io.IOException

class DetailsViewModel(private val repository: DrinksRepository, private val id: String) : ViewModel() {
    val drinkDetails = repository.getDetails(id)

    init {
        refreshDataFromRepository(id)
    }

    private fun refreshDataFromRepository(id: String){
        viewModelScope.launch {
            try {
                repository.refreshDrinkDetails(id)
            } catch (e: IOException) {
            }
        }
    }

}

class DetailsViewModelFactory(private val repository: DrinksRepository, private val id:String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(repository, id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
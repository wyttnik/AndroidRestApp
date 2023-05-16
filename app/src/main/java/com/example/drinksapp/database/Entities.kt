package com.example.drinksapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.drinksapp.network.Drink
import com.example.drinksapp.network.DrinkView

@Entity(tableName = "DrinkViews")
data class DrinkViewTable(
    @PrimaryKey
    val id: String,
    val name: String,
    val img: String
)

fun List<DrinkViewTable>.getDrinks(): List<DrinkView> {
    return map {
        DrinkView(
            name = it.name,
            id = it.id,
            img = it.img
        )
    }
}

@Entity(tableName = "Drinks")
data class DrinkTable(
    @PrimaryKey
    val id: String,
    val name: String,
    val img: String,
    val instruction: String,
    val strIngredient1:String?,
    val strIngredient2:String?,
    val strIngredient3:String?,
    val strIngredient4:String?,
    val strIngredient5:String?,
    val strIngredient6:String?,
    val strIngredient7:String?,
    val strIngredient8:String?,
    val strIngredient9:String?,
    val strIngredient10:String?,
    val strIngredient11:String?,
    val strIngredient12:String?,
    val strIngredient13:String?,
    val strIngredient14:String?,
    val strIngredient15:String?
)

fun List<DrinkTable>.getDetails(): List<Drink> {
    return map {
        Drink(
            name = it.name,
            id = it.id,
            img = it.img,
            instruction = it.instruction,
            strIngredient1 = it.strIngredient1,
            strIngredient2 = it.strIngredient2,
            strIngredient3 = it.strIngredient3,
            strIngredient4 = it.strIngredient4,
            strIngredient5 = it.strIngredient5,
            strIngredient6 = it.strIngredient6,
            strIngredient7 = it.strIngredient7,
            strIngredient8 = it.strIngredient8,
            strIngredient9 = it.strIngredient9,
            strIngredient10 = it.strIngredient10,
            strIngredient11 = it.strIngredient11,
            strIngredient12 = it.strIngredient12,
            strIngredient13 = it.strIngredient13,
            strIngredient14 = it.strIngredient14,
            strIngredient15 = it.strIngredient15
        )
    }
}
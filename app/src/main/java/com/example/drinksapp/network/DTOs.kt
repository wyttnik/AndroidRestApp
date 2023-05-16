package com.example.drinksapp.network

import com.example.drinksapp.database.DrinkTable
import com.example.drinksapp.database.DrinkViewTable
import com.squareup.moshi.Json

data class DrinkContainer(
    @Json(name = "drinks") val drinkDetails: List<Drink>
    )

data class Drink(
    @Json(name = "strDrink") val name: String,
    @Json(name = "idDrink") val id: String,
    @Json(name = "strDrinkThumb") val img: String,
    @Json(name = "strInstructions") val instruction: String,
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

fun DrinkContainer.asDatabaseModel():DrinkTable {
    return drinkDetails[0].let {
        DrinkTable(
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

data class DrinkViewContainer(@Json(name = "drinks") val drinkViews: List<DrinkView>)

data class DrinkView(
    @Json(name = "strDrink") val name: String,
    @Json(name = "idDrink") val id: String,
    @Json(name = "strDrinkThumb") val img: String
)

fun DrinkViewContainer.asDatabaseModel():List<DrinkViewTable> {
    return drinkViews.map {
        DrinkViewTable(
            name = it.name,
            id = it.id,
            img = it.img
        )
    }
}
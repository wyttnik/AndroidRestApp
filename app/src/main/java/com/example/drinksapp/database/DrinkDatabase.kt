package com.example.drinksapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DrinkViewTable::class, DrinkTable::class], version = 1)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun drinkViewDao(): DrinkViewDao

    abstract fun drinkDao(): DrinkDao

    companion object {
        @Volatile
        private var INSTANCE: DrinkDatabase? = null

        fun getDrinksDatabase(context: Context) : DrinkDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DrinkDatabase::class.java,
                    "drink_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
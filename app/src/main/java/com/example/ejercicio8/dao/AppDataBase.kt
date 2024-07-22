package com.example.ejercicio8.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejercicio8.entities.City


@Database(entities = [City::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cityDao() : CityDao
}
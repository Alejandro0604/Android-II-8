package com.example.ejercicio8.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ejercicio8.entities.City


@Dao
abstract class CityDao {

    @Insert
    abstract suspend fun insert(city: City)

    @Update
    abstract suspend fun update(city: City)

    @Delete
    abstract suspend fun delete(city: City)

    @Query("DELETE FROM cities")
    abstract suspend fun deleteAllCities()

    @Query("SELECT * from cities")
    abstract suspend fun getAllCities():List<City>
}
package com.example.ejercicio8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ejercicio8.dao.DatabaseBuilder
import com.example.ejercicio8.databinding.ActivityMainBinding
import com.example.ejercicio8.entities.City
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState:Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        main()
    }

    private fun main()= runBlocking {
        val context = this@MainActivity
        val db = DatabaseBuilder.getInstance(context)
        val cityDao = db.cityDao()

        cityDao.deleteAllCities()

        val city1 = City(0,"Masaya","Ciudad de Masaya",)
        val city2 = City(0,"Managua","Ciudad de Managua",)
        val city3 = City(0,"León","Ciudad de Leon",)
        var listCities : List<City> = listOf(city1, city2, city3)

        listCities.forEach {city ->
            cityDao.insert(city)
        }

        val cities = cityDao.getAllCities()
        Log.e("jalc-cities", "${cities.toString()}")

        val msn = buildString {
            cities.forEach { city ->
                append("ID ${city.id} | Nombre: ${city.name}\n")
            }
        }

    }
}
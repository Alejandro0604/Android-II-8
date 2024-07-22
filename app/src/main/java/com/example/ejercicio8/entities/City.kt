package com.example.ejercicio8.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City (
    @PrimaryKey(autoGenerate = true) val id:Int,
    val name:String,
    val description:String
)
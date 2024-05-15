package com.zaroslikov.myfermacompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "МyFermaSale")
data class SaleTable(
@PrimaryKey(autoGenerate = true)
val id: Int = 0,
val title: String, // название
val count: Double, // Кол-во
val day: Int,  // день
val mount: Int, // месяц
val year: Int, // время
val priceAll: String
)
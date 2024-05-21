package com.zaroslikov.myfermacompose.data.ferma

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "МyFerma", foreignKeys = [ForeignKey(
    entity = ProjectTable::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("idPT"),
    onDelete = ForeignKey.CASCADE)])

data class AddTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Title")
    val title: String, // название

    @ColumnInfo(name = "Count")
    val count: Double, // Кол-во
    val day: Int,  // день
    val mount: Int, // месяц
    val year: Int, // время
    val priceAll: String,

    @ColumnInfo(name = "idPT")
    val idPT: Int
)

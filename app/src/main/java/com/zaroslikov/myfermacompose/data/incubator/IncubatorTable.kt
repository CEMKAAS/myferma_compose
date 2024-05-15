package com.zaroslikov.myfermacompose.data.incubator

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "МyINCUBATOR")
class IncubatorTable (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String, // название
    val type: String, // тип
    val date: String,  // дата начала
    val eggAll: Int, // яиц заложено
    val eggAllEnd: Int, // яиц вылупилось
    val airing: String, // провертивание
    val overIncubator: String, // переворот
    val arhive: String, //Архив
    val dataEnd : String, //Дата Конец
    val timePush : String, // Первое уведомление
    val timePush2 : String, // Второе уведомление
    val timePush3: String // Третье уведомление
)
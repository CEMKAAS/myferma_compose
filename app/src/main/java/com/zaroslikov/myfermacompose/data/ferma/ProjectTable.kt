package com.zaroslikov.myfermacompose.data.ferma

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Project")
data class ProjectTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    val titleProject: String, // название
    val dateBegin: String, // Начало проекта
    val dateFinal: String,  // Конец проекта
    val picture: Int, // Изображение
    val status: Int, // Статус
    val mode: Int //Инкубатор = 0, Хозяйство = 1
)

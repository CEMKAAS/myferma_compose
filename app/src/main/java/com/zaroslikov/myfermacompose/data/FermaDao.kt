package com.zaroslikov.myfermacompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow
@Dao
interface FermaDao {
    @Query("SELECT * from Project")
    fun getItem(): Flow<List<ProjectTable>>

//    @Query("SELECT * from items")
//    suspend fun getAllItem(): List<Item>
//
//    @Query("SELECT * from items WHERE id = :id")
//    fun getItemS(id: Int): Flow<Item>
//
//    @Query("SELECT * from items WHERE lastCount = 1")
//    fun getlastReadProject(): Flow<Item>
//
//    @Query("UPDATE items SET lastCount = 0")
//    suspend fun updateToCount()
//
//    // Specify the conflict strategy as IGNORE, when the user tries to add an
//    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ProjectTable)
//
//    @Update
//    suspend fun update(item: Item)
//
//    @Delete
//    suspend fun delete(item: Item)
}
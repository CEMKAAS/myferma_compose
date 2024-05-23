package com.zaroslikov.myfermacompose.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

@Dao
interface FermaDao {
    @Query("SELECT * from Project")
    fun getItem(): Flow<List<ProjectTable>>

    @Query("SELECT * from МyFerma Where idPT=:id")
    fun getAddProduct(id: Int): Flow<List<AddTable>>

    @Query("SELECT МyFerma.Title, sum(МyFerma.Count) - COALESCE(sum(МyFermaSale.Count),0) - COALESCE(sum(МyFermaWRITEOFF.Count),0) AS ResultCount FROM МyFerma LEFT JOIN МyFermaSale ON МyFerma.Title = МyFermaSale.Title and МyFerma.idPT = МyFermaSale.idPT LEFT JOIN МyFermaWRITEOFF ON МyFerma.Title = МyFermaWRITEOFF.Title and МyFerma.idPT = МyFermaWRITEOFF.idPT Where МyFerma.idPT=:id")
    fun getWareHouse(id: Int): Flow<List<WareHouseData>>

    @Query("SELECT * from МyFerma")
    fun getAddProductAll(): LiveData<List<AddTable>>

    @Query("SELECT * from МyFerma")
    fun getAddProductAll2(): Flow<List<AddTable>>

    @Query("SELECT * from МyFerma")
    fun getAddProductAllNeco(): Flow<List<AddTable>>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdd(addTable: AddTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdd2(addTable: AddTable)

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
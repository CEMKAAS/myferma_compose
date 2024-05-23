package com.zaroslikov.myfermacompose.data

import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

interface FermaRepository {

    fun getItem(): Flow<List<ProjectTable>>
    fun getWareHouse(id:Int): Flow<List<WareHouseData>>

    fun getAddProduct(id: Int):Flow<List<AddTable>>

    fun getAddProductAll():Flow<List<AddTable>>

    suspend fun insert(item:ProjectTable)
    suspend fun insertAdd(addTable: AddTable)
}
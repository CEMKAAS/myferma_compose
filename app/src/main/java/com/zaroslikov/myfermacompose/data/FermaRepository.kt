package com.zaroslikov.myfermacompose.data

import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

interface FermaRepository {

    fun getItem(): Flow<List<ProjectTable>>

    suspend fun insert(item:ProjectTable)
}
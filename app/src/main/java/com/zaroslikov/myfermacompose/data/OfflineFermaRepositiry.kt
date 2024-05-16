package com.zaroslikov.myfermacompose.data

import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

class OfflineFermaRepositiry(private val fermaDao: FermaDao) : FermaRepository {
    override fun getItem(): Flow<List<ProjectTable>> = fermaDao.getItem()


    override suspend fun insert(item: ProjectTable) = fermaDao.insert(item)

}
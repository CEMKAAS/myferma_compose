package com.zaroslikov.myfermacompose.data

import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import kotlinx.coroutines.flow.Flow

class OfflineFermaRepositiry(private val fermaDao: FermaDao) : FermaRepository {
    override fun getItem(): Flow<List<ProjectTable>> = fermaDao.getItem()


    override fun getWareHouse(id:Int): Flow<List<AddTable>> = fermaDao.getWareHouse(id)


    override suspend fun insert(item: ProjectTable) = fermaDao.insert(item)

}
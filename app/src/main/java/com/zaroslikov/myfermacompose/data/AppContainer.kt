package com.zaroslikov.myfermacompose.data

import android.content.Context

interface AppContainer {
    val fermaRepository: FermaRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val fermaRepository: FermaRepository by lazy {
        OfflineFermaRepositiry(FermaDatabase.getDatabase(context).fermaDao())
    }
}

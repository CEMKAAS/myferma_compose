package com.zaroslikov.myfermacompose

import android.app.Application
import com.yandex.mobile.ads.common.MobileAds
import com.zaroslikov.myfermacompose.data.AppContainer
import com.zaroslikov.myfermacompose.data.AppDataContainer

class FermaApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
//    val database: FermaDatabase by lazy { FermaDatabase.getDatabase(this) }
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        MobileAds.initialize(this){


        }
    }


}

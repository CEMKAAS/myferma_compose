package com.zaroslikov.myfermacompose.ui

import android.app.Application
import com.yandex.mobile.ads.common.MobileAds
import com.zaroslikov.myfermacompose.data.FermaDatabase

class FernaApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    val database: FermaDatabase by lazy { FermaDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this){


        }
    }


}

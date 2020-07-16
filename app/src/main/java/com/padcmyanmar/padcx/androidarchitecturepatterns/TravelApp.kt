package com.padcmyanmar.padcx.androidarchitecturepatterns

import android.app.Application
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.ToursModelImpl

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/16/2020.
 */
class TravelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ToursModelImpl.initDatabase(applicationContext)
    }
}
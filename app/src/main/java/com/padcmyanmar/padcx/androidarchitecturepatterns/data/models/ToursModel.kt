package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import io.reactivex.Observable

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
interface ToursModel {
    fun getAllTours() : Observable<ToursAndCountryVO>

    fun getToursByName(toursName: String) : LiveData<ToursVO>

    fun getAllToursOffline() : LiveData<List<ToursVO>>

    fun getAllCountriesOffline(): LiveData<List<ToursVO>>

    fun getDataOffline(): LiveData<List<ToursVO>>
}
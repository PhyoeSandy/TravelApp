package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.dummy.getDummyTours
import io.reactivex.Observable

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */

object MockToursModelImpl : ToursModel {

    override fun getAllTours(): Observable<ToursAndCountryVO> {
        return Observable.just(getDummyTours())
    }

    override fun getToursByName(toursName: String): LiveData<ToursVO> {
        val liveData = MutableLiveData<ToursVO>()
        liveData.postValue(getDummyTours().tours.first{
            it.name.equals(toursName)
        })
        return liveData
    }

    override fun getAllToursOffline(): LiveData<List<ToursVO>> {
        val liveData = MutableLiveData<List<ToursVO>>()
        liveData.postValue(getDummyTours().tours)
        return liveData
    }

    override fun getAllCountriesOffline(): LiveData<List<ToursVO>> {
        val liveData = MutableLiveData<List<ToursVO>>()
        liveData.postValue(getDummyTours().countries)
        return liveData
    }

    override fun getDataOffline(): LiveData<List<ToursVO>> {
        val liveData = MutableLiveData<List<ToursVO>>()
        liveData.postValue(getDummyTours().countries)
        return liveData
    }


}
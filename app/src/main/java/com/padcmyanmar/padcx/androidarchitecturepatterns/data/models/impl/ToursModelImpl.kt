package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.BaseModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
object ToursModelImpl: ToursModel, BaseModel() {

    private val countries = mToursApi.getAllCountries().map { it.data }
    private val tours = mToursApi.getAllTours().map { it.data }

    override fun getAllTours(): Observable<ToursAndCountryVO> {
        return Observable.zip<List<ToursVO>, List<ToursVO>, ToursAndCountryVO>(
                countries,
                tours,
                BiFunction { countries, tours ->
                    return@BiFunction ToursAndCountryVO(
                        countries,tours
                    )
                }
            )
            .doOnNext {
                val countriesList  = it.countries
                it.tours.forEach {data ->
                    data.status = 1
                }
                mDB.toursDao().insertAllTours(countriesList)
                mDB.toursDao().insertAllTours(it.tours)
            }
            .subscribeOn(Schedulers.io())
    }

    override fun getToursByName(toursName: String): LiveData<ToursVO> {
        return mDB.toursDao().getToursByName(toursName)
    }

    override fun getAllToursOffline(): LiveData<List<ToursVO>> {
        return mDB.toursDao().getAllPopularTours()
    }

    override fun getAllCountriesOffline(): LiveData<List<ToursVO>> {
        return mDB.toursDao().getAllCountries()
    }

    override fun getDataOffline(): LiveData<List<ToursVO>> {
        return mDB.toursDao().getAllTours()
    }


}
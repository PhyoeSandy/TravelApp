package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.BaseModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.persistence.db.ToursDB

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
class ToursModelImpl(var context: Context) : ToursModel, BaseModel() {
    private lateinit var mDB : ToursDB

    fun initDatabase(context: Context){
        mDB = ToursDB.getDBInstance(context)
    }

    override fun getAllTours(onError: (String) -> Unit): LiveData<ToursAndCountryVO> {
        TODO("Not yet implemented")
    }

    override fun getToursByName(toursName: String): LiveData<ToursVO> {
        TODO("Not yet implemented")
    }


}
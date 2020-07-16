package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.BaseModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
object ToursModelImpl: ToursModel, BaseModel() {

    override fun getAllTours(onError: (String) -> Unit): LiveData<ToursAndCountryVO> {
        TODO("Not yet implemented")
    }

    override fun getToursByName(toursName: String): LiveData<ToursVO> {
        TODO("Not yet implemented")
    }


}
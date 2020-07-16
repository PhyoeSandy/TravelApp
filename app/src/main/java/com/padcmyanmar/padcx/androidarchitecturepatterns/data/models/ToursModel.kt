package com.padcmyanmar.padcx.androidarchitecturepatterns.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/21/2020.
 */
interface ToursModel {
    fun getAllTours(onError: (String) -> Unit) : LiveData<ToursAndCountryVO>

    fun getToursByName(toursName: String) : LiveData<ToursVO>
}
package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views

import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO


/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/14/2020.
 */
interface ToursDetailsView : BaseView {
    fun displayToursDetails(tours: ToursVO)
}
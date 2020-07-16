package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.ToursDetailsView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/14/2020.
 */
interface ToursDetailsPresenter : BasePresenter<ToursDetailsView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner, toursName: String)
}
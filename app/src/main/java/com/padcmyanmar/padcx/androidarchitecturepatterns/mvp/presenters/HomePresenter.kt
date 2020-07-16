package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.HomeView
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
interface HomePresenter : ToursItemDelegate, BasePresenter<HomeView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}
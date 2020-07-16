package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views

import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
interface HomeView : BaseView {
    fun showEmptyView()
    fun hideEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun displayToursList(toursList: List<ToursVO>)
    fun navigateToToursDetails(toursName: String)
}
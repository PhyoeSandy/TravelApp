package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.ToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.HomePresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.HomeView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    var mToursModel: ToursModel = ToursModelImpl

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllTours(lifecycleOwner)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllTours(lifecycleOwner)
    }

    override fun onTapToursItem(toursName: String) {
        mView?.navigateToToursDetails(toursName)
    }

    private fun requestAllTours(lifecycleOwner: LifecycleOwner){
        mToursModel.getDataOffline() .observe(lifecycleOwner,
            Observer{
                mView?.disableSwipeRefresh()
                if(it.isEmpty()){
                    mView?.showEmptyView()
                }else{
                    mView?.displayToursList(it)
                }
            })
    }
}
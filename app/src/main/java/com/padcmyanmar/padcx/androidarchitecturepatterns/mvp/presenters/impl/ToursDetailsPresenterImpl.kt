package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.ToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.ToursDetailsPresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.ToursDetailsView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/14/2020.
 */
class ToursDetailsPresenterImpl : ToursDetailsPresenter, AbstractBasePresenter<ToursDetailsView>() {

    var mToursModel: ToursModel = ToursModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner, toursName: String) {
        mToursModel.getToursByName(toursName)
            .observe(lifecycleOwner, Observer {
                mView?.displayToursDetails(it)
            })
    }
}
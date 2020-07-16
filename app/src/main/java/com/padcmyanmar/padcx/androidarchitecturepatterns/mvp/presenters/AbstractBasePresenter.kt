package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    var mView: T?= null

    override fun initPresenter(view: T) {
          mView = view
    }
}
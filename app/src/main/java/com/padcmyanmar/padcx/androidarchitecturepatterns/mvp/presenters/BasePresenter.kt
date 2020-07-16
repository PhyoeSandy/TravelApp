package com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters

import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.BaseView


/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
interface BasePresenter<T: BaseView> {
    fun initPresenter(view: T)
}
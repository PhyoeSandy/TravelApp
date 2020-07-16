package com.padcmyanmar.padcx.androidarchitecturepatterns.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.MockToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.ToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.dummy.getDummyTours
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl.ToursDetailsPresenterImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.ToursDetailsView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */
@RunWith(AndroidJUnit4::class)
class DetailsPresenterImplTest {

    private lateinit var mPresenter: ToursDetailsPresenterImpl

    @RelaxedMockK
    private lateinit var mView: ToursDetailsView

    private lateinit var mToursModel: ToursModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        ToursModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mToursModel = MockToursModelImpl

        mPresenter = ToursDetailsPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mToursModel = this.mToursModel
    }

    @Test
    fun onUiReady_callDisplayToursList() {
        val lifeCycleOwner  = mock(LifecycleOwner::class.java)

        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner, "Sea Flower Resort")
        verify {
            mView.displayToursDetails(getDummyTours().tours[0])
        }
    }
}
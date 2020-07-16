package com.padcmyanmar.padcx.androidarchitecturepatterns.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.ToursModel
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.MockToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.models.impl.ToursModelImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.dummy.getDummyTours
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl.HomePresenterImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */
@RunWith(AndroidJUnit4::class)
class HomePresenterImplTest {

    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView: HomeView

    private lateinit var mToursModel: ToursModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        ToursModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mToursModel = MockToursModelImpl

        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mToursModel = this.mToursModel
    }

    @Test
    fun onTapTours_callNavigateToDetails() {
        val tourOne = ToursVO()
        tourOne.name = "Sea Flower Resort"
        tourOne.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        tourOne.location = "Koh Chang Thailand"
        tourOne.averageRating = 3.00

        mPresenter.onTapToursItem(tourOne.name)
        verify {
            mView.navigateToToursDetails(tourOne.name)
        }
    }

    @Test
    fun onUiReady_callDisplayToursList() {
       val lifeCycleOwner  = mock(LifecycleOwner::class.java)

       val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
       lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
       `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner)
        verify {
            mView.displayToursList(getDummyTours().tours)
        }
    }

}
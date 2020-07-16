package com.padcmyanmar.padcx.androidarchitecturepatterns.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.androidarchitecturepatterns.R
import com.padcmyanmar.padcx.androidarchitecturepatterns.adapters.CountryListAdapter
import com.padcmyanmar.padcx.androidarchitecturepatterns.adapters.ToursListAdapter
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.HomePresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl.HomePresenterImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.HomeView
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), HomeView {

    private lateinit var tourAdapter: ToursListAdapter
    private lateinit var countryAdapter: CountryListAdapter

    private lateinit var viewPodEmpty : EmptyViewPod

    private lateinit var mPresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupPresenter()

        setUpSwipeRefresh()

        setupViewPod()
        setupRecyclerView()
        mPresenter.onUiReady(this)
    }

    private fun setupPresenter(){
        mPresenter = ViewModelProviders.of(this)
            .get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayToursList(toursList: List<ToursVO>) {
        tourAdapter.setNewData(toursList.toMutableList())
        countryAdapter.setNewData(toursList.toMutableList())
    }

    override fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    override fun navigateToToursDetails(toursName: String) {

    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }

    private fun setupRecyclerView(){
        countryAdapter = CountryListAdapter(mPresenter)
        val hLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = hLayoutManager
        rvCountry.adapter =  countryAdapter

        tourAdapter = ToursListAdapter(mPresenter)
        rvTour.layoutManager = LinearLayoutManager(activity)
        rvTour.adapter = tourAdapter
    }

    private fun setupViewPod(){
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(
            "There are no tours available",
            "https://icons8.com/icon/46107/empty-box")

    }
}

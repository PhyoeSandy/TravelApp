package com.padcmyanmar.padcx.androidarchitecturepatterns.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.androidarchitecturepatterns.R
import com.padcmyanmar.padcx.androidarchitecturepatterns.adapters.PhotoListAdapter
import com.padcmyanmar.padcx.androidarchitecturepatterns.adapters.ScoreReivewsAdapter
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.ToursDetailsPresenter
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.presenters.impl.ToursDetailsPresenterImpl
import com.padcmyanmar.padcx.androidarchitecturepatterns.mvp.views.ToursDetailsView
import kotlinx.android.synthetic.main.activity_tours_details.*

class ToursDetailsActivity : BaseActivity(), ToursDetailsView {
    private lateinit var photoAdapter: PhotoListAdapter
    private lateinit var scoresReviewsAdapter: ScoreReivewsAdapter
    private lateinit var toursName : String
    private lateinit var mPresenter: ToursDetailsPresenter

    companion object{
        const val IE_TOURS_NAME = "IE_TOURS_NAME"

        fun newIntent(context : Context, toursName : String ) : Intent {
            val intent = Intent(context,ToursDetailsActivity::class.java)
            intent.putExtra(IE_TOURS_NAME,toursName)
            Log.d("Tours Name",toursName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tours_details)

        setupPresenter()
        setupRecyclerView()
        toursName = intent.getStringExtra(IE_TOURS_NAME)

        mPresenter.onUiReady(this,toursName)
    }

    private fun setupPresenter(){
        mPresenter = ViewModelProviders.of(this)
            .get(ToursDetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setupRecyclerView(){
        photoAdapter = PhotoListAdapter()
        val hLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvPhotos.layoutManager = hLayoutManager
        rvPhotos.adapter =  photoAdapter

        scoresReviewsAdapter = ScoreReivewsAdapter()
        rvScroeReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvScroeReview.adapter = scoresReviewsAdapter
    }

    override fun displayToursDetails(tours: ToursVO) {
        tvName.text = tours.name
        tvDescription.text = tours.description
        tvDetailsLocation.text = tours.location
        photoAdapter.setNewData(tours.photos)
        scoresReviewsAdapter.setNewData(tours.scoresAndReviews)

        Glide.with(this)
            .load(tours.photos[1])
            .into(ivPhotosDetail)
    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }
}

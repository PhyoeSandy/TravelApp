package com.padcmyanmar.padcx.androidarchitecturepatterns.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.androidarchitecturepatterns.R
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewholder.BaseTravelViewHolder
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewholder.TourViewHolder
import com.padcmyanmar.padcx.travelapp.delegates.ToursItemDelegate

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class ToursListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseTravelViewHolder, ToursVO>() {
    val mDelegate : ToursItemDelegate =delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTravelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tours,parent,false)
        return TourViewHolder(view,mDelegate)
    }
}
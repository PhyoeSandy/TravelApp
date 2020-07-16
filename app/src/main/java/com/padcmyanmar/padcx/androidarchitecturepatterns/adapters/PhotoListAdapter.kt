package com.padcmyanmar.padcx.androidarchitecturepatterns.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.androidarchitecturepatterns.R
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewholder.PhotoViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
class PhotoListAdapter : BaseRecyclerAdapter<PhotoViewHolder,String>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos,parent,false)
        return PhotoViewHolder(view)
    }
}
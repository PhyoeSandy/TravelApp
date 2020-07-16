package com.padcmyanmar.padcx.androidarchitecturepatterns.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewholder.BaseViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData: MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setNewData(data: MutableList<W>) {
        mData = data
        notifyDataSetChanged()
    }

    fun appendNewData(data: MutableList<W>) {
        mData.addAll(data)
        notifyDataSetChanged()
    }
}
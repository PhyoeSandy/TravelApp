package com.padcmyanmar.padcx.androidarchitecturepatterns.fragments

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Phyoe Sandy Soe Tun
 * on 3/13/2020.
 */
 abstract class BaseFragment : Fragment(){

    fun showSnackbar(message: String){
        activity?.window?.decorView?.let { Snackbar.make(it,message, Snackbar.LENGTH_LONG) }
    }
}
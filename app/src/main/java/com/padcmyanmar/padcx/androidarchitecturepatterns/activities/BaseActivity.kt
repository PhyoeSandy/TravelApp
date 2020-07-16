package com.padcmyanmar.padcx.androidarchitecturepatterns.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
 abstract class BaseActivity : AppCompatActivity(){

    fun showSnackbar(message: String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_LONG).show()
    }
}
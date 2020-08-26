package com.lipnus.sbu.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lipnus.sbu.R
import com.lipnus.sbu.util.LoadingDialog

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    open fun showLoadingDialog(){
        LoadingDialog.show(this)
    }

    open fun dismissLoadingDialog(){
        LoadingDialog.dismiss()
    }
}

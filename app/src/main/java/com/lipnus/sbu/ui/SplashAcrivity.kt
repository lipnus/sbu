package com.lipnus.sbu.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.lipnus.sbu.R
import com.lipnus.sbu.base.BaseActivity
import com.lipnus.sbu.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash_acrivity.*

class SplashAcrivity : BaseActivity() {

    private val DELAY_TIME:Long = 1500
    private val mHandler by lazy { Handler() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acrivity)

        initLayout()
        delayTime({goToMainActiviry()}, DELAY_TIME)
    }

    private fun initLayout(){
        YoYo.with(Techniques.Landing)
            .duration(800)
            .repeat(0)
            .playOn(title_iv)

        YoYo.with(Techniques.FadeIn)
            .duration(800)
            .repeat(0)
            .playOn(title_tv)

        YoYo.with(Techniques.FadeIn)
            .duration(800)
            .repeat(0)
            .playOn(title_sub_tv)

    }

    fun delayTime(delayedFun: ()->Unit, time: Long) {
        mHandler.postDelayed({ delayedFun() }, time )
    }

    fun goToMainActiviry(){
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }

        finish()
    }
}

package com.lipnus.sbu.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.lipnus.sbu.R
import com.lipnus.sbu.ui.main.first.FirstFragment
import com.lipnus.sbu.ui.main.second.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        initLayout()
    }


    fun initLayout(){

        navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_first -> {
                    supportFragmentManager.beginTransaction()
                        .show(firstFragment).hide(secondFragment).commit()

                }
                R.id.navigation_second -> {
                    supportFragmentManager.beginTransaction()
                        .hide(firstFragment).show(secondFragment).commit()
                }
            }
            true
        }
    }

    fun initFragment() {
        firstFragment = FirstFragment.newInstance("Ranking")
        secondFragment = SecondFragment.newInstance("History")

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, firstFragment)
            .add(R.id.fragment_container, secondFragment).hide(secondFragment)
            .commit()
    }
}

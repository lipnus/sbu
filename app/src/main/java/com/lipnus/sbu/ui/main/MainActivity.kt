package com.lipnus.sbu.ui.main

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.lipnus.sbu.R
import com.lipnus.sbu.model.SamsungMan
import com.lipnus.sbu.model.rawsheet.RawSheet
import com.lipnus.sbu.ui.main.first.FirstFragment
import com.lipnus.sbu.ui.main.second.SecondFragment
import com.lipnus.sbu.util.SHEET_URL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connect()

        showWelcomeToast()
        initFragment()
        initLayout()


    }

    private fun showWelcomeToast(){
        Toast.makeText(this, getString(R.string.welcome_comment), Toast.LENGTH_SHORT).show()
    }

    private fun initLayout(){

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

    private fun initFragment() {
        firstFragment = FirstFragment.newInstance("Ranking")
        secondFragment = SecondFragment.newInstance("History")

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, firstFragment)
            .add(R.id.fragment_container, secondFragment).hide(secondFragment)
            .commit()
    }


    private fun connect(){

        val queue = Volley.newRequestQueue(this)
        val url = SHEET_URL

        val stringRequest = StringRequest(
            Request.Method.GET, url, Response.Listener<String> { response ->
                val rawData = removeDollar(response)
                makePussiesData(rawData)
            },
            Response.ErrorListener {
                Log.d("SSS", "에러: $it")
            })

        queue.add(stringRequest)
    }


    //구글시트에서 변수명에 딸라를 붙여놨어
    private fun removeDollar(text: String): String{
        return text.replace("$", "")
    }

    private fun makePussiesData(rawData: String){

        var gson = Gson()
        val rawSheet = gson.fromJson(rawData, RawSheet::class.java)

        var pussies = List<SamsungMan>

        Log.d("SSS", "이름: ${rawSheet.feed.entry[0].gsxname.t}")
        Log.d("SSS", "이름: ${rawSheet.feed.entry[0].gsxmoney.t}")


    }
}

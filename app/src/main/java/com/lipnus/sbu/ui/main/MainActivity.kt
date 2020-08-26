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
import com.lipnus.sbu.base.BaseActivity
import com.lipnus.sbu.model.SamsungMan
import com.lipnus.sbu.model.rawsheet.RawSheet
import com.lipnus.sbu.ui.main.first.FirstFragment
import com.lipnus.sbu.ui.main.second.SecondFragment
import com.lipnus.sbu.util.IMG_SERVER_URL
import com.lipnus.sbu.util.LoadingDialog
import com.lipnus.sbu.util.SHEET_URL
import com.lipnus.sbu.util.pussies
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWelcomeToast()
        showLoadingDialog()
        connect()
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
        firstFragment = FirstFragment.newInstance("프레그먼트로 변수넘길거면 여기서 넘기면 됨")
        secondFragment = SecondFragment.newInstance()

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

                dismissLoadingDialog()
                makePussiesData(removeDollar(response))
                initFragment()
            },
            Response.ErrorListener {
                Log.d("SSS", "에러: $it")
                connect()
            })

        queue.add(stringRequest)
    }


    //구글시트 json 변수명에 딸라를 붙여놔서 지워준다
    private fun removeDollar(text: String): String{
        return text.replace("$", "")
    }

    private fun makePussiesData(rawData: String){

        var gson = Gson()
        val rawSheet = gson.fromJson(rawData, RawSheet::class.java)
        val size = rawSheet.feed.entry.size

        pussies = ArrayList(size)

        for(pro in rawSheet.feed.entry){
            val name = pro.gsxname.t
            val money = pro.gsxmoney.t.toInt()
            val path = IMG_SERVER_URL + name + ".jpg" //이미지 서버가 없어서 안나옴

            val pussy = SamsungMan(name, money, path)
            pussies.add(pussy)
        }

        pussies.sortBy { pussies -> pussies.money*(-1) }
        Log.d("SSS", "$pussies")
    }
}

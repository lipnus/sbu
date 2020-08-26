package com.lipnus.sbu.ui.main.second

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lipnus.sbu.R
import com.lipnus.sbu.model.History
import com.lipnus.sbu.model.SamsungMan
import com.lipnus.sbu.ui.main.first.FirstFragment
import com.lipnus.sbu.ui.main.first.PussyRecycleingViewAdapter
import com.lipnus.sbu.util.pussies


class SecondFragment : Fragment() {

    private lateinit var historyAdapter : HistoryRecycleingViewAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(com.lipnus.sbu.R.layout.fragment_second, container, false)
        initRecyclerView(view)

        val histories = ArrayList<History>()

        histories.add(History("박동익", "10000", "8월 15일"))
        histories.add(History("황선필", "10000", "8월 15일"))
        histories.add(History("조익환", "10000", "8월 15일"))

        updateRecyclerView(histories)
        return view
    }

    private fun initRecyclerView(view: View){

        recyclerView = view.findViewById(com.lipnus.sbu.R.id.recyclerview2)

        historyAdapter = HistoryRecycleingViewAdapter(context)

        recyclerView.run{
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }


    fun updateRecyclerView(items: List<History>){

        for(item in items){
            historyAdapter.addItem( item )
        }
        historyAdapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
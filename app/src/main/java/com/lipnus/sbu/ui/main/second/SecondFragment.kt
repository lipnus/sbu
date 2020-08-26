package com.lipnus.sbu.ui.main.second

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lipnus.sbu.R
import com.lipnus.sbu.model.History
import com.lipnus.sbu.model.SamsungMan
import com.lipnus.sbu.ui.main.first.FirstFragment
import com.lipnus.sbu.ui.main.first.PussyRecycleingViewAdapter
import com.lipnus.sbu.util.histories
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
package com.lipnus.sbu.ui.main.first

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lipnus.sbu.model.SamsungMan
import com.lipnus.sbu.util.pussies


private const val ARG_PARAM1 = "param1"


class FirstFragment : Fragment() {

    private var param1: String? = null

    private lateinit var pussiesAdapter : PussiesRecycleingViewAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(com.lipnus.sbu.R.layout.fragment_first, container, false)
        initRecyclerView(view)


        updateRecyclerView(pussies)
        return view
    }






    private fun initRecyclerView(view: View){

        recyclerView = view.findViewById(com.lipnus.sbu.R.id.recyclerview)

        pussiesAdapter = PussiesRecycleingViewAdapter(context).apply {
            setItemClickListener(object : PussiesRecycleingViewAdapter.ItemClickListener{

                override fun onClick(money: Int) {
                    TODO("각 인물 눌렀을 때")
                }
            })
        }

        recyclerView.run{
            adapter = pussiesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }


    fun updateRecyclerView(items: List<SamsungMan>){

        for(item in items){
            pussiesAdapter.addItem( item )
        }

        pussiesAdapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}

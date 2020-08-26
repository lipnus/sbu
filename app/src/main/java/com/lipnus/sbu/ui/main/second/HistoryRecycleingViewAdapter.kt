package com.lipnus.sbu.ui.main.second

import android.content.Context
import android.support.v4.content.res.TypedArrayUtils.getString
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lipnus.sbu.R
import com.lipnus.sbu.model.History

class HistoryRecycleingViewAdapter(val context: Context?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<History>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_history, parent, false)
        return CustomViewHolder(view)
    }

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var preHistroyTv : TextView = view.findViewById(R.id.history_pre_tv)
        var moneyTv: TextView = view.findViewById(R.id.money_tv)
        var postHistoryTv: TextView = view.findViewById(R.id.history_post_tv)
    }

    fun addItem(item: History){
        items.add(item)
    }

    fun getItem(position: Int): History{
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun deleteAll(){
        items.clear()
    }

    fun deleteItem(position: Int){
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        var view = holder as CustomViewHolder

        view.run{
            preHistroyTv.text = items[pos].date + " 호구 " + items[pos].name + "은 "
            moneyTv.text  = items[pos].money
            postHistoryTv.text = context!!.getString(R.string.histroy_post)
        }
    }
}

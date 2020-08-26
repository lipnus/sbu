package com.lipnus.sbu.ui.main.first

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lipnus.sbu.R
import com.lipnus.sbu.model.SamsungMan

class PussyRecycleingViewAdapter(val context: Context?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //데이터를 저장할 아이템리스트
    private val items = ArrayList<SamsungMan>()


    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(money: Int)
    }

    //클릭리스너
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    //각각의 아이템의 디자인레이아웃을 불러온다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_ranking, parent, false)
        return CustomViewHolder(view)
    }

    //커스텀 뷰홀더
    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var rankTv : TextView = view.findViewById(R.id.rank_tv)
        var nameTv: TextView = view.findViewById(R.id.name_tv)
        var moneyTv: TextView = view.findViewById(R.id.money_tv)
        var profileIv: ImageView = view.findViewById(R.id.profile_iv)
    }

    //아이템을 추가한다
    fun addItem(item: SamsungMan){
        items.add(item)
    }

    fun getItem(position: Int): SamsungMan{
        return items[position]
    }

    //아이템의 개수를 반환
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

    //각각의 아이템의 데이터를 바인딩 시켜준다
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        var view = holder as CustomViewHolder

        view.run{
            rankTv.text = (pos+1).toString()
            nameTv.text = items[pos].name
            moneyTv.text = items[pos].money.toString()
        }

        Glide
            .with(view.itemView.context)
            .load(items[pos].path)
            .placeholder(R.drawable.ic_coffee)
            .centerCrop()
            .into(view.profileIv)
    }
}

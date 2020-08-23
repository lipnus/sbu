package com.lipnus.sbu.ui.main.second

//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.lipnus.sbu.R
//import com.lipnus.sbu.model.SamsungMan
//
//class RankingRecycleingViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    //데이터를 저장할 아이템리스트
//    private val items = ArrayList<SamsungMan>()
//
//
//    //클릭 인터페이스 정의
//    interface ItemClickListener {
//        fun onDeleteClick(title:String, position: Int)
//        fun onClick(title:String, path:String)
//    }
//
//    //클릭리스너
//    private lateinit var itemClickListner: ItemClickListener
//
//    //클릭리스너 등록
//    fun setItemClickListener(itemClickListener: ItemClickListener) {
//        this.itemClickListner = itemClickListener
//    }
//
//    //각각의 아이템의 디자인레이아웃을 불러온다
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_ranking, parent, false)
//        return CustomViewHolder(view)
//    }
//
//    //커스텀 뷰홀더
//    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
//        var titleTv: TextView = view.findViewById(R.id.first_count_tv)
//        var categoryTv: TextView = view.findViewById(R.id.wrong_list_category_tv)
//        var deleteTv: TextView = view.findViewById(R.id.wrong_list_delete_tv)
//    }
//
//    //아이템을 추가한다
//    fun addItem(item: WrongItem){
//        items.add(item)
//    }
//
//    fun getItem(position: Int): WrongItem{
//        return items[position]
//    }
//
//    //아이템의 개수를 반환
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    fun deleteAll(){
//        items.clear()
//    }
//
//    fun deleteItem(position: Int){
//        items.removeAt(position)
//        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, items.size)
//
//    }
//
//    //각각의 아이템의 데이터를 바인딩 시켜준다
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
//        var view = holder as CustomViewHolder
//
//        view.run{
//            titleTv.text = items[pos].title
//            categoryTv.text = items[pos].path.split("/")[1]
//
//            //삭제를 눌렀을 때
//            deleteTv.setOnClickListener {
//                itemClickListner.onDeleteClick(items[pos].title, pos)
//            }
//        }
//
//        //문제를 눌렀을때
//        holder.itemView.setOnClickListener {
//
//            //오답표시와 삭제를 동시에 진행(일단 지워주고 틀리면 다시 추가)
//            itemClickListner.run{
//                onClick(items[pos].title, items[pos].path)
//                onDeleteClick(items[pos].title, pos)
//            }
//
//        }
//    }
//}

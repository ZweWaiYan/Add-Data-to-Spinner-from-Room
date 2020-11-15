package com.letuse.spinnerwithlocalarrayfragment.Category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.letuse.pos.room.Category.Category
import com.letuse.spinnerwithlocalarrayfragment.R
import kotlinx.android.synthetic.main.item_list.view.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    private var itemlist = emptyList<Category>()

    inner class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(cateogry: Category){
            itemView.txt_item_name.text = cateogry.category_name
            itemView.txt_item_id.text = cateogry.category_id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }

    fun addCategoryList(item : List<Category>){
        this.itemlist = item
        notifyDataSetChanged()
    }
}
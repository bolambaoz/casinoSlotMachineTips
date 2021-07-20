package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_cardview.view.*

class SlotAdapter (context: Context, list: ArrayList<SlotModel>, private val listener: onItemClicked):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context: Context = context
    var list: ArrayList<SlotModel> = list

    private inner class View1ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.home_cardview_image
        var text = view.title_txt
        var cardView = view.card_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return View1ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.home_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)

        if(holder is View1ViewHolder){
//            holder.image.setImageResource(item.image)
//            holder.text.text = item.foodName
//            holder.cardView.setOnClickListener{
//                listener.onClicked(context, item.foodName, item.imageDetail, item.foodDetails)
//            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onItemClicked {
        fun onClicked(context: Context, content: String, image: Int, imageDetail: Int)
    }
}
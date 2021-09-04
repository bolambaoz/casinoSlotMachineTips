package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_cardview.view.*
import kotlinx.android.synthetic.main.home_cardview.view.home_cardview_image
import kotlinx.android.synthetic.main.home_cardview.view.title_txt
import kotlinx.android.synthetic.main.home_full_cardview.view.*

class SlotAdapter (context: Context, list: ArrayList<SlotModel>,
    val typeView: Int, private val listener: onItemClicked):
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
        var textShortDescription = view.short_description_txt
        var btnReadMore = view.btn_read_more
        var cardView = view.full_card_view
    }

    private inner class View2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.home_cardview_image
        var cardView = view.card_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (typeView == VIEW_TYPE_TWO) {
            return View2ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.home2_cardview,
                    parent,
                    false
                )
            )
        }
        return View1ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.home_full_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)

        if(holder is View1ViewHolder){
//            holder.image.setImageResource(item.image)
            holder.text.text = item.name
            Glide.with(context).load(item.image).into(holder.image)
            holder.textShortDescription.text = item.description
            holder.btnReadMore.setOnClickListener{
                listener.onClicked(context,item.image, item.description, item.name)
            }
//            holder.cardView.setOnClickListener{
//                listener.onClicked(context,item.image, item.description)
//                Toast.makeText(context, "helloooo....", Toast.LENGTH_SHORT).show()
//            }
        }

        if(holder is View2ViewHolder){
            Glide.with(context).load(item.image).into(holder.image)
            holder.cardView.setOnClickListener{
                listener.onClickedImage(context,item.name)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onItemClicked {
        fun onClicked(context: Context, image: String, imageDetail: String, title: String)
        fun onClickedImage(context: Context, url: String)
    }

}
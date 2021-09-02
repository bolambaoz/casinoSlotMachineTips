package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_slot_list_screen.*
import kotlinx.android.synthetic.main.recycler2_home.*
import kotlinx.android.synthetic.main.recycler_home.*


class SlotListScreen : AppCompatActivity(), SlotAdapter.onItemClicked {

    private  var articles = mutableListOf<SlotModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_list_screen)

//        setupDialog()
//        popupAds()
        // first recyclerview decleration
        expand_text_view.setText(resources.getString(R.string.slot_intro))

        slot_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        slot_recycler.adapter = SlotAdapter(this, getSlotList(), 1, this)//(this,getAllRacing(), this)
        slot_recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
      // second recyclerview decleration
        slot2_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        slot2_recycler.adapter = SlotAdapter(this, getSlotList2(), 2, this)//(this,getAllRacing(), this)


    }

    private fun getSlotList(): ArrayList<SlotModel> {
//        val homeimages = resources.obtainTypedArray(R.array.array_image)
        val title = resources.getStringArray(R.array.array_text_title)
        val content = resources.getStringArray(R.array.array_description_list)
        val description = resources.getStringArray(R.array.array_text_description)
        val images = resources.getStringArray(R.array.array_image_main)
//        val contentDetails = resources.obtainTypedArray(R.array.array_image_detailsmain)
        val list = ArrayList<SlotModel>()


        for (i in 0 until content.count()){
            list.add(
                SlotModel( images[i],
                            title[i],
                                description[i])
            )
        }

        return list
    }

    private fun getSlotList2(): ArrayList<SlotModel> {
        val title = resources.getStringArray(R.array.array_text_title)
        val content = resources.getStringArray(R.array.array_description_list)
        val images = resources.getStringArray(R.array.array_image_small)
        val list = ArrayList<SlotModel>()

        for (i in 0 until content.count()){
            list.add(
                SlotModel( images[i],
                    title[i],
                    "")
            )
        }

        return list
    }

    override fun onClicked(context: Context,image: String, imageDetail: String) {

        val intent = Intent(this, SlotContent::class.java)
        startActivity(intent)

    }

    override fun onClickedImage(context: Context, url: String) {
        Toast.makeText(this, "helloooo....", Toast.LENGTH_SHORT).show()
    }
}
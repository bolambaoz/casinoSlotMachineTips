package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler2_home.*
import kotlinx.android.synthetic.main.recycler_home.*
import kotlinx.android.synthetic.main.recycler_home.slot_recycler

class SlotListScreen : AppCompatActivity(), SlotAdapter.onItemClicked {

    private  var articles = mutableListOf<SlotModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_list_screen)

//        setupDialog()
//        popupAds()
        slot_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        slot_recycler.adapter = SlotAdapter(this, getSlotList(), this)//(this,getAllRacing(), this)

        slot2_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        slot2_recycler.adapter = SlotAdapter(this, getSlotList(), this)//(this,getAllRacing(), this)


    }

    private fun getSlotList(): ArrayList<SlotModel> {
//        val homeimages = resources.obtainTypedArray(R.array.array_image)
//        val contentImage = resources.obtainTypedArray(R.array.array_image_details)
        val content = resources.getStringArray(R.array.array_description_list)
//        val contentDetails = resources.obtainTypedArray(R.array.array_image_detailsmain)
        val list = ArrayList<SlotModel>()


        for (i in 0 until content.count()){
            list.add(
                SlotModel(0,
                            "",
                                "")
            )
        }

        return list
    }

    override fun onClicked(context: Context, content: String, image: Int, imageDetail: Int) {
    }
}
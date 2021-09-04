package com.ninetysixgroup.guidetoslotmachine

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ninetysixgroup.guidetoslotmachine.viewmodel.SlotListScreenViewModel
import kotlinx.android.synthetic.main.activity_slot_list_screen.*
import kotlinx.android.synthetic.main.popup_ads_dialog.*
import kotlinx.android.synthetic.main.recycler2_home.*
import kotlinx.android.synthetic.main.recycler_home.*


class SlotListScreen : AppCompatActivity(), SlotAdapter.onItemClicked {

    private  var articles = mutableListOf<SlotModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_list_screen)

        initViewModel()

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
        val title = resources.getStringArray(R.array.array_text_title)
        val content = resources.getStringArray(R.array.array_description_list)
        val description = resources.getStringArray(R.array.array_text_description)
        val images = resources.getStringArray(R.array.array_image_main)
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

    override fun onClicked(context: Context,image: String, imageDetail: String, title: String) {

        val intent = Intent(this, SlotContent::class.java).apply {
            putExtra("detail", "${imageDetail}")
            putExtra("image", image)
            putExtra("title", title)
        }

        startActivity(intent)

    }

    override fun onClickedImage(context: Context, url: String) {
        toThreeLink()
    }

    private fun toThreeLink(){
        val url = "https://asia3we.com/"
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }

    // instanve of viewmodel

    private fun initViewModel() {
        val viewModel:SlotListScreenViewModel = ViewModelProvider(this).get(SlotListScreenViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,{

            if(it[0].isAllow == true){
//                recyclerAdapter.setCountryList(it)
//                recyclerAdapter.notifyDataSetChanged()
                popupAds()
            } else {
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.makeAPICall()
    }

    private fun popupAds(){

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_ads_dialog)
        dialog.setCancelable(false)
//        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
//        dialog.background.background = resources.getDrawable(imgs.getResourceId(random.nextInt(3), -1))
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.img_exit.setOnClickListener{
            dialog.dismiss()
        }

        dialog.btn_clickhere.setOnClickListener{
            toThreeLink()
        }

        dialog.show();
    }

}
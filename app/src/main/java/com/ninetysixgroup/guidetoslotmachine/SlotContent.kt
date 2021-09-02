package com.ninetysixgroup.guidetoslotmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.toolbar.*

class SlotContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_content)

        setSupportActionBar(toolbar)

        toolbar.title = ""

        img_back_arrow_content.setOnClickListener {
            onBackPressed()
        }

//        toolbar.isVisible = false
    }
}
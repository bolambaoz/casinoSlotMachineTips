package com.ninetysixgroup.guidetoslotmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.slot_content_text.*
import kotlinx.android.synthetic.main.toolbar.*

class SlotContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_content)

        setSupportActionBar(toolbar)

        val intent = intent
        val content = intent.getStringExtra("detail")
        val title = intent.getStringExtra("title")
        val imageContent = intent.getIntExtra("image", 0)

        toolbar.title = ""

        img_back_arrow_content.setOnClickListener {
            onBackPressed()
        }

        content_text_title.text = title
        txt_content_text.text = content

//        toolbar.isVisible = false
    }
}
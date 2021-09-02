package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SlotListScreen::class.java)
        getStarted.setOnClickListener{
            setData()
            startActivity(intent)
            finish()
        }

    }

    fun setData(){

        val insertText = true

        val sharePreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        val editor = sharePreferences.edit()

        editor.apply{
            putBoolean("BOOLEAN_KEY", insertText)
        }.apply()
    }
}
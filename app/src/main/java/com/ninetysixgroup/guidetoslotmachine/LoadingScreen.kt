package com.ninetysixgroup.guidetoslotmachine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_loading_screen.*

class LoadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        imageView.alpha = 0f

       if(!load()){
//           imageView.animate().setDuration(2000).alpha(1f).withEndAction{
//               val intent = Intent(this, MainActivity::class.java)
//               startActivity(intent)
//               overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
//               finish()
//           }
           setupIntent(this,MainActivity::class.java)
       }else{
           setupIntent(this,SlotListScreen::class.java)
       }
    }

    private fun setupIntent(activity: Context, toClass: Class<*>?){
           imageView.animate().setDuration(2000).alpha(1f).withEndAction{
               val intent = Intent(activity, toClass)
               startActivity(intent)
               overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
               finish()
           }
    }

    private fun load(): Boolean {
        val sharePreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        val saveBoolean = sharePreferences.getBoolean("BOOLEAN_KEY",false)
        return saveBoolean
    }
}
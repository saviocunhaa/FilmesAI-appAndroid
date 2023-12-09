package com.example.appfilmes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.appfilmes.view.FormLogin

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = Color.parseColor("#000000") //definir cor da statusBar do android

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
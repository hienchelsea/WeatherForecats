package com.sun.weatherforecats.ui.air

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.weatherforecats.R

class AirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air)
    }
    companion object {
        fun getIntent(context: Context) = Intent(context, AirActivity::class.java)
    }
}

package com.sun.weatherforecats.ui.managercity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.weatherforecats.R

class CityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, CityActivity::class.java)
    }
}

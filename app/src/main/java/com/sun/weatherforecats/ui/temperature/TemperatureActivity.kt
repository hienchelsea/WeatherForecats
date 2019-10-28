package com.sun.weatherforecats.ui.temperature

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.weatherforecats.R
import com.sun.weatherforecats.ui.managercity.CityActivity

class TemperatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
    }
    companion object {
        fun getIntent(context: Context) = Intent(context, TemperatureActivity::class.java)
    }
}

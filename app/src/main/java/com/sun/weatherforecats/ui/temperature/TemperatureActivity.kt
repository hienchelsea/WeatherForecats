package com.sun.weatherforecats.ui.temperature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.weatherforecats.R
import com.sun.weatherforecats.ui.temperature.temperaturedaily.TemperatureDailyFragment
import com.sun.weatherforecats.ui.temperature.temperaturehourly.TemperatureHourlyFragment
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureNowFragment
import kotlinx.android.synthetic.main.activity_temperature.*

class TemperatureActivity : AppCompatActivity() {

    private val _adapter: TemperaturePagerAdapter by lazy {
        TemperaturePagerAdapter(supportFragmentManager).apply {
            addFragment(TemperatureNowFragment.newInstance(), getString(R.string.now))
            addFragment(TemperatureHourlyFragment.newInstance(), getString(R.string.hourly))
            addFragment(TemperatureDailyFragment.newInstance(), getString(R.string.daily))
        }
    }

    private fun initViewPager() {
        viewPagerMain?.apply {
            this.adapter = _adapter
            setCurrentItem(0, true)
            tabLayoutMain?.setupWithViewPager(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        initViewPager()
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, TemperatureActivity::class.java)
    }
}

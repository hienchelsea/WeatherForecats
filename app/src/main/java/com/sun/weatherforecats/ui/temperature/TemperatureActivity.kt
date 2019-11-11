package com.sun.weatherforecats.ui.temperature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.ui.temperature.temperaturedaily.TemperatureDailyFragment
import com.sun.weatherforecats.ui.temperature.temperaturehourly.TemperatureHourlyFragment
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureNowFragment
import kotlinx.android.synthetic.main.activity_temperature.*

class TemperatureActivity : AppCompatActivity(), View.OnClickListener,
    TemperaturePagerAdapter.OnLoadCallback {

    private val cityName by lazy {
        intent.getStringExtra("CityName")
    }

    private val _adapter: TemperaturePagerAdapter by lazy {
        TemperaturePagerAdapter(supportFragmentManager, this).apply {
            addFragment(TemperatureNowFragment.newInstance(this, cityName), getString(R.string.now))
            addFragment(TemperatureHourlyFragment.newInstance(this,cityName), getString(R.string.hourly))
            addFragment(TemperatureDailyFragment.newInstance(this,cityName), getString(R.string.daily))
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
        initView()
        initViewPager()
    }

    private fun initView() {
        textViewCityNameNow.text = cityName
        assignViews(imageViewBack)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewBack -> {
                onBackPressed()
            }
        }
    }

    override fun backFragment() {
        onBackPressed()
    }

    companion object {

        fun getIntent(context: Context, cityName: String): Intent {
            val intent = Intent(context, TemperatureActivity::class.java)
            intent.putExtra("CityName", cityName)
            return intent
        }
    }
}

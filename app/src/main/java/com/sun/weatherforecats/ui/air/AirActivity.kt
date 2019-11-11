package com.sun.weatherforecats.ui.air

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.ui.air.airhistory.AirrHistoryFragment
import com.sun.weatherforecats.ui.air.airhourly.AirHourlyFragment
import com.sun.weatherforecats.ui.air.airnow.AirNowFragment
import com.sun.weatherforecats.ui.temperature.TemperaturePagerAdapter
import kotlinx.android.synthetic.main.activity_air.*

class AirActivity : AppCompatActivity(), View.OnClickListener ,TemperaturePagerAdapter.OnLoadCallback{

    private val cityName by lazy {
        intent.getStringExtra("CityName")
    }

    private val _adapter: TemperaturePagerAdapter by lazy {
        TemperaturePagerAdapter(supportFragmentManager,this).apply {
            addFragment(AirNowFragment.newInstance(this,cityName), getString(R.string.now))
            addFragment(AirHourlyFragment.newInstance(this,cityName), getString(R.string.hourly))
            addFragment(AirrHistoryFragment.newInstance(this,cityName), getString(R.string.history))
        }
    }

    private fun initViewPager() {
        viewPagerMainAir?.apply {
            this.adapter = _adapter
            setCurrentItem(0, true)
            tabLayoutMainAir?.setupWithViewPager(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air)
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
            val intent = Intent(context, AirActivity::class.java)
            intent.putExtra("CityName", cityName)
            return intent
        }
    }
}

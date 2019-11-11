package com.sun.weatherforecats.ui.temperature.temperaturedaily

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.databinding.TemperatureHourlyDetailFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.tempersture_daily_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setImageUrl
import url

class TemperatureDailyDetailFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<TemperatureHourlyDetailFragmentBinding, TemperatureDailyDetailViewModel>(),
    View.OnClickListener {

    override val layoutId: Int = R.layout.tempersture_daily_detail_fragment

    override val bindingVariable = BR.viewModel

    override val viewModel: TemperatureDailyDetailViewModel by viewModel()

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("WeatherCurrentDaily")
        val weatherCurrent = GsonUtils.getGsonParser()?.fromJson(
            stringWeatherCurrent,
            WeatherDaily::class.java
        )
        weatherCurrent?.let { viewModel.getTemperatureDaily(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewBack -> {
                onBackPressed.backFragment()
            }
        }
    }

    override fun observeViewModel() {
        viewModel.temperatureDaily.observe(viewLifecycleOwner, Observer {
            imageViewTemperatureCurrent.setImageUrl(url(it.weather.icon))
            textViewWeatherTemCurrentDetail.text = it.minTemp + " - " + it.maxTemp
            textViewWeatherTemCurrentFeelDetail.text = it.appMinTemp + " - " + it.appMinTemp
            textViewSunCurrent.text = it.sunsetTs + " - " + it.sunriseTs
            textViewMonCurrent.text = it.moonsetTs + " - " + it.moonriseTs
        })
    }

    companion object {
        fun newInstance(
            onBackPressed: OnBackFragment,
            weatherDaily: WeatherDaily
        ): TemperatureDailyDetailFragment {
            val temperatureDailyDetailFragment = TemperatureDailyDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringWeatherCurrent = GsonUtils.getGsonParser()?.toJson(weatherDaily)
            bundle.putSerializable("WeatherCurrentDaily", stringWeatherCurrent)
            temperatureDailyDetailFragment.arguments = bundle
            return temperatureDailyDetailFragment
        }
    }

}

package com.sun.weatherforecats.ui.temperature.temperaturehourly

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.TemperatureHourlyDetailFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.temperature_hourly_detail_fragment.*
import kotlinx.android.synthetic.main.temperature_now_fragment.imageViewTemperatureCurrent
import org.koin.androidx.viewmodel.ext.android.viewModel
import setImageUrl
import url

class TemperatureHourlyDetailFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<TemperatureHourlyDetailFragmentBinding, TemperatureHourlyDetailViewModel>(),
    View.OnClickListener {

    override val viewModel: TemperatureHourlyDetailViewModel by viewModel()
    override val layoutId = R.layout.temperature_hourly_detail_fragment
    override val bindingVariable = BR.viewModel

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("WeatherCurrentHourly")
        val weatherCurrent = GsonUtils.getGsonParser()?.fromJson(
            stringWeatherCurrent,
            WeatherHourly::class.java
        )
        weatherCurrent?.let { viewModel.getTemperatureHourly(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun observeViewModel() {
        viewModel.temperatureHourly.observe(viewLifecycleOwner, Observer {
            imageViewTemperatureCurrent.setImageUrl(url(it.weather.icon))
        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewBack -> {
                onBackPressed.backFragment()
            }
        }
    }


    companion object {
        fun newInstance(
            onBackPressed: OnBackFragment,
            weatherHourly: WeatherHourly
        ): TemperatureHourlyDetailFragment {
            val temperatureHourlyDetailFragment = TemperatureHourlyDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringWeatherCurrent = GsonUtils.getGsonParser()?.toJson(weatherHourly)
            bundle.putSerializable("WeatherCurrentHourly", stringWeatherCurrent)
            temperatureHourlyDetailFragment.arguments = bundle
            return temperatureHourlyDetailFragment
        }
    }

}

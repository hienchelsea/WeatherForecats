package com.sun.weatherforecats.ui.temperature.temperaturenow

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.databinding.TemperatureCurrentDetailFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.temperature_current_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setImageUrl
import url

class TemperatureCurrentDetailFragment(
    private val onBackPressed: OnBackFragment
) :
    BaseFragment<TemperatureCurrentDetailFragmentBinding, TemperatureCurrentDetailViewModel>(),
    View.OnClickListener {

    override val viewModel: TemperatureCurrentDetailViewModel by viewModel()
    override val layoutId = R.layout.temperature_current_detail_fragment
    override val bindingVariable: Int = BR.viewModel

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("WeatherCurrent")
        val weatherCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringWeatherCurrent, WeatherCurrent::class.java)
        weatherCurrent?.let { viewModel.getTemperatureCurrent(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun observeViewModel() {
        viewModel.temperatureCurrent.observe(viewLifecycleOwner, Observer {
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
            weatherCurrent: WeatherCurrent
        ): TemperatureCurrentDetailFragment {
            val temperatureCurrentDetailFragment = TemperatureCurrentDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringWeatherCurrent = GsonUtils.getGsonParser()?.toJson(weatherCurrent)
            bundle.putSerializable("WeatherCurrent", stringWeatherCurrent)
            temperatureCurrentDetailFragment.arguments = bundle
            return temperatureCurrentDetailFragment
        }
    }


}

package com.sun.weatherforecats.ui.air.airhourly

import airDDescriptionHandler
import airImageHandler
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.AirHourlyFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.air_hourly_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirHourlyDetailFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirHourlyFragmentBinding, AirHourlyDetailViewModel>(), View.OnClickListener {

    override val layoutId: Int = R.layout.air_hourly_detail_fragment
    override val bindingVariable: Int = BR.viewModel
    override val viewModel: AirHourlyDetailViewModel by viewModel()

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("WeatherAirHourly")
        val weatherCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringWeatherCurrent, WeatherHourly::class.java)
        weatherCurrent?.let { viewModel.getTemperatureHourly(it) }

        val stringAirCurrent = arguments?.getString("AirHourlyy")
        val airCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringAirCurrent, AirHourly::class.java)
        airCurrent?.let { viewModel.getAirHourly(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun observeViewModel() {
        viewModel.airHourly.observe(viewLifecycleOwner, Observer {
            textViewWeatherCurrentDescriptionDetail.text =
                getString(airDDescriptionHandler(it.aqi.toDouble()))
            imageViewTemperatureCurrent.setImageResource((airImageHandler(it.aqi.toDouble())))
        })
        viewModel.temperatureHourly.observe(viewLifecycleOwner, Observer {

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
            weatherHourly: WeatherHourly,
            airHourly: AirHourly
        ): AirHourlyDetailFragment {
            val airHourlyDetailFragment = AirHourlyDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringTemCurrent = GsonUtils.getGsonParser()?.toJson(weatherHourly)
            val stringAirCurrent = GsonUtils.getGsonParser()?.toJson(airHourly)
            bundle.putSerializable("WeatherAirHourly", stringTemCurrent)
            bundle.putSerializable("AirHourlyy", stringAirCurrent)
            airHourlyDetailFragment.arguments = bundle
            return airHourlyDetailFragment
        }
    }

}

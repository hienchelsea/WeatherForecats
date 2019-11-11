package com.sun.weatherforecats.ui.air.airnow

import airDDescriptionHandler
import airImageHandler
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirCurrent
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.databinding.AirNowDetailFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.air_now_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirNowDetailFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirNowDetailFragmentBinding, AirNowDetailViewModel>(),View.OnClickListener {
    override val layoutId: Int = R.layout.air_now_detail_fragment

    override val bindingVariable: Int = BR.viewModel

    override val viewModel: AirNowDetailViewModel by viewModel()

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("WeatherAirCurrent")
        val weatherCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringWeatherCurrent, WeatherCurrent::class.java)
        weatherCurrent?.let { viewModel.getTemperatureCurrent(it) }

        val stringAirCurrent = arguments?.getString("AirCurrent")
        val airCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringAirCurrent, AirCurrent::class.java)
        airCurrent?.let { viewModel.getAirCurrent(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun observeViewModel() {
        viewModel.airCurrent.observe(viewLifecycleOwner, Observer {
            textViewDescriptionTemCurrent.text =
                getString(airDDescriptionHandler(it.aqi.toDouble()))
            imageViewTemperatureCurrent.setImageResource((airImageHandler(it.aqi.toDouble())))
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
            weatherCurrent: WeatherCurrent,
            airCurrent: AirCurrent
        ): AirNowDetailFragment {
            val airCurrentDetailFragment = AirNowDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringTemCurrent = GsonUtils.getGsonParser()?.toJson(weatherCurrent)
            val stringAirCurrent = GsonUtils.getGsonParser()?.toJson(airCurrent)
            bundle.putSerializable("WeatherAirCurrent", stringTemCurrent)
            bundle.putSerializable("AirCurrent", stringAirCurrent)
            airCurrentDetailFragment.arguments = bundle
            return airCurrentDetailFragment
        }
    }

}

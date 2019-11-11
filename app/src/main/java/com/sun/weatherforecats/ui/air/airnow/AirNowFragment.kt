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
import com.sun.weatherforecats.databinding.AirNowFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import kotlinx.android.synthetic.main.air_now_fragment.*
import kotlinx.android.synthetic.main.load_data_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class AirNowFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirNowFragmentBinding, AirNowViewModel>(),
    View.OnClickListener, OnBackFragment {

    override val layoutId: Int = R.layout.air_now_fragment

    override val bindingVariable: Int = BR.viewModel

    override val viewModel: AirNowViewModel by viewModel()
    private lateinit var weatherCurrent: WeatherCurrent
    private lateinit var airCurrent: AirCurrent

    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initData() {
        nameCity?.let {
            viewModel.getAirCurrent(it)
            viewModel.getTemperatureCurrent(it)
        }
    }

    override fun initView() {
        setUi(progressBar, cardViewAirCurrent)
        assignViews(constraintLayoutAirCurrent)
    }

    override fun observeViewModel() {
        viewModel.temperatureCurrent.observe(viewLifecycleOwner, Observer {
            weatherCurrent = it
        })
        viewModel.airCurrent.observe(viewLifecycleOwner, Observer {
            textViewDescriptionAirCurrent.text =
                getString(airDDescriptionHandler(it.aqi.toDouble()))
            imageViewAirCurrent.setImageResource((airImageHandler(it.aqi.toDouble())))
            airCurrent = it
            setUi(cardViewAirCurrent, progressBar)
        })

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.constraintLayoutAirCurrent -> addFragment(
                R.id.relativeMain,
                AirNowDetailFragment.newInstance(this, weatherCurrent, airCurrent), true
            )
        }
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }

    companion object {
        fun newInstance(onBackPressed: OnBackFragment, nameCity: String): AirNowFragment {
            val temperatureNowFragment = AirNowFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }

}

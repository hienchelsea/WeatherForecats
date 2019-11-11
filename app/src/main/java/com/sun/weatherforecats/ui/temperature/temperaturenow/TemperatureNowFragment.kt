package com.sun.weatherforecats.ui.temperature.temperaturenow

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.databinding.TemperatureNowFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import kotlinx.android.synthetic.main.load_data_progress.*
import kotlinx.android.synthetic.main.temperature_now_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setImageUrl
import setUi
import url

class TemperatureNowFragment(
    private val onBackPressed: OnBackFragment
) : BaseFragment<
        TemperatureNowFragmentBinding,
        TemperatureNowViewModel>(), View.OnClickListener,
    OnBackFragment {

    override val viewModel: TemperatureNowViewModel by viewModel()
    override val layoutId = R.layout.temperature_now_fragment
    override val bindingVariable: Int = BR.viewModel
    private lateinit var weatherCurrent: WeatherCurrent
    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initData() {
        nameCity?.let { viewModel.getTemperatureCurrent(it) }
        setUi(progressBar, cardViewTemCurrent)
    }

    override fun initView() {
        assignViews(constraintLayoutTemCurrent)

    }

    override fun observeViewModel() {
        viewModel.temperatureCurrent.observe(viewLifecycleOwner, Observer {
            setUi(cardViewTemCurrent, progressBar)
            imageViewTemperatureCurrent.setImageUrl(url(it.weather.icon))
            weatherCurrent = it
        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.constraintLayoutTemCurrent -> addFragment(
                R.id.relativeMain,
                TemperatureCurrentDetailFragment.newInstance(this, weatherCurrent),
                true
            )
        }
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }

    companion object {
        fun newInstance(onBackPressed: OnBackFragment, nameCity: String): TemperatureNowFragment {
            val temperatureNowFragment = TemperatureNowFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }

}

package com.sun.weatherforecats.ui.temperature.temperaturehourly

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.TemperatyreHourlyFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureNowFragment
import kotlinx.android.synthetic.main.load_data_progress.*
import kotlinx.android.synthetic.main.temperatyre_hourly_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class TemperatureHourlyFragment(
    private val onBackPressed: OnBackFragment
) :
    BaseFragment<TemperatyreHourlyFragmentBinding, TemperatureHourlyViewModel>(),
    TemperatureHourlyAdapter.OnItemClickListener, OnBackFragment {

    override val viewModel: TemperatureHourlyViewModel by viewModel()

    override val layoutId = R.layout.temperatyre_hourly_fragment

    override val bindingVariable = BR.viewModel

    private val temperatureHourlyAdapter: TemperatureHourlyAdapter by lazy {
        TemperatureHourlyAdapter(this)
    }
    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initData() {
        nameCity?.let { viewModel.getTemperatureHourly(it) }
    }

    override fun initView() {
        setUi(progressBar, constraintLayoutTemHours)
        recyclerViewTemHourly.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = temperatureHourlyAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.temperatureHourly.observe(viewLifecycleOwner, Observer {
            temperatureHourlyAdapter.insertData(it)
            setUi(constraintLayoutTemHours, progressBar)
        })
    }

    override fun onWeather(itemData: WeatherHourly) {
        addFragment(
            R.id.relativeMain,
            TemperatureHourlyDetailFragment.newInstance(this,itemData), true
        )
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }

    companion object {
        fun newInstance(onBackPressed: OnBackFragment,nameCity: String): TemperatureHourlyFragment {
            val temperatureNowFragment = TemperatureHourlyFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }

}

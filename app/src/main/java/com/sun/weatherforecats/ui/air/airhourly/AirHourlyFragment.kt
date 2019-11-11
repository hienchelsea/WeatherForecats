package com.sun.weatherforecats.ui.air.airhourly

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.AirHourlyFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import kotlinx.android.synthetic.main.air_hourly_fragment.*
import kotlinx.android.synthetic.main.load_data_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class AirHourlyFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirHourlyFragmentBinding, AirHourlyViewModel>(),
    AirHourlyAdapter.OnItemClickListener, OnBackFragment {

    override val layoutId: Int = R.layout.air_hourly_fragment

    override val bindingVariable: Int = BR.viewModel

    override val viewModel: AirHourlyViewModel by viewModel()

    private val airHourlyAdapter: AirHourlyAdapter by lazy {
        AirHourlyAdapter(this)
    }

    private var weatherHourlys = mutableListOf<WeatherHourly>()

    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initData() {
        nameCity?.let {
            viewModel.getAirHourly(it)
            viewModel.getTemperatureHourly(it)
        }
    }

    override fun initView() {
        setUi(progressBar, constraintLayoutAirHours)
        recyclerViewAirHourly.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = airHourlyAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.airHourly.observe(viewLifecycleOwner, Observer {
            airHourlyAdapter.insertData(it)
            setUi(constraintLayoutAirHours, progressBar)
        })
        viewModel.temperatureHourly.observe(viewLifecycleOwner, Observer {
            weatherHourlys = it.toMutableList()
        })
    }

    override fun onAir(itemData: AirHourly, itemPosition: Int) {
        addFragment(
            R.id.relativeMain,
            AirHourlyDetailFragment.newInstance(this, weatherHourlys[itemPosition], itemData), true
        )
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }


    companion object {
        fun newInstance(onBackPressed: OnBackFragment, nameCity: String): AirHourlyFragment {
            val temperatureNowFragment = AirHourlyFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }
}

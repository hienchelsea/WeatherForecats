package com.sun.weatherforecats.ui.temperature.temperaturedaily

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.databinding.TemperatureDailyFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import kotlinx.android.synthetic.main.load_data_progress.*
import kotlinx.android.synthetic.main.temperature_daily_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class TemperatureDailyFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<TemperatureDailyFragmentBinding, TemperatureDailyViewModel>(),
    TemperatureDailyAdapter.OnItemClickListener, OnBackFragment {

    override val viewModel: TemperatureDailyViewModel by viewModel()
    override val layoutId: Int = R.layout.temperature_daily_fragment
    override val bindingVariable: Int = BR.viewModel

    private val temperatureDailyAdapter: TemperatureDailyAdapter by lazy {
        TemperatureDailyAdapter(this)
    }

    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initView() {
        setUi(progressBar, recyclerViewTemDaily)
        recyclerViewTemDaily.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = temperatureDailyAdapter
        }
    }

    override fun initData() {
        nameCity?.let { viewModel.getTemperatureDaily(it) }
        setUi(progressBar, recyclerViewTemDaily)
    }

    override fun observeViewModel() {
        viewModel.temperatureDaily.observe(viewLifecycleOwner, Observer {
            setUi(recyclerViewTemDaily, progressBar)
            temperatureDailyAdapter.insertData(it)
        })
    }

    override fun onWeather(itemData: WeatherDaily) {
        addFragment(
            R.id.relativeMain,
            TemperatureDailyDetailFragment.newInstance(this,itemData), true
        )
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }

    companion object {
        fun newInstance(onBackPressed: OnBackFragment, nameCity: String): TemperatureDailyFragment {
            val temperatureNowFragment = TemperatureDailyFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }

}

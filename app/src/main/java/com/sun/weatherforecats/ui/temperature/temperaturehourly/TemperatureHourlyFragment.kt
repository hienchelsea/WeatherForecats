package com.sun.weatherforecats.ui.temperature.temperaturehourly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.Weather
import com.sun.weatherforecats.data.model.WeatherHourly
import kotlinx.android.synthetic.main.temperatyre_hourly_fragment.*

class TemperatureHourlyFragment : Fragment(), TemperatureHourlyAdapter.OnItemClickListener {

    private lateinit var viewModel: TemperatureHourlyViewModel

    private val temperatureHourlyAdapter: TemperatureHourlyAdapter by lazy {
        TemperatureHourlyAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.temperatyre_hourly_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TemperatureHourlyViewModel::class.java)

        recyclerViewTemHourly.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = temperatureHourlyAdapter
        }

        var itemData = mutableListOf<WeatherHourly>()
        itemData.add(
            WeatherHourly(
                "bb",
                1,
                "hhh",
                "bbb",
                12.1,
                2.1,
                11.1,
                Weather("nnn", 12, "cccc"),
                11.1,
                "aaa",
                11,
                11,
                111,
                11.1,
                1,
                "ssss",
                11.1,
                11.1,
                11.1,
                11,
                11.11,
                1,
                1,
                11.1,
                11.1,
                11.1,
                11.1,
                "hh",
                11.1,
                111.1,
                1,
                1
            )
        )
        itemData.add(
            WeatherHourly(
                "bb",
                1,
                "hhh",
                "bbb",
                12.1,
                2.1,
                11.1,
                Weather("nnn", 12, "cccc"),
                11.1,
                "aaa",
                11,
                11,
                111,
                11.1,
                1,
                "ssss",
                11.1,
                11.1,
                11.1,
                11,
                11.11,
                1,
                1,
                11.1,
                11.1,
                11.1,
                11.1,
                "hh",
                11.1,
                111.1,
                1,
                1
            )
        )
        temperatureHourlyAdapter.updateData(itemData.toList())
        // TODO: Use the ViewModel
    }

    override fun onInsert(itemData: WeatherHourly) {
        lateinit var itemData: MutableList<WeatherHourly>
        itemData.add(
            WeatherHourly(
                "bb",
                1,
                "hhh",
                "bbb",
                12.1,
                2.1,
                11.1,
                Weather("nnn", 12, "cccc"),
                11.1,
                "aaa",
                11,
                11,
                111,
                11.1,
                1,
                "ssss",
                11.1,
                11.1,
                11.1,
                11,
                11.11,
                1,
                1,
                11.1,
                11.1,
                11.1,
                11.1,
                "hh",
                11.1,
                111.1,
                1,
                1
            )
        )
        itemData.add(
            WeatherHourly(
                "hh",
                1,
                "hhh",
                "bbb",
                12.1,
                2.1,
                11.1,
                Weather("nnn", 12, "cccc"),
                11.1,
                "aaa",
                11,
                11,
                111,
                11.1,
                1,
                "ssss",
                11.1,
                11.1,
                11.1,
                11,
                11.11,
                1,
                1,
                11.1,
                11.1,
                11.1,
                11.1,
                "hh",
                11.1,
                111.1,
                1,
                1
            )
        )
        temperatureHourlyAdapter.insertData(itemData)
    }

    companion object {
        fun newInstance() = TemperatureHourlyFragment()
    }

}

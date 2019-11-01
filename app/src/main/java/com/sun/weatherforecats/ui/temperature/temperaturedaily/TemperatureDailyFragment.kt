package com.sun.weatherforecats.ui.temperature.temperaturedaily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.Weather
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.data.model.WeatherHourly
import kotlinx.android.synthetic.main.temperature_daily_fragment.*

class TemperatureDailyFragment : Fragment(), TemperatureDailyAdapter.OnItemClickListener {

    private lateinit var viewModel: TemperatureDailyViewModel

    private val temperatureDailyAdapter: TemperatureDailyAdapter by lazy {
        TemperatureDailyAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.temperature_daily_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TemperatureDailyViewModel::class.java)
        // TODO: Use the ViewModel
        recyclerViewTemDaily.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = temperatureDailyAdapter
        }
        var itemData = mutableListOf<WeatherDaily>()
        itemData.add(
            WeatherDaily(
                1,
                "ccc",
                1,
                1.1,
                1,
                1,
                1.1,
                1.1,
                1.1,
                1,
                1,
                11,
                1,
                1.1,
                1.1,
                1,
                "aa",
                1.1,
                "bb",
                1.1,
                1.1,
                1.1,
                1,
                1.1,
                Weather("cc", 1, "cc"),
                1,
                1,
                1,
                1.1,
                1.1,
                1.1,
                1,
                "cc",
                1.1,
                1.11,
                1,
                1
            )
        )
        temperatureDailyAdapter.updateData(itemData)
    }

    override fun onInsert(itemData: WeatherHourly) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = TemperatureDailyFragment()
    }

}

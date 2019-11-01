package com.sun.weatherforecats.ui.temperature.temperaturehourly

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sun.weatherforecats.R

class TemperatureHourlyFragment : Fragment() {

    private lateinit var viewModel: TemperatureHourlyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.temperatyre_hourly_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TemperatureHourlyViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = TemperatureHourlyFragment()
    }

}

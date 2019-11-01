package com.sun.weatherforecats.ui.temperature.temperaturenow

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sun.weatherforecats.R

class TemperatureNowFragment : Fragment() {

    private lateinit var viewModel: TemperatureNowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.temperature_now_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TemperatureNowViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = TemperatureNowFragment()
    }


}

package com.sun.weatherforecats.ui.temperature.temperaturedaily

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sun.weatherforecats.R

class TemperatureDailyFragment : Fragment() {

    companion object {
        fun newInstance() = TemperatureDailyFragment()
    }

    private lateinit var viewModel: TemperatureDailyViewModel

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
    }

}

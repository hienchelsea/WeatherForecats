package com.sun.weatherforecats.ui.air.airhistory

import airDDescriptionHandler
import airImageHandler
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHistory
import com.sun.weatherforecats.databinding.AirHistoryDetailFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.utils.GsonUtils
import kotlinx.android.synthetic.main.air_history_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirHistoryDetailFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirHistoryDetailFragmentBinding, AirHistoryDetailViewModel>(),
    View.OnClickListener {
    override val layoutId: Int = R.layout.air_history_detail_fragment

    override val bindingVariable = BR.viewModel

    override val viewModel: AirHistoryDetailViewModel by viewModel()

    override fun initData() {
        val stringWeatherCurrent = arguments?.getString("AirHistory")
        val weatherCurrent =
            GsonUtils.getGsonParser()?.fromJson(stringWeatherCurrent, AirHistory::class.java)
        weatherCurrent?.let { viewModel.getAirHistory(it) }
    }

    override fun initView() {
        assignViews(imageViewBack)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewBack -> {
                onBackPressed.backFragment()
            }
        }
    }

    override fun observeViewModel() {
        viewModel.airHistory.observe(viewLifecycleOwner, Observer {
            textViewWeatherCurrentDescriptionDetail.text =
                getString(airDDescriptionHandler(it.aqi.toDouble()))
            imageViewTemperatureCurrent.setImageResource((airImageHandler(it.aqi.toDouble())))
        })
    }

    companion object {
        fun newInstance(
            onBackPressed: OnBackFragment,
            airHistory: AirHistory
        ): AirHistoryDetailFragment {
            val airHistoryDetailFragment = AirHistoryDetailFragment(onBackPressed)
            val bundle = Bundle()
            val stringAirHistory = GsonUtils.getGsonParser()?.toJson(airHistory)
            bundle.putSerializable("AirHistory", stringAirHistory)
            airHistoryDetailFragment.arguments = bundle
            return airHistoryDetailFragment
        }
    }

}

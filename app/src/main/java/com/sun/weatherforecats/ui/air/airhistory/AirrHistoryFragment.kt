package com.sun.weatherforecats.ui.air.airhistory

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sun.weatherforecats.BR
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHistory
import com.sun.weatherforecats.databinding.AirrHistoryFragmentBinding
import com.sun.weatherforecats.ui.base.BaseFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import kotlinx.android.synthetic.main.airr_history_fragment.*
import kotlinx.android.synthetic.main.load_data_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class AirrHistoryFragment(private val onBackPressed: OnBackFragment) :
    BaseFragment<AirrHistoryFragmentBinding, AirrHistoryViewModel>(),
    AirHistoryDailyAdapter.OnItemClickListener, OnBackFragment {

    override val layoutId: Int = R.layout.airr_history_fragment

    override val bindingVariable: Int = BR.viewModel

    override val viewModel: AirrHistoryViewModel by viewModel()

    private var airHistory = mutableListOf<AirHistory>()

    private val airHistoryDailyAdapter: AirHistoryDailyAdapter by lazy {
        AirHistoryDailyAdapter(this)
    }

    private val nameCity by lazy {
        arguments?.getString("CityName")
    }

    override fun initData() {
        nameCity?.let { viewModel.getAirHistory(it) }
    }

    override fun initView() {
        setUi(progressBar, constraintLayoutAirHistory)
        recyclerViewAirHistory.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = airHistoryDailyAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.airHistory.observe(viewLifecycleOwner, Observer {
            airHistory = it.toMutableList()
            setUi(constraintLayoutAirHistory, progressBar)
            airHistoryDailyAdapter.insertData(it)
        })
    }

    override fun backFragment() {
        onBackPressed.backFragment()
    }


    override fun onAir(itemData: AirHistory, itemPosition: Int) {
        addFragment(
            R.id.relativeMain,
            AirHistoryDetailFragment.newInstance(this, itemData), true
        )
    }

    companion object {
        fun newInstance(onBackPressed: OnBackFragment, nameCity: String): AirrHistoryFragment {
            val temperatureNowFragment = AirrHistoryFragment(onBackPressed)
            val bundle = Bundle()
            bundle.putSerializable("CityName", nameCity)
            temperatureNowFragment.arguments = bundle
            return temperatureNowFragment
        }
    }

}

package com.sun.weatherforecats.ui.temperature

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sun.weatherforecats.ui.air.airhistory.AirrHistoryFragment
import com.sun.weatherforecats.ui.air.airhourly.AirHourlyFragment
import com.sun.weatherforecats.ui.air.airnow.AirNowFragment
import com.sun.weatherforecats.ui.base.OnBackFragment
import com.sun.weatherforecats.ui.temperature.temperaturedaily.TemperatureDailyFragment
import com.sun.weatherforecats.ui.temperature.temperaturehourly.TemperatureHourlyFragment
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureNowFragment

class TemperaturePagerAdapter(
    fragmentManager: FragmentManager,
    private val onLoadCallback: OnLoadCallback
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT),
    OnBackFragment {

    private val fragments = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = titles[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun backFragment() {
        onLoadCallback.backFragment()
    }


    interface OnLoadCallback {
        fun backFragment()
    }

}

package com.sun.weatherforecats.ui.temperature.temperaturedaily

import android.view.ViewGroup
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.ItemTemperatureDailyBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder

class TemperatureDailyAdapter(
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        WeatherDaily,
        ItemTemperatureDailyBinding,
        TemperatureDailyAdapter.TemperatureDailyViewHolder
        >() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_temperature_daily

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureDailyViewHolder =
        TemperatureDailyViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemTemperatureDailyBinding,
            onItemClickListener = onItemClickListener
        )

    class TemperatureDailyViewHolder(
        binding: ItemTemperatureDailyBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<WeatherDaily, ItemTemperatureDailyBinding>(binding) {

        private lateinit var weatherDaily: WeatherDaily

        override fun onBindData(itemData: WeatherDaily) {
            super.onBindData(itemData)
            binding.viewModel = itemData
        }

    }

    interface OnItemClickListener {
        fun onInsert(itemData: WeatherHourly)
    }

}
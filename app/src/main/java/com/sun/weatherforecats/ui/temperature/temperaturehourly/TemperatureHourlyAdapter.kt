package com.sun.weatherforecats.ui.temperature.temperaturehourly

import android.view.ViewGroup
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.ItemTemperatureHourBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder

class TemperatureHourlyAdapter(
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        WeatherHourly,
        ItemTemperatureHourBinding,
        TemperatureHourlyAdapter.TemperatureHourlyViewHolder
        >() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_temperature_hour

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureHourlyViewHolder =
        TemperatureHourlyViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemTemperatureHourBinding,
            onItemClickListener = onItemClickListener
        )

    class TemperatureHourlyViewHolder(
        binding: ItemTemperatureHourBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<WeatherHourly, ItemTemperatureHourBinding>(binding) {

        private lateinit var weatherHourly: WeatherHourly

        override fun onBindData(itemData: WeatherHourly) {
            super.onBindData(itemData)
            binding.viewModel = itemData
        }

    }

    interface OnItemClickListener {
        fun onInsert(itemData: WeatherHourly)
    }

}
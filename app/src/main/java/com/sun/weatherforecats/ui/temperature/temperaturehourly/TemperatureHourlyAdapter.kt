package com.sun.weatherforecats.ui.temperature.temperaturehourly

import android.view.View
import android.view.ViewGroup
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.ItemTemperatureHourBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder
import setImageUrl
import url

class TemperatureHourlyAdapter(
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        WeatherHourly,
        ItemTemperatureHourBinding,
        TemperatureHourlyAdapter.TemperatureHourlyViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_temperature_hour

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureHourlyViewHolder =
        TemperatureHourlyViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemTemperatureHourBinding,
            onItemClickListener = onItemClickListener
        )

    class TemperatureHourlyViewHolder(
        binding: ItemTemperatureHourBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<WeatherHourly, ItemTemperatureHourBinding>(binding), View.OnClickListener {

        private lateinit var weatherHourly: WeatherHourly

        init {
            assignViews(binding.cardViewTemHourly)
        }

        override fun onBindData(positionItem: Int,itemData: WeatherHourly) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.imageViewAvatar.setImageUrl(url(itemData.weather.icon))
            weatherHourly = itemData
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.cardViewTemHourly -> {
                    onItemClickListener.onWeather(weatherHourly)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onWeather(itemData: WeatherHourly)
    }

}
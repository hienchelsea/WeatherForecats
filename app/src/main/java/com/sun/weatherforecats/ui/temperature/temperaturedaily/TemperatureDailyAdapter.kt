package com.sun.weatherforecats.ui.temperature.temperaturedaily

import android.view.View
import android.view.ViewGroup
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.databinding.ItemTemperatureDailyBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder
import setImageUrl
import url

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
    ) : BaseViewHolder<WeatherDaily, ItemTemperatureDailyBinding>(binding) ,View.OnClickListener{

        private lateinit var weatherDaily: WeatherDaily

        init {
            assignViews(binding.cardViewDaily)
        }

        override fun onBindData(positionItem: Int,itemData: WeatherDaily) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.imageViewAvatar.setImageUrl(url(itemData.weather.icon))
            binding.textViewTemperatureHours.text= itemData.minTemp + " - " +itemData.maxTemp
            weatherDaily= itemData
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.cardViewDaily -> {
                    onItemClickListener.onWeather(weatherDaily)
                }
            }
        }

    }

    interface OnItemClickListener {
        fun onWeather(itemData: WeatherDaily)
    }

}
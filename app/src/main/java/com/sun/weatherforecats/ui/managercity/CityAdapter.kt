package com.sun.weatherforecats.ui.managercity

import android.view.View
import android.view.ViewGroup
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.databinding.ItemCityBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder
import setImageUrl
import url

class CityAdapter (
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        WeatherCurrent,
        ItemCityBinding,
        CityAdapter.CityViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_city

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder =
        CityViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemCityBinding,
            onItemClickListener = onItemClickListener
        )

    class CityViewHolder(
        binding: ItemCityBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<WeatherCurrent, ItemCityBinding>(binding), View.OnClickListener {

        private lateinit var weatherCurrent: WeatherCurrent

        init {
            assignViews(binding.cardViewTemHourly,binding.imageViewDelete)
        }

        override fun onBindData(positionItem: Int,itemData: WeatherCurrent) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.imageViewAvatar.setImageUrl(url(itemData.weather.icon))
            weatherCurrent = itemData
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.cardViewTemHourly -> {
                    onItemClickListener.onWeather(weatherCurrent)
                }
                R.id.imageViewDelete->{
                    onItemClickListener.onDeleteWeather(weatherCurrent)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onWeather(itemData: WeatherCurrent)
        fun onDeleteWeather(itemData: WeatherCurrent)
    }

}
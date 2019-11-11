package com.sun.weatherforecats.ui.air.airhourly

import airImageHandler
import android.view.View
import android.view.ViewGroup
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.databinding.ItemAirHourBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder
import com.sun.weatherforecats.utils.Constants

class AirHourlyAdapter(
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        AirHourly,
        ItemAirHourBinding,
        AirHourlyAdapter.AirHourlyViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_air_hour

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirHourlyViewHolder =
        AirHourlyViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemAirHourBinding,
            onItemClickListener = onItemClickListener
        )

    class AirHourlyViewHolder(
        binding: ItemAirHourBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<AirHourly, ItemAirHourBinding>(binding), View.OnClickListener {

        private lateinit var airHourly: AirHourly
        private var positionItemm: Int=0

        init {
            assignViews(binding.cardViewTemHourly)
        }

        override fun onBindData(positionItem: Int,itemData: AirHourly) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.textViewLink.text = airDDescriptionHandler(itemData.aqi.toDouble())
            binding.imageViewAvatar.setImageResource((airImageHandler(itemData.aqi.toDouble())))
            airHourly=itemData
            positionItemm=positionItem
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.cardViewTemHourly -> {
                    onItemClickListener.onAir(airHourly,positionItemm)
                }
            }
        }

        private fun airDDescriptionHandler(air: Double): String =
            when {
                air < Constants.GOOD - 1 -> "The air is very fresh"
                air in Constants.GOOD until Constants.NORMAL -> "Good air quality"
                air in Constants.NORMAL until Constants.BAD -> "Bad air quality"
                air in Constants.BAD until Constants.VERY_BAD -> "The air quality is very bad"
                air > Constants.VERY_BAD -> "The air is very dangerous"

                else -> "Good air quality"
            }
    }

    interface OnItemClickListener {
        fun onAir(itemData: AirHourly,itemPosition: Int)
    }

}
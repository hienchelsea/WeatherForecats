package com.sun.weatherforecats.ui.air.airhistory

import airImageHandler
import android.view.View
import android.view.ViewGroup
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.AirHistory
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.databinding.ItemAirHistoryBinding
import com.sun.weatherforecats.ui.base.BaseRecyclerAdapter
import com.sun.weatherforecats.ui.base.BaseViewHolder
import com.sun.weatherforecats.utils.Constants

class AirHistoryDailyAdapter (
    private val onItemClickListener: OnItemClickListener
) : BaseRecyclerAdapter<
        AirHistory,
        ItemAirHistoryBinding,
        AirHistoryDailyAdapter.AirHistoryViewHolder
        >() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_air_history

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirHistoryViewHolder =
        AirHistoryViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemAirHistoryBinding,
            onItemClickListener = onItemClickListener
        )

    class AirHistoryViewHolder(
        binding: ItemAirHistoryBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<AirHistory, ItemAirHistoryBinding>(binding) , View.OnClickListener{

        private lateinit var airHourly: AirHistory
        private var positionItemm: Int=0

        init {
            assignViews(binding.cardViewDaily)
        }

        override fun onBindData(positionItem: Int,itemData: AirHistory) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.textViewLink.text = airDDescriptionHandler(itemData.aqi.toDouble())
            binding.imageViewAvatar.setImageResource((airImageHandler(itemData.aqi.toDouble())))
            airHourly=itemData
            positionItemm=positionItem
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.cardViewDaily -> {
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
        fun onAir(itemData: AirHistory, itemPosition: Int)
    }

}
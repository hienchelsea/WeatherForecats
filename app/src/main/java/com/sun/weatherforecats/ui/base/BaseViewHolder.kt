package com.sun.weatherforecats.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T, VB : ViewDataBinding>(
    val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    private var itemData: T? = null
    protected var itemPosition: Int = -1

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }
}

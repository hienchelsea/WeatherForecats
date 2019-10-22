package com.sun.weatherforecats.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sun.weatherforecats.R

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View.OnClickListener.assignViews(vararg views: View?) {
    views.forEach { it?.setOnClickListener(this) }
}
fun ImageView.setImageUrl(url: String, cornerRadius: Int = 0) = Glide.with(context)
    .load(url)
    .apply { if (cornerRadius > 0) transform(CenterCrop(), RoundedCorners(cornerRadius)) }
    .placeholder(R.drawable.ic_launcher_background)
    .into(this)

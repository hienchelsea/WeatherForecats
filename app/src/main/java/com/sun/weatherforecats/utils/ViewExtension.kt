@file:Suppress("DEPRECATION")

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.api.ApiConstants
import com.sun.weatherforecats.utils.Constants

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View.OnClickListener.assignViews(vararg views: View?) {
    views.forEach { it?.setOnClickListener(this) }
}

fun View.hideKeyboard() {
    val inputManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

fun url(s: String): String = ApiConstants.API_BASE_URL_IMAGE + s + ".png"

fun airImageHandler(air: Double): Int =
    when {
        air < Constants.GOOD - 1 -> R.drawable.ic_very_happy
        air in Constants.GOOD until Constants.NORMAL -> R.drawable.ic_happy
        air in Constants.NORMAL until Constants.BAD -> R.drawable.ic_neutral
        air in Constants.BAD until Constants.VERY_BAD -> R.drawable.ic_sad
        air > Constants.VERY_BAD -> R.drawable.ic_angry

        else -> R.drawable.ic_neutral
    }

fun airDDescriptionHandler(air: Double): Int =
    when {
        air < Constants.GOOD - 1 -> R.string.good
        air in Constants.GOOD until Constants.NORMAL -> R.string.normal
        air in Constants.NORMAL until Constants.BAD -> R.string.bad
        air in Constants.BAD until Constants.VERY_BAD -> R.string.very_bad
        air > Constants.VERY_BAD -> R.string.dangerous

        else -> R.string.normal
    }

fun ImageView.setImageUrl(url: String) = Glide.with(context)
    .load(url)
    .into(this)

package com.sun.weatherforecats.ui.managercity

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.model.WeatherCurrent
import kotlinx.android.synthetic.main.dailog_delete_city.*

class DeleteCityDialog(
    private val deleteCityCallback: DeleteCityCallback
) {
    fun deleteCityDialog(context: Context, itemData: WeatherCurrent) {
        val dialog = Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dailog_delete_city)
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        val window = dialog.window
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)

        dialog.buttonDelete.setOnClickListener {
            deleteCityCallback.loadDeleteCityCallback(itemData)
            dialog.dismiss()
        }

        dialog.buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    interface DeleteCityCallback {
        fun loadDeleteCityCallback(itemData: WeatherCurrent)
    }
}

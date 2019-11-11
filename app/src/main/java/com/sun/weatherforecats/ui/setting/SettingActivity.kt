package com.sun.weatherforecats.ui.setting

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.databinding.ActivitySettingBinding
import com.sun.weatherforecats.ui.base.BaseActivity
import com.sun.weatherforecats.utils.AlarmUtils
import com.sun.weatherforecats.utils.Constants
import com.sun.weatherforecats.utils.SharedPreferencesUtils
import formatDecimal
import isNetworkAvailable
import kotlinx.android.synthetic.main.activity_setting.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>(),
    TimePicker.TimePickerDialogCallback, View.OnClickListener, UnitsDialog.UnitsDialogCallback{

    private var hour = 0
    private var minute = 0
    private var sharedPreferencesUtils = SharedPreferencesUtils(this)
    override val viewModel: SettingViewModel by viewModel()
    override val layoutId: Int
        get() = R.layout.activity_setting

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        setTimeNotification()
    }

    override fun initListener() {
        assignViews(
            textViewTime,
            checkbox,textViewUnits,textViewHours,textDay
        )
    }

    override fun checkInternet(): Boolean = isNetworkAvailable(this)

    override fun setupPermissions() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChangeTimePicker(hourOfDay: Int, minute: Int) {
        sharedPreferencesUtils.setString(Constants.HOUR_NOTIFICATION, hourOfDay.toString())
        sharedPreferencesUtils.setString(Constants.MINUTE_NOTIFICATION, minute.toString())
        createNotification()
    }

    private fun setTimeNotification() {
        if (sharedPreferencesUtils.getString(Constants.HOUR_NOTIFICATION) == "") {
            hour = 8
            minute = 0
        } else {
            hour = sharedPreferencesUtils.getString(Constants.HOUR_NOTIFICATION).toInt()
            minute = sharedPreferencesUtils.getString(Constants.MINUTE_NOTIFICATION).toInt()
        }
        if (sharedPreferencesUtils.getBoolean(Constants.CHECK_NOTIFICATION) == true) {
            checkbox.isChecked = true
        }
        textViewTime.text = hour.formatDecimal() + " : " + minute.formatDecimal()
    }

    private fun createNotification() {
        setTimeNotification()
        if (checkbox.isChecked) {
            val calendarCurrent = Calendar.getInstance()
            calendarCurrent.apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
            }
            AlarmUtils.cancelAlarm(this, Constants.REQUEST_CODE)
            AlarmUtils.setTurnOnRepeat(this, Constants.REQUEST_CODE, calendarCurrent.timeInMillis)
        } else {
            AlarmUtils.cancelAlarm(this, Constants.REQUEST_CODE)
        }
    }

    override fun onChangeUnist(f: String, m: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textViewTime -> TimePicker(
                this
            ).clickTimePicker(this)
            R.id.checkbox -> {
                sharedPreferencesUtils.setBoolean(
                    Constants.CHECK_NOTIFICATION,
                    checkbox.isChecked
                )
                createNotification()
            }
            R.id.textViewUnits -> UnitsDialog(
                this
            ).unitDialog(this)

            R.id.textViewHours -> UnitsDialog(
                this
            ).unitDialog(this)

            R.id.textDay -> UnitsDialog(
                this
            ).unitDialog(this)

        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SettingActivity::class.java)
    }



}

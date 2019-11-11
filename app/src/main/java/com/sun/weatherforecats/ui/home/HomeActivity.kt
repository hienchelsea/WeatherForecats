package com.sun.weatherforecats.ui.home

import airDDescriptionHandler
import airImageHandler
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.databinding.ActivityHomeBinding
import com.sun.weatherforecats.ui.air.AirActivity
import com.sun.weatherforecats.ui.base.BaseActivity
import com.sun.weatherforecats.ui.managercity.CityyActivity
import com.sun.weatherforecats.ui.setting.SettingActivity
import com.sun.weatherforecats.ui.temperature.TemperatureActivity
import com.sun.weatherforecats.utils.formatMonth
import hideKeyboard
import isNetworkAvailable
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.load_data_progress.*
import kotlinx.android.synthetic.main.partial_air.*
import kotlinx.android.synthetic.main.partial_temperature.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setImageUrl
import setUi
import url

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(),
    View.OnClickListener {

    private var checkSearch = false
    private var check = 0
    private var nameCity = ""
    private var cites = mutableListOf<City>()

    override val viewModel: HomeViewModel by viewModel()

    override val layoutId = R.layout.activity_home

    override fun checkInternet(): Boolean = isNetworkAvailable(this)

    override fun initView() {
        setUi(progressBar, constraintLayoutHome)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun observeViewModel() {
        viewModel.temperatureCurrent.observe(this, Observer {
            textViewTemperature.text = it.temp + getString(R.string.c)
            textViewDescription.text = it.weather.description
            imageViewTemperature.setImageUrl(url(it.weather.icon))
            if (checkSearch) {
                if (cites.isEmpty()) {
                    viewModel.insetCity(City(name = it.cityName))
                    checkSearch = false
                } else {
                    for (i in 0 until cites.size) {
                        if (cites[i].name == it.cityName) {
                            check = 1
                            break
                        }
                    }
                    if (check == 0) {
                        viewModel.insetCity(City(name = it.cityName))
                        checkSearch = false
                    }
                }

                check = 0
            }

            nameCity = it.cityName
            setUi(constraintLayoutHome, progressBar)
        })
        viewModel.temperatureHourly.observe(this, Observer {
            textViewNextHourOne.text = formatMonth(it[0].timestampLocal)
            textViewNextTemHourOne.text = it[0].temp + getString(R.string.c)
            imageViewNextHourOne.setImageUrl(url(it[0].weather.icon))
            textViewNextHourTwo.text = formatMonth(it[1].timestampLocal)
            textViewNextTemHourTwo.text = it[1].temp + getString(R.string.c)
            imageViewNextHourTwo.setImageUrl(url(it[1].weather.icon))
            textViewNextHourThree.text = formatMonth(it[2].timestampLocal)
            textViewNextTemHourThree.text = it[2].temp + getString(R.string.c)
            imageViewNextHourThree.setImageUrl(url(it[2].weather.icon))
        })
        viewModel.airCurrent.observe(this, Observer {
            textViewAir.text = it.aqi + getString(R.string.aqi)
            textViewDescriptionAir.text = getString(airDDescriptionHandler(it.aqi.toDouble()))
            imageViewAir.setImageResource((airImageHandler(it.aqi.toDouble())))
        })
        viewModel.airHourly.observe(this, Observer {
            textViewNextAirHourOne.text = formatMonth(it[0].timestampLocal)
            imageViewNextAirHourOne.setImageResource((airImageHandler(it[0].aqi.toDouble())))
            textViewNextAirOne.text = it[0].aqi + getString(R.string.aqi)
            textViewNextAirHourTwo.text = formatMonth(it[1].timestampLocal)
            imageViewNextAirHourTwo.setImageResource((airImageHandler(it[1].aqi.toDouble())))
            textViewNextAirTwo.text = it[1].aqi + getString(R.string.aqi)
            textViewNextAirHourThree.text = formatMonth(it[2].timestampLocal)
            imageViewNextAirHourThree.setImageResource((airImageHandler(it[2].aqi.toDouble())))
            textViewNextAirThree.text = it[2].aqi + getString(R.string.aqi)
        })
        viewModel.city.observe(this, Observer {
            cites = it.toMutableList()
        })
        viewModel.messenger.observe(this, Observer {
            setUi(constraintLayoutHome, progressBar)
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        })
    }

    override fun initListener() {
        assignViews(
            imageViewList,
            imageViewSearch,
            cardViewWeather,
            cardViewAirQuality,
            imageViewSetting
        )
    }

    override fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
            return
        }
        val locationManager: LocationManager? =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        locationManager?.let {
            val location: Location = it.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            onGetLocation(location.latitude, location.longitude)
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            REQUEST_CODE_ACCESS_FINE_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_ACCESS_FINE_LOCATION -> {
                if (
                    grantResults.isEmpty() ||
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    setupPermissions()
                }
            }
        }
    }

    private fun onGetLocation(lat: Double, lon: Double) {
        viewModel.setNameCity(lat, lon)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewList -> {
                val intent = CityyActivity.getIntent(this)
                startActivity(intent)
            }
            R.id.imageViewSearch -> {
                if (editTextCity.text.isNotEmpty()) {
                    view.hideKeyboard()
                    viewModel.getWeatherCity(editTextCity.text.toString())
                    checkSearch = true
                    setUi(progressBar, constraintLayoutHome)
                }
            }
            R.id.cardViewWeather -> {
                val intent = TemperatureActivity.getIntent(this, nameCity)
                startActivity(intent)
            }
            R.id.cardViewAirQuality -> {
                val intent = AirActivity.getIntent(this, nameCity)
                startActivity(intent)
            }
            R.id.imageViewSetting -> {
                val intent = SettingActivity.getIntent(this)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        const val REQUEST_CODE_ACCESS_FINE_LOCATION = 101

        fun getIntent(context: Context): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            return intent
        }
    }
}

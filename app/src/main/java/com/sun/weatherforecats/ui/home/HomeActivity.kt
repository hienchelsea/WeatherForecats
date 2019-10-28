package com.sun.weatherforecats.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.sun.weatherforecats.R
import com.sun.weatherforecats.databinding.ActivityHomeBinding
import com.sun.weatherforecats.ui.air.AirActivity
import com.sun.weatherforecats.ui.base.BaseActivity
import com.sun.weatherforecats.ui.managercity.CityActivity
import com.sun.weatherforecats.ui.temperature.TemperatureActivity
import com.sun.weatherforecats.utils.Constants
import com.sun.weatherforecats.utils.assignViews
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.partial_air.*
import kotlinx.android.synthetic.main.partial_temperature.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(),
    View.OnClickListener {

    override val viewModel: HomeViewModel by viewModel()

    override val layoutId = R.layout.activity_home

    override fun initView() {

    }

    override fun observeViewModel() {

    }

    override fun initListener() {
        assignViews(imageViewList, imageViewSearch, cardViewWeather, cardViewAirQuality)
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
            getLocation(location.latitude, location.longitude)
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

    private fun getLocation(lat: Double, lon: Double) {
        viewModel.setNameCity(lat, lon)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewList -> {
                val intent = CityActivity.getIntent(this)
                startActivity(intent)
            }
            R.id.imageViewSearch -> {

            }
            R.id.cardViewWeather -> {
                val intent = TemperatureActivity.getIntent(this)
                startActivity(intent)
            }
            R.id.cardViewAirQuality -> {
                val intent = AirActivity.getIntent(this)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val REQUEST_CODE_ACCESS_FINE_LOCATION = 101
    }
}

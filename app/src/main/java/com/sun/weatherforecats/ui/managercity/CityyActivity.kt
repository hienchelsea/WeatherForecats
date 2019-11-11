package com.sun.weatherforecats.ui.managercity

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import assignViews
import com.sun.weatherforecats.R
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.databinding.ActivityCityyBinding
import com.sun.weatherforecats.ui.base.BaseActivity
import gone
import isNetworkAvailable
import kotlinx.android.synthetic.main.activity_cityy.*
import kotlinx.android.synthetic.main.load_data_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import setUi

class CityyActivity : BaseActivity<ActivityCityyBinding, CityyActivityViewModel>(),
    CityAdapter.OnItemClickListener, DeleteCityDialog.DeleteCityCallback, View.OnClickListener {
   
    private val cityAdapter: CityAdapter by lazy {
        CityAdapter(this)
    }
    private var citys = mutableListOf<City>()
    private var weatherCurrents = mutableListOf<WeatherCurrent>()

    private var check = 0
    override val viewModel: CityyActivityViewModel by viewModel()

    override val layoutId: Int = R.layout.activity_cityy

    override fun checkInternet(): Boolean =isNetworkAvailable(this)

    override fun initView() {
        setUi(progressBar, recyclerViewCity)
        recyclerViewCity.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = cityAdapter
        }
        assignViews(imageViewBack)
    }

    override fun observeViewModel() {
        viewModel.city.observe(this, Observer {
            citys = it.toMutableList()
            if (citys.isNotEmpty()) {
                viewModel.getTemperatureCurrent(citys[check].name)
            } else setUi(recyclerViewCity, progressBar)
        })

        viewModel.temperatureCurent.observe(this, Observer {
            check++
            weatherCurrents.add(it)
            if (check < citys.size) {
                viewModel.getTemperatureCurrent(citys[check].name)
            } else {
                cityAdapter.updateData(weatherCurrents)
                setUi(recyclerViewCity, progressBar)
            }
        })
    }

    override fun setupPermissions() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onWeather(itemData: WeatherCurrent) {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleteWeather(itemData: WeatherCurrent) {
        DeleteCityDialog(this).deleteCityDialog(this, itemData)
    }

    override fun loadDeleteCityCallback(itemData: WeatherCurrent) {
        weatherCurrents.remove(itemData)
        if (weatherCurrents.isEmpty()) {
            recyclerViewCity.gone()
        } else {
            cityAdapter.updateData(weatherCurrents)
        }
        for (i in 0 until citys.size) {
            if (itemData.cityName == citys[i].name) {
                viewModel.deleteCity(citys[i])
                break
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imageViewBack -> {
                onBackPressed()
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, CityyActivity::class.java)
    }
}

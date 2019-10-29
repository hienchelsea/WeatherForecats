package com.sun.weatherforecats.ui.home

import com.sun.weatherforecats.R
import com.sun.weatherforecats.databinding.ActivityHomeBinding
import com.sun.weatherforecats.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override val layoutId = R.layout.activity_home

    override fun initView() {
     //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun observeViewModel() {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

package com.sun.weatherforecats.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseActivity<
        ViewBinding : ViewDataBinding,
        ViewModel : BaseViewModel
        > : AppCompatActivity() {

    private lateinit var viewBinding: ViewBinding
    protected abstract val viewModel: ViewModel

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        initView()
        observeViewModel()
    }

    private fun initViewBinding() {
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
    }

    abstract fun initView()

    abstract fun observeViewModel()

    protected fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        supportFragmentManager.beginTransaction().add(id, fragment).apply {
            if (addToBackStack) addToBackStack(null)
        }.commit()
}

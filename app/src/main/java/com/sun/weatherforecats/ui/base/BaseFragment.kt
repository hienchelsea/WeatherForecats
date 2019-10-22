package com.sun.weatherforecats.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

abstract class BaseFragment<
        ViewBinding : ViewDataBinding,
        ViewModel : BaseViewModel
        > : Fragment(), LifecycleOwner {
    protected lateinit var viewBinding: ViewBinding
    protected abstract val viewModel: ViewModel

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        setBindingVariables()
        observeViewModel()
    }

    open fun setBindingVariables() {
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun observeViewModel()

    protected fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.add(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    fun toast(message: String) = context?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}

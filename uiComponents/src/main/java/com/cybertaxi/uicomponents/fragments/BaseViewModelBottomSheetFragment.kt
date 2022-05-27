package com.cybertaxi.uicomponents.fragments

import android.os.Bundle
import android.view.View
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import com.cybertaxi.uicomponents.viewmodels.IView

abstract class BaseViewModelBottomSheetFragment<V, VM> :
    BaseBottomSheetDialogFragment() where V : IView, VM : AbstractSubscribeViewModel<V> {

    protected abstract val viewModelView: V
    protected val viewModel: VM by lazy { initViewModel() }

    protected abstract fun initViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hack to init viewModel
        viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.subscribe(viewLifecycleOwner, viewModelView)
        viewModel.startLoad()
    }
}
package com.cybertaxi.uicomponents.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import com.cybertaxi.uicomponents.viewmodels.IView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

abstract class BaseViewModelBottomSheetFragment<V, VM> :
    BaseBottomSheetDialogFragment() where V : IView, VM : AbstractSubscribeViewModel<V> {

    protected abstract fun viewModel(): VM
    protected abstract val viewModelView: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel().subscribe(viewLifecycleOwner, viewModelView)
        viewModel().startLoad()
    }
}
package com.cybertaxi.mobile.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.cybertaxi.uicomponents.viewmodels.AbstractSubscribeViewModel
import com.cybertaxi.uicomponents.viewmodels.IView

abstract class AbstractFragment<V : IView, VM : AbstractSubscribeViewModel<V>> : Fragment() {

    protected abstract val layoutRes: Int
    protected abstract val viewModelView: V
    protected abstract fun viewModel(): VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel().subscribe(viewLifecycleOwner, viewModelView)
        viewModel().startLoad()
    }
}
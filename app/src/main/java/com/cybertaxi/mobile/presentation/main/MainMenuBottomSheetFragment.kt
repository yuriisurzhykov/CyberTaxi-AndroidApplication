package com.cybertaxi.mobile.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.menu.MenuItem
import com.cybertaxi.mobile.menu.MenuRecyclerAdapter
import com.cybertaxi.mobile.menu.holder.TripTypeViewHolder
import com.cybertaxi.uicomponents.fragments.BaseViewModelBottomSheetFragment
import com.cybertaxi.uicomponents.views.Visibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuBottomSheetFragment : BaseViewModelBottomSheetFragment<IMainView, MainViewModel>() {

    private val localViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_main_bottom_sheet
    override val viewModelView: IMainView
        get() = viewInternal

    private val tripTypeAdapter by lazy { MenuRecyclerAdapter(TripTypeViewHolder::class) }

    private var progressView: View? = null

    override fun viewModel(): MainViewModel = localViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressView = view.findViewById(R.id.progress)
        with(view.findViewById<RecyclerView>(R.id.trip_type_list)) {
            adapter = tripTypeAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private val viewInternal = object : IMainView {
        override fun drawLoading(visibility: Visibility) {
            visibility.apply(progressView)
        }

        override fun drawTripTypes(list: List<MenuItem>) {
            tripTypeAdapter.setData(list)
        }
    }
}
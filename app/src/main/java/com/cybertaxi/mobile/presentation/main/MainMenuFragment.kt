package com.cybertaxi.mobile.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cybertaxi.mobile.R
import com.cybertaxi.mobile.domain.model.TripVariant
import com.cybertaxi.mobile.presentation.menu.MenuRecyclerAdapter
import com.cybertaxi.mobile.presentation.menu.holder.TripTypeViewHolder
import com.cybertaxi.mobile.presentation.base.AbstractFragment
import com.cybertaxi.uicomponents.views.SpaceItemDecoration
import com.cybertaxi.uicomponents.views.Visibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuFragment : AbstractFragment<IMainView, MainViewModel>() {

    private val localViewModel: MainViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_main_menu

    override val viewModelView: IMainView
        get() = viewInternal

    private val tripTypeAdapter by lazy { TripVariantsAdapter() }

    private var progressView: View? = null

    override fun viewModel(): MainViewModel = localViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressView = view.findViewById(R.id.progress)
        with(view.findViewById<RecyclerView>(R.id.trip_type_list)) {
            adapter = tripTypeAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.small_padding)))
        }
    }

    private val viewInternal = object : IMainView {
        override fun drawLoading(visibility: Visibility) {
            visibility.apply(progressView)
        }

        override fun drawTripTypes(list: List<TripVariant>) {
            tripTypeAdapter.setData(list)
        }
    }
}
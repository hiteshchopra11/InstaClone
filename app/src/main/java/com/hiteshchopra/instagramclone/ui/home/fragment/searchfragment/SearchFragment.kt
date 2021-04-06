package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentSearchBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.adapter.ImageAdapter

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentVM>() {
    override fun getViewModelClass(): Class<SearchFragmentVM> = SearchFragmentVM::class.java
    override fun layoutId(): Int = R.layout.fragment_search

    private lateinit var imageAdapter: ImageAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchBar()
        addObservers()
    }

    private fun addObservers() {
        viewModel.searchState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is SearchState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is SearchState.ShowImages -> {
                    handleDataLoadingUi(false)
                    addImagesToRecycleView(state)
                }
                is SearchState.Error -> {
                    handleDataLoadingUi(false)
                }
            }
        })
    }

    private fun addImagesToRecycleView(state: SearchState.ShowImages) {
        imageAdapter = ImageAdapter(state.images)
        binding.rvImages.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
            adapter = imageAdapter
        }
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbSearch.isVisible = loading
        }
    }

    private fun initSearchBar() {
        binding.apply {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.loadImages(newText)
                    return false
                }
            })
        }
    }
}




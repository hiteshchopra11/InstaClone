package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentSearchBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.adapter.ImageAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
@FlowPreview
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentVM>() {
    override fun getViewModelClass(): Class<SearchFragmentVM> = SearchFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_search

    private lateinit var imageAdapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSearchTextViewPlaceholder(true)
        showErrorTextViewPlaceHolder(false)
        initSearchBar()
        addObservers()
    }

    private fun addObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.images.collect { state ->
                when (state) {
                    is SearchState.Loading -> {
                        showSearchTextViewPlaceholder(false)
                        handleDataLoadingUi(true)
                    }
                    is SearchState.ShowImages -> {
                        handleDataLoadingUi(false)
                        showSearchTextViewPlaceholder(false)
                        addImagesToRecycleView(state)
                    }
                    is SearchState.Error -> {
                        showSearchTextViewPlaceholder(false)
                        showErrorTextViewPlaceHolder(true)
                        handleDataLoadingUi(false)
                    }
                    is SearchState.ShortQuery -> {
                        showSearchTextViewPlaceholder(true)
                    }
                }
            }
        }
    }

    private fun addImagesToRecycleView(state: SearchState.ShowImages) {
        imageAdapter = ImageAdapter(state.images)
        binding.rvImages.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
            adapter = imageAdapter
        }
    }

    private fun initSearchBar() {
        binding.apply {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.searchState.value = newText
                    return false
                }
            })
        }
    }

    private fun showErrorTextViewPlaceHolder(b: Boolean) {
        binding.tvErrorPlaceholder.isVisible = b
    }

    private fun showSearchTextViewPlaceholder(b: Boolean) {
        binding.tvSearchPlaceholder.isVisible = b
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbSearch.isVisible = loading
        }
    }
}
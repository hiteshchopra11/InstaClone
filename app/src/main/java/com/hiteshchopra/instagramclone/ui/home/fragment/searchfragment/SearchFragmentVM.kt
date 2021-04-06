package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.model.Image
import com.hiteshchopra.domain.usecase.UseCaseSearch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragmentVM @Inject constructor(
    private val useCaseSearch: UseCaseSearch
) : ViewModel() {
    private var _searchState: MutableLiveData<SearchState> = MutableLiveData()
    val searchState: LiveData<SearchState> = _searchState

    fun loadImages(query: String) {
        _searchState.value = SearchState.Loading
        viewModelScope.launch {
            when (val result = useCaseSearch.perform(query)) {
                is ApiSafeResult.Success -> {
                    _searchState.value = SearchState.ShowImages(result.data)
                }
                is ApiSafeResult.Failure -> {
                    _searchState.value = SearchState.Error(result.message)
                }
                ApiSafeResult.NetworkError -> {
                    _searchState.value = SearchState.Error("Network Error")
                }
            }
        }
    }
}

sealed class SearchState {
    object Loading : SearchState()
    class ShowImages(val images: List<Image>) : SearchState()
    class Error(val message: String) : SearchState()
}
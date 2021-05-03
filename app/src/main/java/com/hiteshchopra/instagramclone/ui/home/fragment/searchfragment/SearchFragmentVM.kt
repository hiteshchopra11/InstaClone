package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import androidx.lifecycle.ViewModel
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.model.Image
import com.hiteshchopra.domain.usecase.UseCaseSearch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

private const val SEARCH_DELAY_MILLIS = 1000L
private const val MIN_QUERY_LENGTH = 2

@FlowPreview
@ExperimentalCoroutinesApi
class SearchFragmentVM @Inject constructor(
    private val useCaseSearch: UseCaseSearch
) : ViewModel() {

    val searchState = MutableStateFlow<String>("")

    val images = searchState
        .asStateFlow()
        .debounce(SEARCH_DELAY_MILLIS)
        .mapLatest { query ->
            if (query.length > MIN_QUERY_LENGTH) {
                SearchState.Loading
                searchState(query)
            } else {
                SearchState.ShortQuery
            }
        }

    private suspend fun searchState(query: String) =
        when (val result = useCaseSearch.perform(query)) {
            is ApiSafeResult.Success -> {
                SearchState.ShowImages(result.data)
            }
            is ApiSafeResult.Failure -> {
                result.message?.let { SearchState.Error(it) }
            }
            ApiSafeResult.NetworkError -> {
                SearchState.Error("Network Error")
            }
            else -> SearchState.Error("Some unknown error occurred")
        }
}

sealed class SearchState {
    object Loading : SearchState()
    class ShowImages(val images: List<Image>) : SearchState()
    class Error(val message: String) : SearchState()
    object ShortQuery : SearchState()
}
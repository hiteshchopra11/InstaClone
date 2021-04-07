package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.model.Image
import com.hiteshchopra.domain.usecase.UseCaseSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val SEARCH_DELAY_MILLIS = 1000L
private const val MIN_QUERY_LENGTH = 2

@FlowPreview
@ExperimentalCoroutinesApi
class SearchFragmentVM @Inject constructor(
    private val useCaseSearch: UseCaseSearch
) : ViewModel() {

    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    private val _images = queryChannel
        .asFlow()
        .debounce(SEARCH_DELAY_MILLIS)
        .mapLatest { query ->
            withContext(Dispatchers.IO) {
                if (query.length > MIN_QUERY_LENGTH) {
                    SearchState.Loading
                    when (val result = useCaseSearch.perform(query)) {
                        is ApiSafeResult.Success -> {
                            SearchState.ShowImages(result.data)
                        }
                        is ApiSafeResult.Failure -> {
                            SearchState.Error(result.message)
                        }
                        ApiSafeResult.NetworkError -> {
                            SearchState.Error("Network Error")
                        }
                    }
                } else {
                    SearchState.ShortQuery
                }
            }
        }

    val searchResult = _images.asLiveData()

}

sealed class SearchState {
    object Loading : SearchState()
    class ShowImages(val images: List<Image>) : SearchState()
    class Error(val message: String) : SearchState()
    object ShortQuery : SearchState()
}
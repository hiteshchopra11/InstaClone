package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import com.hiteshchopra.domain.usecase.UseCasePosts
import com.hiteshchopra.domain.usecase.UseCaseStories
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentVM @Inject constructor(
    private val useCasePosts: UseCasePosts,
    private val useCaseStories: UseCaseStories
) : ViewModel() {

    private var _postsState: MutableLiveData<PostsState> = MutableLiveData()
    val postsState: LiveData<PostsState> = _postsState

    private var _storiesState: MutableLiveData<StoriesState> = MutableLiveData()
    val storiesState: LiveData<StoriesState> = _storiesState

    fun loadPosts() {
        _postsState.value = PostsState.Loading
        viewModelScope.launch {
            val result = useCasePosts.perform()
            result.collect { response ->
                when (response) {
                    is ApiSafeResult.Success ->
                        _postsState.value = PostsState.ShowPosts(response.data)
                    is ApiSafeResult.Failure ->
                        _postsState.value = response.data?.let { PostsState.ShowPosts(it) }
                    is ApiSafeResult.NetworkError ->
                        _postsState.value = PostsState.Error("Network Error")
                }
            }
        }
    }

    fun loadStories() {
        _storiesState.value = StoriesState.Loading
        viewModelScope.launch {
            val result = useCaseStories.perform()
            result.collect { response ->
                when (response) {
                    is ApiSafeResult.Success -> _storiesState.value =
                        StoriesState.ShowStories(response.data)
                    is ApiSafeResult.Failure -> _storiesState.value =
                        response.data?.let { StoriesState.ShowStories(it) }
                    is ApiSafeResult.NetworkError -> _storiesState.value =
                        StoriesState.Error("Network Error")
                }
            }
        }
    }
}

sealed class PostsState {
    object Loading : PostsState()
    class ShowPosts(val posts: List<PostsEntity>) : PostsState()
    class Error(val message: String) : PostsState()
}

sealed class StoriesState {
    object Loading : StoriesState()
    class ShowStories(val stories: List<StoriesEntity>) : StoriesState()
    class Error(val message: String) : StoriesState()
}

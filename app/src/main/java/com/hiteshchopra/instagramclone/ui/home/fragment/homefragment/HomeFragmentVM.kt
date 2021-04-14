package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.domain.model.Stories
import com.hiteshchopra.domain.usecase.UseCasePosts
import com.hiteshchopra.domain.usecase.UseCaseStories
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenVM @Inject constructor(
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
            result.collect { result ->
                when (result) {
                    is ApiSafeResult.Success -> {
                        _postsState.value = PostsState.ShowPosts(result.data)
                    }
                    is ApiSafeResult.Failure -> {
                        _postsState.value = PostsState.Error(result.message)
                    }
                    ApiSafeResult.NetworkError -> {
                        _postsState.value = PostsState.Error("Network Error")
                    }
                }
            }
        }
    }

    fun loadStories() {
        _storiesState.value = StoriesState.Loading
        viewModelScope.launch {
            when (val result = useCaseStories.perform()) {
                is ApiSafeResult.Success -> {
                    _storiesState.value = StoriesState.ShowStories(result.data)
                }
                is ApiSafeResult.Failure -> {
                    _storiesState.value = StoriesState.Error(result.message)
                }
                ApiSafeResult.NetworkError -> {
                    _storiesState.value = StoriesState.Error("Network Error")
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
    class ShowStories(val stories: List<Stories>) : StoriesState()
    class Error(val message: String) : StoriesState()
}

package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.usecase.UseCaseSearch
import com.hiteshchopra.instagramclone.utils.DummyDataUtils
import com.hiteshchopra.instagramclone.utils.TestCoroutineRule
import com.hiteshchopra.instagramclone.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchFragmentVMTest {
    @ExperimentalCoroutinesApi
    @get: Rule
    val testCoroutineRule = TestCoroutineRule()

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val mainDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getUseCaseSearch: UseCaseSearch

    @ExperimentalCoroutinesApi
    @Before
    fun doSetup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(mainDispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    private suspend fun mockGetImagesUseCasePerformSuccess() {
        coEvery {
            getUseCaseSearch.perform(any())
        } returns ApiSafeResult.Success(DummyDataUtils.getImages())
    }

    private suspend fun mockGetImagesUseCasePerformFailure() {
        coEvery {
            getUseCaseSearch.perform(any())
        } returns ApiSafeResult.Failure(exception = null)
    }

    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    @FlowPreview
    @Test
    fun fetchImageResultReturnsSuccess() = mainDispatcher.runBlockingTest {
        val query = "right query"
        val viewModel = SearchFragmentVM(getUseCaseSearch)
        mockGetImagesUseCasePerformSuccess()
        viewModel.searchState.value = query
        val value = viewModel.images.asLiveData().getOrAwaitValue()
        assert(value is SearchState.ShowImages)
    }

    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    @FlowPreview
    @Test
    fun fetchImageResultReturnsFailure() = runBlocking {
        // subject to test
        val query = "wrong query"
        val viewModel = SearchFragmentVM(getUseCaseSearch)
        mockGetImagesUseCasePerformFailure()
        viewModel.searchState.value = query
        val value = viewModel.images.asLiveData().getOrAwaitValue()
        assert(value is SearchState.Error)
    }
}
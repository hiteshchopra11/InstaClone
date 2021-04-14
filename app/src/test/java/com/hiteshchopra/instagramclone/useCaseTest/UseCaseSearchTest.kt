package com.hiteshchopra.instagramclone.useCaseTest

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.usecase.UseCaseSearch
import com.hiteshchopra.instagramclone.BaseTest
import com.hiteshchopra.instagramclone.injection.component.TestAppComponent
import com.hiteshchopra.instagramclone.utils.FileUtil
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import javax.inject.Inject

class UseCaseSearchTest : BaseTest() {

    override fun injectIntoDagger(testAppComponent: TestAppComponent) {
        testAppComponent.inject(this)
    }

    @Inject
    lateinit var searchUseCase: UseCaseSearch

    @Test
    fun `when api returns success- assert result data contains Images`() =
        runBlocking {
            mockWebServer.enqueue(
                MockResponse().setResponseCode(200)
                    .setBody(FileUtil.loadText("responses/search_response.json"))
            )

            val result = searchUseCase.perform("cat")
            assert(result is ApiSafeResult.Success)
            assert((result as ApiSafeResult.Success).data.isNotEmpty())
        }


}
package com.hiteshchopra.instagramclone.local.posts

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.hiteshchopra.data.local.posts.PostsDB
import com.hiteshchopra.data.local.posts.dao.PostsDao
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class PostsDBTest : TestCase() {
    private lateinit var db: PostsDB
    private lateinit var dao: PostsDao

    @Before
    public override fun setUp() {
        // get context -- since this is an instrumental test it requires
        // context from the running application
        val context = ApplicationProvider.getApplicationContext<Context>()
        // initialize the db and dao variable
        db = Room.inMemoryDatabaseBuilder(context, PostsDB::class.java).build()
        dao = db.getPostsDao()
    }

    // Override function closeDb() and annotate it with @After
    // this function will be called at last when this test class is called

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    // create a test function and annotate it with @Test
    // here we are first adding an item to the db and then checking if that item
    // is present in the db -- if the item is present then our test cases pass

    @Test
    fun writeAndReadLanguage() {
        runBlockingTest {
            val postsList =
                listOf(
                    PostsEntity(12, "TEST", 10, "TEST", "TEST"),
                )
            dao.insertMulPosts(postsList)
            val posts = dao.getPosts()
            Truth.assertThat(posts.first().contains(postsList[0])).isTrue()
        }
    }
}
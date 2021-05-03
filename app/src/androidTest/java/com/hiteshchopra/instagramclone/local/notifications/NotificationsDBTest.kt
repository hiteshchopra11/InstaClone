package com.hiteshchopra.instagramclone.local.notifications

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.local.notifications.dao.NotificationDao
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class NotificationsDBTest : TestCase() {
    private lateinit var db: NotificationDB
    private lateinit var dao: NotificationDao

    @Before
    public override fun setUp() {
        // get context -- since this is an instrumental test it requires
        // context from the running application
        val context = ApplicationProvider.getApplicationContext<Context>()
        // initialize the db and dao variable
        db = Room.inMemoryDatabaseBuilder(context, NotificationDB::class.java).build()
        dao = db.getNotificationsDao()
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
        runBlocking {
            val notification =
                listOf(
                    NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST"),
                    NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST")
                )
            dao.insertNotifications(notification)
            val notifications = dao.getNotifications()
            assertThat(notifications.first().contains(notification[0])).isTrue()
        }
    }
}
package com.chimbori.liteappstarter

import android.content.Intent.ACTION_VIEW
import com.chimbori.liteappstarter.LiteAppStarterActivity.Companion.createLiteAppIntent
import org.junit.Assert.assertEquals
import org.junit.Test

class LiteAppStarterActivityTest {
  @Test
  fun testCreateLiteAppIntent() {
    val actualIntent = createLiteAppIntent("https://example.org/")
    assertEquals(ACTION_VIEW, actualIntent.action)
    assertEquals("https://example.org/", actualIntent.dataString)
    assertEquals("com.chimbori.hermitcrab/com.chimbori.hermitcrab.WebActivity", actualIntent.component!!.flattenToString())
  }
}
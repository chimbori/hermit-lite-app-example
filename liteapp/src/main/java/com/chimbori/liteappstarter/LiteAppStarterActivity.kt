package com.chimbori.liteappstarter

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle

/** The main code for this app, served as a library. No need to make any changes here. */
class LiteAppStarterActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    launchLiteApp(this, getString(R.string.start_url))
    finish()
  }

  companion object {
    private fun launchLiteApp(activity: Activity, startUrl: String) = try {
      activity.startActivity(createLiteAppIntent(startUrl))
    } catch (e: ActivityNotFoundException) {
      activity.startActivity(Intent(activity, InstallActivity::class.java))
    }

    internal fun createLiteAppIntent(startUrl: String) =
      Intent(ACTION_VIEW, Uri.parse(startUrl)).setClassName(HERMIT_PACKAGE_NAME, HERMIT_ACTIVITY_NAME)

    /** Package name of the Hermit app.  */
    const val HERMIT_PACKAGE_NAME = "com.chimbori.hermitcrab"

    /** Component name of the deep-linked Activity in Hermit to use to open a Lite App.  */
    private const val HERMIT_ACTIVITY_NAME = "com.chimbori.hermitcrab.WebActivity"
  }
}

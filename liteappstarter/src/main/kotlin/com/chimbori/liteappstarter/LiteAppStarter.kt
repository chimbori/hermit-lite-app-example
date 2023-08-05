package com.chimbori.liteappstarter

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.chimbori.liteappstarter.databinding.ActivityInstallDialogBinding

/** The main code for this app. No need to make any changes here. */
class LiteAppStarterActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    try {
      startActivity(
        Intent(ACTION_VIEW, Uri.parse(getString(R.string.start_url)))
          .setClassName(HERMIT_PACKAGE_NAME, HERMIT_ACTIVITY_NAME)
      )
    } catch (e: ActivityNotFoundException) {
      startActivity(Intent(this, InstallActivity::class.java))
    }
    finish()
  }
}

/** If Hermit is not installed, this shows a message to the user to go download it. */
class InstallActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityInstallDialogBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.installDialogDescription.text = Html.fromHtml(
      getString(R.string.hermit_description), FROM_HTML_MODE_LEGACY
    )
    binding.installDialogInstallButton.setOnClickListener {
      try {
        startActivity(
          Intent(
            ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$HERMIT_PACKAGE_NAME")
          )
        )
      } catch (e: ActivityNotFoundException) {
        Toast.makeText(applicationContext, R.string.error_play_store, LENGTH_LONG).show()
        try {
          startActivity(Intent(ACTION_VIEW, Uri.parse(HERMIT_DOWNLOAD_LOCATION)))
        } catch (e: ActivityNotFoundException) {
          Toast.makeText(applicationContext, getString(R.string.error_no_app_available), LENGTH_LONG).show()
        }
      }
      finishAndRemoveTask()
    }
    binding.installDialogCancelButton.setOnClickListener {
      finishAndRemoveTask()
    }
  }
}

/** Package name of the Hermit app. */
private const val HERMIT_PACKAGE_NAME = "com.chimbori.hermitcrab"

/** Component name of the deep-linked Activity in Hermit to use to open a Lite App. */
private const val HERMIT_ACTIVITY_NAME = "com.chimbori.hermitcrab.WebActivity"

/** URL where Hermit can be downloaded from directly as an APK. Used on devices where Play Store is not available. */
private const val HERMIT_DOWNLOAD_LOCATION = "https://hermit.chimbori.com/downloads"

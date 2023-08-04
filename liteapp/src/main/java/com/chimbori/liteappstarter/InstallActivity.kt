package com.chimbori.liteappstarter

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.chimbori.liteappstarter.LiteAppStarterActivity.Companion.HERMIT_PACKAGE_NAME
import org.example.liteapp.R

class InstallActivity : Activity(), View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_install_dialog)

    findViewById<TextView>(R.id.install_dialog_description).text =
      Html.fromHtml(getString(R.string.hermit_description), FROM_HTML_MODE_LEGACY)
    findViewById<View>(R.id.install_dialog_install_button).setOnClickListener(this)
    findViewById<View>(R.id.install_dialog_cancel_button).setOnClickListener(this)
  }

  override fun onClick(view: View) {
    when (view.id) {
      R.id.install_dialog_install_button -> {
        try {
          startActivity(Intent(ACTION_VIEW, Uri.parse("market://details?id=$HERMIT_PACKAGE_NAME")))
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
      R.id.install_dialog_cancel_button -> finishAndRemoveTask()
    }
  }

  companion object {
    /** URL where Hermit can be downloaded from directly as an APK. Used on devices where Play Store is not available.  */
    private const val HERMIT_DOWNLOAD_LOCATION = "https://hermit.chimbori.com/downloads"
  }
}

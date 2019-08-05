package org.example.liteapp.simple;

import android.app.Activity;
import android.os.Bundle;

import static com.chimbori.liteapp.starter.HermitIntentStarter.launchLiteApp;

/**
 * This is the Simple version of the APK where you only need to specify a Name, URL, and an Icon.
 *
 * The main code for this app. No need to make any changes here. Things you need to change:
 * - Change the package name in {@code AndroidManifest.xml}.
 * - Change {@code start_url} in {@code res/strings.xml} to point to your Lite App.
 * - Change {@code app_name} in {@code res/strings.xml} to the name of your Lite App.
 * - Add any translations required for the {@code app_name}.
 * - Change the icon in {@code res/mipmap/ic_launcher.png}. This will be used for your Android native app.
 * - Change the adaptive icons in {@code res/drawable/ic_launcher_background} &
 *   {@code res/drawable/ic_launcher_foreground}.
 *
 * Then, recompile, sign with your own certificate, and publish your own APK.
 */
public class RunSimpleLiteAppActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    launchLiteApp(this, getString(R.string.start_url));
    finish();
  }
}

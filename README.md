# Put Hermit Lite App APKs in your App Drawer

Hermit Lite Apps can be placed in your App Drawer in addition to on your home screen.

Since this feature involves creating a separate APK, it cannot be included in the main app.

Create your own APKs by copying this repository and customizing just a few items.
- Lite App URL
- Lite App Name
- Android App Package Name
- Logo

## Getting Started

1.  Use this example project as a template:
    [github.com/chimbori/hermit-lite-app-example](https://github.com/chimbori/hermit-lite-app-example).

1.  Clone the downloaded repo to your local machine,
    then open the downloaded project in [Android Studio](https://developer.android.com/studio).

1.  Look for all instances of the string `CHANGEME` to quickly identify where to make changes.

1.  Change the `applicationId`, since every app must have a unique one.

    - Open `liteappstarter/build.gradle.kts`, and change the following line.
      Usually, this is a domain name you control, with each segment in reverse order,
      like the example above.
      ```
      applicationId = "org.example.liteapp"
      ```

1.  Change the Lite App Name and URL to anything you want.

    - In the same file, change the following lines:
      ```
      resValue("string", "start_url", "https://example.org/")
      resValue("string", "app_name", "Lite App Example")
      ```

1. Change the icon to a custom 512×512 icon: `liteappstarter/src/main/res/mipmap-xxxhdpi`

1. Compile the project and run. Then generate an APK and copy it to your phone.

# Warning

**DO NOT PUBLISH THIS APK ON GOOGLE PLAY. ONLY USE IT ON YOUR PHONE.**

This APK does not contain the full functionality of a browser, and Google may consider it a violation of their Device Distribution Agreement, specifically the [Minimum Functionality](https://play.google.com/about/spam-min-functionality/min-functionality/) clause.

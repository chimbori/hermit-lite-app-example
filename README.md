# Put Hermit Lite App APKs in your App Drawer

The latest version of Hermit includes support for launching Lite Apps from an 
APK (in addition to putting a shortcut icon on your home screen). 

Now you can have Hermit Lite Apps in your App Drawer as well!

## Getting Started

1.  Download this sample project. (via [zip file](https://github.com/chimbori/hermit-lite-app-apk-sample/archive/master.zip) or [git clone](github-mac://openRepo/https://github.com/chimbori/hermit-lite-app-apk-sample)).

1.  Open the downloaded project in [Android Studio](https://developer.android.com/studio).

1.  Change the `applicationID`, since every app must have a unique one.
    - Open the file `lite-app-simple/build.gradle`
    - Change the following line:
      ```
      applicationId "org.example.liteapp.simple"
      ```
      Usually, this is a domain name you control, with each segment in reverse order, like the example above.

1.  Change the URL and Name to anything you want.

    - Open the file `lite-app-simple/build.gradle`
    - Change the following lines:
      ```
      resValue("string", "start_url", "https://example.org/")
      resValue("string", "app_name", "Example Simple")
      ```

1. Change the icon to a custom icon, located in the following directories:
    - Basic PNG icon:
        - `lite-app-simple/src/main/res/mipmap-xxxhdpi`
   
    - [Adaptive Icon](https://developer.android.com/guide/practices/ui_guidelines/icon_design_adaptive) (for Android Oreo and above)
        - `lite-app-simple/src/main/res/drawable-v24/ic_launcher_background.xml`
        - `lite-app-simple/src/main/res/drawable-v24/ic_launcher_foreground.xml`
        - `lite-app-simple/src/main/res/mipmap-anydpi-v26/ic_launcher.xml`
    
    - If you want to keep it simple and use only the Basic PNG icon, just delete the files (and any empty subdirectories) for the adaptive icon.

1. Compile the project and run. Then generate an APK and use it on your phone.

# Warning

**DO NOT PUBLISH THIS APK ON GOOGLE PLAY. ONLY USE IT ON YOUR PHONE.**

This APK does not contain the full functionality of a browser, and Google may consider it a violation of their Device Distribution Agreement, specifically the [Minimum Functionality](https://play.google.com/about/spam-min-functionality/min-functionality/) clause.

**IF YOU CHOOSE TO PUBLISH THIS ON GOOGLE PLAY, YOU RISK GETTING YOUR ACCOUNT BANNED PERMANENTLY.**
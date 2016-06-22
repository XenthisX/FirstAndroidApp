package com.example.elibosley.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Elijah Bosley on 6/21/2016
 */
public class SetupTheme {

    /**
     * Method to set the theme for an activity given that activity. This is very simple and uses
     * preference manager to deal with settings.
     *
     * @param activity the activity to change style on
     */
    public static void setupWindowTheme(Activity activity) {
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(activity);
        String themeName = pref.getString("themeSelection", "Theme");

        switch (themeName) {
            case "LightTheme":
                activity.setTheme(R.style.LightTheme);
                break;
            case "DarkTheme":
                activity.setTheme(R.style.DarkTheme);
                break;
            case "OledBlack":
                activity.setTheme(R.style.OledBlack);
                break;
        }
        Boolean darkerBar = pref.getBoolean("darkerBar", false);
        if (darkerBar) {
            activity.setTheme(R.style.DarkActionbar);
        }
        Boolean orangeFont = pref.getBoolean("orangeFont", false);
        if (orangeFont) {
            activity.setTheme(R.style.OrangeFont);
        }

    }
}

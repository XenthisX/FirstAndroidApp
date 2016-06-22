package com.example.elibosley.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by elibosley on 6/21/16.
 */
public class SetupTheme {


    public static void setupWindowTheme(Activity activity) {
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(activity);
        String themeName = pref.getString("themeSelection", "Theme1");
        if (themeName.equals("Africa")) {
            activity.setTheme(R.style.AppTheme);

        } else if (themeName.equals("LightTheme")) {
            //Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            activity.setTheme(R.style.LightTheme);
        } else if (themeName.equals("DarkTheme")) {
            //Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            activity.setTheme(R.style.DarkTheme);
        }
    }
}

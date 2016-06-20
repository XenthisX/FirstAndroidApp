package com.example.elibosley.myapplication;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    public final static int THEME_DARK = 0;
    public final static int THEME_LIGHT = 1;
    public final static int THEME_DEFAULT = 2;
    private static int sTheme;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DARK:
                activity.setTheme(R.style.DarkTheme);
                break;
            case THEME_LIGHT:
                activity.setTheme(R.style.LightTheme);
                break;
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
        }
    }
}
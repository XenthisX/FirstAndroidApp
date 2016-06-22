package com.example.elibosley.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class PreferencesActivity extends AppCompatActivity {

    /**
     * onCreate method called to setup the theme and create a PreferenceFragment manager
     *
     * @param savedInstanceState saved state in Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetupTheme.setupWindowTheme(this);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }

    /**
     * Necessary to make the MainActivity refresh theme correctly on back button press
     */
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    /**
     * PreferenceFragment that holds theme related preferences, and right now all preferences
     */
    public static class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            PreferenceManager.getDefaultSharedPreferences(this.getActivity()).registerOnSharedPreferenceChangeListener(this);
        }

        /**
         * Function used to reload settings page dynamically when theme is changed
         * TODO: Update the if (key) check to check for only theme change items
         * @param sharedPreferences SharedPreferenceItem to watch
         * @param key the key, retrieved by the listener
         */
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            System.out.println("key was: " + key);
            if (key != null) {
                if (getActivity() != null) {
                    getActivity().recreate();
                }
            }
        }
    }
}
package com.example.elibosley.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.example.elibosley.myapplication.MESSAGE";
    public static boolean isTwentyFour = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        /*THEME = preferences.getString("theme_pref", "0");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "THEME IS" + THEME, Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();

                switch (THEME) {
                    case "0":
                        setTheme(R.style.DarkTheme);
                        recreate();
                        break;
                    case "1":
                        setTheme(R.style.LightTheme);
                        recreate();
                        break;
                }

            }
        }); */
    }

    public void sendMessage(View view) {
        // Do something to respond to the button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // creates the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handles actionbar item clicks here
        int id = item.getItemId();

        if (id == R.id.help) {
            Intent intent = new Intent(this, DisplayHelpActivity.class);
            startActivity(intent);
        }
        if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.textClock) {

            String twelveHour = getString(R.string.time_format_12);
            String twentyFourHour = getString(R.string.time_format_24);
            String mode = getString(R.string.time_mode);
            String current_mode = null;
            TextClock clock = (TextClock) findViewById(R.id.textClock);

            if (isTwentyFour) {
                clock.setFormat12Hour(twentyFourHour);
                clock.setFormat24Hour(twentyFourHour);
                isTwentyFour = false;
                current_mode = mode + " " + getString(R.string.time_mode_24);
            }
            else {
                clock.setFormat12Hour(twelveHour);
                clock.setFormat24Hour(twelveHour);
                isTwentyFour = true;
                current_mode = mode + " " + getString(R.string.time_mode_12);
            }

            Snackbar.make(view, current_mode, Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();

        }
        if (view.getId() == R.id.fab) {


        }
    }
}

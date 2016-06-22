package com.example.elibosley.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class DisplayHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SetupTheme.setupWindowTheme(this);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.help));
        ab.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_display_help);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        // Help tab
        TabHost.TabSpec spec = host.newTabSpec("Help");
        spec.setContent(R.id.help);
        spec.setIndicator(getString(R.string.help));
        host.addTab(spec);

        // Author info tab
        spec = host.newTabSpec("Author Info");
        spec.setContent(R.id.author_info);
        spec.setIndicator(getString(R.string.author_tab));
        host.addTab(spec);
    }
}

package com.khamalganteng.uplace.mainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.khamalganteng.uplace.R;

public class BeritaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarBerita);
        setSupportActionBar(myToolbar);
    }
}

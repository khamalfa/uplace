package com.khamalganteng.uplace.mainMenu.sideMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.khamalganteng.uplace.R;

public class TopUpActivity extends AppCompatActivity {

    Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        Toolbar tuToolbar = (Toolbar) findViewById(R.id.tb_topup);

        setSupportActionBar(tuToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topupmenu, menu);
        return true;
    }

}

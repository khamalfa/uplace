package com.khamalganteng.uplace.mainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.mainMenu.sideMenu.BeliActivity;
import com.khamalganteng.uplace.mainMenu.sideMenu.TopUpActivity;

public class DanaSayaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dana_saya);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbardana);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.danamenu, menu);
        return true;
    }


    public void topupClick(View view)
    {
        Intent i = new Intent(this, TopUpActivity.class);
        startActivity(i);
    }

}

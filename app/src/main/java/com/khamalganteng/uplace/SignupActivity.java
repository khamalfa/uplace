package com.khamalganteng.uplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_daftar);
        setSupportActionBar(myToolbar);

    }
}

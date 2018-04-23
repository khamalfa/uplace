package com.khamalganteng.uplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a;
    }

    public void klikDaftar(View v) {
        Intent intent2 = new Intent(this, SignupActivity.class);
        startActivity(intent2);
    }

}

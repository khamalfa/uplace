package com.khamalganteng.uplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.khamalganteng.uplace.mainMenu.BeritaActivity;
import com.khamalganteng.uplace.mainMenu.CariActivity;
import com.khamalganteng.uplace.mainMenu.DanaSayaActivity;
import com.khamalganteng.uplace.mainMenu.ForumActivity;


public class Mainmenu extends AppCompatActivity
{
    Intent ntent;
    Intent ntent2;
    Intent ntent3;
    Intent ntent4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }
    public void klikDana(View v) {
        ntent = new Intent(this, DanaSayaActivity.class);
        startActivity(ntent);
    }
    public void klikForum(View v) {
        ntent2 = new Intent(this, ForumActivity.class);
        startActivity(ntent2);
    }
    public void klikBerita(View v) {
        ntent3 = new Intent(this, BeritaActivity.class);
        startActivity(ntent3);
    }
    public void klikCari(View v) {
        ntent4 = new Intent(this, CariActivity.class);
        startActivity(ntent4);
    }
}

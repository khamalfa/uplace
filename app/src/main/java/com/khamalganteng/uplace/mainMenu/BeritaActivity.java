package com.khamalganteng.uplace.mainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.adapter.BeritaAdapter;
import com.khamalganteng.uplace.database.Berita;

import java.util.ArrayList;

public class BeritaActivity extends AppCompatActivity
{
    ArrayList<Berita> alBerita = new ArrayList<>();
    RecyclerView rvBerita;

    RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);


        alBerita.add(new Berita("Keuntungan berjualan bakso", "Bakso memang bergizi sekali pemizah...","Detikfinance","10 Hari lalu"));
        alBerita.add(new Berita("Profil: Renchan, Bilyuner pertama RI", "Memang kaya sekali dia ya...","Prestigeholics","3 Menit lalu"));

        rvBerita =  (RecyclerView) findViewById(R.id.rv_berita); rvBerita.setHasFixedSize(true);

        //adapter
        BeritaAdapter adapter = new BeritaAdapter(alBerita, this);
        rvBerita.setAdapter(adapter);
        //layout manager
        lm = new LinearLayoutManager(this);
        rvBerita.setLayoutManager(lm);

        //supaya ada garis vertikal
        rvBerita.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarBerita);
        setSupportActionBar(myToolbar);
    }
}

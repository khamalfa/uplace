package com.khamalganteng.uplace.mainMenu.sideMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.adapter.KomentarAdapter;
import com.khamalganteng.uplace.database.Berita;
import com.khamalganteng.uplace.database.Komentar;

import java.util.ArrayList;

public class DetailPost extends AppCompatActivity {

    ArrayList<Komentar> alKomentar = new ArrayList<>();
    RecyclerView rvKomentar;

    RecyclerView.LayoutManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        alKomentar.add(new Komentar("Gaje Achmada", "2 Menit yang lalu", "Memang berbobot ya diskusi kalian"));
        alKomentar.add(new Komentar("Korg Stonerock", "3 Jam yang lalu", "The revolution has begun1!1"));

        rvKomentar =  (RecyclerView) findViewById(R.id.rv_komentar);
        //supaya cepat karena ukuran baris tdk berubah.
        rvKomentar .setHasFixedSize(true);

        //adapter
        KomentarAdapter adapter = new KomentarAdapter(alKomentar,this);
        rvKomentar.setAdapter(adapter);

        //layout manager
        lm = new LinearLayoutManager(this);
        rvKomentar.setLayoutManager(lm);

        //supaya ada garis vertikal
        rvKomentar.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


    }
}

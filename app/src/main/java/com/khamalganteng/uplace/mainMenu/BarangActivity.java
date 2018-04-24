package com.khamalganteng.uplace.mainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.adapter.BarangAdapter;
import com.khamalganteng.uplace.adapter.ForumAdapter;
import com.khamalganteng.uplace.database.Barang;
import com.khamalganteng.uplace.dbHelper.OpenHelperBarang;

import java.util.Date;

public class BarangActivity extends AppCompatActivity {
    RecyclerView rvBarang;
    RecyclerView.LayoutManager layoutManager;
    OpenHelperBarang helperBarang;
    BarangAdapter barangAdapter;
    TextView tvNamaBarang, tvDeskripsiBarang, tvHargaBarang, tvStokBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);


        rvBarang = (RecyclerView) findViewById(R.id.rvBarang);
        rvBarang.setHasFixedSize(true);

        tvNamaBarang = (TextView) findViewById(R.id.tvNamaBarang);
        tvDeskripsiBarang = (TextView) findViewById(R.id.tvDeskripsiBarang);
        tvHargaBarang= (TextView) findViewById(R.id.tvHargaBarang);
        tvStokBarang = (TextView) findViewById(R.id.tvStokBarang);

        layoutManager = new LinearLayoutManager(this);

        helperBarang = new OpenHelperBarang(this);

        //id user pake shared preferences
        helperBarang.setNewBarang(new Barang(1, "khamal", "MENCARI RENCHAN", 1000,20));

        rvBarang.setLayoutManager(layoutManager);
        rvBarang.setItemAnimator(new DefaultItemAnimator());
        rvBarang.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        populateRV();
    }

    public void populateRV(){
        barangAdapter = new BarangAdapter(helperBarang.getBarangList(""), this);
        rvBarang.setAdapter(barangAdapter);
        barangAdapter.notifyDataSetChanged();
    }
}

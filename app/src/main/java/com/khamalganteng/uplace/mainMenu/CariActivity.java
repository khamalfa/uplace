package com.khamalganteng.uplace.mainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.khamalganteng.uplace.ItemClickListener;
import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.adapter.BarangAdapter;
import com.khamalganteng.uplace.dbHelper.OpenHelperBarang;
import com.khamalganteng.uplace.mainMenu.sideMenu.BeliActivity;

public class CariActivity extends AppCompatActivity implements ItemClickListener {

    String keyword;
    EditText etKeyword;
    Button btnCari;
    OpenHelperBarang ohBarang;
    RecyclerView rvCari;
    BarangAdapter barangAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        etKeyword = (EditText) findViewById(R.id.et_c_keyword);
        btnCari = (Button) findViewById(R.id.btn_c_cari);
        ohBarang = new OpenHelperBarang(this);
        rvCari = (RecyclerView) findViewById(R.id.rvCari);
        layoutManager = new LinearLayoutManager(this);

        rvCari.setHasFixedSize(true);

        rvCari.setLayoutManager(layoutManager);
        rvCari.setItemAnimator(new DefaultItemAnimator());
        rvCari.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));



        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = etKeyword.getText().toString();
                if (!keyword.isEmpty()){
                    populateRV(keyword);
                }
            }
        });


    }

    public void populateRV(String filter){
        barangAdapter = new BarangAdapter(ohBarang.getBarangList(filter), this);
        rvCari.setAdapter(barangAdapter);
        barangAdapter.notifyDataSetChanged();
        barangAdapter.setClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        populateRV();
    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(this, BeliActivity.class);
        startActivity(i);
    }
}

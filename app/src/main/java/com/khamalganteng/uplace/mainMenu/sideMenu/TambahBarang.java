package com.khamalganteng.uplace.mainMenu.sideMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Barang;
import com.khamalganteng.uplace.dbHelper.OpenHelperBarang;

public class TambahBarang extends AppCompatActivity {

    String sNama,sDeskripsi;
    Integer iHarga, iStok;
    EditText etNama,etDeskripsi,etHarga,etStok;
    Button btn_ok;
    OpenHelperBarang ohBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        etNama = (EditText) findViewById(R.id.et_tb_nama);
        etDeskripsi = (EditText) findViewById(R.id.et_tb_deskripsi);
        etHarga = (EditText) findViewById(R.id.et_tb_harga);
        etStok = (EditText) findViewById(R.id.et_tb_stok);
        btn_ok = (Button) findViewById(R.id.btn_tb_ok);

        ohBarang = new OpenHelperBarang(this);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sNama = etNama.getText().toString();
                sDeskripsi = etNama.getText().toString();
                iHarga = Integer.parseInt(etHarga.getText().toString());
                iStok = Integer.parseInt(etStok.getText().toString());
                if(!sNama.isEmpty() && !sDeskripsi.isEmpty() && iHarga!=null && iStok != null){
                    ohBarang.setNewBarang(new Barang(1,sNama,sDeskripsi,iHarga,iStok));
                    finish();
                }
            }
        });

    }
}


package com.khamalganteng.uplace.mainMenu.sideMenu;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.dbHelper.OpenHelperBarang;
import com.khamalganteng.uplace.dbHelper.OpenHelperPosting;

import java.util.Date;

public class PostActivity extends AppCompatActivity {

    EditText etJudul,etIsi;
    String sJudul,sIsi;
    int id_user;
    Button btnOK;
    OpenHelperPosting ohPosting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarpost);
        setSupportActionBar(myToolbar);

        etJudul = (EditText) findViewById(R.id.et_forum_tambah_judul);
        etIsi = (EditText) findViewById(R.id.et_forum_tambah_isi);
        btnOK = (Button) findViewById(R.id.btn_forum_tambah);

        final SharedPreferences mPreferences = getSharedPreferences("DATA_GLOBAL_UPLACE",MODE_PRIVATE);


        ohPosting = new OpenHelperPosting(this);
        id_user= mPreferences.getInt("ID_USER",0);
        sJudul = "";
        sIsi = "";
        final Date a = new Date();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sJudul = etJudul.getText().toString();
                sIsi = etIsi.getText().toString();
                if (!sJudul.isEmpty() && !sIsi.isEmpty()){
                    ohPosting.setNewPosting(new Posting(id_user,"as",sJudul,sIsi,new Date()));
//                    ohPosting.setNewPosting(new Posting(id_user,sJudul,sIsi,a));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"lengkapi",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

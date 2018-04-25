package com.khamalganteng.uplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.khamalganteng.uplace.database.User;
import com.khamalganteng.uplace.dbHelper.OpenHelperUser;

public class SignupActivity extends AppCompatActivity {

    EditText etNamaUMKM,etNama, etEmail, etPassword1,etPassword2,
    etDescUMKM, etAlamatUMKM;
    String namaUMKM,username,email,password1,password2,descUMKM,alamatUMKM;
    OpenHelperUser ohuser;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_daftar);
        setSupportActionBar(myToolbar);

        //INISIASI
        etNamaUMKM = (EditText) findViewById(R.id.et_su_namaUMKM);
        etNama = (EditText) findViewById(R.id.et_su_username);
        etEmail = (EditText) findViewById(R.id.et_su_email);
        etPassword1 = (EditText) findViewById(R.id.et_su_password);
        etPassword2 = (EditText) findViewById(R.id.et_su_password2);
        etDescUMKM = (EditText) findViewById(R.id.et_su_descUMKM);
        etAlamatUMKM = (EditText) findViewById(R.id.et_su_alamatUMKM);

        ohuser = new OpenHelperUser(this);

//        Intent intenta = new Intent(this,MainActivity.class);

        Button btn = (Button) findViewById(R.id.btn_Lanjut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaUMKM = etNamaUMKM.getText().toString();
                username = etNama.getText().toString();
                email = etEmail.getText().toString();
                password1 = etPassword1.getText().toString();
                password2 = etPassword2.getText().toString();
                descUMKM = etDescUMKM.getText().toString();
                alamatUMKM = etAlamatUMKM.getText().toString();

                if (!username.isEmpty() && !password2.isEmpty() && !email.isEmpty() &&
                        !namaUMKM.isEmpty() && !descUMKM.isEmpty() && !alamatUMKM.isEmpty()){

                    ohuser.setNewUser(new User(username,password2,email,namaUMKM,descUMKM,alamatUMKM));

                    finish();
//            startActivity(new Intent(this,MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "MOHON ISI SEMUA FIELD", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // setTitle("Pendaftaran");

    }

    public void klikLanjut(){
//        assignString();

        if (!username.isEmpty() && !password2.isEmpty() && !email.isEmpty() &&
                !namaUMKM.isEmpty() && !descUMKM.isEmpty() && !alamatUMKM.isEmpty()){
            ohuser = new OpenHelperUser(this);
            ohuser.setNewUser(new User(username,password2,email,namaUMKM,descUMKM,alamatUMKM));
            Toast.makeText(this, username+" "+password2, Toast.LENGTH_SHORT).show();

            finish();
//            startActivity(new Intent(this,MainActivity.class));
        }else{
            Toast.makeText(this, "MOHON ISI SEMUA FIELD", Toast.LENGTH_SHORT).show();
        }
    }

    public void assignString(){
        //ASSIGN STRING
        this.namaUMKM = etNamaUMKM.getText().toString();
        this.username = etNama.getText().toString();
        this.email = etEmail.getText().toString();
        this.password1 = etPassword1.getText().toString();
        this.password2 = etPassword2.getText().toString();
        this.descUMKM = etDescUMKM.getText().toString();
        this.alamatUMKM = etAlamatUMKM.getText().toString();
    }
}

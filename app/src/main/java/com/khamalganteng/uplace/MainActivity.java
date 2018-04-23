package com.khamalganteng.uplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.khamalganteng.uplace.dbHelper.OpenHelperUser;
import com.khamalganteng.uplace.mainMenu.ForumActivity;

public class MainActivity extends AppCompatActivity {

    OpenHelperUser openHelperUser;
    EditText et_mail,et_password;
    String email,password;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelperUser = new OpenHelperUser(this);

    }

    public void klikDaftar(View v) {
        intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void klikLogin(View v){
        intent = new Intent(this, ForumActivity.class);
        startActivity(intent);
    }

}

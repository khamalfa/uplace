package com.khamalganteng.uplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.khamalganteng.uplace.database.User;
import com.khamalganteng.uplace.dbHelper.OpenHelperUser;
import com.khamalganteng.uplace.mainMenu.ForumActivity;

public class MainActivity extends AppCompatActivity {

    OpenHelperUser openHelperUser;
    EditText et_mail,et_password;
    String email,password;
    Intent intent;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelperUser = new OpenHelperUser(this);
        openHelperUser.setNewUser(new User("k","qw","lop","a","s","w"));
        user = new User();
        et_mail = (EditText) findViewById(R.id.et_mail);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    public void klikDaftar(View v) {
        intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void klikLogin(View v){
        intent = new Intent(this, Mainmenu.class);
        email = et_mail.getText().toString();
        password = et_password.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()){

            user = openHelperUser.getUser(email,password);

            if (user != null){
                startActivity(intent);
            }else{
                Toast.makeText(this,"SALAH",Toast.LENGTH_SHORT).show();
            }
        }

    }

}

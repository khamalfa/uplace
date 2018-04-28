package com.khamalganteng.uplace;

import android.content.Intent;
import android.content.SharedPreferences;
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
    EditText et_username,et_password;
    String username,password;
    Intent intent;
    User user;
    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelperUser = new OpenHelperUser(this);
//        openHelperUser.setNewUser(new User("k","qw","lop","a","s","w"));
        user = new User();
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        mPreferences = getSharedPreferences("DATA_GLOBAL_UPLACE",MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public void klikDaftar(View v) {
        intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void klikLogin(View v){
        intent = new Intent(this, Mainmenu.class);
        username = et_username.getText().toString();
        password = et_password.getText().toString();
        if (!username.isEmpty() && !password.isEmpty()){

            user = openHelperUser.getUser(username, password);

            if (user != null){
                startActivity(intent);
                mEditor.putInt("ID_USER",user.getId());
                mEditor.commit();
            }else{
                Toast.makeText(this,"Mohon",Toast.LENGTH_SHORT).show();
            }
        }



    }

}

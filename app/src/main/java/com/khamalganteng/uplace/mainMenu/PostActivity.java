
package com.khamalganteng.uplace.mainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.khamalganteng.uplace.R;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarpost);
        setSupportActionBar(myToolbar);

    }
}

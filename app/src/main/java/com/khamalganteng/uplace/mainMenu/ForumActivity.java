package com.khamalganteng.uplace.mainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.adapter.ForumAdapter;
import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.dbHelper.OpenHelperPosting;

import java.util.Date;

public class ForumActivity extends AppCompatActivity {

    RecyclerView rvForum;
    RecyclerView.LayoutManager layoutManager;
    OpenHelperPosting helperPosting;
    ForumAdapter forumAdapter;
    TextView tvJudulPosting, tvIsiPosting;
    Toolbar forumToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        forumToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(forumToolbar);


        rvForum = (RecyclerView) findViewById(R.id.rvForum);
        rvForum.setHasFixedSize(true);

        tvJudulPosting = (TextView) findViewById(R.id.tvJudulPosting);
        tvIsiPosting= (TextView) findViewById(R.id.tvIsiPositing);

        layoutManager = new LinearLayoutManager(this);

        helperPosting = new OpenHelperPosting(this);
        String desc= "terakhir ditemukan di balikpapan sandang pangan, dan terlacak oleh kelakuan tidak wajar luvizat wa euy ah " +
                "bleydeh teu puguh da sia khamal goblog";
        helperPosting.setNewPosting(new Posting(1,"khamal","MENCARI RENCHAN",desc,new Date()));

        rvForum.setLayoutManager(layoutManager);
        rvForum.setItemAnimator(new DefaultItemAnimator());
        rvForum.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        populateRV();

    }

    public void populateRV(){
        forumAdapter = new ForumAdapter(helperPosting.getPostingList(""), this);
        rvForum.setAdapter(forumAdapter);
        forumAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.forummenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnu_Post:
                Intent intent2 = new Intent(this, PostActivity.class);
                startActivity(intent2);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

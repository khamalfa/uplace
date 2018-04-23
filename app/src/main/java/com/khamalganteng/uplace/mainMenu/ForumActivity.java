package com.khamalganteng.uplace.mainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

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

}

package com.khamalganteng.uplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khamalganteng.uplace.ItemClickListener;
import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.database.User;
import com.khamalganteng.uplace.dbHelper.OpenHelperUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder>  {

    public List<Posting> iPosting;
    Context iContext;
    OpenHelperUser ohUser;
    private ItemClickListener clickListener;

    public ForumAdapter(List<Posting> iPosting, Context iContext) {
        this.iPosting = iPosting;
        this.iContext = iContext;
        ohUser = new OpenHelperUser(iContext);
    }

    public ForumAdapter() {
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvJudulPosting;
        public TextView tvIsiPosting;
        public TextView tvPengiPosting;
        public TextView tvWaktuPosting;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudulPosting = (TextView) itemView.findViewById(R.id.tvJudulPosting);
            tvIsiPosting = (TextView) itemView.findViewById(R.id.tvIsiPositing);
            tvPengiPosting = (TextView) itemView.findViewById(R.id.tv_pengirim);

            itemView.setOnClickListener(this); // bind the listener
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.content_forum, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ForumAdapter.ViewHolder holder, int position) {
        final Posting posting = iPosting.get(position);
        User user = new User();

        if (posting != null){
        }

        try {
            user = ohUser.getUser(posting.getId_USER());
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.tvJudulPosting.setText(posting.getJudul_POSTING());
        holder.tvIsiPosting.setText(posting.getIsi_POSTING());
        holder.tvPengiPosting.setText(user.getUsername());

//        Date date = new Date();
//        date=posting.getWaktu_POSTING();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        holder.tvWaktuPosting.setText("Time: " + dateFormat.format(date));

    }

    @Override
    public int getItemCount() {
        return iPosting.size();
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

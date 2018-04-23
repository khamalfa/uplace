package com.khamalganteng.uplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Posting;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder> {

    public List<Posting> iPosting;
    Context iContext;

    public ForumAdapter(List<Posting> iPosting, Context iContext) {
        this.iPosting = iPosting;
        this.iContext = iContext;
    }

    public ForumAdapter() {
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvJudulPosting;
        public TextView tvIsiPosting;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudulPosting = (TextView) itemView.findViewById(R.id.tvJudulPosting);
            tvIsiPosting = (TextView) itemView.findViewById(R.id.tvIsiPositing);
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
        holder.tvJudulPosting.setText(posting.getJudul_POSTING());
        holder.tvIsiPosting.setText(posting.getIsi_POSTING());
    }

    @Override
    public int getItemCount() {
        return iPosting.size();
    }
}

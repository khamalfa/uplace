package com.khamalganteng.uplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khamalganteng.uplace.ItemClickListener;
import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Berita;
import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.database.User;
import com.khamalganteng.uplace.dbHelper.OpenHelperUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder>  {

    public List<Berita> iBerita;
    Context iContext;
    OpenHelperUser ohUser;
    private ItemClickListener clickListener;

    public BeritaAdapter(List<Berita> iBerita, Context iContext) {
        this.iBerita = iBerita;
        this.iContext = iContext;
        ohUser = new OpenHelperUser(iContext);
    }

    public BeritaAdapter() {
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvJudulPosting;

        ImageView ivThumbnews;
        TextView tvSumberita;
        TextView tvDescbrita;
        TextView tvWaktuPosting;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudulPosting = (TextView) itemView.findViewById(R.id.tv_Judulberita);
            ivThumbnews = (ImageView) itemView.findViewById(R.id.iv_thubnews);
            tvSumberita = (TextView) itemView.findViewById(R.id.tv_source);
            tvWaktuPosting = (TextView) itemView.findViewById(R.id.tv_timepublished);
            tvDescbrita = (TextView) itemView.findViewById(R.id.tv_desc);

            itemView.setOnClickListener(this); // bind the listener
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.content_berita, parent, false);
        // set the view's size, margins, paddings `and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder holder, int position) {
        final Berita posting = iBerita.get(position);


        holder.tvJudulPosting.setText(posting.getJudul());
        holder.tvSumberita.setText(posting.getSource());
        holder.tvWaktuPosting.setText(posting.getTime());
        holder.tvDescbrita.setText(posting.getMinidesc());
        //holder.ivThumbnews.sett
//        Date date = new Date();
//        date=posting.getWaktu_POSTING();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");


    }

    @Override
    public int getItemCount() {
        return iBerita.size();
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

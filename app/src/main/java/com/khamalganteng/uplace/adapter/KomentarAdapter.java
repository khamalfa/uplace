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
import com.khamalganteng.uplace.database.Komentar;
import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.database.User;
import com.khamalganteng.uplace.dbHelper.OpenHelperUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.ViewHolder>  {

    public List<Komentar> iKomentar;
    Context iContext;
    OpenHelperUser ohUser;
    private ItemClickListener clickListener;

    public KomentarAdapter(List<Komentar> iKomentar, Context iContext) {
        this.iKomentar = iKomentar;
        this.iContext = iContext;
        ohUser = new OpenHelperUser(iContext);
    }

    public KomentarAdapter() {
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvPengirimKomen;

        ImageView ivThumbsender;
        TextView tvIsiKomen;

        TextView tvWaktuKomen;

        public ViewHolder(View itemView) {
            super(itemView);

             tvPengirimKomen= (TextView) itemView.findViewById(R.id.tv_pengirim);

             ivThumbsender= (ImageView) itemView.findViewById(R.id.iv_senderthumb);
             tvIsiKomen=(TextView) itemView.findViewById(R.id.tv_isikom);

             tvWaktuKomen= (TextView) itemView.findViewById(R.id.tv_waktukom);

            itemView.setOnClickListener(this); // bind the listener
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public KomentarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.content_komentar, parent, false);
        // set the view's size, margins, paddings `and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull KomentarAdapter.ViewHolder holder, int position) {
        final Komentar posting = iKomentar.get(position);

        holder.tvPengirimKomen.setText(posting.getPengirim());

        holder.tvPengirimKomen.setText(posting.getPengirim());
        holder.tvIsiKomen.setText(posting.getIsikomen());

        holder.tvWaktuKomen.setText(posting.getWaktu());
        //holder.ivThumbnews.sett
//        Date date = new Date();
//        date=posting.getWaktu_POSTING();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");


    }

    @Override
    public int getItemCount() {
        return iKomentar.size();
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

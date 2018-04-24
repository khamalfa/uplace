package com.khamalganteng.uplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khamalganteng.uplace.R;
import com.khamalganteng.uplace.database.Barang;
import com.khamalganteng.uplace.database.Posting;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {

    List<Barang> iBarang;
    Context iContext;



    public BarangAdapter() {
    }

    public BarangAdapter(List<Barang> iBarang, Context iContext) {
        this.iBarang = iBarang;
        this.iContext = iContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivBarang;
        public TextView tvNama;
        public TextView tvDeskripsi;
        public TextView tvHarga;
        public TextView tvStok;


        public ViewHolder(View itemView) {
            super(itemView);
            ivBarang = (ImageView) itemView.findViewById(R.id.ivBarang);
            tvNama = (TextView) itemView.findViewById(R.id.tvNamaBarang);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsiBarang);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHargaBarang);
            tvStok = (TextView) itemView.findViewById(R.id.tvStokBarang);

        }
    }

    @NonNull
    @Override
    public BarangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.content_barang, parent, false);
        // set the view's size, margins, paddings and layout parameters
        BarangAdapter.ViewHolder vh = new BarangAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.ViewHolder holder, int position) {
        final Barang posting = iBarang.get(position);
        holder.tvNama.setText(posting.getNama_BARANG());
        holder.tvDeskripsi.setText(posting.getDeskripsi_BARANG());
        holder.tvStok.setText(posting.getStok_BARANG());
        holder.tvHarga.setText(posting.getHarga_BARANG());
    }

    @Override
    public int getItemCount() {
        return iBarang.size();
    }
}

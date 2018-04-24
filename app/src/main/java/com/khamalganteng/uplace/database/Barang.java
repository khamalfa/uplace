package com.khamalganteng.uplace.database;

public class Barang {

    private int id_BARANG;
    private int id_USER;
    private String nama_BARANG;
    private String deskripsi_BARANG;
    private int harga_BARANG;
    private int stok_BARANG;

    public Barang() {
    }

    public Barang(int id_USER, String nama_BARANG, String deskripsi_BARANG, int harga_BARANG, int stok_BARANG) {
        this.id_USER = id_USER;
        this.nama_BARANG = nama_BARANG;
        this.deskripsi_BARANG = deskripsi_BARANG;
        this.harga_BARANG = harga_BARANG;
        this.stok_BARANG = stok_BARANG;
    }

    public int getId_BARANG() {
        return id_BARANG;
    }

    public void setId_BARANG(int id_BARANG) {
        this.id_BARANG = id_BARANG;
    }

    public int getId_USER() {
        return id_USER;
    }

    public void setId_USER(int id_USER) {
        this.id_USER = id_USER;
    }

    public String getNama_BARANG() {
        return nama_BARANG;
    }

    public void setNama_BARANG(String nama_BARANG) {
        this.nama_BARANG = nama_BARANG;
    }

    public String getDeskripsi_BARANG() {
        return deskripsi_BARANG;
    }

    public void setDeskripsi_BARANG(String deskripsi_BARANG) {
        this.deskripsi_BARANG = deskripsi_BARANG;
    }

    public int getHarga_BARANG() {
        return harga_BARANG;
    }

    public void setHarga_BARANG(int harga_BARANG) {
        this.harga_BARANG = harga_BARANG;
    }

    public int getStok_BARANG() {
        return stok_BARANG;
    }

    public void setStok_BARANG(int stok_BARANG) {
        this.stok_BARANG = stok_BARANG;
    }
}

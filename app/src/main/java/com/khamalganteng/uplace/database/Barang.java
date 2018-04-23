package com.khamalganteng.uplace.database;

public class Barang {

    int id_BARANG;
    int id_USER;
    String nama_BARANG;
    String deskripsi_BARANG;

    public Barang() {
    }

    public Barang(int id_BARANG, int id_USER, String nama_BARANG, String deskripsi_BARANG) {
        this.id_BARANG = id_BARANG;
        this.id_USER = id_USER;
        this.nama_BARANG = nama_BARANG;
        this.deskripsi_BARANG = deskripsi_BARANG;
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
}

package com.khamalganteng.uplace.database;

public class Posting {
    int id_POSTING;
    String nama_USER;
    String judul_POSTING;
    String isi_POSTING;

    public Posting() {
    }

    public Posting(int id_POSTING, String nama_USER, String judul_POSTING, String isi_POSTING) {
        this.id_POSTING = id_POSTING;
        this.nama_USER = nama_USER;
        this.judul_POSTING = judul_POSTING;
        this.isi_POSTING = isi_POSTING;
    }

    public int getId_POSTING() {
        return id_POSTING;
    }

    public void setId_POSTING(int id_POSTING) {
        this.id_POSTING = id_POSTING;
    }

    public String getNama_USER() {
        return nama_USER;
    }

    public void setNama_USER(String nama_USER) {
        this.nama_USER = nama_USER;
    }

    public String getJudul_POSTING() {
        return judul_POSTING;
    }

    public void setJudul_POSTING(String judul_POSTING) {
        this.judul_POSTING = judul_POSTING;
    }

    public String getIsi_POSTING() {
        return isi_POSTING;
    }

    public void setIsi_POSTING(String isi_POSTING) {
        this.isi_POSTING = isi_POSTING;
    }
}

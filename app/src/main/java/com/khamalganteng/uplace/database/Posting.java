package com.khamalganteng.uplace.database;

import java.util.Date;

public class Posting {
    private int id_POSTING;
    private int id_USER;
    private String nama_USER;
    private String judul_POSTING;
    private String isi_POSTING;
    private Date waktu_POSTING;

    public Posting() {
    }

    public Posting(int id_POSTING, int id_USER, String nama_USER, String judul_POSTING, String isi_POSTING, Date waktu_POSTING) {
        this.id_POSTING = id_POSTING;
        this.id_USER = id_USER;
        this.nama_USER = nama_USER;
        this.judul_POSTING = judul_POSTING;
        this.isi_POSTING = isi_POSTING;
        this.waktu_POSTING = waktu_POSTING;
    }

    public Posting(int id_USER, String nama_USER, String judul_POSTING, String isi_POSTING, Date waktu_POSTING) {
        this.id_USER = id_USER;
        this.nama_USER = nama_USER;
        this.judul_POSTING = judul_POSTING;
        this.isi_POSTING = isi_POSTING;
        this.waktu_POSTING = waktu_POSTING;
    }

    public Date getWaktu_POSTING() {
        return waktu_POSTING;
    }

    public void setWaktu_POSTING(Date waktu_POSTING) {
        this.waktu_POSTING = waktu_POSTING;
    }

    public int getId_USER() {
        return id_USER;
    }

    public void setId_USER(int id_USER) {
        this.id_USER = id_USER;
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

package com.khamalganteng.uplace.database;

public class User {
    int id;
    String username;
    String password;
    String nama_UMKM;
    String deskripsi_UMKM;
    String alamat_UMKM;

    public User() {
    }

    public User(int id, String username, String password, String nama_UMKM, String deskripsi_UMKM, String alamat_UMKM) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama_UMKM = nama_UMKM;
        this.deskripsi_UMKM = deskripsi_UMKM;
        this.alamat_UMKM = alamat_UMKM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_UMKM() {
        return nama_UMKM;
    }

    public void setNama_UMKM(String nama_UMKM) {
        this.nama_UMKM = nama_UMKM;
    }

    public String getDeskripsi_UMKM() {
        return deskripsi_UMKM;
    }

    public void setDeskripsi_UMKM(String deskripsi_UMKM) {
        this.deskripsi_UMKM = deskripsi_UMKM;
    }

    public String getAlamat_UMKM() {
        return alamat_UMKM;
    }

    public void setAlamat_UMKM(String alamat_UMKM) {
        this.alamat_UMKM = alamat_UMKM;
    }
}

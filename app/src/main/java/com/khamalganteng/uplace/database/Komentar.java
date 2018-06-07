package com.khamalganteng.uplace.database;

/**
 * Created by Agung Sugiarto on 6/7/2018.
 */

public class Komentar
{
    String pengirim;
    String waktu;
    String isikomen;

    public Komentar(String pengirim, String waktu, String isikomen) {
        this.pengirim = pengirim;
        this.waktu = waktu;
        this.isikomen = isikomen;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getIsikomen() {
        return isikomen;
    }

    public void setIsikomen(String isikomen) {
        this.isikomen = isikomen;
    }
}

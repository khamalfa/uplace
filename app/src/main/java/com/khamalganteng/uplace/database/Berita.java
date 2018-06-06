package com.khamalganteng.uplace.database;

import android.widget.ImageView;

/**
 * Created by Agung Sugiarto on 6/6/2018.
 */

public class Berita
{
    private String judul;
   private String minidesc;
    private String source;
    private String time;
    private ImageView thumbnail;

    public Berita(String judul, String minidesc, String source, String time) {
        this.judul = judul;
        this.minidesc = minidesc;
        this.source = source;
        this.time = time;
//        this.thumbnail = thumbnail;
    }


    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }




    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ImageView getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageView thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMinidesc() {
        return minidesc;
    }

    public void setMinidesc(String minidesc) {
        this.minidesc = minidesc;
    }
}


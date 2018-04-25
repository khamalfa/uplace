package com.khamalganteng.uplace.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.khamalganteng.uplace.database.Barang;

import java.util.LinkedList;
import java.util.List;

public class OpenHelperBarang extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "barang.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Barang";
    public static final String COLUMN_ID = "id_barang";
    public static final String COLUMN_ID_USER = "id_user";
    public static final String COLUMN_BARANG_NAME = "name";
    public static final String COLUMN_BARANG_DESC = "deskripsi";
    public static final String COLUMN_BARANG_PRICE = "harga";
    public static final String COLUMN_BARANG_STOCK = "stok";

    public OpenHelperBarang(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public OpenHelperBarang(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ID_USER + " INTEGER NOT NULL, " +
                COLUMN_BARANG_NAME + " TEXT NOT NULL, " +
                COLUMN_BARANG_DESC + " TEXT NOT NULL, " +
                COLUMN_BARANG_PRICE + " INTEGER NOT NULL, " +
                COLUMN_BARANG_STOCK + " INTEGER NOT NULL); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    public void setNewBarang(Barang post) {

        SQLiteDatabase db = this.getWritableDatabase();

        //temporary value, membungkus data dengan ContentValues
        ContentValues temp = new ContentValues();
        temp.put(COLUMN_ID_USER, post.getId_USER());
        temp.put(COLUMN_BARANG_NAME, post.getNama_BARANG());
        temp.put(COLUMN_BARANG_DESC, post.getDeskripsi_BARANG());
        temp.put(COLUMN_BARANG_PRICE, post.getHarga_BARANG());
        temp.put(COLUMN_BARANG_STOCK, post.getStok_BARANG());

        Log.d("DB", post.getNama_BARANG());

        // Masukkan

        db.insert(TABLE_NAME, null, temp);
        db.close();

//        Toast.makeText(this, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    public List<Barang> getBarangList(String filter) {

//        String query = "SELECT  * FROM " + TABLE_NAME;

        String query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ COLUMN_ID + " DESC";

        List<Barang> PostLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Barang post;

        if (cursor.moveToFirst()) {
            do {
                post = new Barang();

                post.setId_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                post.setId_USER(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_USER)));
                post.setNama_BARANG(cursor.getString(cursor.getColumnIndex(COLUMN_BARANG_NAME)));
                post.setDeskripsi_BARANG(cursor.getString(cursor.getColumnIndex(COLUMN_BARANG_DESC)));
                post.setHarga_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_BARANG_PRICE)));
                post.setStok_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_BARANG_PRICE)));

                PostLinkedList.add(post);
            } while (cursor.moveToNext());
        }


        return PostLinkedList;
    }

    public Barang getBarang(int id) {

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id_barang = " + id;

//        query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Barang post = null;

        if (cursor.getCount()>0) {
                post = new Barang();

                post.setId_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                post.setId_USER(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_USER)));
                post.setNama_BARANG(cursor.getString(cursor.getColumnIndex(COLUMN_BARANG_NAME)));
                post.setDeskripsi_BARANG(cursor.getString(cursor.getColumnIndex(COLUMN_BARANG_DESC)));
                post.setHarga_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_BARANG_PRICE)));
                post.setStok_BARANG(cursor.getInt(cursor.getColumnIndex(COLUMN_BARANG_PRICE)));

        }
        
        return post;
    }
}
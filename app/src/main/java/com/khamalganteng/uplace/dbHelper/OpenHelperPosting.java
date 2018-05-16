package com.khamalganteng.uplace.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.khamalganteng.uplace.database.Posting;

import java.util.LinkedList;
import java.util.List;

public class OpenHelperPosting extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "posting.db";
    private static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "Posting";
    public static final String COLUMN_ID = "id_posting";
    public static final String COLUMN_ID_USER = "id_user";
    public static final String COLUMN_POSTING_USERNAME = "username";
    public static final String COLUMN_POSTING_NAME = "judul";
    public static final String COLUMN_POSTING_DESC = "isi";

    public OpenHelperPosting(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public OpenHelperPosting(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ID_USER + " INTEGER NOT NULL, " +
                COLUMN_POSTING_USERNAME + " TEXT NOT NULL, " +
                COLUMN_POSTING_NAME + " TEXT NOT NULL, " +
                COLUMN_POSTING_DESC + " TEXT NOT NULL); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    public void setNewPosting(Posting post) {

        SQLiteDatabase db = this.getWritableDatabase();

        //temporary value, membungkus data dengan ContentValues
        ContentValues temp = new ContentValues();
        temp.put(COLUMN_ID_USER, post.getId_USER());
        temp.put(COLUMN_POSTING_USERNAME, post.getNama_USER());
        temp.put(COLUMN_POSTING_NAME, post.getJudul_POSTING());
        temp.put(COLUMN_POSTING_DESC, post.getIsi_POSTING());

        Log.d("DB", post.getJudul_POSTING());

        // Masukkan

        db.insert(TABLE_NAME, null, temp);
        db.close();

//        Toast.makeText(this, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    public List<Posting> getPostingList(String filter) {

        String query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_ID + " DESC";

//        query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;

        List<Posting> PostLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Posting post;

        if (cursor.moveToFirst()) {
            do {
                post = new Posting();

                post.setId_POSTING(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                post.setId_USER(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_USER)));
                post.setNama_USER(cursor.getString(cursor.getColumnIndex(COLUMN_POSTING_USERNAME)));
                post.setJudul_POSTING(cursor.getString(cursor.getColumnIndex(COLUMN_POSTING_NAME)));
                post.setIsi_POSTING(cursor.getString(cursor.getColumnIndex(COLUMN_POSTING_DESC)));

                PostLinkedList.add(post);
            } while (cursor.moveToNext());
        }


        return PostLinkedList;
    }
}
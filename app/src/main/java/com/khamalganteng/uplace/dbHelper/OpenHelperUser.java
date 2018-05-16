package com.khamalganteng.uplace.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.khamalganteng.uplace.database.Posting;
import com.khamalganteng.uplace.database.User;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class OpenHelperUser extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 7;
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_ID = "id_user";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_UMKM_NAME = "usernameumkm";
    public static final String COLUMN_UMKM_ADDRESS = "alamat";
    public static final String COLUMN_UMKM_DESC = "deskripsi";

    public OpenHelperUser(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


    public OpenHelperUser(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " +
                COLUMN_PASSWORD + " TEXT NOT NULL, " +
                COLUMN_UMKM_NAME + " TEXT NOT NULL, " +
                COLUMN_UMKM_ADDRESS + " TEXT NOT NULL, " +
                COLUMN_UMKM_DESC + " TEXT NOT NULL); "
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            this.onCreate(sqLiteDatabase);
        }

        public void setNewUser(User post) {

            SQLiteDatabase db = this.getWritableDatabase();

            //temporary value, membungkus data dengan ContentValues
            ContentValues temp = new ContentValues();
            temp.put(COLUMN_USERNAME, post.getUsername());
            temp.put(COLUMN_EMAIL, post.getEmail());
            temp.put(COLUMN_PASSWORD, post.getPassword());
            temp.put(COLUMN_UMKM_NAME, post.getNama_UMKM());
            temp.put(COLUMN_UMKM_ADDRESS, post.getAlamat_UMKM());
            temp.put(COLUMN_UMKM_DESC, post.getAlamat_UMKM());

            Log.d("DB", post.getEmail());

            // Masukkan

            db.insert(TABLE_NAME, null, temp);
            db.close();

//        Toast.makeText(, "Deleted successfully.", Toast.LENGTH_SHORT).show();

        }

        public User getUser(String susername, String spassword) {

            String query;

            query = "SELECT * FROM " + TABLE_NAME + " WHERE username LIKE '"+ susername + "' AND password LIKE '"  + spassword +"'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            User post = new User();

            if (cursor.getCount()>0) {
                cursor.moveToFirst();
                   post.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                   post.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                   post.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                   post.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                   post.setNama_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_NAME)));
                   post.setAlamat_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_ADDRESS)));
                   post.setDeskripsi_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_DESC)));
            }else{
                return null;
            }
        return post;
        }

    public User getUser(int id) {

        String query;

        query = "SELECT * FROM " + TABLE_NAME + " WHERE id_user = "+ id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User post = new User();

        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            post.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
            post.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
            post.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
            post.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
            post.setNama_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_NAME)));
            post.setAlamat_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_ADDRESS)));
            post.setDeskripsi_UMKM(cursor.getString(cursor.getColumnIndex(COLUMN_UMKM_DESC)));
        }else{
            return null;
        }
        return post;
    }
}

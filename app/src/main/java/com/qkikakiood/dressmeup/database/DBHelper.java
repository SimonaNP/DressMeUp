package com.qkikakiood.dressmeup.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import com.qkikakiood.dressmeup.ImageHelper;
import com.qkikakiood.dressmeup.cmn.Cloth;

/**
 * Created by a on 19.7.2016 г..
 */
public class DBHelper extends SQLiteOpenHelper {

    protected SQLiteDatabase database;

    public static final String DB_TABLE_CLOTHES = "Clothes";
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "db";
    public static final String KEY_ID = "ID";
    public static final String IMAGE = "IMAGE";
    //public static final String KEY_CATEGORY = "CATEGORY";
    //public static final String KEY_COLOUR = "COLOUR";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        open();
    }

    public void insertCloth(Cloth cloth){
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID, cloth.getClothID());
        cv.put(IMAGE, ImageHelper.BitMapToString(cloth.getImage()));
        database.insert(DB_TABLE_CLOTHES, null, cv);
    }

    public void open(){
        database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createMuseumTable());
    }

    private String createMuseumTable(){
        return "CREATE TABLE IF NOT EXISTS " + DB_TABLE_CLOTHES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ID + " INT, " + IMAGE + " TEXT);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_CLOTHES);
        onCreate(db);
    }

    public void close(){
        database.close();
    }

    public Cursor getClothValues(){
        return this.database.query(DB_TABLE_CLOTHES, new String[]{KEY_ID, IMAGE}, null, null, null, null, null);
    }

}


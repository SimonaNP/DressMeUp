package com.qkikakiood.dressmeup.database;

import android.content.Context;
import android.database.Cursor;

import com.qkikakiood.dressmeup.cmn.Cloth;

/**
 * Created by a on 19.7.2016 г..
 */
public class DBUtils {

    private static DBUtils instance;
    private DBHelper db;

    private DBUtils(Context context){
        initDB(context);
    }

    public static DBUtils getInstance(Context context){
        if(instance == null){
            instance = new DBUtils(context);
        }
        return instance;
    }

    private DBHelper initDB (Context context){
        if(db == null){
            db = new DBHelper(context);
        }
        return db;
    }

    public void writeClothRecord(Cloth cloth){
        db.insertCloth(cloth);
    }

    public Cursor readClothRecord(){ return db.getClothValues(); }


}

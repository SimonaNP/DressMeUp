package com.qkikakiood.dressmeup;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import com.qkikakiood.dressmeup.Adapters.Data_Adapter;
import com.qkikakiood.dressmeup.cmn.Cloth;
import com.qkikakiood.dressmeup.database.DBHelper;
import com.qkikakiood.dressmeup.database.DBUtils;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC1 on 19.7.2016 г..
 */
public class Wardrobe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cloth> clothes = fill_data();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Data_Adapter adapter = new Data_Adapter(clothes,getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Cloth> fill_data()
    {
        DBHelper db = new DBHelper(this) ; //my database helper file
        db.open();
       List<Cloth> resultList = new ArrayList<Cloth>();


        Cursor c = db.getClothValues(); //function to retrieve all values from a table- written in MyDb.java file
        while (c.moveToNext())
        {
            int imageID = c.getInt(c.getColumnIndex("KEY_ID"));

            try
            {
                Cloth cloth = new Cloth();
                cloth.setClothID(imageID);// setDate function is written in Class file
                resultList.add(cloth);
            }
            catch (Exception e) {
                Log.e("TAG", "Error " + e.toString());
            }

        }

        c.close();

        db.close();
        return resultList;
    }
}



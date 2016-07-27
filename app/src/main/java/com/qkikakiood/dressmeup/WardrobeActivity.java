package com.qkikakiood.dressmeup;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qkikakiood.dressmeup.Adapters.ImageAdapter;
import com.qkikakiood.dressmeup.cmn.Cloth;
import com.qkikakiood.dressmeup.database.DBHelper;
import com.qkikakiood.dressmeup.database.DBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC1 on 19.7.2016 г..
 */
public class WardrobeActivity extends AppCompatActivity {

    ArrayList<Cloth> clothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);

        List<Cloth> clothes = fill_data();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ImageAdapter adapter = new ImageAdapter(clothes, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public List<Cloth> fill_data() {
        DBUtils db = DBUtils.getInstance(this);

        List<Cloth> resultList = new ArrayList<Cloth>();


        Cursor c = db.readClothRecord();
        while (c.moveToNext()) {
            int imageID = c.getInt(c.getColumnIndex("ID"));
            String strImage = c.getString(c.getColumnIndex("IMAGE"));
            Bitmap image = ImageHelper.StringToBitMap(strImage);

            try {
                Cloth cloth = new Cloth();
                cloth.setClothID(imageID);// setDate function is written in Class file
                cloth.setImage(image);
                resultList.add(cloth);
            } catch (Exception e) {
                Log.e("TAG", "Error " + e.toString());
            }

        }

        c.close();

        return resultList;
    }
}



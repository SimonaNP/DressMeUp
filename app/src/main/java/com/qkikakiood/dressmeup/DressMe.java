package com.qkikakiood.dressmeup;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.qkikakiood.dressmeup.database.DBHelper;
import com.qkikakiood.dressmeup.database.DbBitmapUtility;

public class DressMe extends AppCompatActivity {
    public ImageView showPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showPhoto = (ImageView) findViewById(R.id.img_show_photo);
        showPhoto.setImageBitmap(getImage());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public Bitmap getImage(){
        byte[] image = DBHelper.getBitmapValues().getBlob(1);
        return DbBitmapUtility.getImage(image);
    }
}

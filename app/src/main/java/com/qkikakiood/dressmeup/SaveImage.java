package com.qkikakiood.dressmeup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class SaveImage extends AppCompatActivity {

//    private String[] spinnerCategory;
//    private String[] spinnerColor;
//
//    Button btnTakePhoto;
//    Button btnDressMe;
//    ImageView imgTakenPhoto;
//    private static final int CAM_REQUEST=1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        this.spinnerCategory = new String[] {
//                "PANTS", "SHORTS", "SKIRT", "DRESS", "T-SHIRT", "SHIRT", "THANK TOP","LONG-SLEEVE"
//        };
//        Spinner sCat = (Spinner) findViewById(R.id.spinner_category);
//        ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, spinnerCategory);
//        sCat.setAdapter(adapterCat);
//
//        this.spinnerColor = new String[] {
//                "BLACK", "WHITE", "BLUE", "GREEN", "RED", "PINK", "YELLOW","ORANGE","PURPLE","GREY","BROWN","NUDE"
//        };
//        Spinner sCol = (Spinner) findViewById(R.id.spinner_color);
//        ArrayAdapter<String> adapterCol = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, spinnerColor);
//        sCol.setAdapter(adapterCol);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        btnTakePhoto = (Button) findViewById(R.id.btn_add);
//        btnDressMe = (Button) findViewById(R.id.btn_dress);
//        imgTakenPhoto = (ImageView) findViewById(R.id.img_picture_taken);
//
//        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == CAM_REQUEST){
//            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//            imgTakenPhoto.setImageBitmap(thumbnail);
//        }
//    }
//
//    class btnTakePhotoClicker implements Button.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            startActivityForResult(cameraIntent,CAM_REQUEST);
//
//
//        }

    }

}
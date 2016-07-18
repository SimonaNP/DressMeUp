package com.qkikakiood.dressmeup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.qkikakiood.dressmeup.DatabaseHelper;

public class SaveImage extends AppCompatActivity {

    Button btnTakePhoto;
    ImageView imgTakenPhoto;
    private DatabaseHelper databaseHelper;
    public static final String IMAGE_ID = "IMG_ID";
    private static final int CAM_REQUEST = 1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);
        databaseHelper = new DatabaseHelper(this);

        btnTakePhoto = (Button) findViewById(R.id.btn_take_photo);
        imgTakenPhoto = (ImageView) findViewById(R.id.img_picture_taken);

        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());

      }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAM_REQUEST) {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                databaseHelper.insetImage(thumbnail, IMAGE_ID);
                imgTakenPhoto.setImageBitmap(thumbnail);
        }
    }


    class btnTakePhotoClicker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,CAM_REQUEST);


        }

    }

}
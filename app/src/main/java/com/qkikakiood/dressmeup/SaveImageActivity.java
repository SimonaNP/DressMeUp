package com.qkikakiood.dressmeup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.qkikakiood.dressmeup.cmn.Cloth;
import com.qkikakiood.dressmeup.database.DBHelper;
import com.qkikakiood.dressmeup.database.DBUtils;

import java.util.ArrayList;

//import com.qkikakiood.dressmeup.DatabaseHelper;

public class SaveImageActivity extends AppCompatActivity {

    Button btnTakePhoto;
    ImageView imgTakenPhoto;

    private static final int CAM_REQUEST = 1313;

    private DBUtils dbUtils;
    public static ArrayList<Cloth> clothes;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);

        dbHelper = new DBHelper(this);
        dbUtils = DBUtils.getInstance(this);
        clothes = new ArrayList<Cloth>();

        btnTakePhoto = (Button) findViewById(R.id.btn_take_photo);
        imgTakenPhoto = (ImageView) findViewById(R.id.img_picture_taken);

        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());

      }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAM_REQUEST) {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                imgTakenPhoto.setImageBitmap(thumbnail);
                Cloth newCloth = new Cloth(thumbnail,1);
                writeRecord(newCloth);
                readDB();
        }
    }

    class btnTakePhotoClicker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,CAM_REQUEST);
        }

    }


    private void writeRecord (Cloth cloth){ dbUtils.writeClothRecord(cloth);   }

    private void readDB(){
        Cursor cursor = dbUtils.readClothRecord();
        if(cursor.moveToFirst()){
            do{
                String clothImg = cursor.getString(cursor.getColumnIndex(DBHelper.IMAGE));
                Bitmap clothImage = ImageHelper.StringToBitMap(clothImg);
                int clothID = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));

                Cloth cloth = new Cloth(clothImage,clothID);
                clothes.add(cloth);

                Log.d("Image", clothImg);
                Log.d("ClothID", String.valueOf(clothID));
            }while(cursor.moveToNext());
        }
    }

}
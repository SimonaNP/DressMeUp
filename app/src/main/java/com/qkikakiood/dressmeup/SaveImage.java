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

public class SaveImage extends AppCompatActivity {

    Button btnTakePhoto;
    ImageView imgTakenPhoto;
    //private DatabaseHelper databaseHelper;
    //public static final String IMAGE_ID = "IMG_ID";
    //private final String TAG = "SaveImage";
    private static final int CAM_REQUEST = 1313;

    private DBUtils dbUtils;
    private ArrayList<Cloth> clothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);
        //databaseHelper = new DatabaseHelper(this);

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

//                databaseHelper.insetImage(thumbnail, IMAGE_ID);
//                new LoadImageFromDatabaseTask().execute(0);
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




//    private class LoadImageFromDatabaseTask extends AsyncTask<Integer, Integer, ImageHelper> {
//
//        private final ProgressDialog LoadImageProgressDialog =  new ProgressDialog(SaveImage.this);
//
//        protected void onPreExecute() {
//            this.LoadImageProgressDialog.setMessage("Loading Image from Db...");
//            this.LoadImageProgressDialog.show();
//        }
//
//        @Override
//        protected ImageHelper doInBackground(Integer... integers) {
//            Log.d("LoadImageFromDatabaseTask : doInBackground", "");
//            return databaseHelper.getImage(IMAGE_ID);
//        }
//
//        protected void onProgressUpdate(Integer... progress) {
//        }
//
//        protected void onPostExecute(ImageHelper imageHelper) {
//            Log.d("LoadImageFromDatabaseTask : onPostExecute - ImageID ", imageHelper.getImageId());
//            if (this.LoadImageProgressDialog.isShowing()) {
//                this.LoadImageProgressDialog.dismiss();
//            }
//            setUpImage(imageHelper.getImageByteArray());
//        }
//
//    }
//
//    private void setUpImage(byte[] bytes) {
//        Log.d(TAG, "Decoding bytes");
//        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//        imgTakenPhoto.setImageBitmap(bitmap);
//    }

}
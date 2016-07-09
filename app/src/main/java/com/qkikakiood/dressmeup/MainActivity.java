 package com.qkikakiood.dressmeup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnTakePhoto;
    ImageView ingTakenPhoto;
    private static final int CAM_REQUEST=1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakePhoto = (Button) findViewById(R.id.btn_add);
        ingTakenPhoto = (ImageView) findViewById(R.id.img_picture_taken);

        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());

    }
@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data){
      super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == CAM_REQUEST){
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ingTakenPhoto.setImageBitmap(thumbnail);
    }
  }

    class btnTakePhotoClicker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,CAM_REQUEST);
        }
    }

    public void openDressMeActivity(View view) {
        Intent intent = new Intent(this, DressMe.class);
    }

}

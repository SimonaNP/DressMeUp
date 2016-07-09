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
    Button addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItem = (Button) findViewById(R.id.btn_add);
    }


    public void openSaveImage(View view)
    {
        Intent intent = new Intent(MainActivity.this, SaveImage.class);
        startActivity(intent);
    }

}
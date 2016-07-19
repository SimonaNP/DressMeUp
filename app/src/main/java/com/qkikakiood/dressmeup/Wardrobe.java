package com.qkikakiood.dressmeup.;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qkikakiood.dressmeup.R;

import java.util.ArrayList;

public class Wardrobe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recView = (RecyclerView) findViewById(R.id.recycle);
        String[] names = new String[]{"nesto", "si"};
        ImagesAdapter conAdapter = new ImagesAdapter(names);
        recView.setLayoutManager(new LinearLayoutManager(this));

        recView.setAdapter(conAdapter);

    }


}
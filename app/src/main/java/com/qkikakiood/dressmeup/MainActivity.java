package com.qkikakiood.dressmeup;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addItem;
    Button checkTheWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItem = (Button) findViewById(R.id.btn_add);
        checkTheWeather = (Button) findViewById(R.id.btn_weather);
    }


    public void openSaveImage(View view)
    {
        Intent intent = new Intent(MainActivity.this, SaveImageActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void openWardrobe(View view)
    {
        Intent intent = new Intent(MainActivity.this, WardrobeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void openWeatherForecast(View view){
        WebView browser = (WebView) findViewById(R.id.webView);
        if (browser != null) {
            browser.loadUrl("http://sinoptik.bg/vratsa-bulgaria-100725712");
        }
    }

}
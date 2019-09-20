package com.twowings.app.shoesize;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Main4Activity extends AppCompatActivity {
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private String sprache="en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppLocale(sprache);
        setContentView(R.layout.activity_main4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setLanguageDE();
            }
        });
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setLanguageEN();
            }
        });



    }

    public void setLanguageDE(){
        this.sprache = "de";
        setAppLocale(sprache);
        setContentView(R.layout.activity_main4);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setLanguageEN(){
        this.sprache = "en";
        setAppLocale(sprache);
        setContentView(R.layout.activity_main4);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setAppLocale(String LocaleCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLocale(new Locale(LocaleCode.toLowerCase()));
        }
        else{
            conf.locale = new Locale(LocaleCode.toLowerCase());
        }
        res.updateConfiguration(conf, dm);
    }

    public void OnbuttonClick(View view) {
        finish();
        System.exit(0);
    }
}

package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class restro_page extends AppCompatActivity {
    ImageView backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_page);

        backbtn=findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restro_page.super.onBackPressed();
            }
        });
    }

    public void navigate(View view) {
        Intent intent = null , chooser = null;
        if(view.getId() == R.id.nav_ziya){
            Uri uri = Uri.parse("geo:0 , 0?q=Ziya Restaurant");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
        if(view.getId() == R.id.nav_mia){
            Uri uri = Uri.parse("geo:0 , 0?q=Mia Cuccinna");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
        if(view.getId() == R.id.nav_sanquo){
            Uri uri = Uri.parse("geo:0 , 0?q=San Qi");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
        if(view.getId() == R.id.nav_golden_dragon){
            Uri uri = Uri.parse("geo:0 , 0?q=The Golden Dragon Restuarant Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
        if(view.getId() == R.id.nav_wasabi){
            Uri uri = Uri.parse("geo:0 , 0?q=Wasabi by Morimoto");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
    }
}
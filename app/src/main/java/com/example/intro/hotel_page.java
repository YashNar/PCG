package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class hotel_page extends AppCompatActivity {
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_page);

        backbtn=findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotel_page.super.onBackPressed();
            }
        });
    }

    public void navigate_hotel(View view) {
        Intent intent = null , chooser = null;
        if(view.getId() == R.id.nav_oberoi){
            Uri uri = Uri.parse("geo:0 , 0?q=The Oberoi, Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_tri_bkc){
            Uri uri = Uri.parse("geo:0 , 0?q=Trident Hotel Bandra Kurla");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_tri_np){
            Uri uri = Uri.parse("geo:0 , 0?q=Trident Hotel, Nariman Point Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.hyatt_regency){
            Uri uri = Uri.parse("geo:0 , 0?q=Grand Hyatt Mumbai Hotel & Residences");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_taj){
            Uri uri = Uri.parse("geo:0 , 0?q=Taj Hotel Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

    }
}
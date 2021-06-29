package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class shop_page extends AppCompatActivity {
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        backbtn=findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_page.super.onBackPressed();
            }
        });
    }

    public void navigate_shop(View view) {
        Intent intent = null , chooser = null;
        if(view.getId() == R.id.nav_colaba){
            Uri uri = Uri.parse("geo:0 , 0?q=Colaba Causeway");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_zaveri_bzr){
            Uri uri = Uri.parse("geo:0 , 0?q=Zaveri Bazaar Kalbadevi");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_lokhandwala){
            Uri uri = Uri.parse("geo:0 , 0?q=Lokhandwala Market Road");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_linking_rd){
            Uri uri = Uri.parse("geo:0 , 0?q=Linking Road Shopping Centre Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_fs){
            Uri uri = Uri.parse("geo:0 , 0?q=Fashion Street Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
    }
}
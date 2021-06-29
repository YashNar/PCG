package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class fun_page extends AppCompatActivity {
    ImageView backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_page);

        backbtn=findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun_page.super.onBackPressed();
            }
        });
    }

    public void navigate_fun(View view) {
        Intent intent = null , chooser = null;
        if(view.getId() == R.id.nav_dharavi){
            Uri uri = Uri.parse("geo:0 , 0?q=Dharavi Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_haji_ali){
            Uri uri = Uri.parse("geo:0 , 0?q=Haji Ali Dargah");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_hanging_garden){
            Uri uri = Uri.parse("geo:0 , 0?q=Hanging Garden Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_mahakali_cave){
            Uri uri = Uri.parse("geo:0 , 0?q=Mahakali Caves");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_essel_world){
            Uri uri = Uri.parse("geo:0 , 0?q=Essel World Amusement Park Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_ban_tank){
            Uri uri = Uri.parse("geo:0 , 0?q=Banganga Tank");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }

        if(view.getId() == R.id.nav_juhu_beach){
            Uri uri = Uri.parse("geo:0 , 0?q=Juhu chowpatty Mumbai");
            intent = new Intent(Intent.ACTION_VIEW , uri);
            chooser = Intent.createChooser(intent , "Launch Map");
            startActivity(chooser);
        }
    }
}
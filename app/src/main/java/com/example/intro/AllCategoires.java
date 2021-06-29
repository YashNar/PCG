package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllCategoires extends AppCompatActivity {

    ImageView backbtn;
    Button c_restro;
    Button c_hotel;
    Button c_fun;
    Button c_shops;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categoires);

        c_restro=findViewById(R.id.cat_restro);
        c_hotel=findViewById(R.id.cat_hotel);
        c_fun=findViewById(R.id.cat_fun);
        c_shops=findViewById(R.id.cat_shops);



        c_restro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),restro_page.class));
            }
        });

        c_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),hotel_page.class));
            }
        });

        c_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fun_page.class));
            }
        });

        c_shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),shop_page.class));
            }
        });


        //hooks
        backbtn=findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategoires.super.onBackPressed();
            }
        });

    }


}
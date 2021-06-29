package com.example.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext() , UserDashboard.class));
            finish();
        }
        if (fAuth.getCurrentUser() == null){
            startActivity(new Intent(getApplicationContext() , Login.class));
            finish();
        }
    }


}
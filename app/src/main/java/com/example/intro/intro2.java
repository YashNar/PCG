package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class intro2 extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int Position=0;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set activity to full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //validation for splash screen
        if(restorePrefData())
        {
            Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_intro2);

        //hide the action bar

        btnNext=findViewById(R.id.btn_next);
        btnGetStarted=findViewById(R.id.btn_get_started);
        tabIndicator=findViewById(R.id.tab_indicator);
        btnAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        //fill list screen
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("No Guide?","Don't Worry! You Don't Need A Tourist Guide Anymore!",R.drawable.guide));
        mList.add(new ScreenItem("Lost Your Way?","Don't Worry! We're Here To Guide You",R.drawable.lostway));
        mList.add(new ScreenItem("POCKET CITY GUIDE!","We Help You Travel Cities You're Not Familiar With :) ",R.drawable.navigate2));

        //setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this , mList);
        screenPager.setAdapter(introViewPagerAdapter);


        //setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        //next button click listner
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Position=screenPager.getCurrentItem();
                if (Position < mList.size())
                {
                    Position++;
                    screenPager.setCurrentItem(Position);
                }

                if(Position==mList.size()-1)
                {
                    //code if we reach to last page oof splash screen
                    loadLastScreen();
                }

            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition()==mList.size()-1)
                {
                    loadLastScreen();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //getStarted button click listner
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //opens main activity
                Intent RegisterActivity=new Intent(getApplicationContext(),Register.class);
                startActivity(RegisterActivity);

                //also  we need to save a boolean value to storage so next time when the user visits the app
                // we could know that he is already checked the intro screen.

                savePrefData();
                finish();

            }
        });



    }

    private boolean restorePrefData(){
        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore=pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefData()
    {
        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    private void loadLastScreen()
    {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        //setup animation
        btnGetStarted.setAnimation(btnAnim);




    }
}
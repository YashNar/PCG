package com.example.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Dashboard
    RecyclerView featuredRecycler, mostviewed, categories;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    TextView searchbtn;

    //Drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView d_restro;
    ImageView d_hotel;
    ImageView d_fun;
    ImageView d_shops;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviewed = findViewById(R.id.mostviewedrecycler);
        categories = findViewById(R.id.categoriesrecycler);
        menuIcon = findViewById(R.id.menu_icon);
        searchbtn=findViewById(R.id.search);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        d_restro=findViewById(R.id.dashboard_restro);
        d_hotel=findViewById(R.id.dashboard_hotel);
        d_fun=findViewById(R.id.dashboard_fun);
        d_shops=findViewById(R.id.dashboard_shop);

        //Function Calls
        featuredRecycler();
        mostviewed();
        categories();


        navigationDrawer();
        clickSearch();


    }
    public void clickSearch(){

        d_restro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),restro_page.class));
            }
        });

        d_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),hotel_page.class));
            }
        });

         d_shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),shop_page.class));
            }
        });

        d_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fun_page.class));
            }
        });


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Map_Mapbox.class));
            }
        });
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategoires.class));
                break;

            case R.id.nav_logout:

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext() , Login.class));
                finish();
                break;

            case R.id.nav_profile:
                startActivity(new Intent(getApplicationContext(),ProfilePage.class));
                break;

            case R.id.nav_aboutus:
                startActivity(new Intent(getApplicationContext(),aboutus.class));
                break;

            case R.id.nav_restaurants:
                startActivity(new Intent(getApplicationContext(),restro_page.class));
                break;

            case R.id.nav_shops:
                startActivity(new Intent(getApplicationContext(),shop_page.class));
                break;

            case R.id.nav_hotel:
                startActivity(new Intent(getApplicationContext(),hotel_page.class));
                break;

            case R.id.nav_fun:
                startActivity(new Intent(getApplicationContext(),fun_page.class));
                break;

            case R.id.nav_search:
                startActivity(new Intent(getApplicationContext(),Map_Mapbox.class));
                break;

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),UserDashboard.class));
                break;
        }



        return true;
    }

    //Recycler View Functions
    private void categories() {
        categories.setHasFixedSize(true);
        categories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new CategoriesHelperClass(R.drawable.restaurant, "Restro"));
        mostViewedLocations.add(new CategoriesHelperClass(R.drawable.shop, "Shop"));
        mostViewedLocations.add(new CategoriesHelperClass(R.drawable.hotel, "Hotel"));
        mostViewedLocations.add(new CategoriesHelperClass(R.drawable.fun, "Fun"));

        adapter = new CategoriesAdapter(mostViewedLocations);
        categories.setAdapter(adapter);
    }

    private void mostviewed() {
        mostviewed.setHasFixedSize(true);
        mostviewed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.gateway, "GateWay Of India", "The Gateway of India is an arch-monument built in the early twentieth century in the city of Mumbai"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.taj, "Taj Hotel", "The Taj Mahal Palace Hotel is a heritage, five-star, luxury hotel built in the Saracenic Revival style in the Colaba region of Mumba"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.marines, "Marine Drive", "Marine Drive is a 3.6-kilometre-long Promenade along the Netaji Subhash Chandra Bose Road in South Mumbai in the city of Mumbai, India. Often, the names Marine Drive"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.haji_ali, "Haji Ali Mosque", "The Haji Ali Mosque, at Mumbai is a spectacle off the Worli sea face. Nestled on a shelf off the coast, it is connected to the coast via a long artificial jetty that is seldom a stranger to a crowd of pilgrims making their way to and from the dargah."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hanging_garden, "Hanging Garden", "Hanging Garden is the city’s oldest and best preserved park. Very strategically located, the most popular attraction in the park is the giant old lady’s shoe where many photography enthusiasts try their luck at a good capture"));
        adapter = new MostViewedAdapter(mostViewedLocations);
        mostviewed.setAdapter(adapter);

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClasss> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.sgnp_borivali, "SGNP Mumbai", "Sanjay Gandhi National Park is a 87 km² protected area in Mumbai, Maharashtra State in India. It was established in 1996 with headquarters at Borivali. It is notable as one of the major national parks existing within a metropolis limit and is one of the most visited parks in the world."));
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.wasabi, "Wasabi by Morimoto", "Wasabi by Morimoto is a regular include in Asia’s 50 Best Restaurants list. The chefs here provide an extensive menu of mouthwatering Japanese delicacies with an array of delicious sakes and succulent sushi. "));
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.trident_nariman, "Trident Nariman Point", "The 5-star Trident Nariman Point is located in Mumbai, overlooking the beautiful Arabian Sea from Marine Drive. Featuring a 24-hour business centre, the hotel has an outdoor pool, a fitness centre and pampering spa treatments. Complimentary WiFi is available in all rooms."));
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.gateway, "GateWay Of India", "The Gateway of India is an arch-monument built in the early twentieth century in the city of Mumbai"));
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.fashion_street, "Fashion Street Mumbai", "Fashion Street is the ultimate destination to go for shopping in Mumbai, situated in South Mumbai. It is a flea market with standalone shops offering you the most unique and fashionable things to buy. Fashion Street has more than a hundred shops with beautiful trendy garments, footwear, and jewellery in stock."));
        featuredLocations.add(new FeaturedHelperClasss(R.drawable.hanging_garden, "Hanging Garden", "Hanging Garden is the city’s oldest and best preserved park. Very strategically located, the most popular attraction in the park is the giant old lady’s shoe where many photography enthusiasts try their luck at a good capture"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }
}

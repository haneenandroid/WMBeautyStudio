package com.example.wmbeautystudio.Booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.wmbeautystudio.ContactUs;
import com.example.wmbeautystudio.MainActivity;
import com.example.wmbeautystudio.Profile.ClientProfile;
import com.example.wmbeautystudio.R;
import com.google.android.material.navigation.NavigationView;

public class LadiesAppointment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    ImageView menuIcon;


    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies_appointment);

        //Hooks
        menuIcon = findViewById(R.id.menu_icon);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();

    }

    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(v -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

    }


    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_profile){
            //Handle the camera action
            startActivity(new Intent(LadiesAppointment.this, ClientProfile.class));
        }else if (id == R.id.nav_gentsservices){
            startActivity(new Intent(LadiesAppointment.this, GentsServices.class));
        }else if (id == R.id.nav_ladiesservices){
            startActivity(new Intent(LadiesAppointment.this, LadiesServices.class));
        }else if (id == R.id.nav_logout){
            startActivity(new Intent(LadiesAppointment.this, MainActivity.class));
        }else if (id == R.id.nav_contact){
            startActivity(new Intent(LadiesAppointment.this, ContactUs.class));
        }
        return true;
    }
}
package com.example.orlayfrozenfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity {
    DrawerLayout dlayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        setNavigationDrawer();
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,dlayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
     BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        dlayout.setDrawerListener(toggle);
//        toggle.syncState();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.logout:
                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
                return true;
            }
        });
   }

//    private void setNavigationDrawer() {
//        dlayout = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.navigation);
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment selectedFragment = null;
//                switch (item.getItemId()){
//                    case R.id.nav_home:
//                        selectedFragment = new HomeFragment();
//                        break;
//                    case R.id.nav_profile:
//                        selectedFragment = new ProfileFragment();
//                        break;
//                    case R.id.nav_logout:
//                        Intent i = new Intent(getApplicationContext(), Login.class);
//                        startActivity(i);
//                        break;
//
//                }
//                if (selectedFragment != null) {
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.frame, selectedFragment); // replace a Fragment with Frame Layout
//                    transaction.commit(); // commit the changes
//                    dlayout.closeDrawers(); // close the all open Drawer Views
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

}
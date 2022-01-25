package com.example.orlayfrozenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Boolean Login;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Login = sharedPref.getBoolean("Login", false);

        Log.d("Login", Login.toString());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               /* Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();*/
                if (Login) {
                    startActivity(new Intent(MainActivity.this, DrawerActivity.class));

                } else {
                    startActivity(new Intent(MainActivity.this, Login.class));
                    finish();
                }
            }
        }, 1000);
    }
}
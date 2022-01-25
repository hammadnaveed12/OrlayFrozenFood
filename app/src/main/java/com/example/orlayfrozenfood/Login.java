package com.example.orlayfrozenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText e1,e2;
 SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPref.edit();

              if(e1.getText().toString().equals("admin") && e2.getText().toString().equals("admin")) {
                  editor.putBoolean("Login", true);
                  editor.apply();
                Toast.makeText(Login.this, "Loginning in", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(i);
                finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
    }
    });
    }
}
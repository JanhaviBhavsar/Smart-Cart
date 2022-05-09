package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void Signin (View view) {
            Intent intent= new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
         public void Login(View view){
        Intent intent= new Intent(this,MainActivity3.class);
        startActivity(intent);
         }

    }

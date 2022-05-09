package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void start(View view){
        Intent intent= new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void login(View view){
Intent intent= new Intent(this,MainActivity3.class);
startActivity(intent);
}
}
package com.example.qlcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btnQLNV;
    private Button btnQLVT;
    private Button btnQLCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQLNV = findViewById(R.id.btn_qlnv);
        btnQLVT = findViewById(R.id.btn_qlvt);
        btnQLCV = findViewById(R.id.btn_qlcv);
        
        btnQLNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnQLNVListener();
            }
        });

        btnQLVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnQLVTListener();
            }
        });

        btnQLCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnQLCVListener();
            }
        });
    }

    private void btnQLCVListener() {
        Intent intent = new Intent();
        intent.setClass(this, StaffPositionActivity.class);
        startActivity(intent);
    }

    private void btnQLVTListener() {
        Intent intent = new Intent();
        intent.setClass(this, PositionManagerActivity.class);
        startActivity(intent);
    }

    private void btnQLNVListener() {
        Intent intent = new Intent();
        intent.setClass(this, StaffManagerActivity.class);
        startActivity(intent);
    }



}
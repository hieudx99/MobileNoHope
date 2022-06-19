package com.example.qlcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qlcv.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionManagerActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtDescription;
    private Button btnAdd;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_manager);

        edtName = findViewById(R.id.edt_name);
        edtDescription = findViewById(R.id.edt_desc);
        btnAdd = findViewById(R.id.btn_add_position);
        lv = findViewById(R.id.lv_position);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddListener();
            }
        });

        loadData();

    }

    private void loadData() {
        DatabaseHelper db = new DatabaseHelper(this);
        List<Position> listPosition = new ArrayList<>();
        listPosition = db.getAllPosition();

        ArrayAdapter<Position> lvAdapter = new ArrayAdapter<Position>(this, android.R.layout.simple_list_item_1, listPosition);
        lv.setAdapter(lvAdapter);
    }


    private void btnAddListener() {
        DatabaseHelper db = new DatabaseHelper(this);
        String name = edtName.getText().toString();
        String description = edtDescription.getText().toString();
        Position position = new Position(name, description);
        db.addPosition(position);
        refresh();
        db.close();
    }

    private void refresh() {
        Intent intent = new Intent();
        intent.setClass(PositionManagerActivity.this, PositionManagerActivity.class);
        startActivity(intent);
        finish();
    }
}
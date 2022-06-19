package com.example.qlcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qlcv.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffManagerActivity extends AppCompatActivity {

    private EditText edtFullname;
    private EditText edtDoB;
    private EditText edtCountry;
    private Spinner spinner;
    private Button btnAdd;
    private ListView lv;

    private ArrayAdapter<Staff> lvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_manager);

        edtFullname = findViewById(R.id.edt_fullname);
        edtDoB = findViewById(R.id.edt_dob);
        edtCountry = findViewById(R.id.edt_country);
        spinner = findViewById(R.id.spn_staff);
        btnAdd = findViewById(R.id.btn_add_staff);
        lv = findViewById(R.id.lv_staff);
        String[] staffLevel = {"CD", "DH", "SDH"};
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, staffLevel);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(spnAdapter);
        
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
        List<Staff> listStaff = new ArrayList<>();
        listStaff = db.getAllStaff();
        lvAdapter = new ArrayAdapter<Staff>(this, android.R.layout.simple_list_item_1, listStaff);
        lv.setAdapter(lvAdapter);
    }

    private void btnAddListener() {
        DatabaseHelper db = new DatabaseHelper(this);
        String fullname = edtFullname.getText().toString();
        String dob = edtDoB.getText().toString();
        String country = edtCountry.getText().toString();
        String level = spinner.getSelectedItem().toString();
        Staff staff = new Staff(fullname, dob, country, level);
        db.addStaff(staff);
//        lvAdapter.notifyDataSetChanged();
        refresh();
        db.close();

    }

    private void refresh() {
        Intent intent = new Intent();
        intent.setClass(StaffManagerActivity.this, StaffManagerActivity.class);
        startActivity(intent);
        finish();
    }
}
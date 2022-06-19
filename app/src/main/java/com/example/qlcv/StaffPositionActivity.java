package com.example.qlcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qlcv.model.Position;
import com.example.qlcv.model.PositionStaff;
import com.example.qlcv.model.Staff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffPositionActivity extends AppCompatActivity {

    private Spinner spnStaff;
    private Spinner spnPosition;
    private Button btnAdd;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_position);

        spnStaff = findViewById(R.id.spn_staff);
        spnPosition = findViewById(R.id.spn_position);
        btnAdd = findViewById(R.id.btn_add);
        lv = findViewById(R.id.lv_position_staff);
        
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddListener();
            }
        });

        loadData();

        loadListView();
    }

    private void loadListView() {
        DatabaseHelper db = new DatabaseHelper(this);
        List<PositionStaff> list = new ArrayList<>();
        list = db.getAllPositionStaff();

        ArrayAdapter<PositionStaff> lvAdapter = new ArrayAdapter<PositionStaff>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(lvAdapter);
    }

    private void loadData() {
        DatabaseHelper db = new DatabaseHelper(this);
        List<Staff> listStaff = new ArrayList<>();
        listStaff = db.getAllStaff();
        List<Position> listPosition = new ArrayList<>();
        listPosition = db.getAllPosition();

        List<Integer> staffData = new ArrayList<>();
        for (Staff staff : listStaff) {
            staffData.add(staff.getId());
        }
        List<Integer> positionData = new ArrayList<>();
        for (Position position : listPosition) {
            positionData.add(position.getId());
        }
        //
        ArrayAdapter<Integer> spnStaffAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, staffData);
        spnStaffAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnStaff.setAdapter(spnStaffAdapter);
        //

        ArrayAdapter<Integer> spnPositionAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, positionData);
        spnPositionAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnPosition.setAdapter(spnPositionAdapter);

    }

    private void btnAddListener() {
        DatabaseHelper db = new DatabaseHelper(this);
        int selectedStaff = (int) spnStaff.getSelectedItem();
        int selectedPosition = (int) spnPosition.getSelectedItem();
        Staff staff = new Staff();
        staff.setId(selectedStaff);
        Position position = new Position();
        position.setId(selectedPosition);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        String createAt = sdf.format(date);
        PositionStaff ps = new PositionStaff(staff, position, createAt,"");
        db.addPositionStaff(ps);
        refresh();
        db.close();

    }

    void refresh() {
        Intent intent = new Intent();
        intent.setClass(StaffPositionActivity.this, StaffPositionActivity.class);
        startActivity(intent);
        finish();
    }
}
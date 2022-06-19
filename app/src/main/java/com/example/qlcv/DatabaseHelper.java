package com.example.qlcv;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.qlcv.model.Position;
import com.example.qlcv.model.PositionStaff;
import com.example.qlcv.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StaffManagement";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Ham nay se chay khi trong storage chua co database ten la DATABASE_NAME
        //querry create table
        String sql = "CREATE TABLE tbl_staff(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fullname TEXT," +
                "dob TEXT," +
                "country TEXT," +
                "level TEXT)";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE tbl_position(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "description TEXT)";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE tbl_staff_position(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "create_at TEXT," +
                "description TEXT," +
                "staff_id INTEGER," +
                "position_id INTEGER," +
                "FOREIGN KEY(staff_id) REFERENCES tbl_staff(id)," +
                "FOREIGN KEY(position_id) REFERENCES tbl_position(id))";

        db.execSQL(sql3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //CRUD insert select


    // xu ly staff
    public void addStaff(Staff staff) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tbl_staff(fullname, dob, country, level) VALUES (?,?,?,?)";
        String[] args = {staff.getFullname(), staff.getDOB(), staff.getCountry(), staff.getLevel()};
        db.execSQL(sql, args);
//        Toast.makeText(context, "add Staff", Toast.LENGTH_SHORT).show();
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM tbl_staff";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String fullname = cursor.getString(1);
            String dob = cursor.getString(2);
            String country = cursor.getString(3);
            String level = cursor.getString(4);
            Staff s = new Staff(id, fullname, dob, country, level);
            staffs.add(s);
            cursor.moveToNext();
        }
        return staffs;
    }
    // end staff

    //xu ly position
    public void addPosition(Position position) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tbl_position(name, description) VALUES(?, ?)";
        String[] args = {position.getName(), position.getDesc()};
        db.execSQL(sql, args);
//        Toast.makeText(context, "add Staff", Toast.LENGTH_SHORT).show();
    }

    public List<Position> getAllPosition() {
        List<Position> listPosition = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM tbl_position";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String descriptrion = cursor.getString(2);
            Position position = new Position(id, name, descriptrion);
            listPosition.add(position);
            cursor.moveToNext();
        }
        return listPosition;
    }
    //end position

    //
    public void addPositionStaff(PositionStaff positionStaff) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO tbl_staff_position(create_at, description, staff_id, position_id) VALUES(?, ?, ?, ?)";
        String[] args = {positionStaff.getCreateAt(), positionStaff.getDesc(), positionStaff.getStaff().getId() + "", positionStaff.getPosition().getId() + ""};
        db.execSQL(sql, args);
//        Toast.makeText(context, "add Staff", Toast.LENGTH_SHORT).show();
    }

    public List<PositionStaff> getAllPositionStaff() {
        List<PositionStaff> listPositionStaff = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM tbl_staff_position";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String createdAt = cursor.getString(1);
            String description = cursor.getString(2);
            int staffId = cursor.getInt(3);
            int positionId = cursor.getInt(4);
            Staff s = new Staff();
            s.setId(staffId);
            Position p = new Position();
            p.setId(positionId);
            PositionStaff ps = new PositionStaff(id, s, p, createdAt, description);
            listPositionStaff.add(ps);
            cursor.moveToNext();
        }
        return listPositionStaff;
    }

}

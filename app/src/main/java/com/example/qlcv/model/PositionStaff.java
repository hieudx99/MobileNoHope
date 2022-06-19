package com.example.qlcv.model;

import java.io.Serializable;

public class PositionStaff implements Serializable {
    private int id;
    private Staff staff;
    private Position position;
    private String createAt;
    private String desc;

    public PositionStaff() {
    }

    public PositionStaff(Staff staff, Position position, String createAt, String desc) {
        this.staff = staff;
        this.position = position;
        this.createAt = createAt;
        this.desc = desc;
    }

    public PositionStaff(int id, Staff staff, Position position, String createAt, String desc) {
        this.id = id;
        this.staff = staff;
        this.position = position;
        this.createAt = createAt;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "PositionStaff{" +
                "id=" + id +
                ", staff=" + staff +
                ", position=" + position +
                ", createAt='" + createAt + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

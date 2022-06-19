package com.example.qlcv.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String fullname;
    private String DOB;
    private String country;
    private String level;

    public Staff() {
    }

    public Staff(String fullname, String DOB, String country, String level) {
        this.fullname = fullname;
        this.DOB = DOB;
        this.country = country;
        this.level = level;
    }

    public Staff(int id, String fullname, String DOB, String country, String level) {
        this.id = id;
        this.fullname = fullname;
        this.DOB = DOB;
        this.country = country;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", DOB='" + DOB + '\'' +
                ", country='" + country + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

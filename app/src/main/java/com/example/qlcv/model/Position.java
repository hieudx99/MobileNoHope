package com.example.qlcv.model;

import java.io.Serializable;

public class Position implements Serializable {
    private int id;
    private String name;
    private String desc;

    public Position() {
    }

    public Position(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Position(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

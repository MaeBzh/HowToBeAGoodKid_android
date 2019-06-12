package com.k.howtobeagoodkid.entities;

public class PointType {

    private long id;
    private String color;
    private int value;

    public PointType() {

    }

    public PointType(long id, String color, int value) {
        this.id = id;
        this.color = color;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

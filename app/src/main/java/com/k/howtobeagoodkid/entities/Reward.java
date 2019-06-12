package com.k.howtobeagoodkid.entities;

public class Reward {
    private long id;
    private String name;
    private int value;
    private String icon;

    public Reward() {

    }

    public Reward(String name, int value, String icon) {
        this.name = name;
        this.value = value;
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

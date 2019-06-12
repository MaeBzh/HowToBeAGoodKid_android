package com.k.howtobeagoodkid.entities;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class Period {
    private long id;
    private DateTime dateStart;
    private DateTime dateEnd;
    private ArrayList<Point> points;
    private int rewardId;
    private User parent;
    private User child;
    private boolean rewardObtained;

    public Period() {

    }

    public Period(long id, DateTime dateStart, DateTime dateEnd, ArrayList<Point> points, int rewardId, User parent,
                  User child, boolean rewardObtained) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.points = points;
        this.rewardId = rewardId;
        this.parent = parent;
        this.child = child;
        this.rewardObtained = rewardObtained;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
    }

    public DateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(DateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public User getChild() {
        return child;
    }

    public void setChild(User child) {
        this.child = child;
    }

    public boolean isRewardObtained() {
        return rewardObtained;
    }

    public void setRewardObtained(boolean rewardObtained) {
        this.rewardObtained = rewardObtained;
    }
}

package com.k.howtobeagoodkid.entities;

public class Point {
    private long id;
    private int periodId;
    private int pointTypeId;
    private int nbPoints;

    public Point() {

    }

    public Point(long id, int periodId, int pointTypeId, int nbPoints) {
        this.id = id;
        this.periodId = periodId;
        this.pointTypeId = pointTypeId;
        this.nbPoints = nbPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getPointTypeId() {
        return pointTypeId;
    }

    public void setPointTypeId(int pointTypeId) {
        this.pointTypeId = pointTypeId;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }
}

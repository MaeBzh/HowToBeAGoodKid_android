package com.k.howtobeagoodkid.entities;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class Period {
    private long id;
    private DateTime dateStart;
    private DateTime dateEnd;
    private boolean rewardObtained;

    private int rewardId;
    private int childId;

    public Period() {

    }

    public Period(long id, DateTime dateStart, DateTime dateEnd, int rewardId,
                  int childId, boolean rewardObtained) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.rewardId = rewardId;
        this.childId = childId;
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

    public boolean isRewardObtained() {
        return rewardObtained;
    }

    public void setRewardObtained(boolean rewardObtained) {
        this.rewardObtained = rewardObtained;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}

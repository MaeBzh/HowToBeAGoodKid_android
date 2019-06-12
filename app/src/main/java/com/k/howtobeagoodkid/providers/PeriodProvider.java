package com.k.howtobeagoodkid.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.PeriodContract;
import com.k.howtobeagoodkid.contract.PointContract;
import com.k.howtobeagoodkid.contract.RewardContract;
import com.k.howtobeagoodkid.contract.UserContract;
import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.entities.Point;
import com.k.howtobeagoodkid.entities.Reward;
import com.k.howtobeagoodkid.entities.User;
import com.k.howtobeagoodkid.utils.Utils;

import java.util.ArrayList;

public class PeriodProvider extends ProviderBase {

    public PeriodProvider(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param period the period to add
     */
    public void insert(Period period) {
        ContentValues values = new ContentValues();
        values.put(PeriodContract.DATESTART, Utils.dateToString(period.getDateStart()));
        values.put(PeriodContract.DATEEND, Utils.dateToString(period.getDateEnd()));
        values.put(PeriodContract.REWARDID, period.getRewardId());
        values.put(PeriodContract.CHILDID, period.getChildId());
        values.put(PeriodContract.REWARDOBTAINED, false);
        this.db.insert(PeriodContract.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the period to delete
     */
    public void delete(long id) {
        this.db.delete(PeriodContract.TABLE_NAME, PeriodContract.KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a reward in Database.
     *
     * @param period the period to update
     */
    public void update(Period period) {
        ContentValues values = new ContentValues();
        values.put(PeriodContract.DATESTART, Utils.dateToString(period.getDateStart()));
        values.put(PeriodContract.DATEEND, Utils.dateToString(period.getDateEnd()));
        values.put(PeriodContract.REWARDID, period.getRewardId());
        values.put(PeriodContract.CHILDID, period.getChildId());
        values.put(PeriodContract.REWARDOBTAINED, period.isRewardObtained());
        this.db.update(PeriodContract.TABLE_NAME, values, PeriodContract.KEY + " = ?",
                new String[]{String.valueOf(period.getId())});
    }

    /**
     * Get one period from Database.
     *
     * @param id the id of the period to get
     */
    public Period get(long id) {
        Period result = new Period();
        String query = "select * from " + PeriodContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = PeriodContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    /**
     * Get all the periods from Database.
     *
     * @return the list of periods
     */
    public ArrayList<Period> getAll() {
        ArrayList<Period> result = new ArrayList<>();
        String query = "select * from " + PeriodContract.TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            Period item;
            do {
                item = PeriodContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }

    /**
     * Get the child User associated to a period.
     * @param period the period
     * @return a User
     */
    public User getAssociateChild(Period period) {
        UserProvider userProvider = new UserProvider(this.getContext());
        return userProvider.get(period.getChildId());
    }

    /**
     * Get the child User associated to a period.
     * @param period the period
     * @return a User
     */
    public Reward getAssociateReward(Period period) {
        RewardProvider rewardProvider = new RewardProvider(this.getContext());
        return rewardProvider.get(period.getRewardId());
    }

    /**
     * Get all the points associated to a period.
     * @param period the period
     * @return a list of points
     */
    public ArrayList<Point> getAssociatedPoints(Period period) {
        ArrayList<Point> result = new ArrayList<>();
        String query = "select * from " + PointContract.TABLE_NAME + " where periodId = ?";
        String[] selectionArgs = new String[]{String.valueOf(period.getId())};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            Point item;
            do {
                item = PointContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }
}


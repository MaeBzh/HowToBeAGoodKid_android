package com.k.howtobeagoodkid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.PeriodContract;
import com.k.howtobeagoodkid.contract.RewardContract;
import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.entities.Reward;
import com.k.howtobeagoodkid.utils.Utils;

import java.util.ArrayList;

public class PeriodDao extends BaseDao {

    public static final String TABLE_CREATE =
            "CREATE TABLE " + PeriodContract.TABLE_NAME + " (" + PeriodContract.KEY + " INTEGER " +
            "PRIMARY KEY " +
            "AUTOINCREMENT, " + PeriodContract.DATESTART + " TEXT, " + PeriodContract.DATEEND + " TEXT, " + PeriodContract.PARENT +
                    " TEXT, " + PeriodContract.CHILD + " TEXT, " + PeriodContract.REWARD + " INTEGER,"
            + " FOREIGN KEY ("+PeriodContract.REWARD+") REFERENCES "+ RewardContract.TABLE_NAME+"("+RewardContract.KEY+
                    "));";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + PeriodContract.TABLE_NAME + ";";

    public PeriodDao(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param period the reward to add
     */
    public void insert(Period period) {
        ContentValues values = new ContentValues();
        values.put(PeriodContract.DATESTART, Utils.dateToString(period.getDateStart()));
        values.put(PeriodContract.DATEEND, Utils.dateToString(period.getDateEnd()));
        values.put(PeriodContract.REWARD, period.getReward().getId());
        values.put(PeriodContract.PARENT, period.getParent().getId());
        values.put(PeriodContract.CHILD, period.getChild().getId());
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
        values.put(PeriodContract.REWARD, period.getReward().getId());
        values.put(PeriodContract.PARENT, period.getParent().getId());
        values.put(PeriodContract.CHILD, period.getChild().getId());
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
     * @return the list of rewards
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

    public Reward getAssociateReward(
            final Period period) {
        Reward result = new Reward();
        String query = "select * from " + RewardContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(period.getReward())};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = RewardContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }
}


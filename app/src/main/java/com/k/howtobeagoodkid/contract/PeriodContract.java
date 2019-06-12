package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.utils.Utils;

public class PeriodContract {

    public static final String TABLE_NAME = "reward";
    public static final String KEY = "id";
    public static final String DATESTART = "dateStart";
    public static final String DATEEND = "dateEnd";
    //    public static final String POINTS = "points";
    public static final String REWARD = "reward";
    public static final String PARENT = "parent";
    public static final String CHILD = "child";
    public static final String REWARDOBTAINED = "rewardObtained";

    public static Period cursorToItem(final Cursor cursor) {
        Period result = new Period();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(PeriodContract.KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(PeriodContract.DATESTART);

            if (index > -1) {
                result.setDateStart(Utils.stringToDate(cursor.getString(index)));
            }
            index = cursor.getColumnIndex(PeriodContract.DATEEND);

            if (index > -1) {
                result.setDateEnd(Utils.stringToDate(cursor.getString(index)));
            }
            index = cursor.getColumnIndex(PeriodContract.REWARD);

            if (index > -1) {
                result.setRewardId(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(PeriodContract.REWARDOBTAINED);

            if (index > -1) {
                result.setRewardObtained(Utils.getBoolean(cursor.getInt(index), cursor));
            }
        }
        return result;
    }

}

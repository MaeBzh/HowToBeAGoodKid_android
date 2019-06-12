package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.utils.Utils;

public class PeriodContract {

    public static final String TABLE_NAME = "period";
    public static final String KEY = "id";
    public static final String DATESTART = "dateStart";
    public static final String DATEEND = "dateEnd";
    public static final String REWARDID = "rewardId";
    public static final String CHILDID = "childId";
    public static final String REWARDOBTAINED = "rewardObtained";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + PeriodContract.TABLE_NAME
                    + " (" + PeriodContract.KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + PeriodContract.DATESTART + " TEXT, "
                    + PeriodContract.DATEEND + " TEXT, "
                    + PeriodContract.REWARDOBTAINED + " INTEGER, "
                    + PeriodContract.CHILDID + " INTEGER, "
                    + PeriodContract.REWARDID + " INTEGER,"
                    + "FOREIGN KEY(" + PeriodContract.CHILDID + ") REFERENCES "
                    + UserContract.TABLE_NAME + "(" + UserContract.KEY + "), "
                    + "FOREIGN KEY(" + PeriodContract.REWARDID + ") REFERENCES "
                    + RewardContract.TABLE_NAME + "(" + RewardContract.KEY + "));";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + PeriodContract.TABLE_NAME + ";";

    /**
     * Turn a cursor into a Period.
     *
     * @param cursor a cursor
     * @return a Period
     */
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

            index = cursor.getColumnIndex(PeriodContract.REWARDID);

            if (index > -1) {
                result.setChildId(cursor.getInt(index));
            }

            index = cursor.getColumnIndex(PeriodContract.CHILDID);

            if (index > -1) {
                result.setChildId(cursor.getInt(index));
            }

            index = cursor.getColumnIndex(PeriodContract.REWARDOBTAINED);

            if (index > -1) {
                result.setRewardObtained(Utils.getBoolean(cursor.getInt(index), cursor));
            }
        }
        return result;
    }

}

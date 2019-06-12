package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.entities.Reward;

public class RewardContract {

    public static final String TABLE_NAME = "reward";
    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String VALUE = "value";
    public static final String ICON = "icon";

    public static Reward cursorToItem(final Cursor cursor) {
        Reward result = new Reward();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(RewardContract.KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(NAME);

            if (index > -1) {
                result.setName(cursor.getString(index));
            }
            index = cursor.getColumnIndex(RewardContract.VALUE);

            if (index > -1) {
                result.setValue(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(RewardContract.ICON);

            if (index > -1) {
                result.setIcon(cursor.getString(index));
            }
        }
        return result;
    }
}

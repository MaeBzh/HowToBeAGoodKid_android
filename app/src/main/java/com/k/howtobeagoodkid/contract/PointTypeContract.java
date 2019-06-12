package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.PointType;

public class PointTypeContract {

    public static final String TABLE_NAME = "pointType";
    public static final String KEY = "id";
    public static final String COLOR = "color";
    public static final String VALUE = "value";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + PointTypeContract.TABLE_NAME
                    + " (" + PointTypeContract.KEY + " INTEGER PRIMARY KEY " + "AUTOINCREMENT, "
                    + PointTypeContract.COLOR + " TEXT,"
                    + PointTypeContract.VALUE + " INTEGER);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + PointTypeContract.TABLE_NAME + ";";

    /**
     * Turn a cursor into a PointType.
     *
     * @param cursor a cursor
     * @return a PointType
     */
    public static PointType cursorToItem(final Cursor cursor) {
        PointType result = new PointType();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(PointTypeContract.KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(PointTypeContract.COLOR);

            if (index > -1) {
                result.setColor(cursor.getString(index));
            }
            index = cursor.getColumnIndex(PointTypeContract.VALUE);

            if (index > -1) {
                result.setValue(cursor.getInt(index));
            }
        }
        return result;
    }
}

package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.Point;

public class PointContract {

    public static final String TABLE_NAME = "point";
    public static final String KEY = "id";
    public static final String PERIODID = "periodId";
    public static final String POINTTYPEID = "pointTypeId";
    public static final String NBPOINTS = "nbPoints";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + PointContract.TABLE_NAME
                    + " (" + PointContract.KEY + " INTEGER PRIMARY KEY " + "AUTOINCREMENT, "
                    + PointContract.PERIODID + " INTEGER,"
                    + PointContract.POINTTYPEID + " INTEGER,"
                    + PointContract.NBPOINTS + " INTEGER,"
                    + " FOREIGN KEY(" + PointContract.PERIODID + ") REFERENCES "
                    + PeriodContract.TABLE_NAME + "(" + PeriodContract.KEY + "),"
                    + " FOREIGN KEY(" + PointContract.POINTTYPEID + ") REFERENCES "
                    + PointTypeContract.TABLE_NAME + "(" + PointTypeContract.KEY + "));";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + PointContract.TABLE_NAME + ";";

    /**
     * Turn a cursor into a Point.
     *
     * @param cursor a cursor
     * @return a Point
     */
    public static Point cursorToItem(final Cursor cursor) {
        Point result = new Point();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(PointContract.KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }

            index = cursor.getColumnIndex(PointContract.NBPOINTS);

            if (index > -1) {
                result.setNbPoints(cursor.getInt(index));
            }

            index = cursor.getColumnIndex(PointContract.PERIODID);

            if (index > -1) {
                result.setPeriodId(cursor.getInt(index));
            }

            if (index > -1) {
                result.setPointTypeId(cursor.getInt(index));
            }
        }
        return result;
    }
}

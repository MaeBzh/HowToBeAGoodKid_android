package com.k.howtobeagoodkid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.entities.Point;
import com.k.howtobeagoodkid.entities.Reward;

import java.util.ArrayList;

public class PointDao extends BaseDao {
    public static final String TABLE_NAME = "point";
    public static final String KEY = "id";
    public static final String COLOR = "color";
    public static final String VALUE = "value";

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, " + COLOR + " TEXT, " + VALUE + " INT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public PointDao(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param point the point to add
     */
    public void insert(Point point) {
        ContentValues values = new ContentValues();
        values.put(PointDao.COLOR, point.getColor());
        values.put(PointDao.VALUE, point.getValue());
        this.db.insert(PointDao.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the point to delete
     */
    public void delete(long id) {
        this.db.delete(PointDao.TABLE_NAME, KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a point in Database.
     *
     * @param point the point to update
     */
    public void update(Point point) {
        ContentValues values = new ContentValues();
        values.put(PointDao.COLOR, point.getColor());
        values.put(PointDao.VALUE, point.getValue());
        this.db.update(TABLE_NAME, values, KEY + " = ?", new String[]{String.valueOf(point.getId())});
    }

    /**
     * Get one point from Database.
     *
     * @param id the id of the point to get
     */
    public Point get(long id) {
        Point result = new Point();
        String query = "select * from " + TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = this.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    /**
     * Get all the points from Database.
     *
     * @return the list of points
     */
    public ArrayList<Point> getAll() {
        ArrayList<Point> result = new ArrayList<>();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            Point item;
            do {
                item = this.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }

    private Point cursorToItem(final Cursor cursor) {
        Point result = new Point();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(COLOR);

            if (index > -1) {
                result.setColor(cursor.getString(index));
            }
            index = cursor.getColumnIndex(VALUE);

            if (index > -1) {
                result.setValue(cursor.getInt(index));
            }
        }
        return result;
    }
}


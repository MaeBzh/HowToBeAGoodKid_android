package com.k.howtobeagoodkid.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.PeriodContract;
import com.k.howtobeagoodkid.contract.PointContract;
import com.k.howtobeagoodkid.contract.PointTypeContract;
import com.k.howtobeagoodkid.entities.Period;
import com.k.howtobeagoodkid.entities.Point;
import com.k.howtobeagoodkid.entities.PointType;

import java.util.ArrayList;

public class PointProvider extends ProviderBase {

    public PointProvider(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param point the point to add
     */
    public void insert(Point point) {
        ContentValues values = new ContentValues();
        values.put(PointContract.PERIODID, point.getPeriodId());
        values.put(PointContract.POINTTYPEID, point.getPointTypeId());
        values.put(PointContract.NBPOINTS, point.getNbPoints());
        this.db.insert(PointContract.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the point to delete
     */
    public void delete(long id) {
        this.db.delete(PointContract.TABLE_NAME, PointContract.KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a point in Database.
     *
     * @param point the point to update
     */
    public void update(Point point) {
        ContentValues values = new ContentValues();
        values.put(PointContract.PERIODID, point.getPeriodId());
        values.put(PointContract.POINTTYPEID, point.getPointTypeId());
        values.put(PointContract.NBPOINTS, point.getNbPoints());
        this.db.update(PointContract.TABLE_NAME, values, PointContract.KEY + " = ?",
                new String[]{String.valueOf(point.getId())});
    }

    /**
     * Get one point from Database.
     *
     * @param id the id of the point to get
     */
    public Point get(long id) {
        Point result = new Point();
        String query = "select * from " + PointContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = PointContract.cursorToItem(cursor);
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
        String query = "select * from " + PointContract.TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
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

    public Period getAssociatedPeriod(Point point) {
        Period result = new Period();
        String query = "select * from " + PeriodContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(point.getPeriodId())};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = PeriodContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    public PointType getAssociatedPointType(Point point) {
        PointType result = new PointType();
        String query = "select * from " + PointTypeContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(point.getPointTypeId())};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = PointTypeContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }
}


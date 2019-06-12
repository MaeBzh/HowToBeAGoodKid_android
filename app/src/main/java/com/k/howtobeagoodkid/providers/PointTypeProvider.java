package com.k.howtobeagoodkid.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.PointContract;
import com.k.howtobeagoodkid.contract.PointTypeContract;
import com.k.howtobeagoodkid.entities.PointType;

import java.util.ArrayList;

public class PointTypeProvider extends ProviderBase {

    public PointTypeProvider(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param pointType the pointType to add
     */
    public void insert(PointType pointType) {
        ContentValues values = new ContentValues();
        values.put(PointTypeContract.COLOR, pointType.getColor());
        values.put(PointTypeContract.VALUE, pointType.getValue());
        this.db.insert(PointContract.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the pointType to delete
     */
    public void delete(long id) {
        this.db.delete(PointTypeContract.TABLE_NAME, PointTypeContract.KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a pointType in Database.
     *
     * @param pointType the point to update
     */
    public void update(PointType pointType) {
        ContentValues values = new ContentValues();
        values.put(PointTypeContract.COLOR, pointType.getColor());
        values.put(PointTypeContract.VALUE, pointType.getValue());
        this.db.update(PointTypeContract.TABLE_NAME, values, PointTypeContract.KEY + " = ?",
                new String[]{String.valueOf(pointType.getId())});
    }

    /**
     * Get one pointType from Database.
     *
     * @param id the id of the pointType to get
     */
    public PointType get(long id) {
        PointType result = new PointType();
        String query = "select * from " + PointTypeContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = PointTypeContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    /**
     * Get all the pointTypes from Database.
     *
     * @return the list of pointTypes
     */
    public ArrayList<PointType> getAll() {
        ArrayList<PointType> result = new ArrayList<>();
        String query = "select * from " + PointTypeContract.TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            PointType item;
            do {
                item = PointTypeContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }
}


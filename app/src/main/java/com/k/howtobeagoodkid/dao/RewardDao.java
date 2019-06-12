package com.k.howtobeagoodkid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.RewardContract;
import com.k.howtobeagoodkid.entities.Reward;

import java.util.ArrayList;

public class RewardDao extends BaseDao {

    public static final String TABLE_CREATE =
            "CREATE TABLE " + RewardContract.TABLE_NAME + " (" + RewardContract.KEY + " INTEGER " +
            "PRIMARY " +
            "KEY " +
            "AUTOINCREMENT, " + NAME + " TEXT, " + RewardContract.VALUE + " INT, " + RewardContract.ICON + " TEXT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + RewardContract.TABLE_NAME + ";";

    public RewardDao(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param reward the reward to add
     */
    public void insert(Reward reward) {
        ContentValues values = new ContentValues();
        values.put(RewardContract.NAME, reward.getName());
        values.put(RewardContract.VALUE, reward.getValue());
        values.put(RewardContract.ICON, reward.getIcon());
        this.db.insert(RewardContract.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the reward to delete
     */
    public void delete(long id) {
        this.db.delete(RewardContract.TABLE_NAME, RewardContract.KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a reward in Database.
     *
     * @param reward the reward to update
     */
    public void update(Reward reward) {
        ContentValues values = new ContentValues();
        values.put(RewardContract.NAME, reward.getName());
        values.put(RewardContract.VALUE, reward.getValue());
        values.put(RewardContract.ICON, reward.getIcon());
        this.db.update(RewardContract.TABLE_NAME, values, RewardContract.KEY + " = ?",
                new String[]{String.valueOf(reward.getId())});
    }

    /**
     * Get one reward from Database.
     *
     * @param id the id of the reward to get
     */
    public Reward get(long id) {
        Reward result = new Reward();
        String query = "select * from " + RewardContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = RewardContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    /**
     * Get all the rewards from Database.
     *
     * @return the list of rewards
     */
    public ArrayList<Reward> getAll() {
        ArrayList<Reward> result = new ArrayList<>();
        String query = "select * from " + RewardContract.TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            Reward item;
            do {
                item = RewardContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }
}


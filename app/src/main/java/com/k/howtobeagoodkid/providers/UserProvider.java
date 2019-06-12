package com.k.howtobeagoodkid.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.k.howtobeagoodkid.contract.UserContract;
import com.k.howtobeagoodkid.entities.User;

import java.util.ArrayList;

public class UserProvider extends ProviderBase {

    public UserProvider(Context context) {
        super(context);
    }

    /**
     * Insert to Database.
     *
     * @param user the user to add
     */
    public void insert(User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.FIRSTNAME, user.getFirstname());
        values.put(UserContract.LASTNAME, user.getLastname());
        values.put(UserContract.EMAIL, user.getEmail());
        //TODO : secure password
        values.put(UserContract.PASSWORD, user.getPassword());
        values.put(UserContract.ISPARENT, user.isParent());
        this.db.insert(UserContract.TABLE_NAME, null, values);

    }

    /**
     * Delete from Database.
     *
     * @param id the id fo the user to delete
     */
    public void delete(long id) {
        this.db.delete(UserContract.TABLE_NAME, UserContract.KEY + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Update a user in DatabaseHandler.
     *
     * @param user the user to update
     */
    public void update(User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.FIRSTNAME, user.getFirstname());
        values.put(UserContract.LASTNAME, user.getLastname());
        values.put(UserContract.EMAIL, user.getEmail());
        //TODO : secure password
        values.put(UserContract.PASSWORD, user.getPassword());
        values.put(UserContract.ISPARENT, user.isParent());
        this.db.update(UserContract.TABLE_NAME, values, UserContract.KEY + " = ?",
                new String[]{String.valueOf(user.getId())});
    }

    /**
     * Get one user from Database.
     *
     * @param id the id of the user to get
     */
    public User get(long id) {
        User result = new User();
        String query = "select * from " + UserContract.TABLE_NAME + " where id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = this.db.rawQuery(query, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = UserContract.cursorToItem(cursor);
        }
        cursor.close();

        return result;
    }

    /**
     * Get all the users from Database.
     *
     * @return the list of users
     */
    public ArrayList<User> getAll() {
        ArrayList<User> result = new ArrayList<>();
        String query = "select * from " + UserContract.TABLE_NAME;
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            User item;
            do {
                item = UserContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }
        return result;
    }
}


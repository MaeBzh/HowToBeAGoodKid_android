package com.k.howtobeagoodkid.contract;

import android.database.Cursor;

import com.k.howtobeagoodkid.entities.User;
import com.k.howtobeagoodkid.utils.Utils;

public class UserContract {

    public static final String TABLE_NAME = "user";
    public static final String KEY = "id";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ISPARENT = "isParent";

    /**
     * Turn a cursor to a User.
     * @param cursor a cursor
     * @return a User
     */
    public static User cursorToItem(final Cursor cursor) {
        User result = new User();
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(UserContract.KEY);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(UserContract.FIRSTNAME);

            if (index > -1) {
                result.setFirstname(cursor.getString(index));
            }
            index = cursor.getColumnIndex(UserContract.LASTNAME);

            if (index > -1) {
                result.setLastname(cursor.getString(index));
            }
            index = cursor.getColumnIndex(UserContract.EMAIL);

            if (index > -1) {
                result.setEmail(cursor.getString(index));
            }
            index = cursor.getColumnIndex(UserContract.PASSWORD);

            if (index > -1) {
                result.setPassword(cursor.getString(index));
            }
            index = cursor.getColumnIndex(UserContract.ISPARENT);

            if (index > -1) {
                result.setIsParent(Utils.getBoolean(cursor.getInt(index), cursor));
            }
        }
        return result;
    }
}

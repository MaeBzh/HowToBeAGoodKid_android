package com.k.howtobeagoodkid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.k.howtobeagoodkid.dao.RewardDao;
import com.k.howtobeagoodkid.dao.UserDao;

import java.io.IOException;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        try {
            context.getAssets().open(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDao.TABLE_CREATE);
        db.execSQL(RewardDao.TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserDao.TABLE_DROP);
        db.execSQL(RewardDao.TABLE_DROP);
        this.onCreate(db);

    }

}

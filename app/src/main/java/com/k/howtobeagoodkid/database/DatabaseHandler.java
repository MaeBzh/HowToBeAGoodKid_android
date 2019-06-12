package com.k.howtobeagoodkid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.k.howtobeagoodkid.contract.PeriodContract;
import com.k.howtobeagoodkid.contract.PointContract;
import com.k.howtobeagoodkid.contract.PointTypeContract;
import com.k.howtobeagoodkid.contract.RewardContract;
import com.k.howtobeagoodkid.contract.UserContract;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserContract.TABLE_CREATE);
        db.execSQL(RewardContract.TABLE_CREATE);
        db.execSQL(PeriodContract.TABLE_CREATE);
        db.execSQL(PointTypeContract.TABLE_CREATE);
        db.execSQL(PointContract.TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserContract.TABLE_DROP);
        db.execSQL(RewardContract.TABLE_DROP);
        db.execSQL(PeriodContract.TABLE_DROP);
        db.execSQL(PointTypeContract.TABLE_DROP);
        db.execSQL(PointContract.TABLE_DROP);
        this.onCreate(db);
    }
}

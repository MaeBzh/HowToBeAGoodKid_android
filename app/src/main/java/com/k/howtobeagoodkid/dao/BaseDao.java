package com.k.howtobeagoodkid.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.k.howtobeagoodkid.database.DatabaseHandler;

public class BaseDao {
    // Nous sommes à la première version de la base
    // Si je décide de la mettre à jour, il faudra changer cet attribut
    protected final static int VERSION = 1;
    // Le nom du fichier qui représente ma base
    protected final static String NAME = "DatabaseHandler.db";

    protected SQLiteDatabase db = null;
    protected DatabaseHandler handler = null;

    public BaseDao(Context context) {
        this.handler = new DatabaseHandler(context, NAME, null, VERSION);
    }

    public SQLiteDatabase open() {
        this.db = this.handler.getWritableDatabase();
        return this.db;
    }

    public void close() {
       this.db.close();
    }

    public SQLiteDatabase getDb() {
        return this.db;
    }
}


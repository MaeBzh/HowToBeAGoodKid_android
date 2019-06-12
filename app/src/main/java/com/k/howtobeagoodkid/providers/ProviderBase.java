package com.k.howtobeagoodkid.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.k.howtobeagoodkid.database.DatabaseHandler;

public abstract class ProviderBase {
    // Nous sommes à la première version de la base
    // Si je décide de la mettre à jour, il faudra changer cet attribut
    protected final static int VERSION = 1;
    // Le nom du fichier qui représente ma base
    protected final static String NAME = "database.sqlite";
    protected SQLiteDatabase db = null;
    protected DatabaseHandler handler = null;
    protected Context context;

    public ProviderBase(Context context) {
        this.context = context;
        this.handler = new DatabaseHandler(context, NAME, null, VERSION);
    }

    public SQLiteDatabase open() {
        this.db = this.handler.getWritableDatabase();
        return this.db;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void close() {
        this.db.close();
    }

    public SQLiteDatabase getDb() {
        return this.db;
    }
}


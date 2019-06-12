package com.k.howtobeagoodkid.views;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.k.howtobeagoodkid.R;
import com.k.howtobeagoodkid.database.DatabaseHandler;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SQLiteDatabase db = new DatabaseHandler(this, "database", null, 1).getWritableDatabase();
    }
}

package com.example.jmush.android_assignment_112;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;

import com.example.jmush.android_assignment_112.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmush on 9/9/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context,Constants.DATABASE_NAME , null, Constants.DATABASE_VERSION);
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + Constants.TABLE_TEST + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.KEY_NAME + " TEXT,"
                + Constants.LAST_NAME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_TEST);

        // Create tables again
        onCreate(db);

    }

    public void addName(NameModel nameModel){

        SQLiteDatabase sqlDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Constants.KEY_NAME,nameModel.getName());
        contentValues.put(Constants.LAST_NAME,nameModel.getLastName());

        // Inserting Row
        sqlDB.insert(Constants.TABLE_TEST, null, contentValues);
        //2nd argument is String containing nullColumnHack
        sqlDB.close(); // Closing database connection

    }


    // code to get all contacts in a list view
    public List<NameModel> getAllContacts() {
        List<NameModel> nameList = new ArrayList<NameModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Constants.TABLE_TEST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                NameModel name = new NameModel();
                name.setId(Integer.parseInt(cursor.getString(0)));
                name.setName(cursor.getString(1));
                name.setLastName(cursor.getString(2));
                // Adding contact to list
                nameList.add(name);
            } while (cursor.moveToNext());
        }

        // return name list
        return nameList;
    }


}




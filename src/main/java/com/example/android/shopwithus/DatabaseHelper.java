package com.example.android.shopwithus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 27-08-2018.
 */


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Project.db";
    public static final String TABLE_NAME = "Company1_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "STATES";
    public static final String COL_3 = "DISTANCE";
    public static final String COL_4 = "WEATHER";
    public static final String COL_5 = "CALAMITY_FACTOR";
    public static final String COL_6 = "CITY_VALUE";

    public static final String TABLE2_NAME = "User_Details";
    public static final String COLU_1 = "USER_ID";
    public static final String COLU_2 = "USER_NAME";
    public static final String COLU_3 = "USER_LNAME";
    public static final String COLU_4 = "USER_EMAIL";
    public static final String COLU_5 = "USER_PASSWORD";
    public static final String COLU_6 = "USER_PRODUCT";
    public static final String COLU_7 = "USER_LOCATION";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +  TABLE_NAME  + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, STATES TEXT, DISTANCE FLOAT, WEATHER FLOAT, CALAMITY_FACTOR INTEGER, CITY_VALUE INTEGER)");
        db.execSQL("create table " + TABLE2_NAME + "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, USER_NAME TEXT,USER_LNAME TEXT ,USER_EMAIL TEXT,USER_PASSWORD TEXT, USER_PRODUCT TEXT, USER_LOCATION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        //  sqLiteDatabase.execSQL("create table " + TABLE2_NAME + "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, USER_NAME TEXT,USER_LNAME TEXT , USER_PRODUCT TEXT);");

    }

    //String Email,String Password, , String Location  ,USER_EMAIL TEXT, USER_PASSWORD TEXT, , USER_LOCATION TEXT
    public boolean insertData(String Name, String LName, String Email, String Password , String Product, String Location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLU_2, Name);
        cv.put(COLU_3, LName);
        cv.put(COLU_4, Email);
        cv.put(COLU_5, Password);
        cv.put(COLU_6, Product);
        cv.put(COLU_7, Location);
        long result = db.insert(TABLE2_NAME, null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public void insertData2(String state, float dist, float weather, int calamity, int city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        cv2.put(COL_2, state);
        cv2.put(COL_3, dist);
        cv2.put(COL_4, weather);
        cv2.put(COL_5, calamity);
        cv2.put(COL_6, city);
        db.insert(TABLE_NAME,null, cv2);
//        if(result1==-1)
//        {
//            return false;
//        }
//        else return true;
    }

    public Cursor getAllData(String statename){
      SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from Company1_Table where TRIM(STATES) = '"+statename.trim()+"'", null);
        return res;
    }

    public Cursor getData( String mail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from User_Details where TRIM(EMAIL) = '"+mail.trim()+"'", null);
        return res;
    }
}

package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    final String TABLE_NAME="Employee";
    final String ID="_id";
    final String NAME="name";


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY, "+NAME+" VARCHAR2(25))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long add(EmployeeData data){
        long id;
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME, data.getName());
        id=db.insert(TABLE_NAME, null, cv);
        //String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+NAME+" = "+"'"+data.getName()+"'";
        //Cursor c=db.rawQuery(sql, null);

//        if (c.moveToFirst()) {
//            id = c.getInt(c.getColumnIndex(ID));
//        }else {
//            id=-1;
//        }
        return id;
    }
}

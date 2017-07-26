package com.example.dell.mysqlclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 7/11/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
public static final String DATABASE_NAME="shop.db";
    public static final String TABLE_NAME="shop_table";
    public static final String NAME="name";
    public static final String QUANTITY="quantity";
    public static final String PRICE="price";
    public static final String NOM="manufacturer";

    public DataHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(name TEXT,manufacturer TEXT,quantity TEXT,price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String manufacturer,String quantity,String price)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(NOM,manufacturer);
        contentValues.put(QUANTITY,quantity);
        contentValues.put(PRICE,price);
        long insResult=db.insert(TABLE_NAME,null,contentValues);
        if(insResult==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor showAll(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }
public boolean updateData(String price)
{
    SQLiteDatabase db= this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(PRICE,price);
   long updateResult= db.update(TABLE_NAME,contentValues,"NAME = " +
           "?",new String[] {price});
    if(updateResult==-1){
        return false;
    }
    else {
        return true;
    }
}
public Integer delete(String quantity)
{
    SQLiteDatabase db= this.getWritableDatabase();
    return db.delete(TABLE_NAME,"NAME = ?",new String[] {quantity});
}
}

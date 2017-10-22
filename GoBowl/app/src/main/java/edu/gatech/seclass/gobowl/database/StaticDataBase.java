package edu.gatech.seclass.gobowl.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Yijin on 7/11/2016.
 */
public class StaticDataBase {
    //all objects share a static dbh
    private static DataBaseHelper dbh;
    public static SQLiteDatabase getWritableDB(Context context) {
        if (dbh == null) {
            dbh =  DataBaseHelper.getDataBaseHelper(context);
            Log.d("Create database","create only one data base");
        }
        return dbh.getWritableDatabase();
    }
}

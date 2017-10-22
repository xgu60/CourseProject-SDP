package edu.gatech.seclass.gobowl.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.gatech.seclass.gobowl.persistentobject.Score;

/**
 * Created by Yijin on 7/7/2016.
 */
public class ScoreDataSource {
    public static final String Table_Score = "Score";
    public static final String Coloums_CustomerID = "CustomerID"; //foreigner key, but for convenience, we may add constraints later
    public static final String Coloums_Value = "Value";
    public static final String Coloums_Date = "Date";
    public static final String Coloums_ID = "ID"; // primary key increase automatically
    public static final String[] Coloums = {
            Coloums_CustomerID,Coloums_Value,Coloums_Date,Coloums_ID
    };
    private SQLiteDatabase db;
    public ScoreDataSource(SQLiteDatabase database) {
        db = database;
    }
    public List<Score> getScoreList(String customerid) {
        List<Score> scoreList = new ArrayList<Score>();
        String whereClause = Coloums_CustomerID + "= ?";
        String[] whereArgs = new String[] {customerid};
        Cursor cursor = db.query(Table_Score, Coloums,whereClause,whereArgs,null,null,null);
        cursor.moveToFirst();
        //maybe optimize later
        while(!cursor.isAfterLast()) {
            //Coloums_CustomerID,Coloums_Value,Coloums_Date,Coloums_ID
            String cusid = cursor.getString(0);//hexid , need conversion , if map to table customer
            int value = (int) cursor.getLong(1);
            Date date = new Date(cursor.getLong(2));
            long id = cursor.getLong(3);
            Score score = new Score(customerid,value,date,id);
            scoreList.add(score);
            cursor.moveToNext();
        }
        cursor.close();
        return scoreList;
    }

    public long addScore(String cusid, int value) {
        // return positive numnber if success , else return -1
        ContentValues cValue = new ContentValues();
        cValue.put(Coloums_CustomerID,cusid); // use space to delimit the first name and last name , i.e Yijin Li
        cValue.put(Coloums_Value,value);
        cValue.put(Coloums_Date, Calendar.getInstance().getTimeInMillis());
        // if number of rows more than 65536 , inform customer reach limt can't add more
        return db.insert(Table_Score,null,cValue);
    }

}

package edu.gatech.seclass.gobowl.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.gatech.seclass.gobowl.persistentobject.Lane;
import edu.gatech.seclass.gobowl.utility.Base;

/**
 * Created by Yijin on 7/7/2016.
 */
public class LaneDataSource {
    private SQLiteDatabase db;
    public static final String Table_Lane = "Lane";
    public static final String Column_LaneNumber = "LaneNumber";
    public static final String Column_NumberOfPlayers = "NumberOfPlayers";
    public static final String Column_Players = "players";
    public static final String Column_TotalCost = "TotalCost";
    public static final String Column_RegistedCustomerID = "RegistedCustomerID";
    public static final String Column_CheckInDate = "CheckInDate";
    public static final String Column_CheckOutDate = "CheckOutDate";
    public static final String Column_ID = "ID";
    public static final String[] Coloums = {
            Column_LaneNumber,Column_NumberOfPlayers,Column_Players,Column_TotalCost,Column_RegistedCustomerID,Column_CheckInDate,Column_CheckOutDate,Column_ID
    };
    public static final int Default_Value_CheckOutDate = 0;
    public static final double Default_Value__TotalCost = 0;
    public LaneDataSource(SQLiteDatabase database) {

        db = database;
    }

    public long addLane(int laneNumber, int numberOfPlayers,String RegistedCustomerID,List<String> players) {
        // return positive numnber if success , else return -1
        ContentValues cValue = new ContentValues();
        cValue.put(Column_LaneNumber,(long) laneNumber); // use space to delimit the first name and last name , i.e Yijin Li
        cValue.put(Column_NumberOfPlayers,(long) numberOfPlayers);
        String playersList = "";
        for (int i = 0; i < players.size() - 1; i++) {
            playersList += players.get(i) + "k____k";
        }
        if (players.size() - 1 >= 0)
            playersList += players.get(players.size() - 1);
        cValue.put(Column_Players, playersList);
        cValue.put(Column_TotalCost, Default_Value__TotalCost);
        cValue.put(Column_RegistedCustomerID, Base.StringToIntegerID(RegistedCustomerID));
        cValue.put(Column_CheckInDate, Calendar.getInstance().getTimeInMillis());
        cValue.put(Column_CheckOutDate, Default_Value_CheckOutDate);
        return db.insert(Table_Lane,null,cValue);
    }

    public List<Integer> getUsingLane() //lanes that is not available
    {
        List<Integer> laneIsUsing = new ArrayList<Integer>();
        Cursor cursor = db.query(Table_Lane, Coloums,null,null,null,null,null);
        cursor.moveToFirst();
        //maybe optimize later
        while(!cursor.isAfterLast()) {
            //Coloums_CustomerID,Coloums_Value,Coloums_Date,Coloums_ID

            int laneNumber = (int ) cursor.getLong(cursor.getColumnIndex(Column_LaneNumber));
            laneIsUsing.add(laneNumber);
            cursor.moveToNext();
        }
        cursor.close();
        return laneIsUsing;
    }

    public boolean updateLane(int laneNumber,double totalCost, Date checkOutDate) {
        ContentValues cValue = new ContentValues();
        cValue.put(Column_TotalCost,totalCost); // use space to delimit the first name and last name , i.e Yijin Li
        cValue.put(Column_CheckOutDate,checkOutDate.getTime());
        String whereClause = Column_LaneNumber + " = ?"; // assume only one such lane in DB
        String[] whereArgs={String.valueOf(laneNumber)};  //customer store string as id
        if (db.update(Table_Lane,cValue,whereClause,whereArgs) == 1)
            return true;
        else
            return false;
    }

    public Lane getLane(int laneNumber){
        String whereClause = Column_LaneNumber + "= ?";
        String[] whereArgs = new String[] {String.valueOf(laneNumber)};
        Cursor cursor = db.query(Table_Lane, Coloums,whereClause,whereArgs,null,null,null);
        cursor.moveToFirst();
        Lane lane = null;
        //maybe optimize later
        while(!cursor.isAfterLast()) {
            if (laneNumber == (int) cursor.getLong(cursor.getColumnIndex(Column_LaneNumber))) {
                //Column_LaneNumber,Column_NumberOfPlayers,Column_Players,Column_TotalCost,Column_RegistedCustomerID,Column_CheckInDate,Column_CheckOutDate,Column_ID
                int lanenum = (int)cursor.getLong(0);
                int numberOfPlayers = (int) cursor.getLong(1);
                String players = cursor.getString(2);
                double totalCost = cursor.getDouble(3);
                String registeredCustomerID = Base.numberTOStringID(cursor.getLong(4));
                Date CheckInDate = new Date(cursor.getLong(5));
                Date CheckOutDate = new Date(cursor.getLong(6));
                long id = cursor.getLong(7);
                lane = new Lane(numberOfPlayers,lanenum,playerSplitter(players),totalCost,registeredCustomerID,CheckInDate,CheckOutDate,id);
                cursor.moveToNext();
                cursor.close();
                return lane;
            }
        }
        cursor.close();
        return lane;
    }

    // use in checkout
    public String getPlayersListForCheckOut(int laneNumbe) {
        String whereClause = Column_LaneNumber + "= ?";
        String[] whereArgs = new String[] {String.valueOf(laneNumbe)};
        Cursor cursor = db.query(Table_Lane, Coloums,whereClause,whereArgs,null,null,null);
        cursor.moveToFirst();
        String players = "Not Found";
        while(!cursor.isAfterLast()) {
            if (laneNumbe == (int) cursor.getLong(cursor.getColumnIndex(Column_LaneNumber))) {
                players = cursor.getString(cursor.getColumnIndex(Column_Players));
                cursor.moveToNext();
                cursor.close();
                return players;
            }
        }
        return players;
    }

    // use in checkout
    public String getCustomerIDForAddingCredit(int laneNumbe) {
        String whereClause = Column_LaneNumber + "= ?";
        String[] whereArgs = new String[] {String.valueOf(laneNumbe)};
        Cursor cursor = db.query(Table_Lane, Coloums,whereClause,whereArgs,null,null,null);
        cursor.moveToFirst();
        String customerID = "Not Found";
        while(!cursor.isAfterLast()) {
            if (laneNumbe == (int) cursor.getLong(cursor.getColumnIndex(Column_LaneNumber))) {
                customerID = Base.numberTOStringID(cursor.getLong(cursor.getColumnIndex(Column_RegistedCustomerID)));
                cursor.moveToNext();
                cursor.close();
                return customerID;
            }
        }
        return customerID;
    }

    public boolean deleteLane(int laneNumbe) {
        return db.delete(Table_Lane, Column_LaneNumber + "=" + laneNumbe, null) > 0;
    }

    public static List<String> playerSplitter(String players){
        List<String> result = new ArrayList<String>();
        String[] res = players.split("k____k");
        if (res != null) {
        for (int i = 0; i < res.length; i++) {
                result.add(res[i]);
            }
        }
        return result;
    }
}

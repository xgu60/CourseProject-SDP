//package seclass.gatech.edu.gobowl.database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import seclass.gatech.edu.gobowl.persistentobject.Customer;
//import seclass.gatech.edu.gobowl.utility.Base;
//
///**
// * Created by Yijin on 7/7/2016.
// */
//public class CustomerDataSource_backup {
//    public static final String Table_Customer = "Customer";
//    public static final String Column_Name = "Name"; // text, Name = First Name + " " + Last Name
//    public static final String Column_Email = "Email"; // text, unique
//    public static final String Column_ID = "ID"; // long,HexID,primary key increase automatically , integer ,  four digit Hex
//    public static final String Column_IsVip = "IsVip"; // integer , 0 not vip , 1 vip,no boolean in DB
//    public static final String Column_CreditForThisYear = "CreditForThisYear"; //float
//    public static final String Column_QRCode = "QRCode";//String, Name + Email, stored as Integer by default (convert to String in Customer), for simulating the customer card code, it shows
//    public static final int Default_Value_IsVip = 0;
//    public static final int Setting_Value_IsVip = 1;
//
//    public static final double Default_Value__CreditForThisYear = 0;
//    public static final String[] Coloums = {
//            Column_Name,Column_Email,Column_ID,Column_IsVip,Column_CreditForThisYear,Column_QRCode
//    };
//
//    //local data base
//    private SQLiteDatabase db2;
//    private DataBaseHelper dbh;
//    //public CustomerDataSource(SQLiteDatabase database)
//    public CustomerDataSource_backup(Context context) {
//        //db = database;
//        dbh = new DataBaseHelper(context);
//        db2 = null;
//    }
//
//    public CustomerDataSource_backup(SQLiteDatabase database) {
//        dbh = null;
//        db2 = database;
//    }
//
//    public long addCustomer(String name, String email) {
//        // return positive number if success , else return -1
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        ContentValues cValue = new ContentValues();
//        cValue.put(Column_Name,name); // use space to delimit the first name and last name , i.e Yijin Li
//        cValue.put(Column_Email,email);
//        cValue.put(Column_CreditForThisYear,Default_Value__CreditForThisYear);
//        cValue.put(Column_IsVip,Default_Value_IsVip);
//        cValue.put(Column_QRCode,name+email);
//        // if number of rows more than 65536 , inform customer reach limt can't add more
//        long rc = db.insert(Table_Customer,null,cValue);
//        db.close();
//        return rc;
//
//    }
//
//    public long addCustomerForTesting(String name, String email,String CustomerID) {
//        // return positive numnber if success , else return -1
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        ContentValues cValue = new ContentValues();
//        cValue.put(Column_Name,name); // use space to delimit the first name and last name , i.e Yijin Li
//        cValue.put(Column_Email,email);
//        cValue.put(Column_ID, Base.StringToIntegerID(CustomerID));
//        cValue.put(Column_CreditForThisYear,Default_Value__CreditForThisYear);
//        cValue.put(Column_IsVip,Default_Value_IsVip);
//        cValue.put(Column_QRCode,name+email);
//        // if number of rows more than 65536 , inform customer reach limt can't add more
//        long rc =  db.insert(Table_Customer,null,cValue);
//        db.close();
//        return rc;
//    }
//
//    //it displays the String name,email on UI
//    public boolean editCustomer(Customer customer) {
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        ContentValues cValue = new ContentValues();
//        cValue.put(Column_Name,customer.getName()); // use space to delimit the first name and last name , i.e Yijin Li
//        cValue.put(Column_Email,customer.getEmail());
//        cValue.put(Column_QRCode,customer.getName()+customer.getEmail());// for simulating QR code
//        String whereClause = Column_ID + " = ?";
//        Long id = Long.decode(customer.getId());
//        String[] whereArgs={ id.toString() };  //customer store string as id
//        if (db.update(Table_Customer,cValue,whereClause,whereArgs) == 1){
//            db.close();
//            return true;
//        }
//        else {
//            db.close();
//            return false;
//        }
//    }
//
//    //add credit for VIP
//    public boolean addCreditForVIP(String customerID, double credit) {
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        Customer customer = findCustomer(customerID);
//        ContentValues cValue = new ContentValues();
//        cValue.put(Column_CreditForThisYear, customer.getCreditForThisYear() + credit);
//        if (customer.getCreditForThisYear() + credit >= 500)
//            cValue.put(Column_IsVip, Setting_Value_IsVip);
//        String whereClause = Column_ID + " = ?";
//        String[] whereArgs={String.valueOf(Base.StringToIntegerID(customerID))};  //customer store string as id
//        if (db.update(Table_Customer,cValue,whereClause,whereArgs) == 1){
//            if(dbh == null)db.close();
//            return true;
//        }
//        else {
//            if(dbh == null)db.close();
//            return false;
//        }
//    }
//
//    public void refreshVIPStatus() { // run annually
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        String refreshVIP = "UPDATE "+ Table_Customer + " SET " + Column_IsVip + " = " + Default_Value_IsVip
//                + ", "+ Column_CreditForThisYear + " = " + Default_Value_IsVip;
//        db.execSQL(refreshVIP);
//        if(dbh == null)db.close();
//    }
//
//
//    public List<Customer> getCustomerList() {
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        List<Customer> customerList = new ArrayList<Customer>();
//        Cursor cursor = db.query(Table_Customer, Coloums,null,null,null,null,null);
//        cursor.moveToFirst();
//        while(cursor.moveToNext()) {
//            //Column_Name,Column_Email,Column_ID,Column_IsVip,Column_CreditForThisYear,Column_QRCode
//            String name = cursor.getString(0);
//            String email = cursor.getString(1);
//            String id = Customer.IdToHexID(cursor.getLong(2));// id saved as long in DB, string (hexid in class)
//            boolean isvip = cursor.getLong(3) != 0? true : false;
//            double creditForThisYear = cursor.getDouble(4);
//            String QRCode = cursor.getString(5);
//            Customer customer = new Customer(name,email,id, isvip,creditForThisYear,QRCode);
//            customerList.add(customer);
//        }
//        cursor.close();
//        if(dbh == null)db.close();
//        return customerList;
//    }
//
//    public Customer findCustomer(String customerid) {
//
//        SQLiteDatabase db;
//        if(dbh == null){
//            db = db2;
//        }else{
//            dbh.reOpen(true);
//            db = dbh.getDB();
//        }
//
//        String whereClause = Column_ID + "= ?";
//        String[] whereArgs = new String[] {String.valueOf(Base.StringToIntegerID(customerid))};
//        Cursor cursor = db.query(Table_Customer, Coloums,whereClause,whereArgs,null,null,null);
//        cursor.moveToFirst();
//        Customer customer = null;
//        //maybe optimize later
//        while(cursor.moveToNext()) {
//            if (Base.StringToIntegerID(customerid) == cursor.getLong(cursor.getColumnIndex(Column_ID))) {
//                String name = cursor.getString(0);
//                String email = cursor.getString(1);
//                String id = Base.numberTOStringID(cursor.getLong(2));// id saved as long in DB, string (hexid in class)
//                boolean isvip = cursor.getLong(3) != 0? true : false;
//                double creditForThisYear = cursor.getDouble(4);
//                String QRCode = cursor.getString(5);
//                customer = new Customer(name,email,id, isvip,creditForThisYear,QRCode);
//                return customer;
//            }
//        }
//        cursor.close();
//        if(dbh == null)db.close();
//        return customer;
//    }
//
//
//}

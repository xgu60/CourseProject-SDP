package edu.gatech.seclass.gobowl.utility;

import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by Yijin on 7/8/2016.
 */
public class CreditCard implements Serializable {
    String firstName;
    String lastNamer;

    public Boolean getTransactionRecords() {
        return transactionRecords;
    }

    public void setTransactionRecords(Boolean transactionRecords) {
        this.transactionRecords = transactionRecords;
    }

    Boolean transactionRecords = true;
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    String ccNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamer() {
        return lastNamer;
    }

    public void setLastNamer(String lastNamer) {
        this.lastNamer = lastNamer;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isSucessOrNot() {
        return sucessOrNot;
    }

    public void setSucessOrNot(boolean sucessOrNot) {
        this.sucessOrNot = sucessOrNot;
    }

    Date expirationDate;
    String securityCode;
    double amount;
    boolean sucessOrNot = true;
    public CreditCard(String readCard, double bill) {
        if (readCard.equals("ERR")) {
            firstName = "Can't Scan";
            lastNamer = "";
            ccNumber = "Can't Scan";
            DateFormat formatter = new SimpleDateFormat("MMddyyyy");
            Date date = new Date();
            try {
                date = (Date)formatter.parse("12312999");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expirationDate = date;
            securityCode = "Can't Scan";
            amount = 0;
            sucessOrNot = false;
        } else {
            //John#Doe#1234123412341234#12312016#111
            String[] args = readCard.split("#");
            firstName = args[0];
            lastNamer = args[1];
            ccNumber = args[2];
            DateFormat formatter = new SimpleDateFormat("MMddyyyy");
            Date date = new Date();
            try {
                date = (Date)formatter.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expirationDate = date;
            securityCode = args[4];
            amount = bill;
            sucessOrNot = true;
        }
    }

    public static String GetRandomCCNumber() {
        //12 digits
        String ccNumber = "";
        for(int i = 0; i < 12; i++){
            //Math.random() returns between 0.0 and 0.999, so to get 0 to 9 we multiply by 10 and
            // cut off the decimal (0.0 to 0.999 >>> 0.0 to 9.99 >>> 0 to 9)
            //int n = (int) Math.random() * 10;
            int max = 9;
            int min = 0;
            Random random = new Random();
            int n = random.nextInt(max - min + 1) + min;
            ccNumber = ccNumber + Integer.toString(n);
        }
        Log.d("Card Number", String.valueOf(ccNumber));
        return ccNumber;
    }

    public static String GetRandomCCSecurityCode() {
        //3 digits

        String ccSecurityCode = "";
        for(int i = 0; i < 3; i++){
            //Math.random() returns between 0.0 and 0.999, so to get 0 to 9 we multiply by 10 and
            // cut off the decimal (0.0 to 0.999 >>> 0.0 to 9.99 >>> 0 to 9)
            int max = 9;
            int min = 0;
            Random random = new Random();
            int n = random.nextInt(max - min + 1) + min;
            //int n = (int) Math.random() * 10;
            ccSecurityCode = ccSecurityCode + Integer.toString(n);
        }

        return ccSecurityCode;
    }

    public static String GetRandomCCExpiration() {
        //8 digits
        //MMDDYYYY
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        Random random1 = new Random();

        int m = random1.nextInt(11) + 1; //don't want 0 allowed and want 12, so + 1
        Random random2 = new Random();
        int d = (random2.nextInt(27) + 1)/28 * days[m] + 1;
        int y = 2018; //get between this year and some years from now
        String date = String.format("%02d", m);
        date = date + String.format("%02d", d);
        date = date + String.format("%04d", y);
        //Log.d("Dates : ", date);
        return date;
    }
}

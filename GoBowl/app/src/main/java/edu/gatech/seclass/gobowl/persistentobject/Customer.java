package edu.gatech.seclass.gobowl.persistentobject;

import java.io.Serializable;

/**
 * Created by Yijin on 7/7/2016.
 */
public class Customer implements Serializable{
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public  String getId() {
        return id;
    }

    public Boolean getVIP() {
        return isVIP;
    }

    public double getCreditForThisYear() {
        return creditForThisYear;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public void setCreditForThisYear(double creditForThisYear) {
        this.creditForThisYear = creditForThisYear;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    private String name;
    private String email;
    private String id;//hexid


    private boolean isVIP;
    private double creditForThisYear;
    private String QRCode;

    public Customer(String name, String email, String id, boolean isVIP, double creditForThisYear, String QRCode) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.isVIP = isVIP;
        this.creditForThisYear = creditForThisYear;
        this.QRCode = QRCode;
    }

//    public static String IdToHexID(long id) {
//        String hexID = Long.toHexString(id);
//        hexID = ("0000".substring(0, 4 - hexID.length())) + hexID;
//        return hexID;
//    }
//
//    public static long HexIDToId(String hexID) {
//        long id = Long.decode(hexID);
//        return id;
//    }
}

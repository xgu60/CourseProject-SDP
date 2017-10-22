package edu.gatech.seclass.gobowl.persistentobject;

import java.util.Date;
import java.util.List;

/**
 * Created by Yijin on 7/7/2016.
 */
public class Lane {
    private long id; // table key

    public Date getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(Date checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public int getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getRegistedCustomerID() {
        return registedCustomerID;
    }

    public void setRegistedCustomerID(String registedCustomerID) {
        this.registedCustomerID = registedCustomerID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    private int numberOfPlayers;
    private int laneNumber;
    private List<String> players; //store the customers' ID and name in string format, ID#_#name, using "k____k" as delimiler between players in DB
    private double totalCost;
    private String registedCustomerID; //store the customers' ID in string format
    private Date checkInDate; // updated in checkin;
    private Date checkedOutDate; //may be updated in checkout, records for extension
    public Lane (int numberOfPlayers,int laneNumber,List<String> players,double totalCost,String registedCustomerID,Date checkInDate,Date checkedOutDate,long id) {
        this.numberOfPlayers = numberOfPlayers;
        this.laneNumber = laneNumber;
        this.players = players;
        this.registedCustomerID = registedCustomerID;
        this.checkInDate = checkInDate;
        this.checkedOutDate = checkedOutDate;
        this.id = id;

    }
}

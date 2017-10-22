package edu.gatech.seclass.gobowl.persistentobject;

import java.util.Date;

/**
 * Created by Yijin on 7/7/2016.
 */
public class Score {
    private long id;
    private int score;
    private Date date;

    public Score (String customerid,int score,Date date,long id) {
        this.customerid = customerid;
        this.score = score;
        this.date = date;
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String customerid;
}

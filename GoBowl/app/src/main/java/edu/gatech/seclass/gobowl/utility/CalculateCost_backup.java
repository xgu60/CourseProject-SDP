package edu.gatech.seclass.gobowl.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xgu60 on 7/7/2016.
 */

public class CalculateCost_backup {
    //column: 00-23 hour, row: Monday to Sunday (0-6)
//    private static int[][] rateTable = new int[][]{
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
//    };
    private static int[][] rateTable = new int[][]{
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
            {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
    };
    public CalculateCost_backup(){
    }

    public int[][] getRateTable(){
        return rateTable;
    }

    public void updateRateTable(int[][] newRateTable){
        //update the rateTable
        rateTable = newRateTable;
    }

    public static double calculateCost(Date start, Date end, boolean isVIP){
        /*To get valuable information from Date object
         *convert Date object to a string having day of the week, hour, minute
         *Thu Jul 07 18:09:46 EDT 2016 ->  "4-18-09"
         *change the string to an array of int [3, 18, 9]
         * */
        SimpleDateFormat df = new SimpleDateFormat("u-HH-mm");
        String[] stStr = df.format(start).split("-");
        String[] edStr = df.format(end).split("-");
        int[] st = new int[]{Integer.valueOf(stStr[0])-1, Integer.valueOf(stStr[1]),
                Integer.valueOf(stStr[2])};
        int[] ed = new int[]{Integer.valueOf(edStr[0])-1, Integer.valueOf(edStr[1]),
                Integer.valueOf(edStr[2])};

        //we assume customer cannot play overnight
        if(st[0] != ed[0]){
            System.out.println("Error! CheckIn and checkOut should be same day.");
            return 10000.0;
        }

        /*to calculate the cost for example start Monday 9:30 [0, 9, 30] to 21:20 [0, 21, 20]
         * first calculate the cost of whole hours from 10:00 to 20:00
         * then calculate the time at beginning (30/60*rate) and end (20/60*rate).
         */

        Double totalCost = 0.0;
        for(int i=st[1]+1; i<ed[1]; i++)  totalCost += rateTable[st[0]][i];
        totalCost += (60-st[2])/60.0*rateTable[st[0]][st[1]] + ed[2]/60.0*rateTable[st[0]][ed[1]];
        //maybe -> if less total one hour , count as one hour
        //VIP has 10% discount
        if(isVIP) totalCost *= 0.9;
        return totalCost;


    }

}

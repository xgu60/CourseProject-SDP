package edu.gatech.seclass.gobowl.utility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by xgu60 on 7/7/2016.
 */

public class CalculateCost{
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
//        private static int[][] rateTable = new int[][]{
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
//    };


    //Sunday to Saturday 1 - 7 -> 0 - 6
    private static int[][] rateTable = new int[][]{
            {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {25, 25, 25, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25},
            {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30},

    };
    public CalculateCost(){
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
        //Calendar calendar = Calendar.getInstance();
        //calendar.get(Calendar.DAY_OF_WEEK);
        //SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
//        HashMap<String,Integer> map = new HashMap<String,Integer>();
//        map.put("Monday",1);
//        map.put("Tuesday",2);
//        map.put("Wednesday",3);
//        map,
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        cal.setTime(end);
        int endDay = cal.get(Calendar.DAY_OF_WEEK);

        //System.out.println();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-HH-mm");
        //Log.d("here","here1");
        String[] stStr = df.format(start).split("-");
        String[] edStr = df.format(end).split("-");
        int[] st = new int[]{Integer.valueOf(stStr[0])-1, Integer.valueOf(stStr[1]),
                Integer.valueOf(stStr[2])};
        int[] ed = new int[]{Integer.valueOf(edStr[0])-1, Integer.valueOf(edStr[1]),
                Integer.valueOf(edStr[2])};

        //System.out.println("start1: " + st[0] + " : " + ed[0]);

        st[0] = startDay - 1;
        ed[0] = endDay - 1;
        //System.out.println("start2: " + st[0] + " : " + ed[0]);



        //we assume customer cannot play overnight
        if(st[0] != ed[0]){
            //System.out.println("Error! CheckIn and checkOut should be same day.");
            //int ratio = (60 - st[2] + ed[2]) > 60 ? 1 : 2;
            //double moneyst = st[1] * (24 - st[1])
            return 360.0; // if cross night , return 360.
        }

        /*to calculate the cost for example start Monday 9:30 [0, 9, 30] to 21:20 [0, 21, 20]
         * first calculate the cost of whole hours from 10:00 to 20:00
         * then calculate the time at beginning (30/60*rate) and end (20/60*rate).
         */

        Double totalCost = 0.0;
        int ratio = (60 - st[2] + ed[2]) > 60 ? 2 : 1;
        //less than 1 hour
        if (ed[1] - st[1] == 0 || (ed[1] - st[1] == 1 && ratio == 1)) {
            totalCost += rateTable[st[0]][st[1]];
        } else {
            for (int i = st[1] + 1; i < ed[1]; i++) totalCost += rateTable[st[0]][i];
            totalCost += (60 - st[2]) / 60.0 * rateTable[st[0]][st[1]] + ed[2] / 60.0 * rateTable[st[0]][ed[1]];
        }//totalCost += rateTable[st[0]][st[1]] + rateTable[st[0]][ed[1]];
        //if (ratio == 1)
            //totalCost -= rateTable[st[0]][ed[1]];
        //maybe -> if less total one hour , count as one hour
        //VIP has 10% discount
        if(isVIP) totalCost *= 0.9;
        return totalCost;


    }

}

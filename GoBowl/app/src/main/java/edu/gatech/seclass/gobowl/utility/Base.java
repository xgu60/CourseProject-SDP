package edu.gatech.seclass.gobowl.utility;

/**
 * Created by Yijin on 7/8/2016.
 */
public class Base {
    public static String numberTOStringID(long id) {
        String s = String.format("%16x", id).trim();
        while (s.length() < 4)
            s = "0" + s;

        return s;
    }

    public static long StringToIntegerID(String hexid) {
        return Long.parseLong(hexid.trim(), 16);
    }

    public static String[] getFirstLastName(String name) {
        String names[] = name.split("\\s+");
        String firstName = "";
        String lastName = "";
        String[] result = new String[2];
        result[0] = "";
        result[1] = "";
        if (names.length == 0) {
            return result;
        } else if (names.length == 1){
            result[0] = names[0];
            return result;
        } else {
            result[0] = names[0];
            result[1] = names[1];
            return result;
        }
    }
}

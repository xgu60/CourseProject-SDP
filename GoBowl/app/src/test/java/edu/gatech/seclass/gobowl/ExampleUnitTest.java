package edu.gatech.seclass.gobowl;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.gatech.seclass.gobowl.utility.Base;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //System.out.println(String.format("%04X","aaa".hashCode()));
        //int n = (int) Long.parseLong("ffff8000", 16);
        //System.out.println(String.format("%04X", (long) 312321123).toUpperCase());
       // System.out.println(Long.parseLong(Integer.toHexString(("aasgsg faaaasfaaaaf".hashCode()) % 60136 + 4096)));
        //System.out.println(CustomerDataSource.stringToFourDigit("apasssska" + "aaa@aaa.com"));

        System.out.println( Long.parseLong("AA0F245C", 16));

        //System.out.println (16 * 16 * 16 * 16);
        //System.out.println("aaaaaa".substring(0,4));
      //  Context context = new Context(
        //DataBaseHelper dbtest = new DataBaseHelper();

         System.out.println(Base.StringToIntegerID("0f0e"));
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(new Date(Calendar.getInstance().getTimeInMillis()) );
        System.out.println(Base.numberTOStringID(3854));
        int j = 2;
        long k = j;
        System.out.println (k);
        Date checkOutTime = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("u-HH-mm");
        String[] edStr = df.format(checkOutTime).split("-");
        System.out.println(edStr[0] + " : " + edStr[1] + " : " + edStr[2]);




    }
}
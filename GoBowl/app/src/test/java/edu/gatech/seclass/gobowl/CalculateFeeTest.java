package edu.gatech.seclass.gobowl;

/**
 * Created by xgu60 on 7/7/2016.
 */


    import java.util.Calendar;
    import java.util.Date;

    import edu.gatech.seclass.gobowl.utility.CalculateCost;

    import static junit.framework.TestCase.assertEquals;


    public class CalculateFeeTest {
        private CalculateCost cost;
        private Calendar cal = Calendar.getInstance();
        private Date start, end;
        @org.junit.Before
        public void setUp() {
            cost = new CalculateCost();
        }

        @org.junit.After
        public void tearDown() {
            cost = null;
        }



        @org.junit.Test
        public void testCalculateCost1() {
            cal.set(2016, Calendar.JULY, 7, 9, 0); //Year, month, day of month, hours, minutes
            start = cal.getTime();
            cal.set(2016, Calendar.JULY, 7, 19, 0); //Year, month, day of month, hours, minutes
            end = cal.getTime();

            assertEquals(210.0, cost.calculateCost(start, end, false));

        }

        @org.junit.Test
        public void testCalculateCost2() {
            cal.set(2016, Calendar.JULY, 2, 10, 0); //Year, month, day of month, hours, minutes
            start = cal.getTime();
            cal.set(2016, Calendar.JULY, 2, 16, 0); //Year, month, day of month, hours, minutes
            end = cal.getTime();

            assertEquals(180.0, cost.calculateCost(start, end, false));

        }

        @org.junit.Test
        public void testCalculateCost3() {
            cal.set(2016, Calendar.JULY, 6, 9, 30); //Year, month, day of month, hours, minutes
            start = cal.getTime();
            cal.set(2016, Calendar.JULY, 6, 21, 15); //Year, month, day of month, hours, minutes
            end = cal.getTime();

            assertEquals(117.5, cost.calculateCost(start, end, false));

        }

        @org.junit.Test
        public void testCalculateCost4() {
            cal.set(2016, Calendar.JULY, 5, 9, 30); //Year, month, day of month, hours, minutes
            start = cal.getTime();
            cal.set(2016, Calendar.JULY, 5, 17, 30); //Year, month, day of month, hours, minutes
            end = cal.getTime();

            assertEquals(162.5, cost.calculateCost(start, end, false));

        }

        @org.junit.Test
        public void testCalculateCost5() {
            cal.set(2016, Calendar.JULY, 5, 9, 30); //Year, month, day of month, hours, minutes
            start = cal.getTime();
            cal.set(2016, Calendar.JULY, 5, 17, 30); //Year, month, day of month, hours, minutes
            end = cal.getTime();

            assertEquals(146.25, cost.calculateCost(start, end, true));

        }
    }


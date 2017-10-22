package edu.gatech.seclass.gobowl;

/**
 * Created by Yijin on 7/7/2016.
 */
import static android.support.test.InstrumentationRegistry.getTargetContext;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.gatech.seclass.gobowl.database.DataBaseHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    private DataBaseHelper database;

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase("GoBowlDB");
        //database = new DataBaseHelper(getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }

    @Test
    public void shouldAddExpenseType() throws Exception {
        //database.addExpenseType(new ExpenseType("Food"));

        //List<String> expenseTypes = database.getExpenseTypes();
        //assertThat(expenseTypes.size(), is(1));
        //assertTrue(expenseTypes.get(0).equals("Food"));
    }
}

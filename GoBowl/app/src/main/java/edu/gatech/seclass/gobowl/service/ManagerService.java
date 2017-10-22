package edu.gatech.seclass.gobowl.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import edu.gatech.seclass.services.PrintingService;
import edu.gatech.seclass.services.ServicesUtils;
import edu.gatech.seclass.gobowl.database.CustomerDataSource;
import edu.gatech.seclass.gobowl.database.DataBaseHelper;
import edu.gatech.seclass.gobowl.database.StaticDataBase;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.utility.Base;
import edu.gatech.seclass.gobowl.utility.CreditCard;

/**
 * Created by Yijin on 7/7/2016.
 */
public class ManagerService {
    private CustomerDataSource customerdao;
    private SQLiteDatabase database;
    private static ManagerService ms;
    Context context;
    private ManagerService(SQLiteDatabase db) {
        customerdao = new CustomerDataSource(db);
        database = db;
    }

    private ManagerService(Context context) {
        this.context = context;
        this.database = StaticDataBase.getWritableDB(context);
        customerdao = new CustomerDataSource(this.database);
    }

    public static ManagerService getManagerService(Context context) {
        if (ms == null)
            ms = new ManagerService(context);
        return ms;
    }

    public boolean addCustomer(String name, String email) {
        // if larger than 65536 then need delete the customer,add handling later
        return customerdao.addCustomer(name,email) >= 0;


//        String[] names = Base.getFirstLastName(name);
//        ServicesUtils.addCustomer(
//                names[0],
//                names[1],
//                CreditCard.GetRandomCCNumber(),
//                CreditCard.GetRandomCCExpiration(),
//                CreditCard.GetRandomCCSecurityCode(),
//                hid);


    }

    public Customer getCustomerByEmail(String email) {
        String hid = customerdao.getCustomerID(email);
        Customer customer = customerdao.findCustomer(hid);
        return customer;
    }

    public void addDummyCustomersForTesting(){
        Log.d("Add default customer:", "For testing");
        customerdao.addCustomerForTesting("Ralph Hapschatt","RalphHapschatt@gmail","86ff");
        Log.d("Customer1 added :", "Ralph Hapschatt");
        customerdao.addCustomerForTesting("Betty Monro","BettyMonro@gmail","9441");
        Log.d("Customer2 added :", "Betty Monro");
        customerdao.addCustomerForTesting("Everett Scott","EverettScott@gmail","0f0e");
        Log.d("Customer3 added :", "Everett Scott");
    }

    public void clearAllTablesForTesting(){
        DataBaseHelper.getDataBaseHelper(context).clearDataBaseForTesting(database);
    }

    //when clilck on edit customer , the customer list shown, this should be called by Activity
    public List<Customer> getCustomerList() {
        return customerdao.getCustomerList();
    }

    //when click on specific customer : the customer infomration shown and you can edit the customer information
    public boolean editCustomer(Customer customer) {
        Boolean check = customerdao.editCustomer(customer);
        return check;
    }

    //when click on print card service , customer list shown, and you choose the customer  and push the button print, card get printed
    //when click on specific customer : the customer infomration shown and you can edit the customer information
    public boolean printCustomerCard(Customer customer) {
        String names[] = Base.getFirstLastName(customer.getName());
        String firstName = "";
        String lastName = "";
        String hexID = customer.getId();
        return PrintingService.printCard(firstName, lastName, hexID);
    }
    //Yearly reset VIP service:
    public void resetVIPYearly() {
        customerdao.refreshVIPStatus();
    }

    public void syncCustomerStubList(){
        List<Customer> customers = this.getCustomerList();

        ServicesUtils.resetCustomers();
        String[] names;
        for(Customer c : customers){
            names = Base.getFirstLastName(c.getName());
            ServicesUtils.addCustomer(
                    names[0],
                    names[1],
                    CreditCard.GetRandomCCNumber(),
                    CreditCard.GetRandomCCExpiration(),
                    CreditCard.GetRandomCCSecurityCode(),
                    c.getId());
        }
    }

}
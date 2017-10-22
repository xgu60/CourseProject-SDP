package edu.gatech.seclass.gobowl.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.gatech.seclass.services.CreditCardService;
import edu.gatech.seclass.services.PaymentService;
import edu.gatech.seclass.services.QRCodeService;
import edu.gatech.seclass.services.ServicesUtils;
import edu.gatech.seclass.gobowl.database.CustomerDataSource;
import edu.gatech.seclass.gobowl.database.LaneDataSource;
import edu.gatech.seclass.gobowl.database.ScoreDataSource;
import edu.gatech.seclass.gobowl.database.StaticDataBase;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.persistentobject.Lane;
import edu.gatech.seclass.gobowl.persistentobject.Score;
import edu.gatech.seclass.gobowl.utility.Base;
import edu.gatech.seclass.gobowl.utility.CalculateCost;
import edu.gatech.seclass.gobowl.utility.CreditCard;

/**
 * Created by Yijin on 7/7/2016.
 */
public class CustomerService {
    private CustomerDataSource customerdao;
    private LaneDataSource lanedao;
    private ScoreDataSource scoredao;
    private static CustomerService cs;
    private SQLiteDatabase database;
    private Context context;
    private CustomerService(SQLiteDatabase db) {
        customerdao = new CustomerDataSource(db);
        lanedao = new LaneDataSource(db);
        scoredao = new ScoreDataSource(db);
    }

    private CustomerService(Context context){
        this.context = context;
        this.database = StaticDataBase.getWritableDB(context);
        customerdao = new CustomerDataSource(this.database);
        lanedao = new LaneDataSource(this.database);
        scoredao = new ScoreDataSource(this.database);
    }

    public static CustomerService getCustomerService(Context context) {
        if (cs == null)
            cs = new CustomerService(context);
        return cs;
    }

    public long addScore(String customerid, int value){
        return scoredao.addScore(customerid,value);
    }

    public List<Score> getScoreList(String customerid) {
        return scoredao.getScoreList(customerid);
    }


    public boolean scanCode(){
        return !QRCodeService.scanQRCode().equals("ERR");
    }

    //Request Lane process start***********:
    public String scanCardToGetCustomerID(){

        List<Customer> customers = customerdao.getCustomerList();

        if (customers == null || customers.size() == 0) {
            return "No Customer exist";
        } else {
            //may optimize later
            String customer = QRCodeService.scanQRCode();//call to external library
            if (customer.equals("ERR")) {
                return "ERR";
            }

            if (    customer != null &&
                    !customer.equals("ERR") ||
                    customerdao.findCustomer(customer) != null) {
                    return customer;
            }
//            double randNum = Math.random();
//            double ran = customers.size() * randNum;
//            int index = (int)ran;
            //return customers.get(index).getId();
            return customer;
        }
    }
    //return the lane Number
    public int getAvailableLaneForRequestLane() {
        List<Integer> usedLanes = lanedao.getUsingLane();
        int max = 0;

        if (usedLanes.size() == 0) {
            return 3;
        } else {
            for (int i = 0; i < usedLanes.size(); i++) {
                max = max > usedLanes.get(i) ? max : usedLanes.get(i);
            }
            return max + 1;
        }
    }

    //vaildate before calling "getNumbersOfPlayersForPlaying"
    public boolean vaildateNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers <= 0)
            return false;
        List<Customer> customers = customerdao.getCustomerList();
        if (null == customers || customers.size() < numberOfPlayers )
            return false;
        else
            return true;
    }

    //Assume that the ones who request the lane may join the game
    //So registedPlayer is the one get from scanCardToGetCustomerID()
    public List<String> getNumbersOfPlayersForPlaying(int numberOfPlayers, String registedPlayer) {
        Customer customer = customerdao.findCustomer(registedPlayer);
        //if numberOfPlayers <= 1, just return the one who register the lane
        //using ID#_#name as players information
        List<String> players = new ArrayList<String>();
        String regostedCustomer = customer.getId() + "#_#" + customer.getName();
        players.add(regostedCustomer);//first added
        List<Customer> customers = customerdao.getCustomerList();
        //may shuffle later for optimazation

        for (int i = 0; i <numberOfPlayers && i < customers.size(); i++ ) {
            String tmpcustomer = customers.get(i).getId() + "#_#" + customers.get(i).getName();
            if (!tmpcustomer.equals(regostedCustomer)) {
                //will simulate here
                players.add(tmpcustomer);
            }
        }
        if (players.size() == numberOfPlayers + 1) {
            players.remove(players.size() - 1);
        }
        return players;
    }

    //laneNunmber get from "getAvailableLaneForRequestLane"
    //int numberOfPlayers is use input
    //players get from "getNumbersOfPlayersForPlaying"
    //registered customer ID from scanCardToGetCustomerID
    public boolean saveLaneInformationToDBForCheckOutLater(int laneNumber,String registeredCustomerID,int numberOfPlayers,List<String> players){
        //if false ,requestLane failed
        return lanedao.addLane(laneNumber,numberOfPlayers,registeredCustomerID,players) >0;
    }
    //Request Lane process end!!!!!!!!!!!!

    //CheckOut Lane Start
    public boolean isLaneRequested(int laneNumber) {
        return lanedao.getLane(laneNumber) != null;
    }
    //Assume laneNumber inputted and "Yes" to save scores, then the list of customers shown
    public List<Customer> getPlayersList(int laneNumber) {
        String players = lanedao.getPlayersListForCheckOut(laneNumber);
        List<Customer> playersList = new ArrayList<Customer>();
        if (players == null)
            return playersList;
        else {
            //playersList += players.get(i) + "k____k" in LaneDataSource
            String splitter = "k____k";
            String[] plis =  players.split(splitter);
            if (plis != null) {
                for (int i = 0; i < plis.length; i++) {
                     String[] fileds = plis[i].split("#_#");
                    //customer.getId() + "#_#" + customer.getName()
                     if(fileds != null && fileds.length > 0) {
                        String customerID = fileds[0];
                         Customer customer = customerdao.findCustomer(customerID);
                         playersList.add(customer);
                     }
                }
            }

        }
        return playersList;
    }
    //After Displayering the List @ UI, user can select and add score for each players,
    public boolean getPlayersList(String customerID, int Score) {
        return scoredao.addScore(customerID,Score) > 0;
    }

    //After adding score , the system ask for money paying :
    public double calCulateCostAccordingToDate(int laneNumber, int billSplit){
        Date checkOutTime = Calendar.getInstance().getTime();
        Lane la = lanedao.getLane(laneNumber);
        double moneyToPaidByeachone= 0;
        if (la != null) {
            Date checkInTime = la.getCheckInDate();
            Customer cus = customerdao.findCustomer(la.getRegistedCustomerID());

//            long checkin = checkInTime.getTime();
//            long checkout =  checkOutTime.getTime();
            moneyToPaidByeachone = CalculateCost.calculateCost(checkInTime,checkOutTime,cus.getVIP())/ billSplit;
            Log.d("Money : ",String.valueOf(moneyToPaidByeachone));
            return moneyToPaidByeachone;
//            if (checkout - checkin < 1000)
//            {
//                checkout+= 1000;
//                checkOutTime = new Date(checkout);
//                // if less than 1 minute , count as one minute
//                Customer cus = customerdao.findCustomer(la.getRegistedCustomerID());
//                if (cus != null && cus.getVIP() != null && billSplit > 0) {
//                }
//            }
        }
        return moneyToPaidByeachone;
    }


    //After knowing how much to be paid by each one, do transaction settlement
    //read Credit Card information for transaction settlement,
    //The CreditCard list stores the read card information , that is success or not
    //The can be shown as read cards process in UI page
    public CreditCard readCardEachTime(double amountForeachbill) {
        String res = CreditCardService.readCreditCard();
        if (res.equals("ERR"))  {
            CreditCard card = new CreditCard(res,amountForeachbill);
            card.setSucessOrNot(false);
            return card;
        } else {
            CreditCard card = new CreditCard(res, amountForeachbill);
            card.setSucessOrNot(true);
            return card;
        }
    }


    public List<CreditCard> readCard(int billSplit , double amountForeachbill) {
        List<CreditCard> creditcards = new ArrayList<CreditCard>();
        int i = 0;
        int count = 0;
        while (i < billSplit) {
            if (count > 10001)
                break;
            String res = CreditCardService.readCreditCard();
            if (res.equals("ERR"))  {
                CreditCard card = new CreditCard(res,amountForeachbill);
                card.setSucessOrNot(false);
                creditcards.add(card);
            } else {
                CreditCard card = new CreditCard(res, amountForeachbill);
                card.setSucessOrNot(true);
                creditcards.add(card);
                i++;
            }
            count++;
        }
        // if creditcards size > 10001 means totally failed, pop a notification to user
        return creditcards;
    }
    // transcation records updated in filed: transactionRecords -- Boolean
    public List<CreditCard> tranSettlement(List<CreditCard> cards, int billSplit , double amountForeachbill) {
        ArrayList<CreditCard> validCredits = new ArrayList<CreditCard>();

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isSucessOrNot()){
                  validCredits.add(cards.get(i));
            }
        }
        //failed in readCard steps, all failss
        if (validCredits.size() != billSplit)
            return validCredits;
        else
        {
            int i = 0;
            int count = 0;
            List<CreditCard> settlementResults = new ArrayList<CreditCard>();
            while (i < billSplit) {
                if (count > 10001) {
                    break;
                }
                count++;
                CreditCard cre = validCredits.get(i);
                if (PaymentService.processPayment(cre.getFirstName(),
                        cre.getLastNamer(),cre.getCcNumber(),
                        cre.getExpirationDate(),cre.getSecurityCode(),cre.getAmount())) {
                    cre.setTransactionRecords(true);
                    settlementResults.add(cre);
                    i++;
                } else {
                    CreditCard creditCard = new CreditCard("ERR",0);
                    creditCard.setTransactionRecords(false);
                    settlementResults.add(creditCard);
                }
            }
            // if creditcards size > 10001 means totally failed, pop a notification to user
            return settlementResults;

        }
    }
    //After transettlement done, add credit to the registed customer
    public boolean addCreditToRegisteredCustomer(int laneNumber,double totalAmount){
        String customerID = lanedao.getCustomerIDForAddingCredit(laneNumber);
        return customerdao.addCreditForVIP(customerID, totalAmount);
    }
    //CheckOut Lane End
    //find cusrtomer :
    public Customer getCustomer(String customerID) {
        return customerdao.findCustomer(customerID);
    }
    //View Scores :
    public List<Score> getScores(String customerID) {
        return scoredao.getScoreList(customerID);
    }

    public void syncForPayment(List<Customer> cus){
        List<Customer> customers = cus;

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

    public void deleteLane(int laneNumber) {
        lanedao.deleteLane(laneNumber);
    }
}

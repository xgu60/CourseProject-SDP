# Design Document


**Author**: \<Team47\>

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | Updates UI and Assumptions |


## 1 Design Considerations


### 1.1 Assumptions

1. The configuration/static information (such as requirement 8 ,the cost of a lane. requirement 12. information relevant to discount ,etc)  can be accessed from configuration files (not shown in the 3.1 Class Diagram) referenced by class's methods.
2. The dashed lines in the 3.1 Class Diagram represent the interaction between the system and the external library
3. The system does not store the information of credit card after transaction completed , the `CreditCard` class in the 3.1 Class Diagram is just for validating credit cards' information during a transaction. And credit card is the only allowable payment method.
4. Manager is the only employee working at the bowling alley
5. In 3.1 Class Diagram, the String (id) of `addCustomer` in `Manager` class is just a String type , (id) is just for explanation: the function return a customer unique id.
6. Calls external libraries may hit failure, but the system will retry to simulate the customer slide cards actions, the system may display the results of trying in the UI. 
7. **A underlying batch job : resetVIPYearly() (in code base : ManagerSevice) will be triggered on January 01 every year to set VIP status of each customer to false and clean of the balance of this years to meet requirement : 12**
8. **Assume the lane requested will be checked out in the same time (not cross night). If the lane is checkout not in the same day (cross night ), the system will cost $360 regardless of the VIP status**
9. **In request lane, suppose the registered customer is one of the player. So if you input n player, actually merely n -1 player need to be added after  the registered customer is scanned**
10. **If checkout time - checkin time < 1 hour, we will count it as one hour, if > 1 hour , we count as minute-base**
11. **the bill is formatted as #.## , for example $6.25.** 
12. **Multiple Scores can be added to a customer during checkout process**


### 1.2 Constraints

1. The implementation of the interactions between the system and utilitis :  (1) printing, (2) QR code scanning, (3) credit-card scanning, and (4) payment processing capabilities depends on how the utilities are provided.
2. There are only two interfaces open to users : CustoemrInterface , ManagerInferface.

### 1.3 System Environment

1. The interface of utilities (1) printing, (2) QR code scanning, (3) credit-card scanning, and (4) payment processing capabilities should be provided by external libraries (vendors).
2. The application should be run on Android platform with API Level 15 as minimum target.
3. We use Android Studio 2.1 (or a later version) as development enviroment.

## 2 Architectural Design


### 2.1 Component Diagram

![component-diagram](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/component_diagram.png "component-diagram")

The System: GoBowl contains four components : Customer , Manager , LaneManager and Score.

The System connects to local database and external libraries : PaymentProcessingService, CardPrinter, Videocam and CreditCardScanner to perform corresponding functionalities stated in the requirements.

### 2.2 Deployment Diagram

The system will be installed in a stand-alone Android machine. A local database will be used and all the componented will be integrated into the single machine. Therefore, we don't need a deployment diagram.

## 3 Low-Level Design

### 3.1 Class Diagram

![Team-Design](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/team-design.png "Team-Design")


## 4 User Interface Design


The User Interfaces are self-explained and provide clear instructions for the users (manager and Customer).

### 4.1 Home Page

![GoBowl_Home](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/Main.png "GoBowl_Home")


### 4.2 Manager

![GoBowl_Manager](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/Manager.png "GoBowl_Manager")

#### 4.2.1 Add Customer 

![GoBowl_AddCustomer_1](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/AddCustomer.png "GoBowl_AddCustomer")

![GoBowl_AddCustomer_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/CustomerAddedMessage.png "GoBowl_AddCustomer_2")


#### 4.2.2 Edit Customer 

![GoBowl_SelectCustomer_1](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/SelectCustomer.png "GoBowl_SelectCustomer_1")

![GoBowl_EditCustomer](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/EditCustomer.png "GoBowl_EditCustomer")

![GoBowl_EditCustomerUpdated](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/EditCustomerSuccess.png "GoBowl_EditCustomerUpdated")

![GoBowl_EditCustomerNotUpdated](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/EditCustomerNotChanged.png "GoBowl_EditCustomerNotUpdated")

#### 4.2.3 Print Customer CardPrinter

![GoBowl_SelectCustomer_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/SelectCustomer.png "GoBowl_SelectCustomer_2")

![GoBowl_PrintCustomerCard](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/PrintCustomerCard.png "GoBowl_PrintCustomerCard")

![GoBowl_PrintCustomerCard_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/CustomerCardPrintingMessage.png "GoBowl_PrintCustomerCard_2")

### 4.3 Customer

![GoBowl_Customer](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/Customer.png "GoBowl_Customer")


#### 4.3.1 Request Lane

![GoBowl_Customer_LaneRequest_1](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneRequest.png "GoBowl_Customer_LaneRequest_1")

![GoBowl_Customer_LaneRequest_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneRequest_ScannedMessage.png "GoBowl_Customer_LaneRequest_2")

![GoBowl_Customer_LaneRequest_3](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneAssigned.png "GoBowl_Customer_LaneRequest_3")

![GoBowl_Customer_LaneRequest_4](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneAssignedPlayersScanned.png "GoBowl_Customer_LaneRequest_4")

![GoBowl_Customer_LaneRequest_5](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneAssignedPlayersScannedLaneInformation.png "GoBowl_Customer_LaneRequest_5")

#### 4.3.2 Check Out Lane

![GoBowl_Customer_Checkout_1](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/LaneCheckout.png "GoBowl_Customer_Checkout_1")

![GoBowl_Customer_Checkout_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/SaveScoresYesNo.png "GoBowl_Customer_Checkout_2")

![GoBowl_Customer_Checkout_3](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/SaveScoresSelectPlayer.png "GoBowl_Customer_Checkout_3")

![GoBowl_Customer_Checkout_4](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/Bill.png "GoBowl_Customer_Checkout_4")

![GoBowl_Customer_Checkout_5](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/BillSplit.png "GoBowl_Customer_Checkout_5")

![GoBowl_Customer_Checkout_6](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/BillPaid_CCDetails.png "GoBowl_Customer_Checkout_6")

![GoBowl_Customer_Checkout_7](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/BillPaid_TransactionLog.png "GoBowl_Customer_Checkout_7")

#### 4.3.3 View Scores

![GoBowl_Customer_ViewScores_1](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/ViewScoresScanCard.png "GoBowl_Customer_ViewScores_1")

![GoBowl_Customer_ViewScores_2](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/Release_SS/ViewScores.png "GoBowl_Customer_ViewScores_2")




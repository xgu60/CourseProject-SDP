# Use Case Model


**Author**: \<Team47\>

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | Updated version |


## 1 Use Case Diagram


![Use_Case_Diagram](https://github.gatech.edu/gt-omscs-softeng/6300Summer16Team47/blob/master/Resource/useCaseModel/User_case.png)


## 2 Manager Use Case Descriptions

### 2.1 addCustomer

- *Requirements: Manager use the system to add a new customer by using customer name and e-mail address as inputs.
- *Pre-conditions: Manager should have the valid name and e-mail address of the new customer 
- *Post-conditions: A new Customer is added to database and printCustomerCard get called.

#### 2.1.1 Normal Scenario

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects ADD_A_NEW_IM_A_CUSTOMER button on Manager_Main_Menu. GUI displays fields for customer info, ADD button and CANCEL button
3. Manager fills in new customer info and selects ADD button. Manager is returned to Manager_Main_Menu after begin notified of success.
4. Customer card is printed automatically

#### 2.1.2 Alternate Scenario

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects ADD_A_NEW_IM_A_CUSTOMER button on Manager_Main_Menu. GUI displays fields for customer info, ADD button and CANCEL button
3. Manager selects CANCEL and is returned to Manager_Main_Menu

#### 2.1.2 Exceptional event

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects ADD_A_NEW_IM_A_CUSTOMER button on Manager_Main_Menu. GUI displays fields for customer info, ADD button and CANCEL button
3. Manager selects ADD before filling in all requred data. Manager is notified of issue and remains at this interface. (e.g system outrage)

### 2.2 printCustomerCard

- *Requirements:  Manager prints a customer's card for an existing customer.
- *Pre-conditions: The customer who needed a CustomerCard has already been added to the database.
- *Post-conditions: The customer's card is printed.

#### 2.2.1 Normal Scenario

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects PRINT_A_CUSTOMER_CARD on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects a customer in drop-down, and selects NEXT button.  GUI displays confirmation screen with customer information, CANCEL button and PRINT button.
4. Manager selects PRINT button.
5. The customer's card is printed.

#### 2.2.2 Alternate Scenario 1

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects PRINT_A_CUSTOMER_CARD on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects CANCEL and is returned to Manager_Main_Menu

#### 2.2.3 Alternate Scenario 2

1. Manager selects IM_THE_MANAGER button. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects PRINT_A_CUSTOMER_CARD on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects a customer in drop-down, and selects NEXT button.  GUI displays confirmation screen with customer information, CANCEL button and PRINT button.
3. Manager selects CANCEL and is returned to Manager_Main_Menu

### 2.3 editCustomerInformation

- *Requirements: Manager edits a customer's information for an existing customer.
- *Pre-conditions: The customer being edited has already been added to database.
- *Post-conditions: The customer's information is updated.

#### 2.3.1 Normal Scenario

1. Manager selects IM_THE_MANAGER button an is sent to Manager_Main_Menu. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects EDIT_A_CUSTOMERS_INFORMATION on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects a customer in drop-down, and selects NEXT button.  GUI displays fields with customer data filled in, SAVE button, and CANCEL button.
4. Manager fills in updated customer information, and selects SAVE button. Values in fields replace old values for that customer. GUI informs Manager of success and has an OK button.
5. Manager selects OK button and is returned to Manager_Main_Menu.

#### 2.3.2 Alternate Scenario 1

1. Manager selects IM_THE_MANAGER button an is sent to Manager_Main_Menu. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects EDIT_A_CUSTOMERS_INFORMATION on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects CANCEL and is returned to Manager_Main_Menu

#### 2.3.3 Alternate Scenario 2

1. Manager selects IM_THE_MANAGER button an is sent to Manager_Main_Menu. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects EDIT_A_CUSTOMERS_INFORMATION on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects a customer in drop-down, and selects NEXT button.  GUI displays fields with customer data filled in, SAVE button, and CANCEL button.
4. Manager leaves customer information unchanged, and selects SAVE button. GUI informs Manager of that no change has taken place and has an OK button.
5. Manager selects OK button and is returned to Manager_Main_Menu.

#### 2.3.4 Alternate Scenario 3

1. Manager selects IM_THE_MANAGER button an is sent to Manager_Main_Menu. GUI displays ADD_A_NEW_CUSTOMER, PRINT_A_CUSTOMER_CARD, EDIT_A_CUSTOMERS_INFORMATION, and CANCEL buttons
2. Manager selects EDIT_A_CUSTOMERS_INFORMATION on Manager_Main_Menu. GUI displays a drop-down list of customers, NEXT button, and CANCEL button (select_a_customer_menu)
3. Manager selects a customer in drop-down, and selects NEXT button.  GUI displays fields with customer data filled in, SAVE button, and CANCEL button.
3. Manager selects CANCEL and is returned to Manager_Main_Menu

## 3 Customer Use Case Descriptions

### 3.1 requestLane

- *Requirements: Customers swipe their customer cards, a lane is assigned to these customers and the lane number is displayed on screen.
- *Pre-conditions: These customers have customer's cards and lanes are always available.
- *Post-conditions: A lane is assigned to these customers and the lane number is displayed on screen. These customers go to the lane and play.

#### 3.1.1 Normal Scenario

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects REQUEST_A_LANE. GUI prompts Customer to scan card and displays CANCEL button and REQUEST_LANE button.
3. Customer scans card and selects REQUEST_LANE. System assigns a lane to customer's. GUI prompts customer for number of players and for each player to scan their card.
4. Customer fills in desired number of players and each player scans thier card.
5. A confirmation window is displayed with a DONE button and a VIEW_LANE_INFORMATION button that dispays lane and player information if selected.
6. Customer selects DONE button and is returned to Main_Login_Menu.

#### 3.1.2 Alternate Scenario 1

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects REQUEST_A_LANE. GUI prompts Customer to scan card and displays CANCEL button and REQUEST_LANE button.
3. Customer scans card and selects CANCEL. Customer is returned to Customer_Main_Menu.

#### 3.1.3 Alternate Scenario 2

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects REQUEST_A_LANE. GUI prompts Customer to scan card and displays CANCEL button and REQUEST_LANE button.
3. Customer scans card and selects REQUEST_LANE. System assigns a lane to customer's. GUI prompts customer for number of players and for each player to scan their card.
4. Customer selects CANCEL and is returned to Customer_Main_Menu.

### 3.2 checkOut

- *Requirements: A customer wishes to checkout a previously requested lane. 
- *Pre-conditions: The customer has previously requested a lane. 
- *Post-conditions: The customer checks out the lane, added scores(if desired) and pays bill. Credits (for vip) are added to the customer's database entry.  

#### 3.2.1 Normal Scenario

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects LANE_CHECKOUT botton. GUI prompts customer for lane number, CANCEL and CONTINUE buttons are displayed.
3. Customer enters lane number in prompt and selects CONTINUE.
4. System asks if any players wish to enter scores. (YES/NO)
5. If Customer selects YES, go to `3.4 addScore`. Here assume the customer selects NO.
6. System asks how many ways to split bill? (Go to `3.5 calculateCostAccordingToDate`)

#### 3.2.2 Alternate Scenario

1. The Alternate Scenarios are derived from `3.4.1 Normal Scenario` at steps 5. (add score or not).

### 3.3 checkScore

- *Requirements: Customer check his score's history (including the score and date) in the system.
- *Pre-conditions: The Customer exist in the system. 
- *Post-conditions: The score history is shown to the customer.

#### 3.3.1 Normal Scenario

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects VIEW_MY_INFORMATION_AND_SCORES botton. GUI prompts customer to scan card and displays CANCEL button.
3. Customer scans card.
4. System displays customer info, a list of scores (empty if no scores have been entered), and an OK button.
5. Customer selects OK button and is returned to the Customer_Main_Menu.

#### 3.3.2 Alternate Scenario 1

1. Customer selects IM_A_CUSTOMER button on Main_Login_Menu. GUI displays REQUEST_A_LANE button, LANE_CHECKOUT button, and VIEW_MY_INFORMATION_AND_SCORES button. (Customer_Main_Menu)
2. Customer selects VIEW_MY_INFORMATION_AND_SCORES botton. GUI prompts customer to scan card and displays CANCEL button.
3. Customer selects CANCEL button and is returned to Customer_Main_Menu.

### 3.4 addScore

- *Requirements: The customers added their scores to the systems. 
- *Pre-conditions: The Customers is checking out a lane and click Yes for adding score.
- *Post-conditions: The customers' Scores are added to the system.

#### 3.4.1 Normal Scenario

1. Customer selects YES, the list of players is displayed.
2. Customer selects a player and enters a score.
3. Repeated until all desired entries completed. (completion indicated with DONE button)

### 3.5 calculateCostAccordingToDate

- *Requirements: The bill needed to be paid by each customer and the instructions of how to pay the bill are shown by the system.
- *Pre-conditions: Customers are checking out a lane.
- *Post-conditions: Customer follow the instrucitons to pay bill.

#### 3.5.1 Normal Scenario

1. Customer inputs the number of ways the bill is to be split and selects PAY_BY_CREDIT_CARD. (go)
2. The system shows the cost for each part of the bill based on the VIP status of the customer who registered the lane and the duration of playing based on the date.
3. (Go to `3.6 transactionSettlement`)

#### 3.5.2 Alternate Scenario 1

1. Customer selects CANCEL and is returned to the Customer_Main_Menu

### 3.6 transactionSettlement

- *Requirements: Customers swipe their credit cards to pay the bill.
- *Pre-conditions: `3.5 calculateCostAccordingToDate` is completed.
- *Post-conditions: Bill is paid and the credits (for VIP) are added to the customer who requested the lane.

#### 3.6.1 Normal Scenario

1. Customer follows the instructions of paying bill to swipe their credits.
2. Repeat the first steps until all the bill are paid.
3. System shows "Bill are paid successfully". Customer is returned to the Main_Login_Menu.

#### 3.6.2 Exceptional event

1. Customer follows the instructions of paying bill to swipe their credits.
2. Exception occurs in the credit card scanner/ the external library of transaction processing.
3. Manager call the vendors for help or take actions for exception handling (such as pay cash).
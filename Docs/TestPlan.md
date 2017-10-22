# Test Plan


**Author**: \<Team47\>

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |
| V2      | add unit tests and some functional testings |
| V3      | add functional testings|

## 1 Testing Strategy

### 1.1 Overall strategy

#### 1.1.1 Unit Testing

*Activities : Each individual functions presented in each use cases will be tested.

*Who will perform : Developer

#### 1.1.2 Integration Testing

*Activities : Examine how individual functions interact with each other, e.g. after adding a specific customer into the system (using addCustomer function), the new added customer achieves the authority to requestLane and checkOut functions.

*Who will perform : Developer && Quality assurance

#### 1.1.3 System Testing

*Activities : Install the App on different android phones, and test all functions that required in the requirement document.

*Who will perform : All members

#### 1.1.4 Regression Testing

*Activities : We will fix bugs/defects discovered in previous testing and then rerun all the tests (Integration Testing,System Testing) again to deliver a high-quality project that fulfils all the requirements .

*Who will perform : All members


### 1.2 Test Selection

1. Developer will use JUnit framework embeded in Android studio to perform the unit testing. 

2. Developer && Quality assurance will use JUnit/Android simulator for the Integration Testing.

3. All Members will use Android simulator/( Install the App on different android phones) to perform the system testing.

4. We may use some Black-box techniques to apply on unit testing, namely Category-Partion to generate the test cases based on the requirement to test functionality and the system.  We may generate a set of test cases for each use case that described in UseCaseModel base on their unique features. 


### 1.3 Adequacy Criterion

1. We are going to go through the requirements repeatedly to make sure all expected functions are covered in the test cases.

2. We will assess the quality of our test cases by getting all members inspect and review each of them until we all are satisfied with the tests.

3. We will examine whether each of the requirements is implemented by testing the system through Android virtual machine.

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

1. Bugs and enhancement requests will be tracked by different roles at different phrase (Unit Testing, Integration Testing, System Testing and Regression Testing).

2. Besides the testing, we will inspect the code and make sure all logic flows are implemented by codes with bugs-free.

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

1. JUnit framework, which allows us to compare the expected results and actual results easily and discover bugs from the exception messages.

2. Black-box techniques to apply on unit testing, such as Category-Partion, which allows our the easily cover the logic flows of each functional units.

3. Android simulator, which allows we perform system test easily.​

## 2 Test Cases

### JUNIT testing

#### calculateCost API

| calculateCost API  |#1 |
|------------|---|
|*its purpose*|test the accuracy of calculateCost API|
|*the steps necessary to perform the test*| in junit, use assertEuals function, July 7 2016 9:00 to 19:00 |
|*the expected result*| 210|
|*the actual result (to be filled later)*|210|         
|*pass/fail information (to be filled later)*||
|*any additional information you think is relevant*||

| calculateCost API  |#2 |
|------------|---|
|*its purpose*|test the accuracy of calculateCost API|
|*the steps necessary to perform the test*| in junit, use assertEuals function, July 2 2016 10:00 to 16:00 |
|*the expected result*| 180|
|*the actual result (to be filled later)*|180|         
|*pass/fail information (to be filled later)*||
|*any additional information you think is relevant*||

| calculateCost API  |#3 |
|------------|---|
|*its purpose*|test the accuracy of calculateCost API|
|*the steps necessary to perform the test*| in junit, use assertEuals function, July 6 2016 9:30 to 21.15 |
|*the expected result*| 117.5|
|*the actual result (to be filled later)*|117.5|         
|*pass/fail information (to be filled later)*||
|*any additional information you think is relevant*||

| calculateCost API  |#4 |
|------------|---|
|*its purpose*|test the accuracy of calculateCost API|
|*the steps necessary to perform the test*| in junit, use assertEuals function, July 5 2016 9:30 to 17:30 |
|*the expected result*| 162.5|
|*the actual result (to be filled later)*|162.5|         
|*pass/fail information (to be filled later)*||
|*any additional information you think is relevant*||

| calculateCost API  |#5 |
|------------|---|
|*its purpose*|test the accuracy of calculateCost API|
|*the steps necessary to perform the test*| in junit, use assertEuals function, July 5 2016 9:30 to 19:30, VIP member |
|*the expected result*| 146.25|
|*the actual result (to be filled later)*|146.25|         
|*pass/fail information (to be filled later)*||
|*any additional information you think is relevant*||

### Integrading tests

#### Add new customer


|ADD A NEW CUSTOMER  |#1 |
|------------|---|
|*its purpose*| Test whether manager can add new customer into the system.|
|*the steps necessary to perform the test*|1. Manager first login the system by click I'M THE MANAGER button. 2. Manager selects ADD A NEW CUSTOMER button on "Welcome Manager!" page. 3. Manager fills in new customer name: Jacob Gyllenhaal. email: gyllenj@gatech.edu and selects ADD button. 4. review the information on screen and click OKAY button.  |
|*the expected result*| 1. Manager is returned to "Welcome Manager!" page  2. Customer card is printed automatically. 3. Customer information is added into system.|
|*the actual result*|As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*|N/A|


|ADD A NEW CUSTOMER  |#2 |
|------------|---|
|*its purpose*| Test whether manager can add new customer without email address.|
|*the steps necessary to perform the test*|1. Manager first login the system by click I'M THE MANAGER button. 2. Manager selects ADD A NEW CUSTOMER button on "Welcome Manager!" page. 3. Manager fills in new customer name: Anne Hatheway and selects ADD button. 4. review the information on screen and click OKAY button.  |
|*the expected result*| 1. System notices the manager to fillin the missing email address|
|*the actual result*|As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*|N/A|

|ADD A NEW CUSTOMER  |#3 |
|------------|---|
|*its purpose*| Test whether manager can add new customer without name.|
|*the steps necessary to perform the test*|1. Manager first login the system by click I'M THE MANAGER button. 2. Manager selects ADD A NEW CUSTOMER button on "Welcome Manager!" page. 3. Manager fills in new customer email address: hatheway@gatech.edu and selects ADD button. 4. review the information on screen and click OKAY button.  |
|*the expected result*| 1. System notices the manager to fillin the missing name|
|*the actual result*|As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*|N/A|

|ADD A NEW CUSTOMER |#4 |
|------------|---|
|*its purpose*| Test whether manager can add new customer without name and email address.|
|*the steps necessary to perform the test*|1. Manager first login the system by click I'M THE MANAGER button. 2. Manager selects ADD A NEW CUSTOMER button on "Welcome Manager!" page. 3. Manager selects ADD button.  |
|*the expected result*| 1. No response, system should wait for name and email address information|
|*the actual result*|As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*|N/A|

|ADD A NEW CUSTOMER |#5 |
|------------|---|
|*its purpose*| Test whether manager can add a duplicated customers (with same name and email address).|
|*the steps necessary to perform the test*|1. Manager first login the system by click I'M THE MANAGER button. 2. Manager selects ADD A NEW CUSTOMER button on "Welcome Manager!" page. 3. Manager fills in new customer name: Jacob Gyllenhaal. email: gyllenj@gatech.edu and selects ADD button. 4. review the information on screen and click OKAY button.  |
|*the expected result*| 1. System notices the manager same customer has already been added|
|*the actual result*|As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*|N/A|

| ADD A NEW CUSTOMER |#6 |
|------------|---|
|*its purpose*| Test the exit function.|
|*the steps necessary to perform the test*|1. Manager selects ADD A NEW CUSTOMER button on Manager_Main_Menu, 2. Manager selects CANCEL button.  |
|*the expected result*| Manager is returned to "Welcome Manager!" page  |
|*the actual result*| As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||




#### Edit customer information
 
|EDIT A CUSROMER'S INFORMATION  |#1 |
|------------|---|
|*its purpose*|test whether Manager can update customer's email address|
|*the steps necessary to perform the test*| 1. Manager selects EDIT A CUSROMER'S INFORMATION on "Welcome Manager!" page. 2. In the pull down list, select the customer that you want to edit."000b, Jacob Gyllenhall, gyllenj@gatech.edu", and clicks NEXT  3. Manager updates the email address to gyllenj2@gateh.edu, and clicks SAVE. 4. Information shown on screen, and click OKAY. |
|*the expected result*| 1. Manager is returned to "Welcome Manager!" page. 2. Customer's email has been updated, as shown in a pull down list in EDIT A CUSTOMER'S INFORMATION PAGE. |
|*the actual result*|1. Manager is returned to "Welcome Manager!" page. 2. Customer email has been updated to gyllenj2@gateh.edu, as shown in a pull down list in EDIT A CUSTOMER'S INFORMATION PAGE. |         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||

|EDIT A CUSROMER'S INFORMATION  |#2 |
|------------|---|
|*its purpose*|test whether Manager can update customer's name, e.g. add a middle name|
|*the steps necessary to perform the test*| 1. Manager selects EDIT A CUSROMER'S INFORMATION on "Welcome Manager!" page. 2. In the pull down list, select the customer that you want to edit."0004, gu xiaodong, john@smith.com", and clicks NEXT  3. Manager updates the name to gu sheldon xiaodong, and clicks SAVE. 4. Information shown on screen, and click OKAY. |
|*the expected result*| 1. Manager is returned to "Welcome Manager!" page. 2. Customer's name has been updated, as shown in a pull down list in EDIT A CUSTOMER'S INFORMATION PAGE. |
|*the actual result*|1. Manager is returned to "Welcome Manager!" page. 2. Customer name has been updated to gu sheldon xiaodong, as shown in a pull down list in EDIT A CUSTOMER'S INFORMATION PAGE. |         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||




#### Print a customer card

|PRINT A CUSTOMER CARD  |#1 |
|------------|---|
|*its purpose*|test whether Manager can print a cusomerCard for a customer|
|*the steps necessary to perform the test*| 1. Manager selects PRINT A CUSTOMER CARD on "Welcome Manager!" page. 2. In the pull down list, select the customer that you want to print a card for."0004, gu xiaodong, john@smith.com", and clicks NEXT. 3. check information on screen, and click PRINT button. 4. click DONE |
|*the expected result*| 1. Manager is returned to "Welcome Manager!" page. 2. A card is printing out for customer.|
|*the actual result*|1. Manager is returned to "Welcome Manager!" page. 2. Customer card is printed out, as shown in logcat: System.out: ##################printCard called##########################|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||




#### Request a lane
 
|REQUEST A LANE  |#1 |
|------------|---|
|*its purpose*|test whether customer can request a lane|
|*the steps necessary to perform the test*| 1. Customer selects I'M A CUSTOMER button on Main_Login_Menu. GUI displays REQUEST A LANE button, LANE CHECKOUT button, and VIEW MY INFORMATION AND SCORES button, 2. Customer selects REQUEST A LANE. 3. Customer is asked to SCAN card, clicks SCAN and REQUEST LANE 4. Fill player number, click SCAN THE CUSTOMERS' CARD TO PLAY.  |
|*the expected result*|1. Scan customer card should return his ID. 2. Scan all players ID. 3. Open a new lane for customers |
|*the actual result *|1. Scan customer card return the message:"Customer: 000b is scaned, plaes request a lane". 2. Players ID are scaned, and a new lane has been opened as revealed by VIEW LANE INFORMATION button, which show a message with all information. |         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|REQUEST A LANE  |#2 |
|------------|---|
|*its purpose*|test whether customer can request a lane withou scan his card|
|*the steps necessary to perform the test*| 1. Customer selects I'M A CUSTOMER button on Main_Login_Menu. GUI displays REQUEST A LANE button, LANE CHECKOUT button, and VIEW MY INFORMATION AND SCORES button, 2. Customer selects REQUEST A LANE. 3. Customer is asked to SCAN card, but customer directly clicks the button REQUEST LANE |
|*the expected result*|Syetem reminds the customer to scan card. |
|*the actual result *|As expected |         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||

|REQUEST A LANE  |#3 |
|------------|---|
|*its purpose*|test whether customer can request a lane without fillin players' number|
|*the steps necessary to perform the test*| 1. Customer selects I'M A CUSTOMER button on Main_Login_Menu. GUI displays REQUEST A LANE button, LANE CHECKOUT button, and VIEW MY INFORMATION AND SCORES button, 2. Customer selects REQUEST A LANE. 3. Customer is asked to SCAN card, clicks SCAN and REQUEST LANE 4. directly click SCAN THE CUSTOMERS' CARD TO PLAY.  |
|*the expected result*|1. System reminds to fillin players number. |
|*the actual result *|As expected |         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|REQUEST A LANE  |#4 |
|------------|---|
|*its purpose*|test whether customer can request a lane using wrong players number|
|*the steps necessary to perform the test*| 1. Customer selects I'M A CUSTOMER button on Main_Login_Menu. GUI displays REQUEST A LANE button, LANE CHECKOUT button, and VIEW MY INFORMATION AND SCORES button, 2. Customer selects REQUEST A LANE. 3. Customer is asked to SCAN card, clicks SCAN and REQUEST LANE 4. Fill a wrong player number (0), click SCAN THE CUSTOMERS' CARD TO PLAY.  |
|*the expected result*|System reminds to fillin a valid number (>=1). |
|*the actual result *|As expected |         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||




#### LANE CHECKOUT

|LANE CHECKOUT  |#1 |
|------------|---|
|*its purpose*|test whetehr customer can checkout a lane|
|*the steps necessary to perform the test*| 1. Customer selects I'M A CUSTOMER button on Main_Login_Menu. GUI displays REQUEST A LANE button, LANE CHECKOUT button, and VIEW MY INFORMATION AND SCORES button, 2. Customer selects LANE CHECKOUT botton, 3. Customer enters lane number (3) in prompt, 4. System asks if any players wish to enter scores. (YES/NO) 5. Customer selects YES. 6. Customer selects a player from a pull down list and clicks SAVE. 7. Fillin scores and click SAVE 8. Repeated step 6 until all desired entries completed, then clicks DONE. 9. System asks how many ways to split bill? 10. Customer selects PAY BY CREDIT CARD button. 11. CLICK TO SWIPE CREDIT CARD 12. OKAY to return Main_Login_Menu.|
|*the expected result*| 1.the list of players is displayed. 2. Split of Bill is displayed and customer with PAY_WITH_CARD button. 3. System prompts Customer to follow instructions on card reader. 4.Customer is returned to Main_Login_Menu.|
|*the actual result*|As expected|         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|LANE CHECKOUT  |#2 |
|------------|---|
|*its purpose*|test whetehr customer can checkout a wrong lane|
|*the steps necessary to perform the test*| Same as the previous steps, except input a wrong lane number 100|
|*the expected result*| System reminds that no such lane exists |
|*the actual result*|As expected|         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|LANE CHECKOUT  |#3 |
|------------|---|
|*its purpose*|test whetehr customer can checkout without lane number|
|*the steps necessary to perform the test*| Same as the previous steps, except without a lane number and directly clicks CONTINUE.|
|*the expected result*| System reminds to fillin a lane number |
|*the actual result*|As expected|         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|LANE CHECKOUT  |#4 |
|------------|---|
|*its purpose*|test whetehr customer can pay without a split number|
|*the steps necessary to perform the test*| Same as the previous steps, except without a split bill number.|
|*the expected result*| System reminds how to split the bill |
|*the actual result*|As expected|         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||

|LANE CHECKOUT  |#5 |
|------------|---|
|*its purpose*|test whetehr customer can split the bill more than player number|
|*the steps necessary to perform the test*| Same as the previous steps, except in put a large split number.|
|*the expected result*| System reminds the number of players (e.g. 100) |
|*the actual result*|As expected|         
|*pass/fail information *|Pass|
|*any additional information you think is relevant*||



#### View my information and scores

|VIEW MY INFORMATION AND SCORES  |#1 |
|------------|---|
|*its purpose*|test whether customer can check his score|
|*the steps necessary to perform the test*|1. Customer selects CUSTOMER button on Main_Login_Menu.  2. Customer selects view my information and scores 3. Customer is prompted to scan card.  |
|*the expected result*| After scan customerCard, customer should see his list of scores |
|*the actual result*| As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||

|VIEW MY INFORMATION AND SCORES  |#2 |
|------------|---|
|*its purpose*|test whether customer can check his score histroy (multiple records)|
|*the steps necessary to perform the test*|1. Customer selects CUSTOMER button on Main_Login_Menu.  2. Customer selects view my information and scores 3. Customer is prompted to scan card.  |
|*the expected result*| After scan customerCard, customer should see his list of scores |
|*the actual result*| As expected|         
|*pass/fail information*|Pass|
|*any additional information you think is relevant*||



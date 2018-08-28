# ATM-Simulator-System
ATM Simulator System with enhancement like Opening Banking Account, Pin Change, Email Alerts

User Guide
ATM Simulator System
GitHub Link: https://github.com/abhikarmaker/ATM-Simulator-System

Database: 
DB Name: atmsystem
MySQL has been used. 
If it doesn’t work, create a database name ‘atmsystem’, and copy all the SQL queries from the atmsystem database and run under the database.

Also assign the libraries 
mysql-connector-java-5.1 45-bin.jar
activation.-2.2.1.jar
mail.jar
itextpdf-5.5.4.jar
jfoenix.jar

Process of using the Software:
1>	Login Page will open once application is started.

2>	If you have already created your Account, Please Login with your Card Number and Pin Number. or else Click on the Sign-Up button, Registration Page will open. There are three pages of Application Registration. Input all your details in three of the pages and submit the form. 

You will be asked to send email to your registered email address.

Click on send. You will receive email with your credentials Card Number and Pin Number.

3>	Now Click on Login > Here, input your credentials, Transaction Page will open.

4>	Transaction Page has 6 Modules >

•	Deposit > Click on Deposit button to deposit a certain amount, once deposited email will be sent to you and Thank You page will open where you will be asked to “Do you want to make another transaction?”, If yes it will revert to Transaction Page or else No to Login Page.

•	Withdrawal > Click on Withdrawal button to withdraw certain amount not more than $500 and must be in multiples of $20, $50 or $100 (Validated). Once withdrawn, email will be sent to you and Thank You page will open where you will be asked to “Do you want to make another transaction?”, If yes it will revert to Transaction Page or else No to Login Page.

•	Fast Cash > Click on Fast Cash button to withdraw exact amount of money such as $50, $100, $200 etc. buttons are already provided. Click the amount which you want to withdraw. Once withdrawn, email will be sent to you and Thank You page will open where you will be asked to “Do you want to make another transaction?”, If yes it will revert to Transaction Page or else No to Login Page.

•	Mini Statement > Click on Mini Statement > Where you will see Display button to show your transactions and If you click on Statement a pdf will generate and sent to your email (This has not been implemented yet). Once Statement is done you will be asked to “Do you want to make another transaction?”, If yes it will revert to Transaction Page or else No to Login Page.

•	Pin Change > Click on Pin Change, you will be asked to enter your old pin with new pin and you need to confirm the new pin, If you click on change, Pin will be changed as well as you will get an email and where you will be asked to “Do you want to make another transaction?”, If yes it will revert to Transaction Page or else No to Login Page..

•	Balance Inquiry > Click on Balance Inquiry, you can view the available balance in your account.

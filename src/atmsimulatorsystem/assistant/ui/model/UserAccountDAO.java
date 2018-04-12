package atmsimulatorsystem.assistant.ui.model;

import atmsimulatorsystem.assistant.Database.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>,
 * PRIYANKA MODI <C0717925>
 */
public class UserAccountDAO {

    /**
     *
     * @return @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObservableList<UserAccount> searchUser() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM USERACCOUNTS";

        try {
            ResultSet rsUsers = DatabaseHandler.dbExecuteQuery(selectStmt);
            ObservableList<UserAccount> userList = getUserList(rsUsers);
            return userList;
        } catch (SQLException ex) {
            System.out.println("Sql select operation has been failed " + ex);
            throw ex;
        }
    }

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private static ObservableList<UserAccount> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Users objects
        ObservableList<UserAccount> userList = FXCollections.observableArrayList();

        while (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUser_id(rs.getInt("User_id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setMiddle_name(rs.getString("middle_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setFather_name(rs.getString("father_name"));
            user.setGender(rs.getString("gender"));
            user.setEmail_address(rs.getString("email_address"));
            user.setMarital_status(rs.getString("marital_status"));
            user.setAddress(rs.getString("address"));
            user.setCity(rs.getString("city"));
            user.setPin_code(rs.getString("pin_code"));
            user.setState(rs.getString("state"));

            user.setRandomNumber(rs.getString("randomNumber"));
            user.setPinNumber(rs.getString("pinNumber"));

            user.setAccountNumber(rs.getString("account_number"));
            //Add user to the ObservableList
            userList.add(user);
        }
        //return userList (ObservableList of Users)
        return userList;
    }

    /**
     *
     * @param fname
     * @param mname
     * @param lname
     * @param faname
     * @param dob
     * @param gender
     * @param email
     * @param marital
     * @param address
     * @param city
     * @param pincode
     * @param state
     * @param religion
     * @param income
     * @param education
     * @param occupation
     * @param sinNumber
     * @param status
     * @param existingAcc
     * @param accountType
     * @param randomNumber
     * @param pinNumber
     * @param accountNumber
     * @param service_request
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void insertUser(String fname, String mname, String lname,
            String faname, LocalDate dob, String gender, String email, String marital,
            String address, String city, String pincode, String state,
            String religion, String income, String education, String occupation,
            String sinNumber, String status, String existingAcc,
            String accountType, String randomNumber,
            String pinNumber, String accountNumber, String service_request) throws SQLException, ClassNotFoundException {

        //Execute INSERT operation
        String updateStmt = "INSERT INTO USERACCOUNTS(first_name,middle_name,last_name,"
                + "father_name, dateofBirth, gender,email_address,marital_status,address,"
                + "city,pin_code,state,religion,income,"
                + "education_qualification, occupation, sin_number,status,"
                + "existing_account,account_type,randomNumber, pinNumber,account_number, service_request) VALUES ("
                + "'" + fname + "',"
                + "'" + mname + "',"
                + "'" + lname + "',"
                + "'" + faname + "',"
                + "'" + dob + "',"
                + "'" + gender + "',"
                + "'" + email + "',"
                + "'" + marital + "',"
                + "'" + address + "',"
                + "'" + city + "',"
                + "'" + pincode + "',"
                + "'" + state + "',"
                + "'" + religion + "',"
                + "'" + income + "',"
                + "'" + education + "',"
                + "'" + occupation + "',"
                + "'" + sinNumber + "',"
                + "'" + status + "',"
                + "'" + existingAcc + "',"
                + "'" + accountType + "',"
                + "'" + randomNumber + "',"
                + "'" + pinNumber + "',"
                + "'" + accountNumber + "',"
                + "'" + service_request + "'"
                + ")";

        try {
            DatabaseHandler.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while Insert Operation: " + e);
            throw e;
        }
    }

    /**
     *
     * @param cardNumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    //Login Form Calling
    public static UserAccount searchUser(String cardNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM USERACCOUNTS WHERE randomNumber=" + cardNumber;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get user object
            UserAccount user = getUserFromResultSet(rsUser);

            //Return employee object
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + cardNumber
                    + " card number, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    /**
     * 
     * @param accountNumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    //Email Access Form Calling
    public static UserAccount searchUserWithAccountNumber(String accountNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM USERACCOUNTS WHERE account_number=" + accountNumber;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get user object
            UserAccount user = getUserFromResultSet(rsUser);

            //Return user object
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an user with " + accountNumber
                    + " account number, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    /**
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public static UserAccount getUserFromResultSet(ResultSet rs) throws SQLException {
        UserAccount user = new UserAccount();
        if (rs.next()) {
            user.setRandomNumber(rs.getString("randomNumber"));
            user.setPinNumber(rs.getString("pinNumber"));
            user.setEmail_address(rs.getString("email_address"));
            user.setAccountNumber(rs.getString("account_number"));
            user.setFirst_name(rs.getString("first_name"));
            user.setMiddle_name(rs.getString("middle_name"));
            user.setLast_name(rs.getString("last_name"));
        }
        return user;
    }

    /**
     * 
     * @param accountNumber
     * @param pinNumber
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    //*************************************
    //UPDATE an User's Pin Number
    //*************************************
    public static void updateUserPin(String accountNumber, String pinNumber) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt
                = "   UPDATE USERACCOUNTS\n"
                + "      SET pinNumber = '" + pinNumber + "'\n"
                + "    WHERE account_number = " + accountNumber + ";";

        //Execute UPDATE operation
        try {
            DatabaseHandler.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}

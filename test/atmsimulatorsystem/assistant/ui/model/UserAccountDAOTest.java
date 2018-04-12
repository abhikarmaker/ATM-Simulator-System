/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class UserAccountDAOTest {

    public UserAccountDAOTest() {
    }

//    /**
//     * Test of searchUser method, of class UserAccountDAO.
//     */
//    @Test
//    public void testSearchUser_0args() throws Exception {
//        System.out.println("searchUser");
//        ObservableList<UserAccount> expResult = null;
//        ObservableList<UserAccount> result = UserAccountDAO.searchUser();
//        
//        assertEquals(expResult, result);
//    }
    
    
    /**
     * Test of insertUser method, of class UserAccountDAO.
     */
    @Test
    public void testInsertUser() throws Exception {
        Random r = new Random();
        String branchNumber = "002";
        String transitNumber = "84248";
        String creatingAccountNumber = String.format("%06d", (Object) r.nextInt(100001));
        
        System.out.println("insertUser");
        String fname = "Abhijeet";
        String mname = "";
        String lname = "Karmaker";
        String faname = "Jadab Lal Karmaker";
        LocalDate dob = LocalDate.of(2018, Month.APRIL, 01);
        String gender = "Male";
        String email = "abhijeet.karmaker@yahoo.com";
        String marital = "Single";
        String address = "755 Roger Street";
        String city = "Sarnia";
        String pincode = "N7S2S8";
        String state = "ON";
        String religion = "Hindu";
        String income = "$20,000";
        String education = "Graduation";
        String occupation = "Student";
        String sinNumber = String.format("%09d", (Object) r.nextInt(100001));
        String status = "Non Immigrant";
        String existingAcc = "Yes";
        String accountType = "Saving Account";
        String randomNumber = "1460606673887053";
        String pinNumber = "123456";
        String accountNumber = transitNumber + branchNumber
                + creatingAccountNumber;
        String service_request = "ATM CARD";
        UserAccountDAO.insertUser(fname, mname, lname, faname, dob, gender, email, marital, address, city, pincode, state, religion, income, education, occupation, sinNumber, status, existingAcc, accountType, randomNumber, pinNumber, accountNumber, service_request);
    }

    /**
     * Test of searchUser method, of class UserAccountDAO.
     */
    @Test
    public void testSearchUser_String() throws Exception {
        System.out.println("searchUser");
        String cardNumber = null;
        String expResult = null;
        UserAccount result = UserAccountDAO.searchUser(cardNumber);
        assertEquals(expResult, result.getRandomNumber());
    }

    /**
     * Test of searchUserWithAccountNumber method, of class UserAccountDAO.
     */
    @Test
    public void testSearchUserWithAccountNumber() throws Exception {
        System.out.println("searchUserWithAccountNumber");
        String accountNumber = null;
        UserAccount expResult = null;
        UserAccount result = UserAccountDAO.searchUserWithAccountNumber(accountNumber);
        assertEquals(expResult, result.getAccountNumber());
    }

//    /**
//     * Test of getUserFromResultSet method, of class UserAccountDAO.
//     */
//    @Test
//    public void testGetUserFromResultSet() throws Exception {
//        System.out.println("getUserFromResultSet");
//        ResultSet rs = null;
//        UserAccount expResult = null;
//        UserAccount result = UserAccountDAO.getUserFromResultSet(rs);
//        if(rs.next()){
//            result.getRandomNumber();
//            result.getPinNumber();
//            result.getEmail_address();
//            result.getAccountNumber();
//            result.getFirst_name();
//            result.getMiddle_name();
//            result.getLast_name();
//            
//        }
//        assertEquals(expResult, result);
//    }
    /**
     * Test of updateUserPin method, of class UserAccountDAO.
     */
    @Test
    public void testUpdateUserPin() throws Exception {
        System.out.println("updateUserPin");
        String accountNumber = "84248002046964";
        String pinNumber = "123456";
        UserAccountDAO.updateUserPin(accountNumber, pinNumber);
    }

}

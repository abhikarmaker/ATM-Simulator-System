/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class UserTransactionsDAOTest {
    
    public UserTransactionsDAOTest() {
    }

    /**
     * Test of searchUser method, of class UserTransactionsDAO.
     */
//    @Test
//    public void testSearchUser() throws Exception {
//        System.out.println("searchUser");
//        ObservableList<UserTransactions> expResult = null;
//        ObservableList<UserTransactions> result = UserTransactionsDAO.searchUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchUserForTransactionDetails method, of class UserTransactionsDAO.
     */
    @Test
    public void testSearchUserForTransactionDetails() throws Exception {
        System.out.println("searchUserForTransactionDetails");
        String accountNumber = null;
        UserTransactions expResult = null;
        UserTransactions result = UserTransactionsDAO.searchUserForTransactionDetails(accountNumber);
        assertEquals(expResult, result.getAccountNumber());
    }

    /**
     * Test of getUserFromResultSet method, of class UserTransactionsDAO.
     */
//    @Test
//    public void testGetUserFromResultSet() throws Exception {
//        System.out.println("getUserFromResultSet");
//        ResultSet rs = null;
//        UserTransactions expResult = null;
//        UserTransactions result = UserTransactionsDAO.getUserFromResultSet(rs);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertDepositAmount method, of class UserTransactionsDAO.
     */
    @Test
    public void testInsertDepositAmount() throws Exception {
        System.out.println("insertDepositAmount");
        String accountNumber = "84248002046963";
        double balance = 100.0;
        double deposit = 100.0;
        String date = "2018-04-01 00:00:00";
        UserTransactionsDAO.insertDepositAmount(accountNumber, balance, deposit, date);
    }

    /**
     * Test of insertWithdrawlAmount method, of class UserTransactionsDAO.
     */
    @Test
    public void testInsertWithdrawlAmount() throws Exception {
        System.out.println("insertWithdrawlAmount");
        String accountNumber = "84248002046963";
        double balance = 100.0;
        double withdraw = 50.0;
        String date = "2018-04-01 00:00:00";
        UserTransactionsDAO.insertWithdrawlAmount(accountNumber, balance, withdraw, date);
    }

    /**
     * Test of searchUserForMiniStatementData method, of class UserTransactionsDAO.
     */
    @Test
    public void testSearchUserForMiniStatementData() throws Exception {
        System.out.println("searchUserForMiniStatementData");
        String accountNumber = null;
        UserTransactions expResult = null;
        UserTransactions result = UserTransactionsDAO.searchUserForMiniStatementData(accountNumber);
        assertEquals(expResult, result.getAccountNumber());
    }

    /**
     * Test of getUserDataFromResultSet method, of class UserTransactionsDAO.
     */
//    @Test
//    public void testGetUserDataFromResultSet() throws Exception {
//        System.out.println("getUserDataFromResultSet");
//        ResultSet rs = null;
//        UserTransactions expResult = null;
//        UserTransactions result = UserTransactionsDAO.getUserDataFromResultSet(rs);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchUserForTransactionDetailsEmail method, of class UserTransactionsDAO.
     */
    @Test
    public void testSearchUserForTransactionDetailsEmail() throws Exception {
        System.out.println("searchUserForTransactionDetailsEmail");
        String accountNumber = null;
        UserTransactions expResult = null;
        UserTransactions result = UserTransactionsDAO.searchUserForTransactionDetailsEmail(accountNumber);
        assertEquals(expResult, result.getAccountNumber());
    }

    /**
     * Test of getUserFromResultSetEmail method, of class UserTransactionsDAO.
     */
//    @Test
//    public void testGetUserFromResultSetEmail() throws Exception {
//        System.out.println("getUserFromResultSetEmail");
//        ResultSet rs = null;
//        UserTransactions expResult = null;
//        UserTransactions result = UserTransactionsDAO.getUserFromResultSetEmail(rs);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

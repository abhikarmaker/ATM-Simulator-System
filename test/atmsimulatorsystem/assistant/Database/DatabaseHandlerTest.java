/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.Database;

import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class DatabaseHandlerTest {
    
    public DatabaseHandlerTest() {
    }
    
    /**
     * Test of dbConnect method, of class DatabaseHandler.
     */
    @Test
    public void testDbConnect() throws Exception {
        System.out.println("dbConnect");
        DatabaseHandler.dbConnect();
    }

    /**
     * Test of dbDisconnect method, of class DatabaseHandler.
     */
    @Test
    public void testDbDisconnect() throws Exception {
        System.out.println("dbDisconnect");
        DatabaseHandler.dbDisconnect();
    }

    /**
     * Test of dbExecuteQuery method, of class DatabaseHandler.
     */
//    @Test
//    public void testDbExecuteQuery() throws Exception {
//        System.out.println("dbExecuteQuery");
//        String queryStmt = null;
//        String accountNumber = "84248002046968";
//        ResultSet expResult = null;
//        UserAccount user = UserAccountDAO.searchUserWithAccountNumber(accountNumber);
//        user.getAccountNumber();
//        queryStmt = "Select * from USERACCOUNTS where account_number = "+user.getAccountNumber();
//        ResultSet result = DatabaseHandler.dbExecuteQuery(queryStmt);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of dbExecuteUpdate method, of class DatabaseHandler.
//     */
//    @Test
//    public void testDbExecuteUpdate() throws Exception {
//        System.out.println("dbExecuteUpdate");
//        String sqlStmt = "";
//        DatabaseHandler.dbExecuteUpdate(sqlStmt);
//    }   
}

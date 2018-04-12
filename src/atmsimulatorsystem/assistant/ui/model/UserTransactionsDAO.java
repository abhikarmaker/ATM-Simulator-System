package atmsimulatorsystem.assistant.ui.model;

import atmsimulatorsystem.assistant.Database.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class UserTransactionsDAO {

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static ObservableList<UserTransactions> searchUser() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM TRANSACTIONS";

        try {
            ResultSet rsUsers = DatabaseHandler.dbExecuteQuery(selectStmt);
            ObservableList<UserTransactions> userList = getUserList(rsUsers);
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
    private static ObservableList<UserTransactions> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of UserTransactions objects
        ObservableList<UserTransactions> userList = FXCollections.observableArrayList();

        while (rs.next()) {
            UserTransactions user = new UserTransactions();
            user.setTransaction_id(rs.getInt("transaction_id"));
            user.setAccountNumber(rs.getString("account_number"));
            user.setBalance(rs.getDouble("balance"));
            user.setDeposit(rs.getDouble("deposit"));
            user.setWithdrawl(rs.getDouble("withdrwal"));
            user.setDate(rs.getDate("date"));
            //Add users to the ObservableList
            userList.add(user);
        }
        //return userList (ObservableList of Users)
        return userList;
    }

    /**
     * 
     * @param accountNumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static UserTransactions searchUserForTransactionDetails(String accountNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt
                = "SELECT t.account_number, t.balance, u.first_name "
                + " FROM TRANSACTIONS t "
                + " JOIN USERACCOUNTS u"
                + " ON u.account_number = t.account_number"
                + " WHERE t.account_number= " + accountNumber;
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get user object
            UserTransactions user = getUserFromResultSet(rsUser);

            //Return user object
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an user with " + accountNumber + " account number, an error occurred: " + e);
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
    public static UserTransactions getUserFromResultSet(ResultSet rs) throws SQLException {
        UserTransactions user = new UserTransactions();
        rs.afterLast();
        if (rs.previous()) {
            user.setAccountNumber(rs.getString("account_number"));
            user.setFirst_name(rs.getString("first_name"));
            user.setBalance(rs.getDouble("balance"));
        }
        return user;
    }
    
    /**
     * 
     * @param accountNumber
     * @param balance
     * @param deposit
     * @param date
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void insertDepositAmount(String accountNumber, double balance, double deposit, String date) throws ClassNotFoundException, SQLException{
        String updateStmt = "INSERT INTO TRANSACTIONS(account_number, balance, deposit, date) VALUES ("
                + "'" + accountNumber + "',"
                + "'" + balance + "',"
                + "'" + deposit + "',"
                + "'" + date + "'"
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
     * @param accountNumber
     * @param balance
     * @param withdraw
     * @param date
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void insertWithdrawlAmount(String accountNumber, double balance, double withdraw, String date) throws ClassNotFoundException, SQLException{
        String updateStmt = "INSERT INTO TRANSACTIONS(account_number, balance, withdrawl, date) VALUES ("
                + "'" + accountNumber + "',"
                + "'" + balance + "',"
                + "'" + withdraw + "',"
                + "'" + date + "'"
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
     * @param accountNumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static UserTransactions searchUserForMiniStatementData(String accountNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt
                = "SELECT t.account_number, t.balance, t.deposit, t.withdrawl, t.date, u.first_name"
                + " FROM TRANSACTIONS t "
                + " JOIN USERACCOUNTS u"
                + " ON u.account_number = t.account_number"
                + " WHERE t.account_number= " + accountNumber;
                //+ " ORDER BY t.transaction_id desc limit 10";
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get user Transaction object
            UserTransactions user = getUserDataFromResultSet(rsUser);

            //Return user Transaction object
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
    public static UserTransactions getUserDataFromResultSet(ResultSet rs) throws SQLException {
        UserTransactions user = new UserTransactions();
        while (rs.next()) {
            user.setAccountNumber(rs.getString("account_number"));
            user.setDate(rs.getDate("date"));
            user.setDeposit(rs.getDouble("deposit"));
            user.setWithdrawl(rs.getDouble("withdrawl"));
            user.setBalance(rs.getDouble("balance"));
            user.setFirst_name(rs.getString("first_name"));
        }
        return user;
    }
    
    /**
     * 
     * @param accountNumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static UserTransactions searchUserForTransactionDetailsEmail(String accountNumber) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt
                = "SELECT t.account_number, u.email_address, t.deposit, t.withdrawl, t.balance, u.first_name "
                + " FROM TRANSACTIONS t "
                + " JOIN USERACCOUNTS u"
                + " ON u.account_number = t.account_number"
                + " WHERE t.account_number= " + accountNumber;
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getUserFromResultSet method and get user object
            UserTransactions user = getUserFromResultSetEmail(rsUser);

            //Return employee object
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an user with " + accountNumber + " account number, an error occurred: " + e);
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
    public static UserTransactions getUserFromResultSetEmail(ResultSet rs) throws SQLException {
        UserTransactions user = new UserTransactions();
        rs.afterLast();
        if (rs.previous()) {
            user.setAccountNumber(rs.getString("account_number"));
            user.setFirst_name(rs.getString("first_name"));
            user.setBalance(rs.getDouble("balance"));
            user.setEmail(rs.getString("email_address"));
            user.setDeposit(rs.getDouble("deposit"));
            user.setWithdrawl(rs.getDouble("withdrawl"));
        }
        return user;
    }
}

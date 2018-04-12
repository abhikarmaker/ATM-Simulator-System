package atmsimulatorsystem.assistant.ui.model;

import java.util.Date;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class UserTransactions {

    private int transaction_id;
    private String accountNumber;
    private double balance;
    private double deposit;
    private double withdrawl;
    private String first_name;
    private Date date;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTransactions(double balance, double deposit, double withdrawl, Date date) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawl = withdrawl;
        this.date = date;
    }

    public UserTransactions() {
        this.transaction_id = transaction_id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawl = withdrawl;
        this.first_name = first_name;
        this.date = date;
        this.email = email;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int user_id) {
        this.transaction_id = user_id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawl() {
        return withdrawl;
    }

    public void setWithdrawl(double withdrawl) {
        this.withdrawl = withdrawl;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}

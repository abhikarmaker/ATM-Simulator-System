/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.Transaction;

import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserTransactions;
import atmsimulatorsystem.assistant.ui.model.UserTransactionsDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TransactionController implements Initializable {

    @FXML
    private Button btnDeposit;
    @FXML
    private Button btnCashWithdrawal;
    @FXML
    private Button btnFastCash;
    @FXML
    private Button btnMiniStatement;
    @FXML
    private Button btnPinChange;
    @FXML
    private Button btnBalanceEnquiry;
    @FXML
    private Button btnExit;
    @FXML
    private Label lblAccountNumber;
    @FXML
    private Label lblName;
    
    UserAccount user = new UserAccount();
    UserTransactions userTran = new UserTransactions();
    @FXML
    private AnchorPane root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void depositButtonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/Transaction/Deposit.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            DepositController controller = loader.<DepositController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void cashWithdrawalButtonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/Transaction/Withdrawl.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            WithdrawlController controller = loader.<WithdrawlController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void fastCashButtonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/Transaction/FastCash.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            FastCashController controller = loader.<FastCashController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void miniStatementButttonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            userTran.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/Transaction/MiniStatement.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            MiniStatementController controller = loader.<MiniStatementController>getController();
            controller.setText(userTran);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void pinChangeButtonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/Transaction/PinChange.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            PinChangeController controller = loader.<PinChangeController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void balanceEnquiryButtonAction(ActionEvent event) {
        try {
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            //Setting values from Transactions table to balance Enquiry
            UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
                userData.add(userTran);
                userTran.setBalance(userTran.getBalance());
                userTran.setFirst_name(userTran.getFirst_name());
                
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/"
                    + "assistant/ui/Transaction/BalanceEnquiry.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            BalanceEnquiryController controller = loader.<BalanceEnquiryController>getController();
            controller.setText(userTran);
            controller.setTextAccount(user);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/Login/Login.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setText(UserAccount user) {
        String accountNumber = user.getAccountNumber();
        this.lblAccountNumber.setText(accountNumber);
        String fname = user.getFirst_name();
        String mname = user.getMiddle_name();
        String lname = user.getLast_name();
        this.lblName.setText(fname + " " + mname + " " + lname);
    }
}

package atmsimulatorsystem.assistant.ui.Transaction;

import atmsimulatorsystem.assistant.ui.ThankYouPage.ThankYouPageController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import atmsimulatorsystem.assistant.ui.model.UserTransactions;
import atmsimulatorsystem.assistant.ui.model.UserTransactionsDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class FastCashController implements Initializable {

    @FXML
    private Label lblAccountNumber;
    @FXML
    private Button btnExit;
    @FXML
    private Button btn50;
    @FXML
    private Button btn100;
    @FXML
    private Button btn200;
    @FXML
    private Button btn500;
    @FXML
    private Button btn400;
    @FXML
    private Button btn300;

    UserAccount user = new UserAccount();
    @FXML
    private AnchorPane root;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/Transaction/Transaction.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Transactions");
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            UserAccount user = UserAccountDAO.searchUserWithAccountNumber(lblAccountNumber.getText());
            ObservableList<UserAccount> userData = FXCollections.observableArrayList();
            userData.add(user);
            user.setFirst_name(user.getFirst_name());
            user.setMiddle_name(user.getMiddle_name());
            user.setLast_name(user.getLast_name());

            TransactionController controller = loader.<TransactionController>getController();
            controller.setText(user);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void fiftyButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 50;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 50 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $50.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    @FXML
    private void hundredButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 100;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 20 != 0 && withdraw % 50 != 0 && withdraw % 100 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $20, $50 or $100.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    @FXML
    private void twohundredButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 200;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 20 != 0 && withdraw % 50 != 0 && withdraw % 100 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $20, $50 or $100.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    @FXML
    private void fivehundredButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 500;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 20 != 0 && withdraw % 50 != 0 && withdraw % 100 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $20, $50 or $100.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    @FXML
    private void fourhundredButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 400;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 20 != 0 && withdraw % 50 != 0 && withdraw % 100 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $20, $50 or $100.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    @FXML
    private void threehundredButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserTransactions userTran = UserTransactionsDAO.searchUserForTransactionDetails(lblAccountNumber.getText());
        System.out.println(dateFormat.format(date));
        if (user != null) {
            ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
            userData.add(userTran);
            double balance = userTran.getBalance();
            double withdraw = 300;
            if (balance < withdraw) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Insufficient Fund in your Account");
                alert.showAndWait();
            } else if (withdraw % 20 != 0 && withdraw % 50 != 0 && withdraw % 100 != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("There are no denomination of $20, $50 or $100.");
                alert.showAndWait();
            } else {
                balance -= withdraw;
                UserTransactionsDAO.insertWithdrawlAmount(lblAccountNumber.getText(), balance, withdraw, dateFormat.format(date));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have successfully Withdrawed " + withdraw + " from your Account.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Unable to Form the Transaction.");
            alert.showAndWait();
        }
    }

    public void setText(UserAccount user) {
        String accountNumber = user.getAccountNumber();
        this.lblAccountNumber.setText(accountNumber);
    }

    private void emailSender() {
        try {
            UserTransactions user = UserTransactionsDAO.searchUserForTransactionDetailsEmail(lblAccountNumber.getText());
            if (user != null) {
                ObservableList<UserTransactions> userData = FXCollections.observableArrayList();
                userData.add(user);
                String accountNumberFromDB = user.getAccountNumber();
                String emailAddress = user.getEmail();
                String accountNumber = lblAccountNumber.getText();
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
                Date date = new Date();
                double debited = user.getWithdrawl();
                double balance = user.getBalance();
                if (accountNumber.equals(accountNumberFromDB)) {
                    System.out.println("Matched");
                    String host = "smtp.gmail.com";
                    String user1 = "abhijeet.karmaker@gmail.com";
                    String pass = "Arpita@92";
                    String to = emailAddress;
                    String from = "abhijeet.karmaker@gmail.com";
                    String subject = "ATM SIMULATOR SYSTEM ACCOUNT DEPOSIT DETAILS";
                    String messageText = "Your Account " + accountNumber + " Debited"
                            + " $" + debited + " on " + dateFormat.format(date) + ". Available balance is "
                            + balance;
                    boolean sessionDebug = false;

                    Properties props = System.getProperties();

                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(from));
                    InternetAddress[] address = {new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setSentDate(new Date());
                    msg.setText(messageText);

                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user1, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("Message send Successfully" + messageText);
                } else {
                    System.out.println("Account number does not match");
                }
            }
        } catch (ClassNotFoundException | SQLException | MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    private void thankYouPageLoader() {
        UserAccount user = new UserAccount();
        try {

            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/ThankYouPage/ThankYouPage.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Thank You");
            stage.show();
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            ThankYouPageController controller = loader.<ThankYouPageController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

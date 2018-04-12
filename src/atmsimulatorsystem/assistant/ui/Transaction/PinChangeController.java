package atmsimulatorsystem.assistant.ui.Transaction;

import atmsimulatorsystem.assistant.ui.ThankYouPage.ThankYouPageController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class PinChangeController implements Initializable {
    
    @FXML
    private TextField txtOldPin;
    @FXML
    private TextField txtNewPin;
    @FXML
    private TextField txtConfirmNewPin;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnChange;
    @FXML
    private AnchorPane root;
    @FXML
    private Label lblAccountNumber;
    
    UserAccount user = new UserAccount();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void changeButtonAction(ActionEvent event) {
        try {
            if (txtNewPin.getText().equals(txtConfirmNewPin.getText()) && txtNewPin.getText().length() == 6) {
                UserAccountDAO.updateUserPin(lblAccountNumber.getText(), txtNewPin.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Your Pin has been successfully changed. Check your mail.");
                alert.showAndWait();
                emailSender();
                thankYouPageLoader();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("New Pin and Confirm Pin does not match.");
                alert.showAndWait();
            }
        } catch (SQLException | ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Problem occurred while updating email: " + e);
            alert.showAndWait();
        }
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
    
    public void setText(UserAccount user) {
        String accountNumber = user.getAccountNumber();
        this.lblAccountNumber.setText(accountNumber);
    }
    
     private void emailSender() {
        try {
            UserAccount user = UserAccountDAO.searchUserWithAccountNumber(lblAccountNumber.getText());
            if (user != null) {
                ObservableList<UserAccount> userData = FXCollections.observableArrayList();
                userData.add(user);
                String accountNumberFromDB = user.getAccountNumber();
                String emailAddress = user.getEmail_address();
                String pinNumber = user.getPinNumber();
                String accountNumber = lblAccountNumber.getText();
                if (accountNumber.equals(accountNumberFromDB)) {
                    System.out.println("Matched");
                    String host = "smtp.gmail.com";
                    String user1 = "abhijeet.karmaker@gmail.com";
                    String pass = "Arpita@92";
                    String to = emailAddress;
                    String from = "abhijeet.karmaker@gmail.com";
                    String subject = "ATM SIMULATOR SYSTEM ACCOUNT OPENING CREDENTIALS";
                    String messageText = "Your Pin has successfully changed for "
                            + "the Account Number."+ accountNumber +" Your New Pin is :" + pinNumber;
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

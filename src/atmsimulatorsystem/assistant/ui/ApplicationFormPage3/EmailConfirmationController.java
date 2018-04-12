package atmsimulatorsystem.assistant.ui.ApplicationFormPage3;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class EmailConfirmationController implements Initializable {

    @FXML
    private Label lblData;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSend;
    @FXML
    private AnchorPane root;
    @FXML
    private Label lblAcc;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void sendButtonAction(ActionEvent event) {
        emailSender();
    }

    private void emailSender() {
        try {
            UserAccount user = UserAccountDAO.searchUserWithAccountNumber(lblAcc.getText());
            if (user != null) {
                ObservableList<UserAccount> userData = FXCollections.observableArrayList();
                userData.add(user);
                String cardNumber = lblData.getText();
                String accountNumberFromDB = user.getAccountNumber();
                String emailAddress = user.getEmail_address();
                String pinNumber = user.getPinNumber();
                String accountNumber = lblAcc.getText();
                String fname = user.getFirst_name();
                String mname = user.getMiddle_name();
                String lname = user.getLast_name();
                System.out.println(fname + mname + lname);
                System.out.println(accountNumberFromDB + " " + pinNumber + " "
                        + emailAddress + " " + accountNumber);
                if (accountNumber.equals(accountNumberFromDB)) {
                    System.out.println("Matched");
                    String host = "smtp.gmail.com";
                    String user1 = "abhijeet.karmaker@gmail.com";
                    String pass = "Arpita@92";
                    String to = emailAddress;
                    String from = "abhijeet.karmaker@gmail.com";
                    String subject = "ATM SIMULATOR SYSTEM ACCOUNT OPENING CREDENTIALS";
                    String messageText = "Congrats your account has been created,  "
                            + "\nYour Account Number is :" + accountNumber
                            + "\nFull Name :" + fname + " " + mname + " " + lname
                            + "\nYour Card Number is :" + cardNumber
                            + " and your pin number is :" + pinNumber;
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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Your credentials has been successfully emailed to you.");
                    alert.showAndWait();
                    System.out.println("Message send Successfully" + messageText);
                } else {
                    System.out.println("Account number does not match");
                }
            }
        } catch (ClassNotFoundException | SQLException | MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setText(UserAccount user) {
        String cardNumber = user.getRandomNumber();
        lblData.setText(cardNumber);
        String accountNumber = user.getAccountNumber();
        lblAcc.setText(accountNumber);
    }

    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }

}

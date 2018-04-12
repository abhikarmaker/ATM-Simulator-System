package atmsimulatorsystem.assistant.ui.ApplicationFormPage3;

import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>,
 * PRIYANKA MODI <C0717925>
 */
public class ApplicationFormPage3Controller implements Initializable {
    
    @FXML
    private Label lblCardNumber;
    @FXML
    private Label lblPinNumber;
    @FXML
    private CheckBox checkBoxAtmCard, checkBoxInternetBanking, checkBoxMobileBanking,
            checkBoxEmailAlerts, checkBoxAChequeBook, checkBoxEStatement, checkBoxDeclaration;
    
    ObservableList<String> checkBoxList = FXCollections.observableArrayList();
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Label lbl1, lbl8, lbl7, lbl6, lbl5, lbl4, lbl3, lbl2, lbl10, lbl11, lbl12, lbl13, lbl14,
            lbl15, lbl16, lbl17, lbl18, lbl9, lbl19, lbl20, lbl21;
    @FXML
    private AnchorPane root;
    @FXML
    private Label lblDOB, lblLastFourDigit;
    
    Random r = new Random();
    int max = 9999;
    int min = 1000;
    String randomNumber4 = String.format("%04d", (Object) r.nextInt((max - min) + 1 + min));
    String pinNum = String.format("%06d", (Object) r.nextInt((999999 - 100000) + 1 + 100000));
    String pinGenerated = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        onload();
    }
    
    private void onload() {
        lblLastFourDigit.setText(randomNumber4);
    }
    
    @FXML
    private void saveButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        try {
            String randomNumber1 = String.format("%04d", (Object) r.nextInt((max - min) + 1 + min));
            String randomNumber2 = String.format("%04d", (Object) r.nextInt((max - min) + 1 + min));
            String randomNumber3 = String.format("%04d", (Object) r.nextInt((max - min) + 1 + min));
            String cardnumber = randomNumber1 + randomNumber2 + randomNumber3 + randomNumber4;
            String branchNumber = "002";
            String transitNumber = "84248";
            String creatingAccountNumber = String.format("%06d", (Object) r.nextInt(100001));
            String accountNumber = transitNumber + branchNumber
                    + creatingAccountNumber;
            
            String fname = lbl1.getText();
            String mname = lbl2.getText();
            String lname = lbl3.getText();
            String faname = lbl4.getText();
            String maritalStatus = lbl5.getText();            
            String date = lblDOB.getText();
            LocalDate localDate = LocalDate.parse(date);
            
            String gender = lbl6.getText();
            String emailAddress = lbl7.getText();
            String address = lbl8.getText();
            String city = lbl9.getText();
            String pin = lbl10.getText();
            String state = lbl11.getText();
            String rel = lbl12.getText();
            String income = lbl13.getText();
            String edu = lbl14.getText();
            String occu = lbl15.getText();
            String sinnumber = lbl16.getText();
            String status = lbl17.getText();
            String existingaccount = lbl18.getText();
            String accounttype = lbl19.getText();
            
            String message = "";
            if (checkBoxAtmCard.isSelected()) {
                message += checkBoxAtmCard.getText() + ",";
            }
            if (checkBoxInternetBanking.isSelected()) {
                message += checkBoxInternetBanking.getText() + ",";
            }
            if (checkBoxMobileBanking.isSelected()) {
                message += checkBoxMobileBanking.getText() + ",";
            }
            if (checkBoxEmailAlerts.isSelected()) {
                message += checkBoxEmailAlerts.getText() + ",";
            }
            if (checkBoxAChequeBook.isSelected()) {
                message += checkBoxAChequeBook.getText() + ",";
            }
            if (checkBoxEStatement.isSelected()) {
                message += checkBoxEStatement.getText();
            }
            
            UserAccountDAO.insertUser(fname, mname, lname, faname, localDate, gender,
                    emailAddress, maritalStatus, address,
                    city, pin, state, rel, income, edu, occu, sinnumber, status, existingaccount,
                    accounttype, cardnumber, pinNum, accountNumber, message);
            
            UserAccount user = new UserAccount();
            user.setRandomNumber(cardnumber);
            user.setAccountNumber(accountNumber);
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/ApplicationFormPage3/EmailConfirmation.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Email Confirmation");
            stage.show();
            EmailConfirmationController controller = loader.<EmailConfirmationController>getController();
            controller.setText(user);
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void backButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
    
    void loadWindow(String location, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationFormPage3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void atmCardCheckBox(ActionEvent event) {
        if (checkBoxAtmCard.isSelected()) {
            checkBoxAtmCard.setOnAction(e -> {
                checkBoxList.add(checkBoxAtmCard.getText());
            });
        }
    }
    
    @FXML
    private void internetBankingCheckBox(ActionEvent event) {
        if (checkBoxInternetBanking.isSelected()) {
            checkBoxInternetBanking.setOnAction(e -> {
                checkBoxList.add(checkBoxInternetBanking.getText());
            });
        }
    }
    
    @FXML
    private void mobileBankingCheckBox(ActionEvent event) {
        if (checkBoxMobileBanking.isSelected()) {
            checkBoxMobileBanking.setOnAction(e -> {
                checkBoxList.add(checkBoxMobileBanking.getText());
            });
        }
    }
    
    @FXML
    private void emaikAlertsCheckBox(ActionEvent event) {
        if (checkBoxEmailAlerts.isSelected()) {
            checkBoxEmailAlerts.setOnAction(e -> {
                checkBoxList.add(checkBoxEmailAlerts.getText());
            });
        }
    }
    
    @FXML
    private void checkBookCheckBox(ActionEvent event) {
        if (checkBoxAChequeBook.isSelected()) {
            checkBoxAChequeBook.setOnAction(e -> {
                checkBoxList.add(checkBoxAChequeBook.getText());
            });
        }
    }
    
    @FXML
    private void eStatementCheckBox(ActionEvent event) {
        if (checkBoxEStatement.isSelected()) {
            checkBoxEStatement.setOnAction(e -> {
                checkBoxList.add(checkBoxEStatement.getText());
            });
        }
    }
    
    public void setText(UserAccount user) {
        int user_id = user.getUser_id();
        String fname = user.getFirst_name();
        this.lbl1.setText(fname);
        String mname = user.getMiddle_name();
        this.lbl2.setText(mname);
        String lname = user.getLast_name();
        this.lbl3.setText(lname);
        String faname = user.getFather_name();
        this.lbl4.setText(faname);
        String maritalStatus = user.getMarital_status();
        this.lbl5.setText(maritalStatus);
        String gender = user.getGender();
        this.lbl6.setText(gender);
        String email = user.getEmail_address();
        this.lbl7.setText(email);
        String address = user.getAddress();
        this.lbl8.setText(address);
        String city = user.getCity();
        this.lbl9.setText(city);
        String pincode = user.getPin_code();
        this.lbl10.setText(pincode);
        String state = user.getState();
        this.lbl11.setText(state);
        String religion = user.getReligion();
        this.lbl12.setText(religion);
        String income = user.getIncome();
        this.lbl13.setText(income);
        String education = user.getEducation_qualification();
        this.lbl14.setText(education);
        String occupation = user.getOccupation();
        this.lbl15.setText(occupation);
        String sin_num = user.getSin_number();
        this.lbl16.setText(sin_num);
        String status = user.getStatus();
        this.lbl17.setText(status);
        String existing_acc = user.getExisting_account();
        this.lbl18.setText(existing_acc);
        String account_type = user.getAccount_type();
        this.lbl19.setText(account_type);
        LocalDate dob = user.getDateofBirth();
        this.lblDOB.setText(dob.toString());
    }
}

package atmsimulatorsystem.assistant.ui.ApplicationFormPage2;

import atmsimulatorsystem.assistant.Database.DatabaseHandler;
import atmsimulatorsystem.assistant.ui.ApplicationFormPage3.ApplicationFormPage3Controller;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationFormPage2Controller implements Initializable {

    DatabaseHandler databasehandler;

    @FXML
    private Font x1;
    @FXML
    private ChoiceBox<String> comboBoxStatus;
    @FXML
    private TextField txtSinNumber;
    @FXML
    private ChoiceBox<String> comboBoxReligion;
    @FXML
    private ChoiceBox<String> comboBoxIncome;
    @FXML
    private ChoiceBox<String> comboBoxEducation;
    @FXML
    private ChoiceBox<String> comboBoxOccupation;
    @FXML
    private RadioButton radioExistActYes;
    @FXML
    private RadioButton radioExistActNo;
    @FXML
    private RadioButton radioSavAct;
    @FXML
    private RadioButton radioCurAct;
    @FXML
    private RadioButton radioChqAct;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane root;
    UserAccount user = new UserAccount();
    private String existingAccount;
    private String accountType;
    @FXML
    private Label lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lblDOB;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        try {
            String religion = (String) comboBoxReligion.getSelectionModel().getSelectedItem();
            String income = (String) comboBoxIncome.getSelectionModel().getSelectedItem();
            String education = (String) comboBoxEducation.getSelectionModel().getSelectedItem();
            String occupation = (String) comboBoxOccupation.getSelectionModel().getSelectedItem();
            String sinNumber = txtSinNumber.getText();
            String status = (String) comboBoxStatus.getSelectionModel().getSelectedItem();
            String fname = lbl1.getText();
            String mname = lbl2.getText();
            String lname = lbl3.getText();
            String faname = lbl4.getText();
            
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");            
            String date = lblDOB.getText();	
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date);
            
            String maritalStatus = lbl5.getText();
            String gender = lbl6.getText();
            String emailAddress = lbl7.getText();
            String address = lbl8.getText();
            String city = lbl9.getText();
            String pin = lbl10.getText();
            String state = lbl11.getText();
            UserAccount user = new UserAccount();
            user.setFirst_name(fname);
            user.setMiddle_name(mname);
            user.setLast_name(lname);
            user.setFather_name(faname);
            user.setDateofBirth(localDate);
            user.setMarital_status(maritalStatus);
            user.setGender(gender);
            user.setEmail_address(emailAddress);
            user.setAddress(address);
            user.setCity(city);
            user.setPin_code(pin);
            user.setState(state);
            user.setReligion(religion);
            user.setIncome(income);
            user.setEducation_qualification(education);
            user.setOccupation(occupation);
            user.setSin_number(sinNumber);
            user.setStatus(status);
            user.setExisting_account(existingAccount);
            user.setAccount_type(accountType);
            if (comboBoxReligion.getSelectionModel().isEmpty() || comboBoxIncome.getSelectionModel().isEmpty() 
                    || comboBoxEducation.getSelectionModel().isEmpty() || comboBoxOccupation.getSelectionModel().isEmpty()
                    || sinNumber.isEmpty() || comboBoxStatus.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please Enter in all fields");
                alert.showAndWait();
            } else if (sinNumber.length() != 9) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Sin number must be 9 digits");
                alert1.showAndWait();
            } else if (!sinNumber.matches("\\d*")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Sin number must be Numeric");
                alert1.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Success");
                alert.showAndWait();
                Stage stage = (Stage) root.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/ApplicationFormPage3/ApplicationFormPage3.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
                stage.show();
                ApplicationFormPage3Controller controller = loader.<ApplicationFormPage3Controller>getController();
                controller.setText(user);
            }
        } catch (IOException e) {
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(location));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationFormPage2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void yesRadioButton(ActionEvent event) {

        if (radioExistActYes.isSelected()) {
            existingAccount = "Yes";
            radioExistActNo.setSelected(false);
        }
    }

    @FXML
    private void noRadioButton(ActionEvent event) {
        if (radioExistActNo.isSelected()) {
            existingAccount = "No";
            radioExistActYes.setSelected(false);
        }
    }

    @FXML
    private void savingAccountRadioButton(ActionEvent event) {
        if (radioSavAct.isSelected()) {
            accountType = "Saving Account";
            radioCurAct.setSelected(false);
            radioChqAct.setSelected(false);
        }
    }

    @FXML
    private void currentAccountRadioButton(ActionEvent event) {
        if (radioCurAct.isSelected()) {
            accountType = "Current Account";
            radioSavAct.setSelected(false);
            radioChqAct.setSelected(false);
        }
    }

    @FXML
    private void chequingAccountRadioButton(ActionEvent event) {
        if (radioChqAct.isSelected()) {
            accountType = "Chequing Account";
            radioCurAct.setSelected(false);
            radioSavAct.setSelected(false);
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
        LocalDate dob = user.getDateofBirth();
        this.lblDOB.setText(dob.toString());
    }
}

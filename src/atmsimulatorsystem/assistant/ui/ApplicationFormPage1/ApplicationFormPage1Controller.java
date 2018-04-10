package atmsimulatorsystem.assistant.ui.ApplicationFormPage1;

import atmsimulatorsystem.assistant.ui.ApplicationFormPage2.ApplicationFormPage2Controller;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationFormPage1Controller implements Initializable {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtFatherName;
    @FXML
    private Font x1;
    @FXML
    private RadioButton radioGenderMale;
    @FXML
    private RadioButton radioGenderFemale;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtPinCode;
    @FXML
    private TextField txtState;
    @FXML
    private TextField txtEmailAddress;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private ComboBox<String> comboMarital;

    private String gender;
    @FXML
    private DatePicker dateDOB;
    @FXML
    private AnchorPane root;

    private UserAccount userDetails;

    public void initData(UserAccount user) {
        userDetails = user;
        txtFirstName.setText(userDetails.getFirst_name());
        txtMiddleName.setText(userDetails.getMiddle_name());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        try {
            String fName = txtFirstName.getText();
            String mName = txtMiddleName.getText();
            String lName = txtLastName.getText();
            String faName = txtFatherName.getText();
            String combo = (String) comboMarital.getSelectionModel().getSelectedItem();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String pinCode = txtPinCode.getText();
            String state = txtState.getText();
            String emailAaddress = txtEmailAddress.getText();
            
            LocalDate date = dateDOB.getValue();
            System.out.println(date);
            UserAccount user = new UserAccount();

            user.setFirst_name(fName);
            user.setMiddle_name(mName);
            user.setLast_name(lName);
            user.setFather_name(faName);
            user.setDateofBirth(date);
            user.setGender(gender);
            user.setEmail_address(emailAaddress);
            user.setMarital_status(combo);
            user.setAddress(address);
            user.setCity(city);
            user.setPin_code(pinCode);
            user.setState(state);

            if (fName.isEmpty() || lName.isEmpty() || faName.isEmpty()
                    || comboMarital.getSelectionModel().isEmpty() || emailAaddress.isEmpty() 
                    || address.isEmpty() || city.isEmpty() || pinCode.isEmpty() 
                    || state.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Please Enter in all fields");
                alert.showAndWait();
            } else if (!txtEmailAddress.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Input correct Email Address!");
                alert.showAndWait();
                txtEmailAddress.isFocused();
            } else if (!txtPinCode.getText().matches("[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] ?[0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Input correct Pin Code Format!");
                alert.showAndWait();
                txtPinCode.isFocused();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Success. Go to Next Form.");
                alert.showAndWait();

                Stage stage = (Stage) root.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/ApplicationFormPage2/ApplicationFormPage2.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
                stage.show();
                stage.setTitle("Form Page 2");
                ApplicationFormPage2Controller controller = loader.<ApplicationFormPage2Controller>getController();
                controller.setText(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void backButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.toBack();
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
            Logger.getLogger(ApplicationFormPage1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void maleRadioButton(ActionEvent event) {
        if (radioGenderMale.isSelected()) {
            gender = "Male";
            radioGenderFemale.setSelected(false);
        }
    }

    @FXML
    private void femaleRadioButton(ActionEvent event) {
        if (radioGenderFemale.isSelected()) {
            gender = "Female";
            radioGenderMale.setSelected(false);
        }
    }
}

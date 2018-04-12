package atmsimulatorsystem.assistant.ui.Login;

import atmsimulatorsystem.assistant.Database.DatabaseHandler;
import atmsimulatorsystem.assistant.ui.Transaction.TransactionController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>,
 * PRIYANKA MODI <C0717925>
 */
public class LoginController implements Initializable {

    PreparedStatement pst;
    DatabaseHandler databasehandler;
    @FXML
    private TextField txtCardNumber;
    @FXML
    private PasswordField txtPinNumber;
    @FXML
    private Label btnExit;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton btnRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginButtonAction(ActionEvent event) {
        try {
            if (txtCardNumber.getText().isEmpty() || txtPinNumber.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please Enter in all fields");
                alert.showAndWait();
            } else if (txtCardNumber.getText().length() != 16) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Card number must be 16 digits");
                alert1.showAndWait();
            } else if (!txtCardNumber.getText().matches("\\d*")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Card number must be Numeric");
                alert1.showAndWait();
            } else if (txtPinNumber.getText().length() != 6) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setHeaderText(null);
                alert2.setContentText("Pin number must be 6 digits");
                alert2.showAndWait();
            } else if (!txtPinNumber.getText().matches("\\d*")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Pin number must be Numeric");
                alert1.showAndWait();
            } else {
                UserAccount user = UserAccountDAO.searchUser(txtCardNumber.getText());
                if (user != null) {
                    ObservableList<UserAccount> userData = FXCollections.observableArrayList();
                    userData.add(user);
                    String cardNumber = user.getRandomNumber();
                    String pinNumber = user.getPinNumber();
                    String accountNumber = user.getAccountNumber();
                    if (txtCardNumber.getText().equals(cardNumber) && txtPinNumber.getText().equals(pinNumber)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Success.\n Welcome To ATM Simulator System.");
                        alert.showAndWait();
                        user.setAccountNumber(accountNumber);
                        Stage stage = (Stage) root.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem/assistant/ui/Transaction/Transaction.fxml"));
                        Parent root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Transactions");
                        stage.show();

                        TransactionController controller = loader.<TransactionController>getController();
                        controller.setText(user);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("User is Not Available. CardNumber or Pin Does not Match");
                        alert.showAndWait();
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitButtonAction(MouseEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @FXML
    private void registerButtonAction(ActionEvent event) {
        loadWindow("/atmsimulatorsystem/assistant/ui/ApplicationFormPage1"
                + "/ApplicationFormPage1.fxml", "Application Form Page 1");
    }
}

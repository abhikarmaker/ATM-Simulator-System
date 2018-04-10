/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.ThankYouPage;

import atmsimulatorsystem.assistant.ui.Transaction.TransactionController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
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
public class ThankYouPageController implements Initializable {

    @FXML
    private Button btnYes;
    @FXML
    private Button btnExit;
    @FXML
    private Label lblAccountNumber;
    @FXML
    private AnchorPane root;

    UserAccount user = new UserAccount();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void yesButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""
                    + "/atmsimulatorsystem/assistant/ui/Transaction/Transaction.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
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
    private void exitButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(""
                + "/atmsimulatorsystem/assistant/ui/Login/Login.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setText(UserAccount user) {
        String accountNumber = user.getAccountNumber();
        this.lblAccountNumber.setText(accountNumber);
    }
}

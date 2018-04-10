/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem.assistant.ui.WelcomePage;

import atmsimulatorsystem.assistant.ui.Login.LoginController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class WelcomePageController implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnTransactions;
    @FXML
    private Label uid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logoutButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void transactionsButtonAction(ActionEvent event) {
        loadWindow("/atmsimulatorsystem/assistant/ui/Transaction/Transaction.fxml", "Transactions");
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
            Logger.getLogger(WelcomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

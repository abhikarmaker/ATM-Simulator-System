package atmsimulatorsystem.assistant.ui.ApplicationFormPage3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ApplicationFormPage3 extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ApplicationFormPage3.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ATM Simulator System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

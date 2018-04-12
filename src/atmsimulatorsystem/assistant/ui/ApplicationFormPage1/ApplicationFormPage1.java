package atmsimulatorsystem.assistant.ui.ApplicationFormPage1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>, PRIYANKA MODI <C0717925>
 */
public class ApplicationFormPage1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ApplicationFormPage1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Application Form 1");
        stage.show();
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}

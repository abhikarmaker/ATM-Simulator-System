package atmsimulatorsystem.assistant.ui.ApplicationFormPage2;

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
public class ApplicationFormPage2 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ApplicationFormPage2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Application Form 2");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

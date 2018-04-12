package atmsimulatorsystem.assistant.ui.Transaction;

import atmsimulatorsystem.assistant.Database.DatabaseHandler;
import atmsimulatorsystem.assistant.ui.ThankYouPage.ThankYouPageController;
import atmsimulatorsystem.assistant.ui.model.UserAccount;
import atmsimulatorsystem.assistant.ui.model.UserAccountDAO;
import atmsimulatorsystem.assistant.ui.model.UserTransactions;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ABHIJEET KARMAKER <C0720286>, NARESH GUNIMANIKULA <C0719672>,
 * PRIYANKA MODI <C0717925>
 */
public class MiniStatementController implements Initializable {

    UserTransactions user = new UserTransactions();
    ObservableList<UserTransactions> list = FXCollections.observableArrayList();
    DatabaseHandler databasehandler;

    @FXML
    private AnchorPane root;
    @FXML
    private Button btnExit;
    @FXML
    private Label lblAccountNumber;
    @FXML
    private TableColumn<UserTransactions, Date> colDate;
    @FXML
    private TableColumn<UserTransactions, Double> colDeposit;
    @FXML
    private TableColumn<UserTransactions, Double> colWithdraw;
    @FXML
    private TableColumn<UserTransactions, Double> colTotalBalance;
    @FXML
    private TableView<UserTransactions> tableView;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button btnStatement;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        //statement();
    }

    void initCol() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDeposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        colWithdraw.setCellValueFactory(new PropertyValueFactory<>("withdrawl"));
        colTotalBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""
                    + "/atmsimulatorsystem/assistant/ui/Transaction/Transaction.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Transactions");
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

    public void setText(UserTransactions user) throws SQLException, ClassNotFoundException {
        String accountNumber = user.getAccountNumber();
        this.lblAccountNumber.setText(accountNumber);
    }

    @FXML
    private void displayButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt
                = "SELECT t.account_number, t.balance, t.deposit, t.withdrawl, t.date "
                + " FROM TRANSACTIONS t "
                + " JOIN USERACCOUNTS u"
                + " ON u.account_number = t.account_number"
                + " WHERE t.account_number= " + lblAccountNumber.getText();
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsUser = DatabaseHandler.dbExecuteQuery(selectStmt);
            //Send ResultSet to the getUserFromResultSet method and get user object
            UserTransactions user = new UserTransactions();
            if (rsUser.isBeforeFirst()) {
                while (rsUser.next()) {
                    Date colDate = rsUser.getDate("date");
                    double colDeposit = rsUser.getDouble("deposit");
                    double colWithdrawl = rsUser.getDouble("withdrawl");
                    double colBalance = rsUser.getDouble("balance");
                    list.add(new UserTransactions(colBalance, colDeposit, colWithdrawl, colDate));
                    System.out.println(colBalance + " " + colDeposit + " " + colWithdrawl + " " + colDate);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("No Transactions has been made yet");
                alert.showAndWait();
            }
            //Return user object
        } catch (SQLException e) {
            System.out.println(e);
            //Return exception
            throw e;
        }

        tableView.getItems()
                .setAll(list);
    }

    private void statement() {
        String selectStmt
                = "SELECT t.account_number, t.balance, t.deposit, t.withdrawl, t.date, u.first_name"
                + " FROM TRANSACTIONS t "
                + " JOIN USERACCOUNTS u"
                + " ON u.account_number = t.account_number"
                + " WHERE t.account_number= " + lblAccountNumber.getText();
        Document document = new Document(PageSize.A4);
        document.addAuthor("ATM SIMULATOR SYSTEM STATEMENT");
        document.addTitle("ATM SIMULATOR SYSTEM STATEMENT");
        System.out.println("Document has been Created");
        Random r = new Random();
        int max = 99;
        int min = 10;
        String counter = String.format("%02d", (Object) r.nextInt((max - min) + 1 + min));
        try {
            //UserTransactions userTran = UserTransactionsDAO.searchUserForMiniStatementData();
            //if (userTran != null) {
            ResultSet rs = DatabaseHandler.dbExecuteQuery(selectStmt);
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            UserTransactions user = new UserTransactions();
            PdfWriter.getInstance(document, new FileOutputStream(new File("Statement_("
                    + lblAccountNumber.getText() + ")_" + counter + ".pdf")));
//            if (!rs.next()) {
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setHeaderText(null);
//                alert.setContentText("No Transactions has been made yet");
//                alert.showAndWait();
//            } else {
            if (rs.next()) {
                String fname = rs.getString("first_name");

                Paragraph para = new Paragraph("           "
                        + "           "
                        + "           "
                        + "           "
                        + "           "
                        + "Statement of the month\n"
                        + "Name: " + fname
                        + "\nDeposit Amount                 "
                        + "Withdrawl Amount               "
                        + "Available Balance                   "
                        + "Date\n\n"
                );

                document.open();
                document.add(para);
            }
            while (rs.next()) {
                double balance = rs.getDouble("balance");
                String fname = rs.getString("first_name");
                double deposit = rs.getDouble("deposit");
                double withdrawl = rs.getDouble("withdrawl");
                Date date = rs.getDate("date");
                Paragraph para1 = new Paragraph(deposit + "                                      "
                        + withdrawl
                        + "                                      "
                        + balance
                        + "                                      "
                        + date);
                document.add(para1);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Your Statement has been mailed to you.");
            alert.showAndWait();
            thankYouPageLoader();

        } catch (DocumentException | FileNotFoundException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        document.close();
    }

    @FXML
    private void statementButtonAction(ActionEvent event) {
        statement();
    }

    private void thankYouPageLoader() {
        UserAccount user = new UserAccount();
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/atmsimulatorsystem"
                    + "/assistant/ui/ThankYouPage/ThankYouPage.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Thank You");
            stage.show();
            String accountNumber = lblAccountNumber.getText();
            user.setAccountNumber(accountNumber);
            ThankYouPageController controller = loader.<ThankYouPageController>getController();
            controller.setText(user);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

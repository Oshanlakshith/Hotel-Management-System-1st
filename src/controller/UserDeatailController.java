package controller;

import Model.User;
import Model.UserDatabase;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDeatailController {
    public ComboBox<String> cmbUserId;
    public TextField txtUserId;
    public TextField txtTitleId;
    public TextField txtTitle;
    public TextField txtName;
    public TextField txtPassword;
    public Label lblRoom;

    public void initialize() {
        cmbUserId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {

                setUserId(newValue);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        try {

            loadEmploye();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setUserId(String UserId) throws SQLException, ClassNotFoundException {
        User u1 = new UserController().getUser(UserId);
        if (u1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Results..").show();
        } else {
            txtUserId.setText(u1.getUId());
            txtTitleId.setText(u1.getTitleId());
            txtTitle.setText(u1.getJobTitle());
            txtName.setText(u1.getName());
        }
    }

    public void LogingButton(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        String UId = txtUserId.getText();
        String Name = txtName.getText();
        String jobTitle = txtTitle.getText();
        String Password = txtPassword.getText();

        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Roll WHERE  EmployeId=? and E_Password=?");
        stm.setString(1, UId);
        stm.setString(2, Password);
        ResultSet rst = stm.executeQuery();

        if (rst.next()) {

            UserDatabase database = new UserDatabase(
                    cmbUserId.getValue(),
                    cmbUserId.getValue(),
                    jobTitle,
                    Name,
                    Password
            );
            if (new UserController().UserDatabase(database)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DashBoardForm.fxml"));
                Parent load = loader.load();

                DashBoardFormController dashBoardFormController = loader.getController();
                dashBoardFormController.UserNameId(UId, Name);

                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            }else{
                new Alert(Alert.AlertType.WARNING,"Wrong Password").show();
            }
        }
    }

    public void loadEmploye() throws SQLException, ClassNotFoundException {
        List<String> EmployeId = new UserController().getEmployeId();
        cmbUserId.getItems().addAll(EmployeId);
    }
}
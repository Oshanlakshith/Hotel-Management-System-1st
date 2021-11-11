package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LogFormController {

    public AnchorPane logingAnchor;
    public TextField txtName;
    public TextField txtPassword;

    public void logingButton(ActionEvent actionEvent) throws IOException {
        String Name = txtName.getText();
        String password = txtPassword.getText();

        if (Name.equals("Hotel") && password.equals("123")) {
            URL resource = getClass().getResource("../View/UserDeatail.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) logingAnchor.getScene().getWindow();
            window.setScene(new Scene(load));
        } else {
            new Alert(Alert.AlertType.WARNING, "No loging").show();
        }
    }
}
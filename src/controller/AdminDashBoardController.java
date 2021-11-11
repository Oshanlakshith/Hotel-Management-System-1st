package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashBoardController {
    public AnchorPane AdminAnchor;

    public void EmployeAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EmployeNew.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("/CSS/mycss.css");
        AdminAnchor.getChildren().add(root);
    }

    public void AddRoom(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/RoomForm.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("/CSS/roomcss.css");
        AdminAnchor.getChildren().add(root);
    }

    public void MealButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/MealForm.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("/CSS/roomcss.css");
        AdminAnchor.getChildren().clear();
        AdminAnchor.getChildren().add(root);
    }

    public void Payment(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/PaymentForm.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("/CSS/roomcss.css");
        AdminAnchor.getChildren().clear();
        AdminAnchor.getChildren().add(root);
    }

}

package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    public Label lblName;
    public Label lblId;
    public AnchorPane AddAnchor;
    public ImageView Image;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane logPaneAnchor;
    public AnchorPane dashboardAnchor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Time();
        Date();
    }

    public void CustomerForm(ActionEvent actionEvent) throws IOException {
        String id=lblId.getText();
        String name=lblName.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/CustomerForm.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("/CSS/css.css");

        CustomerFormController customerFormController=loader.getController();
        customerFormController.UserIDName(id,name);

        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(root);
    }
    public void Time(){
        Thread thread=new Thread(()->{
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");

            boolean stop = false;
            while (!stop){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timenow=sdf.format(new Date());
                Platform.runLater(()->{
                    lblTime.setText(timenow);
                });
            }
        });
        thread.start();

    }
    public void Date(){
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        String datenow=sdf.format(new Date());
        lblDate.setText(datenow);

    }

    public void LogingAdmin(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AdminDashBoard.fxml"));
        Parent load = loader.load();
        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(load);
    }

    public void ParkBUtton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ParkForm.fxml"));
        Parent load = loader.load();
        load.getStylesheets().add("/CSS/mycss.css");
        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(load);
    }
    public void UserNameId(String id,String name){
        lblId.setText(id);
        lblName.setText(name);
    }

    public void BookingButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/BookingForm.fxml"));
        Parent load=loader.load();
        load.getStylesheets().add("/CSS/mycss.css");
        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(load);
    }

    public void DeataiButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Deatail.fxml"));
        Parent load = loader.load();
        load.getStylesheets().add("/CSS/css.css");
        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(load);
    }

    public void RoomsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/BookingRoom.fxml"));
        Parent load = loader.load();
        load.getStylesheets().add("/CSS/css.css");
        AddAnchor.getChildren().clear();
        AddAnchor.getChildren().add(load);
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/logForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashboardAnchor.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}


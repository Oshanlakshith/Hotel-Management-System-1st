package controller;

import Model.Park;
import View.tm.ParkTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ParkFormController implements Initializable {

    public ComboBox<String>cmbCustomerId;
    public ComboBox<String>cmbVehicleName;
    public TextField txtVName;
    public Label lblSlot;
    public AnchorPane txtCName;
    public TableView<ParkTm>tblParkDeatail;
    public TableColumn colCid;
    public TableColumn colCName;
    public TableColumn colVName;
    public TableColumn colVSlot;
    public TextField txtCustomerName;
    public TextField txtCustomerId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String>vehicleType=FXCollections.observableArrayList(
                "Car","Bus","Van","Threeweel","Bike"
        );
        cmbVehicleName.setItems(vehicleType);
        cmbVehicleName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtVName.setText(newValue);
        });
        try {

            loadCustomerId();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {

                setCustomer(newValue);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        try {

            setParkDeatail(new ParkController().getAllCDeatail());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadCustomerId() throws SQLException, ClassNotFoundException {
        List<String>id=new CustomerController().getCustomerId();
        cmbCustomerId.getItems().addAll(id);
    }
    private void setCustomer(String id) throws SQLException, ClassNotFoundException {
        Park p1=new ParkController().getCustomer(id);
        if(p1==null){
            new Alert(Alert.AlertType.WARNING,"Try Again..").show();
        }else{
            txtCustomerId.setText(p1.getCustomerId());
            txtCustomerName.setText(p1.getCustomerName());
        }
    }
 public void setParkDeatail(ArrayList<Park>parks){
        ObservableList<ParkTm>oblist=FXCollections.observableArrayList();
        parks.forEach(e->{
            oblist.add(
                    new ParkTm(e.getSlot(),e.getCustomerId(),e.getCustomerName(),e.getVehicleName())
            );
        });
        tblParkDeatail.setItems(oblist);

        colVSlot.setCellValueFactory(new PropertyValueFactory<>("slot"));
        colCid.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colVName.setCellValueFactory(new PropertyValueFactory<>("VehicleName"));

 }
    public void SlotButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(txtVName.getText().equals("Bike")){
            Random r = new Random();
            int start = 1;
            int end = 60;
            int result = r.nextInt(end - start) + start;
            lblSlot.setText(String.valueOf(result));
        }
        if(txtVName.getText().equals("Threeweel")){
            Random r = new Random();
            int start = 60;
            int end = 110;
            int result = r.nextInt(end - start) + start;
            lblSlot.setText(String.valueOf(result));
        }
        if(txtVName.getText().equals("Van")){
            Random r = new Random();
            int start = 110;
            int end = 170;
            int result = r.nextInt(end - start) + start;
            lblSlot.setText(String.valueOf(result));
        }
        if(txtVName.getText().equals("Car")){
            Random r = new Random();
            int start = 170;
            int end = 250;
            int result = r.nextInt(end - start) + start;
            lblSlot.setText(String.valueOf(result));
        }
        if(txtVName.getText().equals("Bus")){
            Random r = new Random();
            int start = 250;
            int end = 300;
            int result = r.nextInt(end - start) + start;
            lblSlot.setText(String.valueOf(result));
        }
        Park p1=new Park(
          lblSlot.getText(),txtCustomerId.getText(),txtCustomerName.getText(),txtVName.getText()
        );
        if(new ParkController().ParkDeatail(p1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Save..").showAndWait();
            setParkDeatail(new ParkController().getAllCDeatail()); 
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again..").show();
        }
    }
}
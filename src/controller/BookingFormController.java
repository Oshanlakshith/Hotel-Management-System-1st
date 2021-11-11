package controller;

import Model.*;
import View.tm.BookingTm;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


public class BookingFormController implements Initializable {
    public TextField txtCId;
    public ComboBox<String>cmbCustomerId;
    public TextField txtRoomType;
    public ComboBox<String>cmbRoomType;
    public TextField txtRoomNo;
    public TextField txtMealType;
    public TextField txtPrice;
    public TextField txtTotal;
    public TextField txtRoomPrice;
    public ComboBox<String>cmbMealType;
    public TextField txtAdult;
    public TextField txtChild;
    public Label lblREcivationId;
    public Label lblDate;
    public Label lblTime;
    public TextField txtCheckIn;
    public TextField txtCheckOut;
    public TextField txtMealId;
    public TableView<BookingTm>tblBookingDeatail;
    public TableColumn colRecivation;
    public TableColumn colCId;
    public TableColumn colCheckIn;
    public TableColumn colCheckOut;
    public TableColumn colRoomNo;
    public TableColumn colMealType;
    public TableColumn colTotal;
    public TableColumn colDate;
    public TableColumn colTime;
    public AnchorPane billContext;
    public TableColumn colMealPrice;
    public Button jasper;

    int count=0;
    ObservableList<BookingTm>oblist= FXCollections.observableArrayList();
    public void AddTable(ActionEvent actionEvent) throws IOException {

        String reservationId=lblREcivationId.getText();
        String customerId=txtCId.getText();
        String checkIn=txtCheckIn.getText();
        String getCheckOut=txtCheckOut.getText();
        String roomtype=txtRoomType.getText();
        String adult=txtAdult.getText();
        String child=txtChild.getText();
        int RoomPrice= Integer.parseInt(txtRoomPrice.getText());
        int MealPrice= Integer.parseInt(txtPrice.getText());
        String roomNo=txtRoomNo.getText();
        String mealType=txtMealType.getText();
        Double total= Double.valueOf(RoomPrice+MealPrice);
        String date=lblDate.getText();
        String time=lblTime.getText();
        String rPrice=txtRoomPrice.getText();


        BookingTm t1=new BookingTm(
                reservationId,
                customerId,
                checkIn,
                getCheckOut,
                roomNo,
                rPrice,
                mealType,
                txtPrice.getText(),
                total,
                date,
                time
        );
        oblist.add(t1);
        tblBookingDeatail.setItems(oblist);
        txtTotal.setText(total+"/=");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/bill.fxml"));
        Parent load = loader.load();


        BillController billController = loader.getController();
        billController.UserNameId(reservationId, customerId,checkIn,getCheckOut,roomtype,adult,child,total);

        billContext.getChildren().clear();
        billContext.getChildren().add(load);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBookingId();

        Time();
        Date();
        try {

            loadCustomerId();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
          txtCId.setText(newValue);
        });
        try {
            loadRoomType();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                setRoomDeatail(newValue);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        try {

            loadMealId();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbMealType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setMeal(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        colRecivation.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("getCheckOut"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colMealType.setCellValueFactory(new PropertyValueFactory<>("mealType"));
        colMealPrice.setCellValueFactory(new PropertyValueFactory<>("mealPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));


    }

    private void setRoomDeatail(String room) throws SQLException, ClassNotFoundException {
        roomco r1=new BookingController().getRoom(room);
        if(r1==null){
            new Alert(Alert.AlertType.WARNING,"TryAgain..").show();
        }else{
            txtRoomNo.setText(r1.getRoomNo());
            txtRoomType.setText(r1.getRoomType());
            txtRoomPrice.setText(r1.getPrice());
        }
    }

    public void setBookingId(){
        try {

            lblREcivationId.setText(new BookingController().getBookingId());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void setMeal(String Meal) throws SQLException, ClassNotFoundException {
        Booking b1=new BookingController().getMeal(Meal);
        if(b1==null){
            new Alert(Alert.AlertType.WARNING,"TryAgain..").show();
        }else{
            txtMealId.setText(b1.getMealId());
            txtMealType.setText(b1.getMealType());
            txtPrice.setText(String.valueOf(b1.getMealPrice()));
        }
    }

   /* private void setRoom(String Detail) throws SQLException, ClassNotFoundException {
        Booking b1 = new BookingController().getRoom(Detail);
        if(b1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Results").show();
        }else{
            txtRoomNo.setText(b1.getRoomNo());
            txtRoomPrice.setText(String.valueOf(b1.getRPrice()));
        }
    }*/
    public void SaveButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Booking b1=new Booking(
                lblREcivationId.getText(), txtCId.getText(), txtRoomNo.getText(), txtMealId.getText(), txtMealType.getText(), txtPrice.getText(), txtCheckIn.getText(), txtCheckOut.getText(), txtRoomType.getText(), txtRoomPrice.getText(), txtAdult.getText(), txtChild.getText(), lblDate.getText(), lblTime.getText(), txtTotal.getText()
        );
        if (new BookingController().SaveBooking(b1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Save..").showAndWait();

        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        ArrayList<MealDeatail>mealDeatails=new ArrayList<>();
        for (BookingTm temp:oblist) {
            mealDeatails.add(
                    new MealDeatail(
                       temp.getRoomNo(),temp.getMealType(),temp.getMealPrice(),temp.getDate(),temp.getTime()
                    )
            );
        }
        roomDeatail r1=new roomDeatail(
               txtRoomNo.getText(),txtCId.getText() ,lblREcivationId.getText(),Double.parseDouble(txtRoomPrice.getText()),lblDate.getText(),mealDeatails
        );
            if(new BookingController().Room(r1)){
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again..").show();
            }
/*
        RoomRD r1=new RoomRD(
                txtRoomNo.getText(), txtCId.getText(), lblREcivationId.getText(), txtRoomType.getText(), Double.parseDouble(txtRoomPrice.getText()));
        if(new BookingController().RoomRD(r1)) {
        }else{
            new Alert(Alert.AlertType.WARNING,"Try..").show();
        }*/

        Payment p1=new Payment(
                txtCId.getText(),lblREcivationId.getText(),lblDate.getText(),lblTime.getText(),String.valueOf(txtTotal.getText())
        );
        if(new PaymentController().SavePayment(p1)){
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();
        }
    }


    public void UpdateButton(ActionEvent actionEvent) throws IOException {
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/View/reports/CheckIN.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);
            ObservableList<BookingTm> items = tblBookingDeatail.getItems();
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, new JRBeanArrayDataSource(items.toArray()));
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
    public void ClearButton(ActionEvent actionEvent) {
        txtRoomType.clear();
        txtPrice.clear();
        txtRoomPrice.clear();
        txtChild.clear();
        txtCheckIn.clear();
        txtCheckOut.clear();
        txtTotal.clear();
        txtAdult.clear();
        txtMealType.clear();
        txtCId.clear();
        txtRoomNo.clear();
        txtMealId.clear();
    }




    public void loadCustomerId() throws SQLException, ClassNotFoundException {
        List<String>id=new BookingController().getCutomerId();
        cmbCustomerId.getItems().addAll(id);
    }
    public void loadRoomType() throws SQLException, ClassNotFoundException {
            List<String> type = new BookingController().getRoomType();
            cmbRoomType.getItems().addAll(type);
        }

    public void loadMealId() throws SQLException, ClassNotFoundException {
        List<String>MealId=new BookingController().getMealAdd();
        cmbMealType.getItems().addAll(MealId);
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

}
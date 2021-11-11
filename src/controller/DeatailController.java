package controller;

import Model.Booking;
import Model.BookingRoom;
import View.tm.BookingRoomTm;
import View.tm.DeatailTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeatailController implements Initializable {
    public TableColumn colReservationId;
    public TableColumn colCustomerId;
    public TableColumn colCheckIn;
    public TableColumn colcheckOut;
    public TableColumn colRoomType;
    public TableColumn colRoomNo;
    public TableColumn colRoomPrice;
    public TableColumn colMealId;
    public TableColumn colMealType;
    public TableColumn colMealPrice;
    public TableColumn colTotal;
    public TableColumn colAdut;
    public TableColumn colChild;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableView<DeatailTm>tblDeatail;
    public Label lblReservation;
    public Label lblRoom;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            BookingRoom(new RoomController().getAllBookingRooms());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        colReservationId.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colcheckOut.setCellValueFactory(new PropertyValueFactory<>("getCheckOut"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RPrice"));
        colMealId.setCellValueFactory(new PropertyValueFactory<>("mealId"));
        colMealType.setCellValueFactory(new PropertyValueFactory<>("MealType"));
        colMealPrice.setCellValueFactory(new PropertyValueFactory<>("MealPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAdut.setCellValueFactory(new PropertyValueFactory<>("Adult"));
        colChild.setCellValueFactory(new PropertyValueFactory<>("child"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));


        try {

            setreservation(new BookingController().getAllBooking());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setreservation(ArrayList<Booking> allBooking) {
            ObservableList<DeatailTm>oblist= FXCollections.observableArrayList();
            int count=0;
            allBooking.forEach(e->{
                oblist.add(
                        new DeatailTm(
                                e.getReservationId(),e.getCustomerId(),e.getRoomNo(),e.getMealId(),e.getMealType(),e.getMealPrice(),e.getCheckIn(),e.getGetCheckOut(),e.getRoomType(),e.getRPrice(),e.getAdult(),e.getChild(),e.getDate(),e.getTime(),e.getTotal()
                        ));
                   });

            for (int i = 0; i <oblist.size(); i++) {
                    if(i<oblist.size()){
                      count++;
                    }
              }
                lblReservation.setText(count+"");
                tblDeatail.setItems(oblist);
        }
    private void BookingRoom(ArrayList<BookingRoom> allBookingRooms) {
        ObservableList<BookingRoomTm>oblist= FXCollections.observableArrayList();
        int count=0;
        allBookingRooms.forEach(e->{
            oblist.add(
                    new BookingRoomTm(
                            e.getRoomNo(),e.getCid(),e.getReservation(),e.getRoomPrice(),e.getDate()
                    ));
        });
        for (int i = 0; i <oblist.size(); i++) {
            count++;
        }
        lblRoom.setText(count+"");
    }
}

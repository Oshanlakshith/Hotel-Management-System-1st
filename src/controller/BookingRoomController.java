package controller;

import Model.BookingRoom;
import View.tm.BookingRoomTm;
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

public class BookingRoomController implements Initializable {

    public TableView<BookingRoomTm>tblBookingRoom;
    public TableColumn colRoomNo;
    public TableColumn colDate;
    public TableColumn colcustomerId;
    public TableColumn colReservation;
    public TableColumn colRoomPrice;
    public Label lblBookingRoom;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        colcustomerId.setCellValueFactory(new PropertyValueFactory<>("Cid"));
        colReservation.setCellValueFactory(new PropertyValueFactory<>("Reservation"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

        try {

            BookingRoom(new RoomController().getAllBookingRooms());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        lblBookingRoom.setText(count+"");
        tblBookingRoom.setItems(oblist);
    }
}

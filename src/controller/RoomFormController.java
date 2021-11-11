package controller;

import Model.Room;
import View.tm.RoomTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
    public TextField txtRoomType;
    public TextField txtRoomId;
    public TextField txtAcType;
    public ComboBox<String>cmbAcType;
    public TextField txtPrice;

    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colAc;
    public TableColumn colPrice;
    public TableView<RoomTm>tblRooms;

    static ArrayList<String>Ac=new ArrayList<>();
    static{
        Ac.add("A/C");
        Ac.add("Non-A/C");
    }

    public Label lblRooms;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
        colAc.setCellValueFactory(new PropertyValueFactory<>("AcType"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {

            setRooms(new RoomController().getAllRooms());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      ObservableList<String>oblist=FXCollections.observableArrayList();
        for (String temp:Ac) {
            oblist.add(temp);
        }
        cmbAcType.setItems(oblist);

        cmbAcType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtAcType.setText(newValue);
        });
    }
    public void SaveButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Room r1=new Room(
                txtRoomId.getText(),txtRoomType.getText(),txtAcType.getText(),txtPrice.getText()
        );
        if(new RoomController().AddRoom(r1)){
            new Alert(Alert.AlertType.CONFIRMATION,"ADD ROOM").showAndWait();
            setRooms(new RoomController().getAllRooms());
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void setRooms(ArrayList<Room>roomlist){
        ObservableList<RoomTm>oblist= FXCollections.observableArrayList();
       int count=0;
        roomlist.forEach(e-> {
            oblist.add(
                    new RoomTm(
                            e.getRoomNo(), e.getRoomType(), e.getAcType(), e.getPrice()
                    ));
        });
        for (int i = 0; i <oblist.size(); i++) {
            if(i<oblist.size()){
                count++;
            }
        }
        lblRooms.setText(count+"");
        tblRooms.setItems(oblist);
    }
    public void ClearButton(ActionEvent actionEvent) {
        txtRoomId.clear();
        txtRoomType.clear();
        txtAcType.clear();
        txtPrice.clear();
    }

    public void DeleteButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(new RoomController().DeleteRoom(txtRoomId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete").showAndWait();
            setRooms(new RoomController().getAllRooms());
        }else{
            new Alert(Alert.AlertType.WARNING,"TryAgain").show();
        }
    }

    public void UpdateButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Room r1=new Room(
                txtRoomId.getText(),txtRoomType.getText(),txtAcType.getText(),txtPrice.getText()
        );
        if(new RoomController().UpdateRoom(r1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Update").showAndWait();
            setRooms(new RoomController().getAllRooms());
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").showAndWait();
        }
    }

    public void SearchButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      String id=txtRoomId.getText();
      Room r1=new RoomController().getRooms(id);

      if(r1==null){
          new Alert(Alert.AlertType.WARNING,"Empty Results").show();
      }else {
          setData(r1);
      }
    }
    public void setData(Room id){
        txtRoomId.setText(id.getRoomNo());
        txtRoomType.setText(id.getRoomType());
        txtAcType.setText(id.getAcType());
        txtPrice.setText(id.getPrice());
    }

}
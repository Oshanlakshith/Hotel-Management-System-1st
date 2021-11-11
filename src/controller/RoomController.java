package controller;

import Model.BookingRoom;
import Model.Room;
import db.DbConnection;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomController {
   public boolean AddRoom(Room r) throws SQLException, ClassNotFoundException {
       PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO RoomAdd VALUES (?,?,?,?)");
       stm.setObject(1,r.getRoomNo());
       stm.setObject(2,r.getRoomType());
       stm.setObject(3,r.getAcType());
       stm.setObject(4,r.getPrice());

       return stm.executeUpdate()>0;
   }
   public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException {
       PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM RoomAdd");
       ResultSet rst = stm.executeQuery();
       ArrayList<Room>rooms=new ArrayList<>();
       while (rst.next()){
           rooms.add(
                 new Room(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
          ));
       }
       return rooms;
   }
   public boolean DeleteRoom(String id) throws SQLException, ClassNotFoundException {
       if(DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM RoomAdd WHERE RoomNo='"+id +"'").executeUpdate()>0){
           return true;
       }else {
           return false;
       }
   }

    public Room getRooms(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM RoomAdd WHERE RoomNo=?");
        stm.setObject(1,id);

        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Room c1=new Room(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            return c1;
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Results...").show();
        }
        return  null;
    }

    public boolean UpdateRoom(Room c) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE RoomAdd SET RoomType=?,AC_Type=?,Price=? WHERE RoomNo=?");
        stm.setObject(1,c.getRoomType());
        stm.setObject(2,c.getAcType());
        stm.setObject(3,c.getPrice());
        stm.setObject(4,c.getRoomNo());
        return stm.executeUpdate()>0;
    }
    public ArrayList<BookingRoom> getAllBookingRooms() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Room");
        ResultSet rst = stm.executeQuery();
        ArrayList<BookingRoom>rooms=new ArrayList<>();
        while (rst.next()){
            rooms.add(
                    new BookingRoom(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)
                    ));
        }
        return rooms;
    }
}

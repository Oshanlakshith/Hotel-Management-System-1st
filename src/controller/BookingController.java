package controller;

import Model.*;
import db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    public List<String>getCutomerId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Customer").executeQuery();
        List<String>ids=new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }
    public List<String>getRoomType() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM RoomAdd").executeQuery();
        List<String>Roomtypes=new ArrayList<>();
        while (rst.next()){
            Roomtypes.add(
                    rst.getString(2)
            );
        }
        return Roomtypes;
    }
    public List<String>getRoomNo() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM RoomAdd").executeQuery();
        List<String>no=new ArrayList<>();
        while (rst.next()){
            no.add(
                    rst.getString(1)
            );
        }
        return no;
    }
    public List<String>getMealAdd() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM MealAdd").executeQuery();
        List<String>no=new ArrayList<>();
        while (rst.next()){
            no.add(
                    rst.getString(1)
            );
        }
        return no;
    }
    public boolean SaveBooking(Booking b) throws ClassNotFoundException, SQLException {
        Connection con= DbConnection.getInstance().getConnection();
        String query="INSERT INTO  reservation VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm=con.prepareStatement(query);

        stm.setObject(1,b.getReservationId());
        stm.setObject(2,b.getCustomerId());
        stm.setObject(3,b.getRoomNo());
        stm.setObject(4,b.getMealId());
        stm.setObject(5,b.getMealType());
        stm.setObject(6,b.getMealPrice());
        stm.setObject(7,b.getCheckIn());
        stm.setObject(8,b.getGetCheckOut());
        stm.setObject(9,b.getRoomType());
        stm.setObject(10,b.getRPrice());
        stm.setObject(11,b.getAdult());
        stm.setObject(12,b.getChild());
        stm.setObject(13,b.getDate());
        stm.setObject(14,b.getTime());
        stm.setObject(15,b.getTotal());

        return stm.executeUpdate()>0;
    }
    public boolean RoomRD(RoomRD rd) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO Room VALUES (?,?,?,?,?)");
        stm.setObject(1,rd.getRoomNo());
        stm.setObject(2,rd.getCId());
        stm.setObject(3,rd.getReservationId());
        stm.setObject(4,rd.getRoomType());
        stm.setObject(5,rd.getPrice());

        return stm.executeUpdate()>0;
    }


    public roomco getRoom(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM RoomAdd WHERE RoomType='" + id + "'").executeQuery();
        if(rst.next()){
            return new roomco(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(4)
            );
        }else{
            return null;
        }
    }
    public Booking getMeal(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM MealAdd WHERE  MealId='" + id + "'").executeQuery();
        if(rst.next()){
            return new Booking(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }else{
            return null;
        }
    }
    public ArrayList<Booking>getAllBooking() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM reservation");
        ResultSet rst = stm.executeQuery();
        ArrayList<Booking>bookings=new ArrayList<>();
        while(rst.next()){
            bookings.add(
                    new Booking(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getString(7),
                            rst.getString(8),
                            rst.getString(9),
                            rst.getString(10),
                            rst.getString(11),
                            rst.getString(12),
                            rst.getString(13),
                            rst.getString(14),
                            rst.getString(15)
                            ));
        }
        return bookings;
    }

    public String getBookingId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM  reservation ORDER BY RId DESC LIMIT 1").executeQuery();
        if(rst.next()){
            int tempId =Integer.parseInt(rst.getString(1).split("-")[1]);
            tempId=tempId+1;
            if(tempId<9){
                return "0-00"+tempId;
            }else if(tempId<99){
                return "0-0"+tempId;
            }else {
                return "0-"+tempId;
            }
        }else {
            return "0-001";
        }
    }
   public boolean Room(roomDeatail roomDeatail){
        Connection con=null;
       try {
            con=DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement stm=con.prepareStatement("INSERT INTO  Room VALUES ( ?,?,?,?,?)");
            stm.setObject(1,roomDeatail.getRoomNo());
            stm.setObject(2,roomDeatail.getCId());
            stm.setObject(3,roomDeatail.getReservationId());
            stm.setObject(4,roomDeatail.getRoomprice());
            stm.setObject(5,roomDeatail.getDate());

           if(stm.executeUpdate()>0){
               if(saveMealDeatail(roomDeatail.getRoomNo(),roomDeatail.getMeals())){
                   con.commit();
                   return true;
               }else {
                   con.rollback();
                   return false;
               }
           }else {
               con.rollback();
               return false;
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }finally {
           try {

               con.setAutoCommit(true);


           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       }
       return false;
   }
   public boolean saveMealDeatail(String RoomNo,ArrayList<MealDeatail>meals) throws SQLException, ClassNotFoundException {
       for (MealDeatail temp:meals
            ) {
           PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO  mealdetail VALUES (?,?,?,?,?)");
           stm.setObject(1,temp.getRoomNo());
           stm.setObject(2,temp.getMealType());
           stm.setObject(3,temp.getMealPrice());
           stm.setObject(4,temp.getDate());
           stm.setObject(5,temp.getTime());

           if(stm.executeUpdate()>0){
           }else {
               return false;
           }
       }
       return true;
   }
}
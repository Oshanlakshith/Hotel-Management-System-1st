package controller;

import Model.Park;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkController {
    public Park getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Customer WHERE  CId='" + id + "'").executeQuery();
        if (rst.next()) {
            return new Park(
                    rst.getString(1),
                    rst.getString(2)
            );
        } else {
            return null;
        }
    }
    public boolean ParkDeatail(Park p) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO  parking VALUES (?,?,?,?)");
        stm.setObject(1,p.getSlot());
        stm.setObject(2,p.getCustomerId());
        stm.setObject(3,p.getCustomerName());
        stm.setObject(4,p.getVehicleName());

        return stm.executeUpdate()>0;
    }

    public ArrayList<Park> getAllCDeatail() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM parking");
        ResultSet rst = stm.executeQuery();
        ArrayList<Park>parks=new ArrayList<>();
        while(rst.next()){
            parks.add(
                    new Park(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4)
                    ));

        }
        return parks;
    }
}

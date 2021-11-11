package controller;

import Model.Customer;
import Model.CustomerUpdate;
import db.DbConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements controller.Customer {
    public boolean SaveCustomer(Customer c) throws SQLException, ClassNotFoundException {
        Connection con=DbConnection.getInstance().getConnection();
       String query="INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement stm=con.prepareStatement(query);

        stm.setObject(1,c.getCId());
        stm.setObject(2,c.getCName());
        stm.setObject(3,c.getCAddress());
        stm.setObject(4,c.getCPhoneNo());
        stm.setObject(5,c.getGender());
        stm.setObject(6,c.getCEMail());
        stm.setObject(7,c.getCAge());
        stm.setObject(8,c.getCountry());
        stm.setObject(9,c.getDate());
        stm.setObject(10,c.getTime());
        stm.setObject(11,c.getUId());
        stm.setObject(12,c.getUName());

        return stm.executeUpdate()>0;
    }
    public boolean UpdateCustomer(CustomerUpdate c) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE Customer SET CName=?,CAddress=?,CPhoneNo=?,Gender=?,CEmail=?,CAge=?,ECountry=? WHERE CId=?");

        stm.setObject(1,c.getCName());
        stm.setObject(2,c.getCAddress());
        stm.setObject(3,c.getTNumber());
        stm.setObject(4,c.getGender());
        stm.setObject(5,c.getEmail());
        stm.setObject(6,c.getAge());
        stm.setObject(7,c.getCountry());
        stm.setObject(8,c.getCId());

       return stm.executeUpdate()>0;
    }
    public CustomerUpdate getCustomer(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Customer WHERE CId=?");
        stm.setObject(1,id);

        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            CustomerUpdate c1=new CustomerUpdate(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            return c1;
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Results...").show();
        }
        return  null;
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        if (DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM Customer WHERE CId='" + id + "'").executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Customer>getAllCDeatail() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Customer");
        ResultSet rst = stm.executeQuery();
        ArrayList<Customer>customers=new ArrayList<>();
        while(rst.next()){
            customers.add(
                    new Customer(
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
                            rst.getString(12)
                    ));

        }
        return customers;
    }
    public List<String>getCustomerId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Customer").executeQuery();
        List<String>ids=new ArrayList<>();
        while (rst.next()){
            ids.add(
              rst.getString(1)
            );
        }
   return ids;
    }
}
package controller;

import Model.Employe;
import Model.Employee;
import db.DbConnection;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeController {
    public boolean SaveEmploye(Employee c) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO Roll VALUES (?,?,?,?,?,?,?,?)");
        stm.setObject(1,c.getEmployeeId());
        stm.setObject(2,c.getJobTitleId());
        stm.setObject(3,c.getJobTitle());
        stm.setObject(4,c.getEmployeeName());
        stm.setObject(5,c.getAddress());
        stm.setObject(6,c.getPhoneNumber());
        stm.setObject(7,c.getPassword());
        stm.setObject(8,c.getDate());

        return stm.executeUpdate()>0;
    }
    public Employe getEmploye(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Roll WHERE EmployeId=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Employe e1=new Employe(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                Integer.parseInt(rst.getString(6)),
                Integer.parseInt(rst.getString(7)
            ));
            return e1;
        }else{
         new Alert(Alert.AlertType.WARNING,"Empty Results..").show();
        }
        return null;
    }

    public ArrayList<Employee>getAllEmployes() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Roll");
        ResultSet rst=stm.executeQuery();
        ArrayList<Employee>employes=new ArrayList<>();
        while(rst.next()) {
            employes.add(
                    new Employee(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            Integer.parseInt(rst.getString(6)),
                            Integer.parseInt(rst.getString(7)),
                            rst.getString(8)
                    ));
        }
        return employes;
    }

    public boolean deleteEmploye(String code) throws SQLException, ClassNotFoundException {
        if(DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM Roll WHERE EmployeId='"+code+"'").executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean UpdateEmploye(Employe e) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE Roll SET TitleId=?,E_JobTitle=?,E_Name=?,E_Address=?,E_PhoneNo=?,E_Password=? WHERE EmployeId=?");
        stm.setObject(1,e.getJobTitleId());
        stm.setObject(2,e.getJobTitle());
        stm.setObject(3,e.getEmployeName());
        stm.setObject(4,e.getAddress());
        stm.setObject(5,e.getPhoneNumber());
        stm.setObject(6,e.getPassword());
        stm.setObject(7,e.getEmployeId());

        return stm.executeUpdate()>0;
    }
}

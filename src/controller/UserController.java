package controller;

import Model.User;
import Model.UserDatabase;
import Model.UserTable;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public List<String>getEmployeId() throws SQLException, ClassNotFoundException {
        ResultSet rst =DbConnection.getInstance().getConnection().prepareStatement("SELECT*FROM Roll").executeQuery();
        List<String>ids=new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }

    public User getUser(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Roll WHERE EmployeId='" + id + "'").executeQuery();
        if(rst.next()){
            return new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }else {
            return null;
        }
    }
 /*   public ArrayList<UserTable>userTables() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Roll");
        ResultSet rst = stm.executeQuery();
        ArrayList<UserTable>userTable=new ArrayList();
        while (rst.next()){
            userTable.add(
                    new UserTable(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4)
                    ));
        }
        return  userTable;
    }*/
    public boolean UserDatabase(UserDatabase database){
        try {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO User VALUES (?,?,?,?,?)");
            stm.setObject(1,database.getUId());
            stm.setObject(2,database.getEId());
            stm.setObject(3,database.getName());
            stm.setObject(4,database.getJobTitle());
            stm.setObject(5,database.getPassword());

            return stm.executeUpdate()>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

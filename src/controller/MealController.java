package controller;

import Model.Meal;
import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealController {
    public boolean AddMeal(Meal m) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO MealAdd VALUES (?,?,?)");
        stm.setObject(1,m.getMealId());
        stm.setObject(2,m.getMealType());
        stm.setObject(3,m.getMealPrice());

        return stm.executeUpdate()>0;
    }
    public boolean UpdateMeal(Meal c) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE MealAdd SET MealType=?,MealPrice=? WHERE MealId=?");
        stm.setObject(1,c.getMealType());
        stm.setObject(2,c.getMealPrice());
        stm.setObject(3,c.getMealId());

        return stm.executeUpdate()>0;
    }
    public boolean DeleteMeal(String id) throws SQLException, ClassNotFoundException {
        if (DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM MealAdd WHERE MealId='" + id + "'").executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Meal getMeal(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM MealAdd WHERE  MealId='" + id + "'").executeQuery();
        if(rst.next()){
            return new Meal(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }else {
            return null;
        }
    }
    public ArrayList<Meal>meals() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM mealAdd");
        ResultSet rst = stm.executeQuery();
        ArrayList<Meal>meals=new ArrayList<>();
        while (rst.next()){
            meals.add(
                    new Meal(
                     rst.getString(1),
                     rst.getString(2),
                     rst.getString(3)
                    ));
        }
        return meals;
    }
}
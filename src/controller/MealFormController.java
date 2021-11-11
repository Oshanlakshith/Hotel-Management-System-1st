package controller;

import Model.Meal;
import View.tm.MealTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MealFormController implements Initializable {

    public TextField txtMealId;
    public TextField txtPrice;
    public TextField txtMealType;
    public TableColumn colMealId;
    public TableColumn colMealType;
    public TableColumn colMealPrice;
    public TableView tblMeal;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMealId.setCellValueFactory(new PropertyValueFactory<>("mealId"));
        colMealType.setCellValueFactory(new PropertyValueFactory<>("mealType"));
        colMealPrice.setCellValueFactory(new PropertyValueFactory<>("mealPrice"));

        try {

            setMealTable(new MealController().meals());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setMealTable(ArrayList<Meal> meals) {
        ObservableList<MealTm>oblist= FXCollections.observableArrayList();
        meals.forEach(e->{
            oblist.add(
                    new MealTm(
                        e.getMealId(),e.getMealType(),e.getMealPrice()
                    )
            );
        });
        tblMeal.setItems(oblist);
    }

    public void SaveButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Meal m1=new Meal(
                txtMealId.getText(),txtMealType.getText(),txtPrice.getText()
        );
        if(new MealController().AddMeal(m1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Save..").showAndWait();
            setMealTable(new MealController().meals());
        }else{
            new Alert(Alert.AlertType.WARNING,"Try again..").show();
        }
    }
    public void UpdateButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Meal m1=new Meal(
                txtMealId.getText(),txtMealType.getText(),txtPrice.getText()
        );
        if(new MealController().UpdateMeal(m1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Update").showAndWait();
            setMealTable(new MealController().meals());
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }
    public void DeleteButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(new MealController().DeleteMeal(txtMealId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete").showAndWait();
            setMealTable(new MealController().meals());
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again..").show();
        }
    }


    public void ClearButton(ActionEvent actionEvent) {
        txtMealId.clear();
        txtMealType.clear();
        txtPrice.clear();
    }

    public void SearchButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       String Id=txtMealId.getText();
        Meal m1=new MealController().getMeal(Id);
        if(m1==null){
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();
            }else{
                setData(m1);
        }
    }
    public void setData(Meal m){
        txtMealId.setText(m.getMealId());
        txtMealType.setText(m.getMealType());
        txtPrice.setText(m.getMealPrice());
    }


}
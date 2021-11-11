package controller;

import Model.Employe;
import Model.Employee;
import View.tm.EmployeTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class EmployeNewController {

    public TextField txtEmployeId;
    public TextField txtMobile;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtPassword;
    public TableView<EmployeTm>tblDeatail;
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colTitleId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colPasssword;
    public TableColumn colDate;
    public Label lblDate;
    public TextField txtDate;
    public TextField txtTitle;
    public TextField txtJobTitleId;
    public TableColumn colDate1;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;

    public void initialize() throws SQLException, ClassNotFoundException {

        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colTitleId.setCellValueFactory(new PropertyValueFactory<>("TitleId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        colPasssword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Date();
        setEmployeDeatail(new EmployeController().getAllEmployes());
    }
//============================================================================================================

    public void EmployeSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EId=txtEmployeId.getText();
        Employe e1=new EmployeController().getEmploye(EId);
        if(e1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Results").show();
        }else{
            setEmploye(e1);
        }
    }
    public void setEmploye(Employe e1){
        txtEmployeId.setText(e1.getEmployeId());
        txtTitle.setText(e1.getJobTitle());
        txtJobTitleId.setText(e1.getJobTitleId());
        txtName.setText(e1.getEmployeName());
        txtAddress.setText(e1.getAddress());
        txtMobile.setText(String.valueOf(e1.getPhoneNumber()));
        txtPassword.setText(String.valueOf(e1.getPassword()));

    }
    //==============================================================================

    public void SaveEmploye(ActionEvent actionEvent){
        Employee e1=new Employee(
                txtEmployeId.getText(),
                txtJobTitleId.getText(),
                txtTitle.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtMobile.getText()),
                Integer.parseInt(txtPassword.getText()),
                txtDate.getText());

        try {
            if(SaveEmploye(e1)){
                new Alert(Alert.AlertType.CONFIRMATION,"Save...").showAndWait();
                setEmployeDeatail(new EmployeController().getAllEmployes());
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    boolean SaveEmploye(Employee e) throws SQLException, ClassNotFoundException {
        return new EmployeController().SaveEmploye(e);
    }
    //============================================================================================================================
    public void EmployeDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(new EmployeController().deleteEmploye(txtEmployeId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete...").showAndWait();
            setEmployeDeatail(new EmployeController().getAllEmployes());
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Results").show();
        }
    }
    //=============================================================================================================================

    public void EmployeUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Employe e1=new Employe(
                txtEmployeId.getText(),txtTitle.getText(),txtJobTitleId.getText(),txtName.getText(),txtAddress.getText(),Integer.parseInt(txtMobile.getText()),Integer.parseInt(txtPassword.getText())
        );
        if(new EmployeController().UpdateEmploye(e1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Update..").showAndWait();
            setEmployeDeatail(new EmployeController().getAllEmployes());
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again");
        }
    }
        //Table data load
    //========================================================================================================================
        public void setEmployeDeatail(ArrayList<Employee>loadEmploye){
            ObservableList<EmployeTm>oblist= FXCollections.observableArrayList();
            loadEmploye.forEach(e->{
                oblist.add(
                       new EmployeTm(e.getEmployeeId(),e.getJobTitle(),e.getJobTitleId(),e.getEmployeeName(),e.getAddress(),String.valueOf(e.getPhoneNumber()),String.valueOf(e.getPassword()),e.getDate())
                );
             });
            tblDeatail.setItems(oblist);
            }
    //============================================================================================================================
    public void ClearButton(ActionEvent actionEvent) {
        txtEmployeId.clear();
        txtTitle.clear();
        txtJobTitleId.clear();
        txtName.clear();
        txtAddress.clear();
        txtMobile.clear();
        txtPassword.clear();
    }
    //==================================================================================================================
    public void Date(){
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        String datenow=sdf.format(new Date());
        txtDate.setText(datenow);
    }

    public void EmployeValidation(KeyEvent keyEvent) {
        Pattern idPattern = Pattern.compile("^(E00-)[0-9]{2,4}$");
        Pattern titleidPattern = Pattern.compile("^(T10-)[0-3]{2}$");
        Pattern jobTypePatern = Pattern.compile("^[A-z]{3,9}$");
        Pattern NamePattern = Pattern.compile("^[A-z]{2,10}(\\s)?[a-z]{2,15}$");
        Pattern AddressPattern = Pattern.compile("^[A-z 0-9]{2,10}(,)?(\\s)?[A-z]{2,10}(\\s)?[A-z a-z]{2,10}$");
        Pattern MobilePattern = Pattern.compile("^[0-9]{3}(-)?[0-9]{6,7}$");
        Pattern PasswordPattern = Pattern.compile("^[1-9]{3,9}$");

        String Eid = txtEmployeId.getText();
        if (idPattern.matcher(Eid).matches()) {
            txtEmployeId.setStyle("-fx-border-color: green");
        } else {
            txtEmployeId.setStyle("-fx-border-color: red");
        }

        String titleId = txtJobTitleId.getText();
        if (titleidPattern.matcher(titleId).matches()) {
            txtJobTitleId.setStyle("-fx-border-color: green");
        } else {
            txtJobTitleId.setStyle("-fx-border-color: red");
        }
        String title = txtTitle.getText();
        if (jobTypePatern.matcher(title).matches()) {
            txtTitle.setStyle("-fx-border-color: green");
        } else {
            txtTitle.setStyle("-fx-border-color: red");
        }
        String name = txtName.getText();
        if (NamePattern.matcher(name).matches()) {
            txtName.setStyle("-fx-border-color: green");
        } else {
            txtName.setStyle("-fx-border-color: red");
        }
        String address = txtAddress.getText();
        if (AddressPattern.matcher(address).matches()) {
            txtAddress.setStyle("-fx-border-color: green");
        } else {
            txtAddress.setStyle("-fx-border-color: red");
        }
        String contact = txtMobile.getText();
        if (MobilePattern.matcher(contact).matches()) {
            txtMobile.setStyle("-fx-border-color: green");
        } else {
            txtMobile.setStyle("-fx-border-color: red");
        }
        String password = txtPassword.getText();
        if (PasswordPattern.matcher(password).matches()) {
            txtPassword.setStyle("-fx-border-color: green");
        } else {
            txtPassword.setStyle("-fx-border-color: red");
        }
        boolean inDisabled=(Eid.isEmpty()||Eid.trim().isEmpty() || (titleId.isEmpty()||titleId.trim().isEmpty() || title.isEmpty()||title.trim().isEmpty() || name.isEmpty()||name.trim().isEmpty() || address.isEmpty()||address.trim().isEmpty() || contact.isEmpty()||contact.trim().isEmpty() || password.isEmpty()||password.trim().isEmpty()));
        btnSave.setDisable(inDisabled);
        btnUpdate.setDisable(inDisabled);
        btnDelete.setDisable(inDisabled);
    }

}

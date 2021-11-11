package controller;

import Model.Customer;
import Model.CustomerUpdate;
import View.tm.CustomerTm;
import javafx.application.Platform;
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

public class CustomerFormController {
    public TextField txtId;
    public TextField txtMobile;
    public TextField txtEmail;
    public TextField txtAge;
    public TextField txtCountry;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtGender;
    public Label lblName;
    public Label lblId;
    public Label lblDate;
    public Label lblTime;
    public ComboBox<String> cmbGender;

    public TableView<CustomerTm> tblCutomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colGender;
    public TableColumn colEmail;
    public TableColumn colAge;
    public TableColumn colCountry;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colUserId;
    public TableColumn colUserName;
    public Button btnSave;

    ObservableList<CustomerTm> oblist = FXCollections.observableArrayList();
    ArrayList<Customer>customers=new ArrayList<>();
    static ArrayList<String> gender = new ArrayList<>();
    static {
        gender.add("Male");
        gender.add("Femail");
    }
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("CId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("CName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("CAddress"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("CPhoneNo"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("CEMail"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("CAge"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("UId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("UName"));

        ObservableList<String> oblist = FXCollections.observableArrayList();
        for (String temp : gender
        ) {
            oblist.add(temp);
        }
        cmbGender.setItems(oblist);

        cmbGender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        txtGender.setText(newValue);
        });
        Time();
        Date();
        try {

            setCustomerDeatail(new CustomerController().getAllCDeatail());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void setCustomerDeatail(ArrayList<Customer> allCDeatail) {
        ObservableList<CustomerTm> oblist = FXCollections.observableArrayList();
        allCDeatail.forEach(e -> {
            oblist.add(
                    new CustomerTm(
                            e.getCId(), e.getCName(), e.getCAddress(), e.getCPhoneNo(), e.getGender(), e.getCEMail(), e.getCAge(), e.getCountry(), e.getDate(), e.getTime(), e.getUId(), e.getUName()
                    ));
        });
        tblCutomer.setItems(oblist);
    }

    public void textFealdButton(KeyEvent keyEvent) {

        Pattern idPattern = Pattern.compile("^(C00-)[0-9]{2,4}$");
        Pattern namePattern = Pattern.compile("^[A-z]{2,10}(\\s)?[a-z]{2,15}$");
        Pattern AddressPattern = Pattern.compile("^[A-z 0-9]{2,10}(,)?(\\s)?[A-z]{2,10}(\\s)?[A-z a-z]{2,10}");
        Pattern ContactPattern = Pattern.compile("^[0-9]{3}(-)?[0-9]{6,7}$");
        Pattern mailPattern = Pattern.compile("^[A-z a-z 0-9]{2,25}(@)[a-z]{2,6}(.)[a-z]{1,5}$");
        Pattern agePattern = Pattern.compile("^[0-9]{1,3}$");
        Pattern countryPattern = Pattern.compile("^[A-z]{3,10}$");

        String Cid = txtId.getText();
        if (idPattern.matcher(Cid).matches()) {
            txtId.setStyle("-fx-border-color: green");
        } else {
            txtId.setStyle("-fx-border-color: red");
        }

        String name = txtName.getText();
        if (namePattern.matcher(name).matches()) {
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
        if (ContactPattern.matcher(contact).matches()) {
            txtMobile.setStyle("-fx-border-color: green");
        } else {
            txtMobile.setStyle("-fx-border-color: red");
        }

        String Email = txtEmail.getText();
        if (mailPattern.matcher(Email).matches()) {
            txtEmail.setStyle("-fx-border-color: green");
        } else {
            txtEmail.setStyle("-fx-border-color: red");
        }


        String Age = txtAge.getText();
        if (agePattern.matcher(Age).matches()) {
            txtAge.setStyle("-fx-border-color: green");
        } else {
            txtAge.setStyle("-fx-border-color: red");

        }
        String Country = txtCountry.getText();
        if (countryPattern.matcher(Country).matches()) {
            txtCountry.setStyle("-fx-border-color: green");
        } else {
            txtCountry.setStyle("-fx-border-color: red");
        }
       boolean inDisabled=(Cid.isEmpty()||Cid.trim().isEmpty() || name.isEmpty()||name.trim().isEmpty() || address.isEmpty()||address.trim().isEmpty() || contact.isEmpty()||contact.trim().isEmpty() || Email.isEmpty()||Email.trim().isEmpty() || Age.isEmpty()||Age.trim().isEmpty() || Country.isEmpty()||Country.trim().isEmpty());
        btnSave.setDisable(inDisabled);
  }


    public void SaveButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        Customer c1 = new Customer(txtId.getText(), txtName.getText(), txtAddress.getText(), txtMobile.getText(), txtGender.getText(), txtEmail.getText(), txtAge.getText(), txtCountry.getText(), lblDate.getText(), lblTime.getText(), lblId.getText(), lblName.getText());
        if (SaveCustomer(c1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            setCustomerDeatail(new CustomerController().getAllCDeatail());
        } else
            new Alert(Alert.AlertType.WARNING, "Try again").show();
    }

    boolean SaveCustomer(Customer c) throws SQLException, ClassNotFoundException {
        return new CustomerController().SaveCustomer(c);
    }

    public void UIdName(String id, String name) {
        lblId.setText(id);
        lblName.setText(name);
    }

    public void Time() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

            boolean stop = false;
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(timenow);
                });
            }
        });
        thread.start();
    }

    public void Date() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String datenow = sdf.format(new Date());
        lblDate.setText(datenow);

    }

    public void UserIDName(String id, String name) {
        lblId.setText(id);
        lblName.setText(name);
    }


    public void UpdateButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerUpdate c1 = new CustomerUpdate(
                txtId.getText(), txtName.getText(), txtAddress.getText(), txtMobile.getText(), txtGender.getText(), txtEmail.getText(), txtAge.getText(), txtCountry.getText()
        );
        if (new CustomerController().UpdateCustomer(c1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update..").showAndWait();
            setCustomerDeatail(new CustomerController().getAllCDeatail());
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void DeleteButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (new CustomerController().deleteCustomer(txtId.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Delete..").showAndWait();
            setCustomerDeatail(new CustomerController().getAllCDeatail());
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void ClearButton(ActionEvent actionEvent) {
        txtId.clear();
        txtMobile.clear();
        txtEmail.clear();
        txtAge.clear();
        txtCountry.clear();
        txtName.clear();
        txtAddress.clear();
        txtGender.clear();
    }

    public void CustomerSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id = txtId.getText();
        CustomerUpdate c1 = new CustomerController().getCustomer(Id);
        if (c1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Results..").show();
        } else {
            setData(c1);
        }
    }

    public void setData(CustomerUpdate id) {
        txtId.setText(id.getCId());
        txtName.setText(id.getCName());
        txtAddress.setText(id.getCAddress());
        txtMobile.setText(id.getTNumber());
        txtGender.setText(id.getGender());
        txtEmail.setText(id.getEmail());
        txtAge.setText(id.getAge());
        txtCountry.setText(id.getCountry());
    }
}
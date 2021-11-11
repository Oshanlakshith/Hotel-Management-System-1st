package controller;

import Model.Payment;
import View.tm.PaymentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {

    public TableView<PaymentTm>tblPayments;
    public TableColumn colCustomerId;
    public TableColumn colReservationId;
    public TableColumn colPaymentDate;
    public TableColumn colPaymentTime;
    public TableColumn colPayment;
    public TextField txtCId;
    public TextField txtPayment;
    public TextField txtPTime;
    public TextField txtPDate;
    public TextField txtRId;
    public Label lblPaymentId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colReservationId.setCellValueFactory(new PropertyValueFactory<>("recervationId"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("PaymentDate"));
        colPaymentTime.setCellValueFactory(new PropertyValueFactory<>("PaymentTime"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));

        try {

            AllPayment(new PaymentController().AllPayment()) ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void AllPayment(ArrayList<Payment> allPayment) {
        ObservableList<PaymentTm>oblist= FXCollections.observableArrayList();
        allPayment.forEach(e->{
            oblist.add(
                    new PaymentTm(
                            e.getCustomerId(),e.getRecervationId(),e.getPaymentDate(),e.getPaymentTime(),e.getPayment()
             ));
        });
        tblPayments.setItems(oblist);
    }

    public void CustomerSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String Id=txtCId.getText();
        Payment p1=new PaymentController().getAllpayment(Id);
        if(p1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Results..").show();
        }  else{
            setPayment(p1);
        }
    }
    public void setPayment(Payment p){
        txtRId.setText(p.getRecervationId());
        txtPDate.setText(p.getPaymentDate());
        txtPTime.setText(p.getPaymentTime());
        txtPayment.setText(p.getPayment());
    }
}

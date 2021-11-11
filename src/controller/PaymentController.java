package controller;

import Model.CustomerUpdate;
import Model.Payment;
import db.DbConnection;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentController {
    public boolean SavePayment(Payment p) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO Payment VALUES (?,?,?,?,?)");
        stm.setObject(1, p.getCustomerId());
        stm.setObject(2, p.getRecervationId());
        stm.setObject(3, p.getPaymentDate());
        stm.setObject(4, p.getPaymentTime());
        stm.setObject(5, p.getPayment());

        return stm.executeUpdate() > 0;
    }

    public ArrayList<Payment> AllPayment() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM Payment");
        ResultSet rst = stm.executeQuery();
        ArrayList<Payment> payments = new ArrayList<>();
        while (rst.next()) {
            payments.add(
                    new Payment(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)

                    ));
        }
        return payments;
    }

    public Payment getAllpayment(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Payment WHERE  CustomerId=?");
        stm.setObject(1, id);

        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)


                    );
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Results...").show();
        }
        return null;
    }
}

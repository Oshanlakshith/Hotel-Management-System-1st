package controller;

import View.tm.BookingTm;
import db.DbConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;


public class BillController{
    public Label lblCustId;
    public Label lblCheckIn;
    public Label lblAdult;
    public Label lblRoomType;
    public Label lblChild;
    public Label lblTotal;
    public Label lblCheckOut;
    public Label lblReservationId;
    public Button btnreport;
    public Button btnreport1;


    public void UserNameId(String reservationId, String customerId, String checkIn, String getCheckOut, String roomtype, String adult, String child, Double total) {
        lblReservationId.setText(reservationId);
        lblCustId.setText(customerId);
        lblCheckIn.setText(checkIn);
        lblCheckOut.setText(getCheckOut);
        lblRoomType.setText(roomtype);
        lblAdult.setText(adult);
        lblChild.setText(child);
        lblTotal.setText(String.valueOf(total));
    }

    public void SqlAction(ActionEvent actionEvent) {
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/View/reports/Welcome.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);
            try {
                JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, DbConnection.getInstance().getConnection());
                JasperViewer.viewReport(jasperPrint,false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    public void textReportButton(ActionEvent actionEvent) {

        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/View/reports/CheckIN.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);
            ObservableList<BookingTm> items;
            items = new BookingFormController().tblBookingDeatail.getItems();
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, new JRBeanArrayDataSource(items.toArray()));
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException e) {
            e.printStackTrace();
        }
}}

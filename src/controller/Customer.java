package controller;

import Model.CustomerUpdate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Customer {
    public boolean SaveCustomer(Model.Customer c) throws SQLException, ClassNotFoundException;
    public boolean UpdateCustomer(CustomerUpdate c) throws SQLException, ClassNotFoundException;
    public CustomerUpdate getCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<Model.Customer>getAllCDeatail() throws SQLException, ClassNotFoundException;
    public List<String> getCustomerId() throws SQLException, ClassNotFoundException;
}

package dao;

import java.sql.*;
import java.util.*;
import config.DBConnection;
import model.Customer;

public class CustomerDAO {
    public void addCustomer(Customer c) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Customers (FirstName, LastName, Email) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, c.firstName);
        ps.setString(2, c.lastName);
        ps.setString(3, c.email);
        ps.executeUpdate();
        conn.close();
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM Customers";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            list.add(new Customer(rs.getInt("CustomerID"), rs.getString("FirstName"), rs.getString("LastName"),
                    rs.getString("Email")));
        }
        conn.close();
        return list;
    }
}

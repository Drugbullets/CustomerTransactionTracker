package dao;

import java.sql.*;
import config.DBConnection;
import model.Transaction;

public class TransactionDAO {
    public void addTransaction(Transaction t) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Transactions (CustomerID, Type, Amount) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, t.customerID);
        ps.setString(2, t.type);
        ps.setDouble(3, t.amount);
        ps.executeUpdate();
        conn.close();
    }

    public double getTotalByType(int customerID, String type) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT SUM(Amount) FROM Transactions WHERE CustomerID = ? AND Type = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, customerID);
        ps.setString(2, type);
        ResultSet rs = ps.executeQuery();
        double total = 0;
        if (rs.next()) {
            total = rs.getDouble(1);
        }
        conn.close();
        return total;
    }
}

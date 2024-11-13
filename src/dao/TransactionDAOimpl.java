package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DBconnection;

public class TransactionDAOimpl implements TransactionDAO {

    @Override
    public void viewTransactions() {
        String sql = "SELECT * FROM TRANSACTION_LOG";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Check if there are any results
            if (!rs.next()) {
                System.out.println("No transactions found.");
                return;
            }

            // Display all the records from the TRANSACTION_LOG table
            System.out.println("Transaction ID | Product ID | Inventory ID | Transaction Type | Quantity | Transaction Date");
            do {
                int transactionId = rs.getInt("transaction_id");
                int productId = rs.getInt("product_id");
                int inventoryId = rs.getInt("inventory_id");
                String transactionType = rs.getString("transaction_type");
                int quantity = rs.getInt("quantity");
                String transactionDate = rs.getString("transaction_date");

                System.out.println(transactionId + " | " + productId + " | " + inventoryId + " | " + transactionType + " | " + quantity + " | " + transactionDate);

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println("Error fetching transactions: " + e.getMessage());
        }
    }
}

package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StockData;
import utility.DBconnection;

public class StockDataDAOimpl implements StockDataDAO{

	public void addStock(StockData stockData) throws SQLException {
	    String sql = "INSERT INTO STOCK_DATA (product_id, inventory_id, stock_level, threshold) VALUES (?, ?, ?, ?)";

	    try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, stockData.getProductId());
	        ps.setInt(2, stockData.getInventoryId());
	        ps.setInt(3, stockData.getStockLevel());
	        ps.setInt(4, stockData.getThreshold());

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Stock data added successfully to the database.");
	            logTransaction(stockData.getProductId(), stockData.getInventoryId(), "ADD", stockData.getStockLevel());
	        } else {
	            System.out.println("Failed to add stock data.");
	        }
	    }
	}

	@Override
	public void removeStock(int id) {
	    String sql = "DELETE FROM STOCK_DATA WHERE stock_id = ?";

	    try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, id);

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Stock entry with ID " + id + " removed successfully.");
	            // Assuming a quantity of 1 for this remove operation (can be adjusted as needed)
	            logTransaction(id, /* Set inventory ID */ 1, "REMOVE", 1);
	        } else {
	            System.out.println("No stock entry found with the given ID: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Failed to remove stock entry. Please check the ID or try again.");
	    }
	}



	@Override
	public void updateStock(int stockID, int stockCount, char option) {
	    String sql = "{CALL UpdateStockLevel(?, ?, ?)}";

	    try (Connection con = DBconnection.getConnection();
	         CallableStatement cs = con.prepareCall(sql)) {

	        cs.setInt(1, stockID);
	        cs.setInt(2, stockCount);
	        cs.setString(3, String.valueOf(option));

	        cs.execute();
	        System.out.println("Stock updated successfully for stock ID: " + stockID);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Failed to update stock. Please check the stock ID or try again.");
	    }
	}


	 @Override
	 public void viewStock(int id) {
		 String sql = "SELECT * FROM STOCK_DATA WHERE stock_id = ?";

	     try (Connection con = DBconnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        try (ResultSet rs = ps.executeQuery()) {

	        	if (!rs.next()) {
	                System.out.println("No stock found with the given ID.");
	                return;
	                }

	            int stockId = rs.getInt("stock_id");
	            int productId = rs.getInt("product_id");
	            int inventoryId = rs.getInt("inventory_id");
	            int stockLevel = rs.getInt("stock_level");
	            int threshold = rs.getInt("threshold");

	            System.out.println("Stock ID: " + stockId);
	            System.out.println("Product ID: " + productId);
	            System.out.println("Inventory ID: " + inventoryId);
	            System.out.println("Stock Level: " + stockLevel);
	            System.out.println("Threshold: " + threshold);

	            }
	        } catch (SQLException e) {
	            System.out.println("Error fetching stock data: " + e.getMessage());
	        }
	    }
	 
	 public void logTransaction(int productId, int inventoryId, String transactionType, int quantity) throws SQLException {
		    String sql = "INSERT INTO TRANSACTION_LOG (product_id, inventory_id, transaction_type, quantity) VALUES (?, ?, ?, ?)";

		    try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
		        ps.setInt(1, productId);
		        ps.setInt(2, inventoryId);
		        ps.setString(3, transactionType);
		        ps.setInt(4, quantity);

		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected > 0) {
		            System.out.println("Transaction logged successfully.");
		        } else {
		            System.out.println("Failed to log transaction.");
		        }
		    }
		}


	}


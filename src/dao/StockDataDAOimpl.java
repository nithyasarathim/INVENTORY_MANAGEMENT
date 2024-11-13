package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StockData;
import utility.DBconnection;

public class StockDataDAOimpl implements StockDataDAO{

	@Override
	public void addStock(StockData stockData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStock(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStock(int stockID, int stockCount) {
		// TODO Auto-generated method stub
		
	}


	 @Override
	 public void viewStock(int id) {
		 String sql = "SELECT * FROM STOCK_DATA WHERE stock_id = ?";

	     try (Connection con = DBconnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql)) {

	            // Set the stock_id parameter in the query
	        ps.setInt(1, id);

	            // Execute the query
	        try (ResultSet rs = ps.executeQuery()) {

	                // Check if the stock record exists
	        	if (!rs.next()) {
	                System.out.println("No stock found with the given ID.");
	                return;
	                }

	                // Retrieve and display stock details
	            int stockId = rs.getInt("stock_id");
	            int productId = rs.getInt("product_id");
	            int inventoryId = rs.getInt("inventory_id");
	            int stockLevel = rs.getInt("stock_level");
	            int threshold = rs.getInt("threshold");

	                // Print the stock details
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
	}


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Inventory;
import utility.DBconnection;

public class InventoryDAOimpl implements InventoryDAO {

    @Override
    public void addInventory(String name) throws SQLException {
        String sql = "INSERT INTO INVENTORY (inventory_name) VALUES (?)";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            int result = ps.executeUpdate();
            if (result == 0) {
                throw new SQLException("Failed to add inventory");
            } else {
                System.out.println("Inventory added successfully!");
            }
        }
    }

    @Override
    public void removeInventory(int id) throws SQLException {
        String sql = "DELETE FROM INVENTORY WHERE inventory_id = ?";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 0) {
                throw new SQLException("No inventory found with the given ID");
            } else {
                System.out.println("Inventory removed successfully!");
            }
        }
    }

    @Override
    public void viewInventory(int inventoryID) throws SQLException {
        String sql = "SELECT * FROM INVENTORY WHERE inventory_id = ?";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, inventoryID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Inventory ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                // Add more fields as needed
            } else {
                System.out.println("No inventory found with the given ID.");
            }
        }
    }
}


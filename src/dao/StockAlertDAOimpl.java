package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DBconnection;

public class StockAlertDAOimpl implements StockAlertDAO {

    @Override
    public void viewAlerts() {
        String sql = "SELECT * FROM STOCK_ALERT";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) {
                System.out.println("No alerts found.");
                return;
            }

            System.out.println("Alert ID | Product ID | Inventory ID | Alert Type | Timestamp | Status");
            do {
                int alertId = rs.getInt("alert_id");
                int productId = rs.getInt("product_id");
                int inventoryId = rs.getInt("inventory_id");
                String alertType = rs.getString("alert_type");
                String timestamp = rs.getString("alert_timestamp");
                String status = rs.getString("status");

                System.out.println(alertId + " | " + productId + " | " + inventoryId + " | " + alertType + " | " + timestamp + " | " + status);

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println("Error fetching stock alerts: " + e.getMessage());
        }
    }
}

package dao;

import java.sql.SQLException;

public interface InventoryDAO {

	void addInventory(String name) throws SQLException;

	void removeInventory(int id) throws SQLException;

	void viewInventory(int inventoryID) throws SQLException;

}

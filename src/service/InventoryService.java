package service;

import java.sql.SQLException;

import dao.InventoryDAO;
import dao.InventoryDAOimpl;

public class InventoryService {
	
	private final InventoryDAO inventoryDAO;
	
	public InventoryService() {
		this.inventoryDAO=new InventoryDAOimpl();
	}

	public void addInventory(String name) throws SQLException {
		inventoryDAO.addInventory(name);		
	}

	public void removeInventory(int id) throws SQLException {
		inventoryDAO.removeInventory(id);
		
	}

	public void viewInventory(int inventoryID) throws SQLException {
		inventoryDAO.viewInventory(inventoryID);
		
	}

}

package service;

import dao.InventoryDAO;
import dao.InventoryDAOimpl;

public class InventoryService {
	
	private final InventoryDAO inventoryDAO;
	
	public InventoryService() {
		this.inventoryDAO=new InventoryDAOimpl();
	}

	public void addInventory(String name) {
		inventoryDAO.addInventory(name);		
	}

	public void removeInventory(int id) {
		inventoryDAO.removeInventory(id);
		
	}

}
